#!/usr/bin/env python
# -*- coding: utf-8 -*-

def binary_search(mylist, key):
    """
    二分查找法，非递归
    :param mylist: 要查找的列表
    :param key: 需要匹配的 key
    :return:索引
    """
    start = 0
    end = len(mylist) - 1
    while start <= end:
        mid = (end + start) // 2
        if mylist[mid] > key:
            end = mid - 1
        elif mylist[mid] < key:
            start = mid + 1
        else:
            return mid


if __name__ == '__main__':
    mylist = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    print(binary_search(mylist, 4))
