from collections import Counter

def couting_sort(arr):
    
    # Count occurrences
    count = [0] * (max(arr) + 1)

    # Find frequency
    for num in arr:
        count[num] += 1

    # Build Sorted Array
    sorted_arr = []

    for freq in range(len(count)):
        for _ in range(count[freq]):
            sorted_arr.append(freq)

    return sorted_arr


arr = [5, 2, 4, 8, 3]
print(couting_sort(arr))



"""
Time and Space Complexity
-------------------------------
            Time        Space
-------------------------------            
Best        O(n+k)      O(n+k)
Average     O(n+k)      O(n+k)
Worst       O(n+k)      O(n+k)

n = number of elements, k = range of value (max - min + 1)
"""

