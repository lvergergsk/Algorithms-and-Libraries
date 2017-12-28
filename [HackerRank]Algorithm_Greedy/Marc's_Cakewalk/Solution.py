#!/bin/python3

import logging
import sys

if __debug__:
    logging.basicConfig(stream=sys.stderr, level=logging.DEBUG)

if __name__ == '__main__':
    n = int(input().strip())
    calories = list(map(int, input().strip().split(' ')))
    calories = sorted(calories, reverse=True)

    if __debug__:
        logging.debug('calories = ' + str(calories))

    j = 0
    m = 0
    for c in calories:
        m += c * (2 ** j)
        j += 1
    print(m)
