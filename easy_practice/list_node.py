#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
链表相关简单习题
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def print_list_reversingly(phead):
    """
    从尾到头打印链表 P5
    """
    stack = []
    while phead:
        stack.append(phead)
        phead = phead.next

    while stack:
        node = stack.pop()
        print(node.val,)


def merge_ordered_node(phead1, phead2):
    """
    合并两个有序的链表,递归解法（Java 中有道类似的题，合并有序数组，没有使用递归的方式）
    会改变传入参数
    TODO: 对比java那道合并有序数组的题目
    """
    if phead1 is None:
        return phead2
    if phead2 is None:
        return phead1
    if phead1.val < phead2.val:
        merged_head = phead1
        merged_head.next = merge_ordered_node(phead1.next, phead2)
    else:
        merged_head = phead2
        merged_head.next = merge_ordered_node(phead1, phead2.next)
    return merged_head


def reverse_list_node(phead):
    """
    反转单链表，非递归
    """
    pNode = phead
    pPrev = None
    reversed_head = None
    while pNode:
        pNext = pNode.next
        if pNext is None:
            reversed_head = pNode
        pNode.next = pPrev
        # 移动游标
        pPrev = pNode
        pNode = pNext
    return reversed_head


def reverse_list_node2(phead):
    """
    反转单链表，递归
    :param phead:
    """
    if not phead or not phead.next:
        return phead
    else:
        reversed_head = reverse_list_node2(phead.next)
        phead.next.next = phead
        phead.next = None
        return reversed_head


def find_kth_node(head, k):
    """
    返回倒数第 k 个节点
    """
    if not head:
        return head
    if k <= 0:
        return None
    p1 = head
    p2 = head
    # 让 p1 指针比 p2 快 k 个节点
    for i in range(0, k-1):
        if p1.next:
            p1 = p1.next
        else:
            return None
    while p1.next:
        p1 = p1.next
        p2 = p2.next
    return p2


def find_first_common_node(phead1, phead2):
    """
    输入两个链表，返回它们的第一个公共节点
    """
    length1 = get_list_length(phead1)
    length2 = get_list_length(phead2)
    length_diff = abs(length1 - length2)

    if length1 > length2:
        long_list = phead1
        short_list = phead2
    else:
        long_list = phead2
        short_list = phead1

    for i in range(length_diff):
        long_list = long_list.next

    while long_list is not None and short_list is not None and long_list != short_list:
        long_list = long_list.next
        short_list = short_list.next

    first_common_node = long_list
    return first_common_node


def get_list_length(phead):
    """
    返回链表的长度
    """
    length = 0
    while phead is not None:
        phead = phead.next
        length += 1
    return length


if __name__ == '__main__':
    node1 = ListNode(1)
    node2 = ListNode(3)
    node3 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node4 = ListNode(2)
    node5 = ListNode(4)
    node6 = ListNode(6)
    node4.next = node5
    node5.next = node6
    merged = merge_ordered_node(node1, node4)
    while merged:
        print(merged.val, end=" |"),
        merged = merged.next
    print("\n" + str(get_list_length(node1)) + "\n")

    reversed_result = reverse_list_node2(node1)
    while reversed_result:
        print(reversed_result.val, end=" |"),
        reversed_result = reversed_result.next
