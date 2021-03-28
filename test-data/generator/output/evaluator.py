import helpers as hp

def validatePlan(plan):
    hp.planIsValid = True
    hp.assertTrue(hp.courseNameInContext(plan, "COS 120"),"COS 120 not scheduled")
    hp.assertTrue(hp.courseNameInContext(plan, "COS 121"),"COS 121 not scheduled")
    hp.assertTrue(hp.nCourseNamesInContext(plan, 2, ["COS 120", "COS 121", "COS 143"]),'Not enough courses taken from set: ["COS 120", "COS 121", "COS 143"]')

    if hp.planIsValid:
        print("Valid Plan")


plan = hp.loadPlan()
validatePlan(plan)
