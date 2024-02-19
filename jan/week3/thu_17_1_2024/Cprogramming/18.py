def findMedianSortedArrays(nums1, nums2):
    merged = sorted(nums1 + nums2)
    n = len(merged)
    
    if n % 2 == 0:
       
        return (merged[n // 2 - 1] + merged[n // 2]) / 2
    else:

        return merged[n // 2]
    
nums1 = [1, 3]
nums2 = [2]
result = findMedianSortedArrays(nums1, nums2)
print(result)    