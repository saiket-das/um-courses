"""
Bucket Sort works like:
    “Split data into groups (buckets), sort each group, then combine.”
"""

def bucket_sort(arr):
    n = len(arr)

    # Step 1: create buckets
    buckets = [[] for _ in range(n)]

    # Step 2: put elements into buckets
    for num in arr:
        index = num // 2
        if index >= n:
            index = n - 1
        
        buckets[index].append(num)

    # Step 3: sort each bucket
    for i in range(n):
        buckets[i].sort()
    
    # Step 4: Merge buckets
    sorted_arr = []
    for bukcet in buckets:
        sorted_arr.extend(bukcet)

    return sorted_arr


arr = [5, 2, 4, 8, 3]
print(bucket_sort(arr))



"""
Time and Space Complexity
-------------------------------
            Time        Space
-------------------------------            
Best        O(n+k)      O(n+k)
Average     O(n+k)      O(n+k)
Worst       O(n^2)      O(n+k)    => All elements fall into one bucket, that bucket becomes a normal list

n = number of elements, k = range of value (max - min + 1)
"""

