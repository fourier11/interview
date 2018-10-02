#!/usr/bin/env python
# -*- coding: utf-8 -*-

'''
在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到「第一个」只出现一次的字符。
用到哈希表的知识点
难度：*
'''


class Solution:
    def FirstNotRepeatingChar(self, s):
        if not s:
            return None
        alphabet = {}
        alist = list(s)
        for i in alist:
            # 利用哈希表，存下所有字符和出现次数的映射关系
            if i not in alphabet.keys():
                alphabet[i] = 0
            alphabet[i] += 1
        for i in alist:
            if alphabet[i] == 1:
                return i
        return -1

s = Solution()
print(s.FirstNotRepeatingChar('abaccdeff'))