#!/usr/bin/env python
# -*- coding: utf-8 -*-

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
    print(dec_to_bin(64))