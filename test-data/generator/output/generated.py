from Helpers.PlanEvaluator import PlanEvaluator
from Helpers.Validator import Validator
from Helpers.Scorer import Scorer
import Helpers.Utilities as ut

def validatePlan():
  validator = Validator()
  
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 102']), '1 courses from [COS 102] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 103']), '1 courses from [COS 103] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 120']), '1 courses from [COS 120] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(2, ['COS 121', 'COS 333']), '2 courses from [COS 121, COS 333] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 311', 'COS 321']), '1 courses from [COS 311, COS 321] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(2, ['COS 381', 'COS 421', 'COS 436']), '2 courses from [COS 381, COS 421, COS 436] required but not found')
  validator.assertEquals(evaluator.totalCredits(), 128.0, '128 credits')
  validator.assertEquals(evaluator.totalCreditsGreaterThanEqualToCourseNumber(300), 42.0, '42 credits')
  validator.assertTrue(evaluator.violatesLeftBeforeRight('[COS 120]', 'COS 121'), 'Course [COS 120] must come before course COS 121')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 121']), '1 courses from [COS 121] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 121']), '1 courses from [COS 121] required but not found')
  
  if validator.isValid:
    print("Valid Plan")
  else:
    print("Invalid Plan")

def scorePlan():
  scorer = Scorer()
  scorer.enableDiagnostics()
  
  scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['COS 999']), 5.0, 'Taking 1 courses from [COS 999]', invert=False)
  scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['COS 381']), 1.0, 'Taking 1 courses from [COS 381]', invert=False)
  scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['COS 421']), 1.0, 'Taking 1 courses from [COS 421]', invert=False)
  scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['COS 421']), 1.0, 'Taking 1 courses from [COS 421]', invert=False)
  scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['COS 121']), 5.0, 'Taking 1 courses from [COS 121]', invert=False)
  
  print("Final Score: {:.0f}%".format(scorer.getScore()))

evaluator = PlanEvaluator()
validatePlan()
scorePlan()
