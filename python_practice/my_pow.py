#!/usr/bin/env python
# -*- coding: utf-8 -*-


def my_power(base, exponent):
    """
    自身实现的高次方， base 的 exponent 次方， 采用了递归方式
    :param base:
    :param exponent:
    :return:
    """
    if exponent == 0:
        return 1
    if exponent == 1:
        return base
    if exponent > 0:
        result = my_power(base, exponent // 2)
        result *= result
        if exponent % 2 != 0:
            result *= base
        return result
    else:
        result = my_power(base, -exponent // 2)
        result *= result
        if -exponent % 2 != 0:
            result *= base
        return 1/result



print(my_power(3,3))
print(my_power(2,5))
print(my_power(-2,7))