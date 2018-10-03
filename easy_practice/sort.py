#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
快排以外的其他几种排序
"""


def bubble(bubble_list):
    """
    冒泡排序
    """
    for i in range(len(bubble_list)-1):
        for j in range(len(bubble_list)-1-i):
            if bubble_list[j] > bubble_list[j+1]:
                bubble_list[j], bubble_list[j+1] = bubble_list[j+1], bubble_list[j]
    return bubble_list


def insert_sort(alist):
    """
    插入排序
    """
    for key, item in enumerate(alist):
        index = key
        while index > 0 and alist[index-1] > item:
            alist[index] = alist[index-1]
            index -= 1
        alist[index] = item
    return alist


def merge_sort(alist):
    """
    归并排序，递归方案
    """
    # 最小的分组也要有 2 个元素
    if len(alist) > 1:
        mid = len(alist) // 2
        # 归并排序的缺点就是下面这两行，要申请额外的存储空间
        left_half = alist[:mid]
        right_half = alist[mid:]

        merge_sort(left_half)
        merge_sort(right_half)

        i = 0
        j = 0
        k = 0
        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                alist[k] = left_half[i]
                i += 1
            else:
                alist[k] = right_half[j]
                j += 1
            k += 1

        while i < len(left_half):
            alist[k] = left_half[i]
            i += 1
            k += 1
        while j < len(right_half):
            alist[k] = right_half[j]
            j += 1
            k += 1


if __name__ == '__main__':
    alist = [3, 4, 5, 2, 6, 8, 7]
    print(bubble(alist))

    alist = [3, 4, 5, 2, 6, 8, 7]
    print(insert_sort(alist))

    alist = [3, 4, 5, 2, 6, 8, 7]
    merge_sort(alist)
    print(alist)
