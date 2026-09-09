class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        temp_dict = {}

        for i in range(len(nums)):
            sub = target - nums[i]
            if sub not in temp_dict:
                temp_dict[nums[i]] = i
            else:
                return [temp_dict[sub], i]
        return []


class Solution:
    def twoSum(self, nums:List[int], target : int) -> List[int]:

        dict = {}

        for i in range (len(nums)):
            sub = target - nums[i]
            if sub not in dict:
                dict[nums[i]] = i
            else:
                return [i, dict[sub]]
        return []