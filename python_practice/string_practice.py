#!/usr/bin/env python
# -*- coding: utf-8 -*-


def permutation(ss):
    """
    把字符串的每种排列展示出来,排列是有顺序的
    注：还不理解
    """
    if not len(ss):
        return []
    if len(ss) == 1:
        return list(ss)
    char_list = list(ss)
    char_list.sort()
    str_list = []
    for i in range(len(char_list)):
        if i > 0 and char_list[i] == char_list[i-1]:
            continue
        tmp = permutation(''.join(char_list[:i]) + ''.join(char_list[i+1:]))
        for j in tmp:
            str_list.append(char_list[i]+j)
    return str_list


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
    text = "Hello world abc"
    swap_words(text)

    ss = "abc"
    print(permutation(ss))

    ss = 'abc'
    print(group(ss))


