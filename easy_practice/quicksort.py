#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
快速排序的几种写法，非常经典的算法。
"""


def quick_sort_from_baike(L, low, high):
    """
    百度百科上的示例代码，感觉应该是最精简的快排代码
    """
    i = low
    j = high
    if i >= j:
        return L
    key = L[i]  # 从头取 key 值
    while i < j:
        while i < j and L[j] >= key:
            j -= 1
        L[i] = L[j]
        while i < j and L[i] <= key:
            i += 1
        L[j] = L[i]
    L[i] = key
    quick_sort_from_baike(L, low, i-1)
    quick_sort_from_baike(L, j+1, high)
    return L

def quicksort_for_python(array):
    '''
    更加精简的快排，利用了Python的列表表达式,问题是用到了额外的存储空间，
    如果列表很大，这个解法就非常不合适了。
    '''
    if len(array) < 2:
        # base case, arrays with 0 or 1 element are already "sorted"
        return array
    else:
        # recursive case
        pivot = array[0]
        # sub-array of all the elements less than the pivot
        less = [i for i in array[1:] if i <= pivot]
        # sub-array of all the elements greater than the pivot
        greater = [i for i in array[1:] if i > pivot]
        return quicksort_for_python(less) + [pivot] + quicksort_for_python(greater)

a = [2, 9, 3, 4, 1, 6, 45, 23, 78, 44, 23, 11]
quicksort(a, 0, len(a))
print(a)

a = [2, 9, 3, 4, 1, 6, 45, 23, 78, 44, 23, 11]
quick_sort_from_baike(a, 0, len(a)-1)
print(a)

a = [2, 9, 3, 4, 1, 6, 45, 23, 78, 44, 23, 11]
print(quicksort_for_python(a))