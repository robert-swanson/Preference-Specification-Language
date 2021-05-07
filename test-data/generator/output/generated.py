from Helpers.PlanEvaluator import PlanEvaluator
from Helpers.Validator import Validator
from Helpers.Scorer import Scorer
import Helpers.Utilities as ut

def validatePlan():
  validator = Validator()
  
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 102']), '1 courses from [COS 102] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 120', 'SYS 120']), '1 courses from [COS 120, SYS 120] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 121']), '1 courses from [COS 121] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 143']), '1 courses from [COS 143] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 243']), '1 courses from [COS 243] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 265']), '1 courses from [COS 265] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 284']), '1 courses from [COS 284] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 492']), '1 courses from [COS 492] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 493']), '1 courses from [COS 493] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['MAT 151']), '1 courses from [MAT 151] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['MAT 215']), '1 courses from [MAT 215] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 311', 'COS 321']), '1 courses from [COS 311, COS 321] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 320', 'COS 382', 'COS 435']), '1 courses from [COS 320, COS 382, COS 435] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 393', 'COS 394', 'COS 450']), '1 courses from [COS 393, COS 394, COS 450] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['MAT 210', 'MAT 352']), '1 courses from [MAT 210, MAT 352] required but not found')
  validator.assertTrue((evaluator.totalCredits() >= 128.0), '128 credits (got {})'.format(evaluator.totalCredits()))
  validator.assertTrue((evaluator.totalCreditsGreaterThanEqualToCourseNumber(300) >= 42.0), '42 upper level credits (got {})'.format(evaluator.totalCreditsGreaterThanEqualToCourseNumber(300)))
  if ((evaluator.courseName('COS 120') or evaluator.courseName('COS 121')) and (evaluator.courseName('COS 143') or evaluator.courseName('COS 265'))):
    print('Entering Condition: If Condition')
    print('Closing Scope')
  elif evaluator.courseName('SYS 120'):
    print('Entering Condition: Otherwise If')
    print('Closing Scope')
  else:
    print('Entering Condition: Otherwise')
    print('Closing Scope')
  if evaluator.contextStack.subcontext(lambda: evaluator.courseName('COS 121')):
    print('Entering Context: When Condition')
    print('Closing Scope')
  
  print()
  print("---------------------")
  if validator.isValid:
    print("Valid Plan")
  else:
    print("Invalid Plan")
  print("---------------------")
  print()

def scorePlan():
  scorer = Scorer()
  scorer.enableDiagnostics()
  
  scorer.scoreSigmoid(evaluator.averageStartTime(), 10.0, 'Earlier classes', invert=False, worstBound=None, bestBound=None, lowerQuartile=840.0, upperQuartile=600.0)
  scorer.scoreSigmoid(evaluator.totalCredits(), 1.0, 'at most 14 credits', invert=False, worstBound=None, bestBound=None, lowerQuartile=15.0, upperQuartile=14.0)
  scorer.scoreSigmoid(evaluator.totalCredits(), 1.0, 'at least 15 credits', invert=False, worstBound=None, bestBound=None, lowerQuartile=14.9, upperQuartile=15.0)
  if ((evaluator.courseName('COS 120') or evaluator.courseName('COS 121')) and (evaluator.courseName('COS 143') or evaluator.courseName('COS 265'))):
    print('Entering Condition: If Condition')
    scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['COS 121']), 1.0, 'Taking 1 courses from [COS 121]', invert=True)
    print('Closing Scope')
  elif evaluator.courseName('SYS 120'):
    print('Entering Condition: Otherwise If')
    scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['COS 265']), 1.0, 'Taking 1 courses from [COS 265]', invert=False)
    scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['MAT 210']), 1.0, 'Taking 1 courses from [MAT 210]', invert=False)
    print('Closing Scope')
  else:
    print('Entering Condition: Otherwise')
    print('Closing Scope')
  if evaluator.contextStack.subcontext(lambda: evaluator.courseName('COS 121')):
    print('Entering Context: When Condition')
    scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['COS 121']), 1.0, 'Taking 1 courses from [COS 121]', invert=True)
    print('Closing Scope')
  
  print()
  print("---------------------")
  print("Final Score: {:.0f}%".format(scorer.getScore()))
  print("---------------------")
  print()

evaluator = PlanEvaluator()
validatePlan()
scorePlan()
