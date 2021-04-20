from Helpers.PlanEvaluator import PlanEvaluator
from Helpers.Validator import Validator
from Helpers.Scorer import Scorer
import Helpers.Utilities as ut

def validatePlan():
  validator = Validator()
  
  validator.assertTrue(evaluator.courseName('COS 120'), 'Course COS 120 expected but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(2, ['COS 120', 'COS 121', 'COS 143']), '2 courses from [[COS 120, COS 121, COS 143]] required but not found')
  validator.assertTrue(evaluator.violatesLeftBeforeRight('COS 120', 'COS 121'), 'Course COS 120 must come before course COS 121')
  validator.assertEquals(evaluator.totalCredits(), 15.0, '15 credits')
  validator.assertEquals(evaluator.totalCourses(), 5.0, '5 courses')
  validator.assertTrue((evaluator.totalCreditsGreaterThanEqualToCourseNumber(200) > 80.0), 'More than 80 credits over 200')
  
  if validator.isValid:
    print("Valid Plan")
  else:
    print("Invalid Plan")

def scorePlan():
  scorer = Scorer()
  scorer.enableDiagnostics()
  
  scorer.scoreBoolean(evaluator.courseName('COS 120'), 5.0, 'Taking course: COS 120')
  scorer.scoreBoolean(evaluator.nCourseNamesIn(2, ['COS 120', 'COS 121', 'COS 143']), 10.0, 'Taking 2 courses from [[COS 120, COS 121, COS 143]]')
  scorer.scoreBoolean(evaluator.violatesLeftBeforeRight('COS 120', 'COS 121'), 10.0, 'Taking course COS 120 before course COS 121')
  scorer.scoreOptimum(evaluator.totalCredits(), 3.0, '15 credits', 15.0, worstDeviance=None, lowerQuartileDeviance=None, leftWorstDeviance=None, leftLowerQuartileDeviance=2.0, rightWorstDeviance=None, rightLowerQuartileDeviance=2.0)
  scorer.scoreOptimum(evaluator.totalCourses(), 4.2, '5 courses', 5.0, worstDeviance=None, lowerQuartileDeviance=None, leftWorstDeviance=None, leftLowerQuartileDeviance=1.0, rightWorstDeviance=None, rightLowerQuartileDeviance=1.0)
  scorer.scoreSigmoid(evaluator.totalCreditsGreaterThanEqualToCourseNumber(200), 18.0, 'More than 80 credits over 200', worstBound=None, bestBound=None, lowerQuartile=75.0, upperQuartile=85.0)
  scorer.scoreSigmoid(evaluator.averageStartTime(), 3.0, 'Earlier classes', worstBound=None, bestBound=None, lowerQuartile=840.0, upperQuartile=600.0)
  scorer.scoreSigmoid(evaluator.averageStartTime(), 3.0, 'Later classes', worstBound=None, bestBound=None, lowerQuartile=600.0, upperQuartile=840.0)
  
  print("Final Score: {:.0f}%".format(scorer.getScore()))

evaluator = PlanEvaluator()
validatePlan()
scorePlan()
