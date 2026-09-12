class Solution:
    def kSum(self, nums: List[int], target: int, k: int) -> List[List[int]]:
        res = []
        if not nums:
            return res
        avg = target // k
        if nums[-1] < avg or nums[0] > avg:
            return res

        if k == 2:
            return self.twoSum(nums, target)
        
        for i in range(len(nums)):
            if i == 0 or nums[i-1] != nums[i]:
                temp_res = self.kSum(nums[i + 1:], target - nums[i], k - 1)
                for sub_list in temp_res:
                    res.append([nums[i]] + sub_list)
        return res
        
    def twoSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        cache_set = set()

        for i in range(len(nums)):
            if not res or res[-1][0] != nums[i]:
                remaining = target - nums[i]
                if remaining in cache_set:
                    res.append([nums[i], remaining])
            cache_set.add(nums[i])
        return res
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        return self.kSum(nums, target, 4)
        