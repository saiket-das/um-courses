"""
Shell sort improves insertion sort by: 
    comparing elements that are far apart first, then gradually reducing the gap

So instead of sorting adjacent elements only, we first sort:
    far elements → then closer → then final insertion sort
"""

def shell_sort(arr):
    n = len(arr)
    
    gap = n // 2

    while gap > 0:
        for i in range(gap, n):
            temp = arr[i]
            j = i 

            while j >= gap and temp < arr[j - gap]:
                arr[j] = arr[j - gap]
                j -= gap
            
            arr[j] = temp

        gap //= 2

    return arr


arr = [5, 2, 4, 8, 3]
print(shell_sort(arr))



"""
Time and Space Complexity
-------------------------------
            Time        Space
-------------------------------            
Best        O(nlogn)    O(1)
Average     O(n^1.5)    O(1)
Worst       O(n^2)      O(1)
"""

