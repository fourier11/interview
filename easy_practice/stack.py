#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
栈相关的练习题，十进制转二进制还是比较有意思的，
其他就当了解一些概念
"""


class Stack(object):
    def __init__(self):
        self.items = []

    def is_empty(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[len(self.items)-1]

    def size(self):
        return len(self.items)


# 利用栈将字串的字符反转
def reverse_str(mystr):
    s = Stack()
    output_str = ''
    for c in mystr:
        s.push(c)
    while not s.is_empty():
        output_str += s.pop()
    return output_str


# 利用栈将十进制整数转化为二进制整数
def dec_to_bin(dec_number):
    s = Stack()
    while dec_number > 0:
        temp = dec_number % 2
        s.push(temp)
        dec_number = dec_number // 2
    bin_string = ''
    while not s.is_empty():
        bin_string += str(s.pop())
    return bin_string

if __name__ == '__main__':
    test_str = "abcdefg"
    print(reverse_str(test_str))

    print(dec_to_bin(64))