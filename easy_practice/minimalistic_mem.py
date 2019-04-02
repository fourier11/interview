#!/usr/bin/env python
# -*- coding: utf-8 -*-

'''
缓存优化示例，这样可以避免不必要的重复计算
'''
def fib(n):
    if n == 1 or n == 0:
        return 1
    return fib(n-2) + fib(n-1)


# 普通写法
def memoize(f):
    cache = {}

    def memf(*x):
        if x not in cache:
            cache[x] = f(*x)
        return cache[x]
    return memf

fib = memoize(fib)
print(fib(10))


# 采用装饰器的写法
@memoize
def fib_new(n):
    if n == 1 or n == 0:
        return 1
    return fib_new(n-2) + fib_new(n-1)
print(fib_new(10))
