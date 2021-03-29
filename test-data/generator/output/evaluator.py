from Helpers.PlanEvaluator import PlanEvaluator
from Helpers.Validator import Validator
import Helpers.Utilities as ut

def validatePlan():
    validator = Validator()
    validator.assertTrue(evaluator.courseName("COS 120"),"COS 120 not scheduled")
    validator.assertTrue(evaluator.courseName("COS 121"),"COS 121 not scheduled")
    validator.assertTrue(evaluator.nCourseNamesIn(2, ["COS 120", "COS 121", "COS 143"]),'Not enough courses taken from set: ["COS 120", "COS 121", "COS 143"]')
    validator.assertTrue(evaluator.violatesLeftBeforeRight("COS 121", "COS 121"),"COS 120 must come before COS 121")
    validator.assertFalse(evaluator.violatesLeftBeforeRight("COS 121", "COS 120"),"Assert failed: COS 120 must come before COS 121")
    validator.assertEquals(evaluator.totalCredits(), 20, "Expected 20 credits")
    validator.assertEquals(evaluator.averageStartTime(), 637.5, "Expected the minutes since midnight to be 637.5")
    validator.assertEquals(ut.minsSinceMidnightToArmyTime(evaluator.averageStartTime()), 1037, "expected army time to be 1037")
    validator.assertEquals(evaluator.totalCreditsGreaterThanEqualToCourseNumber(200), 6, "expected 6 credits")
    validator.assertEquals(evaluator.totalCoursesGreaterThanEqualToCourseNumber(200), 2, "expected 2 courses")

    if evaluator.contextStack.tryPushSubContextWithCondition(lambda contextIn: PlanEvaluator.courseNameInContext(contextIn, "COS 120")):
        print(evaluator.contextStack.currentContext())
        # Do context things
        evaluator.contextStack.popContext()

    if validator.isValid:
        print("Valid Plan")

evaluator = PlanEvaluator()
validatePlan()