# Time: O(N^2)
# Space: O(N)
class Solution(object):
    def findNumberOfLIS(self, nums):
        N = len(nums)
        if N <= 1: return N
        #         to store length of longest subsequence which end at ith character
        lengths = [0] * N
        #         to store number of longest subsequence,
        #         in case of there are multiple longest subsequence end at ith character
        counts = [1] * N

        #         0 ... i ... j ... N
        for j, num in enumerate(nums):
            for i in range(j):
                #                 if we can concat char j at the end of longest sequence ending at i,
                #                 then jth element must be greater than ith element by definition of LIS.
                if nums[i] < nums[j]:
                    #                     if we create a new sequence that is longer than we current have,
                    #                     then record the length, and count at j should be exactly the same as count at i.
                    if lengths[i] >= lengths[j]:
                        lengths[j] = 1 + lengths[i]
                        counts[j] = counts[i]
                    #                     if we create a new sequence that is as long as we current have,
                    #                     then increase count of j position.
                    elif lengths[i] + 1 == lengths[j]:
                        counts[j] += counts[i]

        #         length of LIS in given sequence should be the longest one.
        longest = max(lengths)

        #         returned format: (LIS length, Number of LIS of that length)
        return sum(c for i, c in enumerate(counts) if lengths[i] == longest)