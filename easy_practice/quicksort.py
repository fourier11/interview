#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
快速排序的几种写法，非常经典的算法。
"""


def quicksort(lst, lo, hi):
    """
    注意：这里hi不是list最后一位的索引，而是length
    """
    if lo < hi:
        p = partition(lst, lo, hi)
        quicksort(lst, lo, p)
        quicksort(lst, p+1, hi)
    return


def partition(lst, lo, hi):
    # 以中间值为 key 值
    pivot = lst[(lo + hi) // 2]
    i = lo - 1
    for j in range(lo, hi):
        if lst[j] < pivot:
            i += 1
            lst[i], lst[j] = lst[j], lst[i]
    if lst[hi-1] < lst[i+1]:
        lst[i+1], lst[hi-1] = lst[hi-1], lst[i+1]
    return i+1


def quick_sort_from_baike(L, low, high):
    """
    百度百科上的示例代码，感觉应该是最精简的快排代码
    :param L:
    :param low:
    :param high:
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


a = [2, 9, 3, 4, 1, 6, 45, 23, 78, 44, 23, 11]
quicksort(a, 0, len(a))
print(a)

a = [2, 9, 3, 4, 1, 6, 45, 23, 78, 44, 23, 11]
quick_sort_from_baike(a, 0, len(a)-1)
print(a)