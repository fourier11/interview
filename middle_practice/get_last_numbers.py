#!/usr/bin/env python
# -*- coding: utf-8 -*-

'''
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
难度：****
'''

class Solution:
    # 基于Partition的方法， 算法复杂度是 O(n)
    def GetLeastNumbers_Solution(self, tinput, k):
        if tinput is None or len(tinput) < k or k <= 0:
            return []
        start = 0
        end = len(tinput) - 1
        index = self.Partition(tinput, start, end)
        while index != k-1:
            if index > k-1:
                end = index - 1
                index = self.Partition(tinput, start, end)
            else:
                start = index + 1
                index = self.Partition(tinput, start, end)
        output = tinput[:k]
        output.sort()
        return output

    # 快排的划分算法（这个很重要，必须掌握，能有多种变形）,返回的是 key 的 index
    def Partition(self, numbers, start, end):
        if numbers is None or start < 0 or end >= len(numbers):
            return None
        if end == start:
            return start
        key = numbers[start]
        leftmark = start
        rightmark = end

        while leftmark < rightmark:
            while numbers[rightmark] >= key and leftmark < rightmark:
                rightmark -= 1
            numbers[leftmark] = numbers[rightmark]
            while numbers[leftmark] <= key and leftmark < rightmark:
                leftmark += 1
            numbers[rightmark] = numbers[leftmark]
        numbers[leftmark] = key
        return leftmark


tinput = [4, 5, 1, 6, 2, 7, 3, 8]
s = Solution()
print(s.GetLeastNumbers_Solution(tinput, 4))
