#!/usr/bin/env python
# -*- coding: utf-8 -*-


# 对字符串中的单词进行反转，但是字符不能反转
def swap_words(text):
    char_list = list(text)
    char_list.reverse()
    begin = 0
    for i in range(len(char_list)):
        if char_list[i] == ' ':
            swap(char_list, begin, i-1)
            begin = i + 1
    swap(char_list, begin, len(char_list)-1)
    print("".join(char_list))


# 和上面的是同一个题目
def swap(arry_list, begin, end):
    while begin < end:
        arry_list[begin], arry_list[end] = arry_list[end], arry_list[begin]
        begin += 1
        end -= 1


def permutation(ss):
    """
    把字符串的每种排列展示出来
    注：还不理解
    难度：***
    :param ss:输入的字符串
    :return:
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
        # TODO:弄明白为什么注释掉
        # str_list=list(set(str_list))
        # str_list.sort()
    return str_list


if __name__ == "__main__":
    text = "Hello world abc"
    swap_words(text)
    # ss = 'abc'
    # print(group(ss))


