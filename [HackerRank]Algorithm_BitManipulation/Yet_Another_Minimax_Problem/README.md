#### Difficulty
Medium

#### Procedure
1. find the first bit from most siginificant bit, that variate amoung numbers.
1. divide numbers into two group based on that bit, group 0 and group 1.
1. solution is the minimum xor value of numbers, one from group 1 and another from group 2.

#### Hint
The complexity is O(N*M) where N+M=N.
Using binary tree may reduce it to O(N+M).