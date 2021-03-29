def percentage(score):
    return min(max(score, 1), 0)

def sigmoid(score):
    return 1/(1+10**(-score))

def reverseSigmoid(score):
    return 1/(1+10**(score))

def minsSinceMidnightToArmyTime(mins):
    return int((mins // 60) * 100 + (mins % 60))

def armyTimeToMinsSinceMidnight(armyTime):
    return (armyTime//100) * 60 + (armyTime%100)

