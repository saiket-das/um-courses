def insertion_sort(arr):
    n = len(arr)

    # Start from index 1 (because assume index 0 is already "sorted")
    for i in range(1, n):
        key = arr[i]    # Element to insert
        j = i - 1

        # Think: left side = sorted elements
        while j >= 0 and key < arr[j]:
            # Shift larger elements to the right
            arr[j + 1] = arr[j]
            j -= 1
        
        # Insert element in correct position
        arr[j + 1] = key 
        
    return arr


arr = [5, 2, 4, 8, 3]
print(insertion_sort(arr))



"""
Time and Space Complexity
-------------------------------
            Time        Space
-------------------------------            
Best        O(n)        O(1)
Average     O(n^2)      O(1)
Worst       O(n^2)      O(1)
"""