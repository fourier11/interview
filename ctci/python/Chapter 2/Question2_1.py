#!/usr/bin/env python
# -*- coding: utf-8 -*-


from classes.LinkedList import randomLinkedList

"""
移除未排序链表中的重复结点
"""
# use a hash table, O(n)，只利用了key，也可以用set来实现
def deleteDups(linkedlist):
    if (linkedlist.head != None):
        currNode = linkedlist.head
        dic =  {currNode.value: True}
        while currNode.next != None:
            if currNode.next.value in dic:
                currNode.next = currNode.next.next
            else:
                dic[currNode.next.value] = True
                currNode = currNode.next

def delete_dups(linkedlist):
    if linkedlist.head is not None:
        currNode = linkedlist.head
        currNode_set = set()
        currNode_set.add(currNode.value)
        while currNode.next is not None:
            if currNode.next.value in currNode_set:
                currNode.next = currNode.next.next
            else:
                currNode_set.add(currNode.next.value)
                currNode = currNode.next

# use no data structure, O(n2)
def deleteDups2(linkedlist):
    currNode = linkedlist.head
    while currNode != None:
        runner = currNode
        while runner.next != None:
            if runner.next.value == currNode.value:
                runner.next = runner.next.next
            else:
                runner = runner.next
        currNode = currNode.next




#---------------- test --------------------
L1 = randomLinkedList(9, 3, 7)
print(L1)
deleteDups(L1)
print(L1)
L2 = randomLinkedList(9, 3, 7)
print(L2)
deleteDups2(L2)
print(L2)
L3 = randomLinkedList(9, 3, 7)
print(L3)
delete_dups(L3)
print(L3)