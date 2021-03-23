# scalar functions
def percentage(score):
    return min(max(score, 1), 0) * weight
def sigmoid(score):
    return weight/(1+10**(-score))
def reverseSigmoid(score):
    return weight/(1+10**(score))

# applyPreference
def applyPreference(totalScore, maxScore, scalar, weight, score):
    return (totalScore+weight*scalar(score), maxScore+weight)


# plan evaluators
def courseNameInContext(context, courseName):
    if termSectionForCourseName(context, courseName) != None:
        return true
    else:
        return false

def nCourseNamesInContext(context, n, courseNamesList):
    count = 0
    for courseName in courseNamesList:
        if courseNameInContext(context, courseName):
            count += 1
            if count >= n:
                return true
    return false

def violatesLeftBeforeRight(context, leftCourseName, rightCourseName):
    leftTerm = termSectionForCourseName(context, leftCourseName)
    rightTerm = termSectionForCourseName(context, rightCourseName)
    if leftTerm != None and rightTerm != None:
        return leftTerm.term-number < rightTerm.term-number
    else:
        return false

def termSectionForCourseName(context, courseName):
    for term in context.terms:
            for section in term.sections:
                if section.course-name == courseName:
                    return term, section
    return None