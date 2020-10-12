#!/usr/bin/env python
# -*- coding: utf-8 -*-

def group(ss):
    """
    生成字符所有的组合
    """
    if not ss:
        return []
    if len(ss) == 1:
        return list(ss)
    char_list = list(ss)
    char_list.sort()
    str_list = []
    for i in range(len(char_list)):
        str_list.append(char_list[i])
        if i > 0 and char_list[i] == char_list[i-1]:
            continue
        tmp = group(''.join(char_list[i+1:]))
        for j in tmp:
            str_list.append(char_list[i]+j)
    return str_list


if __name__ == "__main__":
    ss = 'abc'
    print(group(ss))
