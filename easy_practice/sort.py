#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
快排以外的其他几种排序
"""


def bubble(bubble_list):
    """
    冒泡排序
    :param bubble_list:
    :return:
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
        mid = len(alist)//2
        # 归并排序的缺点就是下面这两行，要申请额外的存储空间
        lefthalf = alist[:mid]
        righthalf = alist[mid:]

        merge_sort(lefthalf)
        merge_sort(righthalf)

        i = 0; j = 0; k = 0
        while i < len(lefthalf) and j < len(righthalf):
            if lefthalf[i] < righthalf[j]:
                alist[k] = lefthalf[i]
                i += 1
            else:
                alist[k] = righthalf[j]
                j += 1
            k += 1

        while i < len(lefthalf):
            alist[k] = lefthalf[i]
            i += 1
            k += 1
        while j < len(righthalf):
            alist[k] = righthalf[j]
            j += 1


if __name__ == '__main__':
    alist = [3, 4, 5, 2, 6, 8, 7]
    print(insert_sort(alist))
