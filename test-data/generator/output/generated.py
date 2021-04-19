from Helpers.PlanEvaluator import PlanEvaluator
from Helpers.Validator import Validator
from Helpers.Scorer import Scorer
import Helpers.Utilities as ut

def validatePlan():
  validator = Validator()
  
  validator.assertTrue(evaluator.courseName('COS 120'), 'Course COS 120 expected but not found')
  validator.assertTrue(evaluator.nCourseNamesIn(2, ['COS 120', 'COS 121', 'COS 143']), '2 courses from [[COS 120, COS 121, COS 143]] required but not found')
  validator.assertTrue(evaluator.violatesLeftBeforeRight('COS 120', 'COS 121'), 'Course COS 120 must come before course COS 121')
  validator.assertEquals(evaluator.totalCredits(), 15, '15 credits required for semester')
  validator.assertEquals(evaluator.totalCredits(), 150, '150 credits required for plan')
  validator.assertEquals(evaluator.totalCourses(), 15, '15 courses required for semester')
  validator.assertEquals(evaluator.totalCourses(), 150, '150 courses required for plan')
  validator.assertEquals(evaluator.totalCreditsGreaterThanEqualToCourseNumber(200), 15, '15 credits over level 200 required for semester')
  validator.assertEquals(evaluator.totalCreditsGreaterThanEqualToCourseNumber(200), 150, '150 credits over level 200 required for plan')
  validator.assertEquals(evaluator.totalCoursesGreaterThanEqualToCourseNumber(200), 15, '15 courses over level 200 required for semester')
  validator.assertEquals(evaluator.totalCoursesGreaterThanEqualToCourseNumber(200), 150, '150 courses over level 200 required for plan')
  
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
  scorer.scoreOptimum(evaluator.totalCredits(), 3.0, '15 credits preferred for semester', 15, worstDeviance=None, lowerQuartileDeviance=1.0, leftWorstDeviance=None, leftLowerQuartileDeviance=None, rightWorstDeviance=None, rightLowerQuartileDeviance=None)
  scorer.scoreOptimum(evaluator.totalCredits(), 5.0, '150 credits preferred for plan', 150, worstDeviance=None, lowerQuartileDeviance=10.0, leftWorstDeviance=None, leftLowerQuartileDeviance=None, rightWorstDeviance=None, rightLowerQuartileDeviance=None)
  scorer.scoreOptimum(evaluator.totalCourses(), 5.0, '15 courses preferred for semester', 15, worstDeviance=None, lowerQuartileDeviance=1.0, leftWorstDeviance=None, leftLowerQuartileDeviance=None, rightWorstDeviance=None, rightLowerQuartileDeviance=None)
  scorer.scoreOptimum(evaluator.totalCourses(), 1.0, '150 courses preferred for plan', 150, worstDeviance=None, lowerQuartileDeviance=10.0, leftWorstDeviance=None, leftLowerQuartileDeviance=None, rightWorstDeviance=None, rightLowerQuartileDeviance=None)
  scorer.scoreOptimum(evaluator.totalCreditsGreaterThanEqualToCourseNumber(200), 3.0, '15 credits over level 200 preferred for semester', 15, worstDeviance=None, lowerQuartileDeviance=1.0, leftWorstDeviance=None, leftLowerQuartileDeviance=None, rightWorstDeviance=None, rightLowerQuartileDeviance=None)
  scorer.scoreOptimum(evaluator.totalCreditsGreaterThanEqualToCourseNumber(200), 5.0, '150 credits over level 200 preferred for plan', 150, worstDeviance=None, lowerQuartileDeviance=10.0, leftWorstDeviance=None, leftLowerQuartileDeviance=None, rightWorstDeviance=None, rightLowerQuartileDeviance=None)
  scorer.scoreOptimum(evaluator.totalCoursesGreaterThanEqualToCourseNumber(200), 5.0, '15 courses over level 200 preferred for semester', 15, worstDeviance=None, lowerQuartileDeviance=1.0, leftWorstDeviance=None, leftLowerQuartileDeviance=None, rightWorstDeviance=None, rightLowerQuartileDeviance=None)
  scorer.scoreOptimum(evaluator.totalCoursesGreaterThanEqualToCourseNumber(200), 1.0, '150 courses preferred for plan', 150, worstDeviance=None, lowerQuartileDeviance=10.0, leftWorstDeviance=None, leftLowerQuartileDeviance=None, rightWorstDeviance=None, rightLowerQuartileDeviance=None)
  
  print("Final Score: {:.0f}%".format(scorer.getScore()))

evaluator = PlanEvaluator()
validatePlan()
scorePlan()
