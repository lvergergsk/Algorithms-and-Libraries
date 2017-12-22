#!/bin/python3


def abbreviation(original, target):
    dp = [[False for f1 in range(len(original) + 1)] for f2 in range(len(target) + 1)]
    dp[0][0] = True
    # for 0 length target string, original have to be all lower case
    for f1 in range(1, len(original)):
        if original[f1 - 1].islower():
            dp[0][f1] = True
    for f1 in range(1, len(original) + 1):
        for f2 in range(1, len(target) + 1):
            if original[f1 - 1].islower() & dp[f2][f1 - 1]:
                dp[f2][f1] = True
            if dp[f2 - 1][f1 - 1] & (
                    (original[f1 - 1] == target[f2 - 1]) | (original[f1 - 1].upper() == target[f2 - 1])):
                dp[f2][f1] = True
    if dp[len(target)][len(original)]:
        return "YES"
    else:
        return "NO"


if __name__ == "__main__":
    q = int(input().strip())
    for a0 in range(q):
        original = input().strip()
        target = input().strip()
        result = abbreviation(original, target)
        print(result)
