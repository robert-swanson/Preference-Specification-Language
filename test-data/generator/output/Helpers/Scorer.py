class Scorer:
    def __init__(self):
        self.score = 0
        self.maxPossibleScore = 0

    def getScore(self):
        return self.score/self.maxPossibleScore * 100

    def scoreBoolean(self, value, weight, preferenceName, diagnostics=False):
        self.maxPossibleScore += weight
        score = 1 if value else 0

        if diagnostics:
            print("Score: {:.2f}%\tWeight: {}\tPreference Name: {}".format(score*100, weight, preferenceName))
            # print("Score: {:.2f}\tCurrent: {:.0f} (given: val={}, weight={})".format(score, self.getScore(), value, weight))

        self.score += score * weight

    def scoreSigmoid(self, value, weight, preferenceName, worstBound=0, bestBound=1, diagnostics=False):
        # worstBound describes the value required to return a score of 0.25 * weight
        # bestBound describes the value required to return a score of 0.75 * weight
        # if bestBound < worstBound then the sigmoid function is reversed, giving higher scores for lower values

        self.maxPossibleScore += weight
        normalizedValue = (value - worstBound) / (bestBound - worstBound) - .5
        score = 1 / (1+pow(9,normalizedValue*-1))

        if diagnostics:
            print("Score: {:.2f}%\tWeight: {}\tPreference Name: {}".format(score*100, weight, preferenceName))
            # print("Score: {:.2f}\tCurrent: {:.0f} (given: val={}, weight={}, worst={}, best={})".format(score, self.getScore(), value, weight, worstBound, bestBound))

        self.score += score * weight


