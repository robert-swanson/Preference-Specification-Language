# def courseNameInPlan(context, courseName):
#     return context.courses.contains(courseName)

# def nCourseNamesInPlan(context, n, fromCourseNames):
#     count = 0
#     for courseName in fromCourseNames:
#         if courseNameInPlan(context, courseName):
#             count += 1
#             if count >= n:
#                 return true
#     return false

# def leftBeforeRight(context, leftCourseName, rightCourseName):
#     if courseNameInPlan(leftCourseName) and courseNameInPlan(rightCourseName):
#         return context.courses[leftCourseName].semester < context.courses[rightCourseName].semseter

# EARLIEST_MEETING_TIME = 800
# LATEST_MEETING_TIME = 1500
#
# def averageMeetingTime(context):
#     timeSum = 0
#     for meeting in context.meetings:
#         timeSum += (meeting.time - EARLIEST_MEETING_TIME) / (LATEST_MEETING_TIME - EARLIEST_MEETING_TIME)
#     return timeSum / len(context.meetings)

# def credits(context):
#     creditSum = 0
#     for meeting in context.meetings:
#         creditSum += meeting.credits
#     return creditSum

# def creditsOver(context, minCourseNumber):
#     creditSum = 0
#     for meeting in context.meetings:
#         if meeting.courseNumber >= minCourseNumber:
#             creditSum += meeting.credits
#     return creditSum

# def applyPreference(totalScore, maxScore, scaler, weight, score):
#     return (totalScore+weight*scaler(preferenceSatisfaction), maxScore+weight)
#
# def percentage(score):
#     return min(max(score, 1), 0) * weight
#
# def sigmoid(score):
#     return weight/(1+10**(-score))
# def reverseSigmoid(score):
#     return weight/(1+10**(score))
#
# def contextFromSemester(contextIn, semester):
#     contextOut = { courses: [], meetings: [] }
#     for meeting in contextIn.meeting:
#         if meeting.semester == semester:
#             contextOut.courses.append(meeting.course)
#             contextOut.meetings.append(meeting)
