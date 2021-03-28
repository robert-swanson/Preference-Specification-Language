import sys
import json
import copy


# Initialization
def printUsage():
    print("USAGE: python3 evaluator.py plan.json")
    exit()


def loadPlan():
    if (len(sys.argv) < 2):
        printUsage()

    file = open(sys.argv[1])
    plan = json.load(file)
    return plan

# context generator
def contextFromSemester(contextIn, conditionFunction):
    contextOut = copy.deepcopy(contextIn)
    for term in contextIn['terms']:
        if not conditionFunction(contextFromTerm(term)):
            contextOut['terms'].remove(term)
    return contextOut

def contextFromTerm(term):
    return {
        "terms": [term]
    }


# Validation
planIsValid = None

def assertTrue(value, message):
    global planIsValid
    if not value:
        planIsValid = False
        print("Requirement Violation: {}".format(message))

def assertFalse(value, message):
    assertTrue(not value, message)

def assertEquals(value, expected, message):
    assertTrue(value == expected, "{} (expected '{}' but found '{}')".format(message, expected, value))


# utility functions
def percentage(score):
    return min(max(score, 1), 0)

def sigmoid(score):
    return 1/(1+10**(-score))

def reverseSigmoid(score):
    return 1/(1+10**(score))

def minsSinceMidnightToArmyTime(mins):
    return int((mins // 60) * 100 + (mins % 60))

def armyTimeToMinsSinceMidnight(armyTime):
    return (armyTime//100) * 60 + (armyTime%100)


# applyPreference
def applyPreference(totalScore, maxScore, scalar, weight, score):
    return (totalScore+weight*scalar(score), maxScore+weight)


# plan evaluators
def courseNameInContext(context, courseName):
    if termSectionForCourseName(context, courseName) is not None:
        return True
    else:
        return False

def nCourseNamesInContext(context, n, courseNamesList):
    count = 0
    for courseName in courseNamesList:
        if courseNameInContext(context, courseName):
            count += 1
            if count >= n:
                return True
    return False

def violatesLeftBeforeRight(context, leftCourseName, rightCourseName):
    leftTerm, _ = termSectionForCourseName(context, leftCourseName)
    rightTerm, _ = termSectionForCourseName(context, rightCourseName)
    if leftTerm is not None and rightTerm is not None:
        return leftTerm['term-number'] < rightTerm['term-number']
    else:
        return False

def termSectionForCourseName(context, courseName):
    for term in context['terms']:
            for section in term['sections']:
                if section['course-name'] == courseName:
                    return term, section
    return None

EARLIEST_MEETING_TIME = 800
LATEST_MEETING_TIME = 1500

def averageStartTime(context):
    timeSum = 0
    counter = 0
    for term in context['terms']:
        for section in term['sections']:
            for meeting in section['meetings']:
                armyTime = meeting['start-time']
                timeSum += armyTimeToMinsSinceMidnight(armyTime)
                counter += 1
    return timeSum / counter

def totalCredits(context):
    creditSum = 0
    for term in context['terms']:
        for section in term['sections']:
            creditSum += section['credits']
    return creditSum

def totalCreditsGreaterThanEqualToCourseNumber(context, minCourseNumber):
    creditSum = 0
    for term in context['terms']:
        for section in term['sections']:
            if section['course-number'] >= minCourseNumber:
                creditSum += section['credits']
    return creditSum

def totalCoursesGreaterThanEqualToCourseNumber(context, minCourseNumber):
    courseSum = 0
    for term in context['terms']:
        for section in term['sections']:
            if section['course-number'] >= minCourseNumber:
                courseSum += 1
    return courseSum



