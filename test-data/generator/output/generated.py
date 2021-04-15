from Helpers.PlanEvaluator import PlanEvaluator
from Helpers.Validator import Validator
from Helpers.Scorer import Scorer
import Helpers.Utilities as ut

def validatePlan():
  validator = Validator()
  
  validator.assertTrue(evaluator.courseName('COS 120'), 'Course COS 120 expected but not found')
  validator.assertTrue(evaluator.courseName('COS 121'), 'Course COS 121 expected but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(2, ['COS 120', 'COS 121', 'COS 143']), '2 courses from [[COS 120, COS 121, COS 143]] required but not found')
  validator.assertTrue(evaluator.violatesLeftBeforeRight('COS 120', 'COS 121'), 'Course COS 120 must come before course COS 121')
  
  if validator.isValid:
    print("Valid Plan")
  else:
    print("Invalid Plan")

def scorePlan():
  scorer = Scorer()
  scorer.enableDiagnostics()
  
  scorer.scoreBoolean(evaluator.courseName('COS 121'), 1.0, 'Taking course: COS 121')
  scorer.scoreOptimum(evaluator.totalCredits(), 10.0, 'Prefer 15 credits for semester', 15, worstDeviance=None, lowerQuartileDeviance=1.0, leftWorstDeviance=None, leftLowerQuartileDeviance=None, rightWorstDeviance=None, rightLowerQuartileDeviance=None)
  
  print("Final Score: {:.0f}%".format(scorer.getScore()))

evaluator = PlanEvaluator()
validatePlan()
scorePlan()
