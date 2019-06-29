# -*- coding:utf-8 -*-
class Solution:
    # array 二维列表
    def Find(self, target, array):
        # write code here
        if array is None:
            return
        raw_num = len(array)
        col_num = len(array[0])
        i = col_num - 1
        j = 0
        while i > 0 and j < raw_num:
            if array[j][i] < target:
                j += 1
            elif array[j][i] > target:
                i -= 1
            else:
                return True
        return False
            