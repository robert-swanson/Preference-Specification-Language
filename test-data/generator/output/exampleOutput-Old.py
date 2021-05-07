import helpers

STRONGLY = 10
MODERATLY = 5
SLIGHTLY = 1

def isValidPlan(plan):
    return (
        courseNameInPlan(plan, "COS 102") and
        courseNameInPlan(plan, "COS 103") and
        courseNameInPlan(plan, "COS 120") and
        courseNameInPlan(plan, "COS 121") and

        nCourseNamesInPlan(plan, 1, ["COS 311", "COS 321"]) and
        nCourseNamesInPlan(plan, 2, ["COS 381", "COS 421", "COS 436"]) and

        credits() >= 128 and
        creditsOver(plan, 300) >= 42 and

        leftBeforeRight(plan, "COS 120", "COS 121")
    )

def planScore(plan):
    totalScore = 0
    maxScore = 0

    (totalScore, maxScore) = applyPreference(totalScore, maxScore, percentage, STRONGLY, courseNameInPlan(plan, "COS 121"))
    (totalScore, maxScore) = applyPreference(totalScore, maxScore, sigmoid, MODERATLY, averageMeetingTime(plan))

    if courseNameInPlan("COS 436"):
        (totalScore, maxScore) = applyPreference(totalScore, maxScore, percentage, SLIGHTLY, courseNameInPlan(plan, "COS 381"))
        (totalScore, maxScore) = applyPreference(totalScore, maxScore, percentage, SLIGHTLY, not courseNameInPlan(plan, "COS 421"))

    if courseNameInPlan("COS 381"):
        semesterContext = contextFromSemester(plan, plan.courses["COS 381"].semseter)
        (totalScore, maxScore) = applyPreference(totalScore, maxScore, reverseSigmoid, MODERATLY, credits(semesterContext))

    return totalScore/maxScore
