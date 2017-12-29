class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        d = {k: v for v, k in enumerate(nums)}
        print(d)
        for i in range(len(nums)):
            if target - nums[i] in d:
                index = d[target - nums[i]]
                if i != index:
                    return [i, index]
