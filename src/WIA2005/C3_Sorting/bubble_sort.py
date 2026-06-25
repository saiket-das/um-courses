def bubble_sort(arr):
    n = len(arr)

    for i in range(n):
        for j in range(n - i - 1):
            if (arr[j+1] < arr[j]):
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
        
    return arr


arr = [5, 2, 4, 8, 3]
print(bubble_sort(arr))



"""
Time and Space Complexity
            Time        Space
Best        O(n^2)      O(1)
Average     O(n^2)      O(1)
Worst       O(n^2)      O(1)
"""