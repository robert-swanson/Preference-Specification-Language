import helpers as hp

def validatePlan(plan):
    hp.planIsValid = True
    hp.assertTrue(hp.courseNameInContext(plan, "COS 120"),"COS 120 not scheduled")
    hp.assertTrue(hp.courseNameInContext(plan, "COS 121"),"COS 121 not scheduled")
    hp.assertTrue(hp.nCourseNamesInContext(plan, 2, ["COS 120", "COS 121", "COS 143"]),'Not enough courses taken from set: ["COS 120", "COS 121", "COS 143"]')
    hp.assertTrue(hp.violatesLeftBeforeRight(plan, "COS 120", "COS 121"),"COS 120 must come before COS 121")
    hp.assertFalse(hp.violatesLeftBeforeRight(plan, "COS 121", "COS 120"),"Assert failed: COS 120 must come before COS 121")
    hp.assertEquals(hp.totalCredits(plan), 20, "Expected 20 credits")
    hp.assertEquals(hp.averageStartTime(plan), 637.5, "Expected the minutes since midnight to be 637.5")
    hp.assertEquals(hp.minsSinceMidnightToArmyTime(hp.averageStartTime(plan)), 1037, "expected army time to be 1037")
    hp.assertEquals(hp.totalCreditsGreaterThanEqualToCourseNumber(plan, 200), 6, "expected 6 credits")
    hp.assertEquals(hp.totalCoursesGreaterThanEqualToCourseNumber(plan, 200), 2, "expected 2 courses")
    print(hp.contextFromSemester(plan, containsCOS120))

def containsCOS120(term):
    return hp.courseNameInContext(plan, "COS 120")

plan = hp.loadPlan()
validatePlan(plan)

if hp.planIsValid:
    print("Valid Plan")