#!/usr/bin/env python
# -*- coding: utf-8 -*-

from classes.LinkedList import *

"""
以给定值x，把链表分成两部分，所有小于x的结点排在大于或等于x的结点之前
画图更容易理解流程。
P1不需要比较，因为分界点本身就不确定，如果P1小于x，把P1算到左半边。如果P1大于x，可以把P1算到右半边。
"""


def partition(linkedlist, x):
    if linkedlist.head != None:
        p1 = linkedlist.head
        p2 = linkedlist.head.next
        while p2 != None:
            if p2.value < x:
                p1.next = p2.next
                # 这一行，把P2放到了头结点的后面
                p2.next = linkedlist.head
                # 然后头结点变成P2
                linkedlist.head = p2
                # 继续把P2放在P1后面
                p2 = p1.next
            else:
                p1 = p1.next
                p2 = p1.next


#----------------test-----------------
L = randomLinkedList(10, 0, 50)
x = 25

print L, " , x=25"   
partition(L, x)
print L 
