#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
给定两个字符串，编写程序，确定其中一个字符串的字符重新排列后能否编程另一个字符串
第一个函数是忽略大小写，第二个不忽略大小写。个人感觉方法不好，直接调用Counter方法，走了捷径，没有体现出代码功底
"""


def anagram(s1, s2):
    s1 = s1.lower()
    s2 = s2.lower()
    # sort, convert to str and strip
    s1 = ''.join(sorted(s1)).strip()
    s2 = ''.join(sorted(s2)).strip()
    return s1 == s2


def anagram2(string1, string2):
    ''' We just check if the counts of each character are the same '''
    from collections import Counter
    return Counter(string1)==Counter(string2)


if __name__ == '__main__':
    words = ( ('So dark the con          of man', 'Madonna of        The Rocks'),
              (' ba ', ' Ab   '),
              ('anne', 'annea') )
    for w1, w2 in words:
        print('anagram({}, {}): {}'.format(w1, w2, anagram(w1, w2)))
        print('anagram({}, {}): {}'.format(w1, w2, anagram2(w1, w2)))
