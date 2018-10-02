#!/usr/bin/env python
# -*- coding: utf-8 -*-

# 最小 k 个数
# 方法一：可以修改输入的数组，可以 O(n) 算法，比排序 O(nlogn)好，还是用到快排的划分算法。


class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        if tinput == None or len(tinput) <= 0 or len(tinput) < k or k <=0:
            return []
        n = len(tinput)
        start = 0
        end = n - 1
        index = self.Partition(tinput, n, start, end)
        while index != k-1:
            if index > k-1:
                end = index - 1
                index = self.Partition(tinput, n, start, end)
            else:
                start = index + 1
                index = self.Partition(tinput, n, start, end)
        output = tinput[:k]
        output.sort()
        return output

    def Partition(self, numbers, length, start, end):
        if numbers == None or length <= 0 or start < 0 or end >= length:
            return None
        if end == start:
            return end
        pivotvlue = numbers[start]
        leftmark = start + 1
        rightmark = end

        done = False

        while not done:
            while numbers[leftmark] <= pivotvlue and leftmark <=rightmark:
                leftmark += 1
            while numbers[rightmark] >= pivotvlue and rightmark >= leftmark:
                rightmark -= 1
            if leftmark > rightmark:
                done = True
            else:
                numbers[leftmark], numbers[rightmark] = numbers[rightmark], numbers[leftmark]
        numbers[rightmark], numbers[start] = numbers[start], numbers[rightmark]
        return rightmark

    # 方法二适合海量数据，复杂度 O(nlogk),最大堆的概念还不清楚，需要再深入了解一下
    def GetLeastNumbers(self, tinput, k):
        import heapq
        if tinput == None or len(tinput) < k or len(tinput) <= 0 or k <= 0:
            return []
        output = []
        for number in tinput:
            if len(output) < k:
                output.append(number)
            else:
                output = heapq.nlargest(k, output)
                if number >= output[0]:
                    continue
                else:
                    output[0] = number
        return output[::-1]  # 因为是最大堆，需要逆向输出 k 个数
