#!/bin/python3

if __name__ == '__main__':
    n = int(input().strip())
    arr = [int(arr_temp) for arr_temp in input().strip().split(' ')]
    for i in reversed(arr):
        print(i, end=' ')
