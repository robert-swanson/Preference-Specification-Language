from Helpers.PlanEvaluator import PlanEvaluator
from Helpers.Validator import Validator
from Helpers.Scorer import Scorer
import Helpers.Utilities as ut

def validatePlan():
  validator = Validator()
  
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 120', 'SYS 120']), '1 courses from [COS 120, SYS 120] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(10, ['COS 102', 'COS 121', 'COS 143', 'COS 243', 'COS 265', 'COS 284', 'COS 492', 'COS 493', 'MAT 151', 'MAT 215']), '10 courses from [COS 102, COS 121, COS 143, COS 243, COS 265, COS 284, COS 492, COS 493, MAT 151, MAT 215] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 311', 'COS 321']), '1 courses from [COS 311, COS 321] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 320', 'COS 382', 'COS 435']), '1 courses from [COS 320, COS 382, COS 435] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['COS 393', 'COS 394', 'COS 450']), '1 courses from [COS 393, COS 394, COS 450] required but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(1, ['MAT 210', 'MAT 352']), '1 courses from [MAT 210, MAT 352] required but not found')
  validator.assertTrue((evaluator.totalCredits() >= 128.0), '128 credits (got {})'.format(evaluator.totalCredits()))
  validator.assertTrue((evaluator.totalCreditsGreaterThanEqualToCourseNumber(300) >= 42.0), '42 upper level credits (got {})'.format(evaluator.totalCreditsGreaterThanEqualToCourseNumber(300)))
  if (evaluator.courseName('COS 121') and (not evaluator.courseName('COS 144'))):
    print('Entering Condition: if (COS 121 and not COS 144)')
    validator.assertTrue(evaluator.violatesLeftBeforeRight('COS 265', 'COS 120'), 'Course COS 265 must come before course COS 120')
    print('Closing Scope')
  elif evaluator.courseName('COS 143'):
    print('Entering Condition: otherwise if COS 143')
    print('Closing Scope')
  else:
    print('Entering Condition: Otherwise')
    print('Closing Scope')
  if evaluator.contextStack.subcontext(lambda: evaluator.courseName('COS 121')):
    print('Entering Context: when COS 121')
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
  scorer.scoreSigmoid(evaluator.totalCredits(), 1.0, 'at most 14 credits', invert=False, worstBound=None, bestBound=None, lowerQuartile=16.0, upperQuartile=14.0)
  scorer.scoreSigmoid(evaluator.totalCredits(), 1.0, 'at least 15 credits', invert=False, worstBound=None, bestBound=None, lowerQuartile=13.0, upperQuartile=15.0)
  if (evaluator.courseName('COS 121') and (not evaluator.courseName('COS 144'))):
    print('Entering Condition: if (COS 121 and not COS 144)')
    scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['COS 243']), 1.0, 'Taking 1 courses from [COS 243]', invert=False)
    print('Closing Scope')
  elif evaluator.courseName('COS 143'):
    print('Entering Condition: otherwise if COS 143')
    scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['COS 243']), 1.0, 'Taking 1 courses from [COS 243]', invert=False)
    scorer.scoreBoolean(evaluator.nCourseNamesIn(1, ['COS 265']), 1.0, 'Taking 1 courses from [COS 265]', invert=False)
    print('Closing Scope')
  else:
    print('Entering Condition: Otherwise')
    print('Closing Scope')
  if evaluator.contextStack.subcontext(lambda: evaluator.courseName('COS 121')):
    print('Entering Context: when COS 121')
    scorer.scoreSigmoid(evaluator.totalCourses(), 1.0, 'at most 5 courses', invert=False, worstBound=None, bestBound=None, lowerQuartile=7.0, upperQuartile=5.0)
    scorer.scoreSigmoid(evaluator.totalCredits(), 1.0, 'at least 15 credits', invert=False, worstBound=None, bestBound=None, lowerQuartile=13.0, upperQuartile=15.0)
    scorer.scoreSigmoid(evaluator.averageStartTime(), 1.0, 'Later classes', invert=False, worstBound=None, bestBound=None, lowerQuartile=600.0, upperQuartile=840.0)
    print('Closing Scope')
  
  print()
  print("---------------------")
  print("Final Score: {:.0f}%".format(scorer.getScore()))
  print("---------------------")
  print()

evaluator = PlanEvaluator()
validatePlan()
scorePlan()
