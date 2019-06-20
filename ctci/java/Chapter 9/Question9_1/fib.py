# -*- coding:utf-8 -*-
class Solution:
    # Fib数列问题，下面这两种方法都是比较优化的
    # 第一种方法采用了动态规划方式，用result数组缓存过
    def jumpFloor(self, number):
        # write code here
        if number == 1:
            return 1
        elif number == 2:
            return 2
        result = {}
        result[1] = 1
        result[2] = 2
        for i in range(3, number+1):
            result[i] = result[i-1] + result[i-2]
        return result[number]

    def jumpFloor2(self, number):
        # write code here
        num1 = 0
        num2 = 1
        num3 = 0
        if number < 2:
            return 1
        for i in range(1, number+1):
            num3 = num1 + num2
            num1 = num2
            num2 = num3
        return num3

    # 变态跳台阶
    def jumpFloor3(self, number):
        # write code here
        if number == 1:
            return 1
        elif number == 2:
            return 2
        result = {}
        result[1] = 1
        result[2] = 2
        for i in range(3, number+1):
            result[i] = 2 * result[i-1]
        return result[number]
