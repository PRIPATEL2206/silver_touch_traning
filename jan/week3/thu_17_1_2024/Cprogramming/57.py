# file 57.py
# The Maximum Sum Increasing Subsequence Problem involves finding the maximum sum of an increasing subsequence in an array.

def max_sum_increasing_subsequence(nums):
    n = len(nums)
    max_sum = nums.copy()

    for i in range(1, n):
        for j in range(i):
            if nums[i] > nums[j] and max_sum[i] < max_sum[j] + nums[i]:
                max_sum[i] = max_sum[j] + nums[i]

    return max(max_sum)

# Example usage
nums = [1, 101, 2, 3, 100, 4, 5]
result = max_sum_increasing_subsequence(nums)
print(f"Maximum sum of increasing subsequence: {result}")
