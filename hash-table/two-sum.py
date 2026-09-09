class Solution:
    def twoSum(self, nums: List[int], target : int) -> List[int]:
        dict = {}

        for i in range (len(nums)):
            sub = target - nums[i]
            if sub in dict:
                return[i, dict[sub]]
            else:
                dict[nums[i]] = i

        return[] 