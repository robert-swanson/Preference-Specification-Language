import helpers as hp

def validatePlan(plan):
    hp.planIsValid = True
    hp.assertTrue(hp.courseNameInContext(plan, "COS 120"),"COS 120 not scheduled")
    hp.assertTrue(hp.courseNameInContext(plan, "COS 121"),"COS 121 not scheduled")
    hp.assertTrue(hp.nCourseNamesInContext(plan, 2, ["COS 120", "COS 121", "COS 143"]),'Not enough courses taken from set: ["COS 120", "COS 121", "COS 143"]')
    hp.assertTrue(hp.violatesLeftBeforeRight(plan, "COS 120", "COS 121"),"COS 120 must come before COS 121")
    hp.assertFalse(hp.violatesLeftBeforeRight(plan, "COS 121", "COS 120"),"Assert failed: COS 120 must come before COS 121")
    hp.assertEquals(hp.totalCredits(plan), 20, "Expected 20 credits")
    hp.assertEquals(hp.averageStartTime(plan), 20, "Expected the time to be ")



plan = hp.loadPlan()
validatePlan(plan)

if hp.planIsValid:
    print("Valid Plan")