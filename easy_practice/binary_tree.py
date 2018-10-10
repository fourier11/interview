#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
二叉树相关练习题，都是些比较简单的
"""


class BTNode(object):
    def __init__(self, data):
        self.data = data
        self.left_child = None
        self.right_child = None


# 给一个列表，生成二叉树,而且是查找二叉树，递归方式
def init_binary_tree(source_data, length):
    root = BTNode(source_data[0])
    for x in range(1, length):
        node = BTNode(source_data[x])
        insert_tree(root, node)
    return root


def insert_tree(root, node):
    if root:
        if node.data < root.data:
            if root.left_child:
                insert_tree(root.left_child, node)
            else:
                root.left_child = node
        else:
            if root.right_child:
                insert_tree(root.right_child, node)
            else:
                root.right_child = node
    else:
        return None


# 前序 pre order（递归写法）
def pre_order(root):
    if root:
        print("%d | " % root.data, end="")
        pre_order(root.left_child)
        pre_order(root.right_child)


# 前序非递归写法
def pre_order2(root):
    stack = [root]
    while stack:
        node = stack.pop()
        print('%d | ' % node.data, end="")
        if node.right_child:
            stack.append(node.right_child)
        if node.left_child:
            stack.append(node.left_child)


# 中序 in order
def in_order(root):
    if root:
        in_order(root.left_child)
        print('%d | ' % root.data, end="")
        in_order(root.right_child)


# 后序 post order
def post_order(root):
    if root:
        post_order(root.left_child)
        post_order(root.right_child)
        print('%d | ' % root.data, end="")


def layer_order(root, length):
    """
    按层遍历(非递归方式)
    :param root:
    :param length: 表示节点的个数，不是树的深度
    :return:
    """
    alist = [root]
    for x in range(length):
        node = alist[x]
        print('%d | ' % node.data, end="")
        if node.left_child:
            alist.append(node.left_child)
        if node.right_child:
            alist.append(node.right_child)


def reConstructBinaryTree(pre, tin):
    """
    重建二叉树 P6
    输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    :param pre:前序遍历
    :param tin:中序遍历
    """
    if not pre and not tin:
        return None
    if set(pre) != set(tin):
        return None

    proot = BTNode(pre[0])  # 先拿到根节点
    i = tin.index(pre[0])
    # 下面这段递归是我个人很难想到,还是比较巧妙的，注意i+1
    proot.left_child = reConstructBinaryTree(pre[1:i+1], tin[:i])
    proot.right_child = reConstructBinaryTree(pre[i+1:], tin[i+1:])
    return proot


if __name__ == '__main__':
    source_data = [4, 3, 1, 2, 5, 6, 8, 9]
    root = init_binary_tree(source_data, 8)
    """
    以下是测试数据二叉树大致结构
    ***4****
    **3*5***
    *1***6**
    **2***8*
    *******9
    """
    pre_order(root)
    print('\n')
    pre_order2(root)
    print('\n')
    in_order(root)
    print('\n')
    post_order(root)
    print('\n')
    layer_order(root, 8)
    print("\n")

    root2 = reConstructBinaryTree([4, 3, 1, 2, 5, 6, 8, 9], [1, 2, 3, 4, 5, 6, 8, 9])
    pre_order(root2)

