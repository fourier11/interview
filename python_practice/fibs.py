#!/usr/bin/env Python
# coding=utf-8

def fibs(max):
    """
    斐波那契数列生成器
    :param max: 
    :return: 
    """
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b = b, a + b
        n = n + 1

if __name__ == "__main__":
    f = fibs(10000)
    for i in f:
       print(i)