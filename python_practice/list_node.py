#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
链表相关简单习题
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def find_loop_entry(phead):
    """
    寻找环的入口
    注：从链表起点head开始到入口点的距离a,与从slow和fast的相遇点到入口点的距离加上环的整数倍相等。
    """
    fast = phead
    slow = phead
    while slow != None and fast.next != None:
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            break
    if slow == None or fast.next == None:
        return None
    ptr1 = phead
    ptr2 = slow
    while ptr1 != ptr2:
        ptr1 = ptr1.next
        ptr2 = ptr2.next
    return ptr1


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
    # merged = merge_ordered_node(node1, node4)
    # while merged:
    #     print(merged.val, end=" |")
    #     merged = merged.next
    # print("\n" + str(get_list_length(node1)) + "\n")

    # reversed_result = reverse_list_node2(node1)
    # while reversed_result:
    #     print(reversed_result.val, end=" |"),
    #     reversed_result = reversed_result.next
    node3.next = node4
    node4.next = node2
    print(has_loop(node1))
    print(find_loop_entry(node1).val)
