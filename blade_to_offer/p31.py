#!/usr/bin/env python
# -*- coding: utf-8 -*-

'''
输入一个整型数组,数组里有整数也有负数。
数组中一二或连续的多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)

注：面试的时候遇到这道题的变形，不要生搬硬套。

'''

class Solution:
    def FindGreatestSumOfSubArray(self, array):
        if array == None or len(array) == 0:
            return None
        cur_sum = 0
        greatest_sum = array[0]
        for i in range(len(array)):
            if cur_sum <= 0:
                cur_sum = array[i]
            else:
                cur_sum += array[i]
            if cur_sum >= greatest_sum:
                greatest_sum = cur_sum
        return greatest_sum
