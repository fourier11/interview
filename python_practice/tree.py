#!/usr/bin/env python
# -*- coding: utf-8 -*-


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    @staticmethod
    def get_deep_node(root):
        """
        返回所有叶子节点的深度（有 bug，有的节点会多减1）,而且这个方法思路不够清晰。
        :param root:
        :return:
        """
        index = 1
        deep_dict = {}
        stack = []
        while True:
            if not root.left and not root.right:
                deep_dict[root.val] = index
            elif root.left and root.right:
                stack.append(root.right)
                root = root.left
                index += 1
                continue
            elif root.left and not root.right:
                root = root.left
                index += 1
                continue
            elif not root.left and root.right:
                root = root.right
                index += 1
                continue

            if stack:
                root = stack.pop()
                index -= 1
            else:
                break
        for key, value in deep_dict.items():
            print("index is" + str(key) + ", value is" + str(value))

    def max_depth(self, root):
        """
        返回树的深度
        :param root:
        :return:
        """
        if not root:
            return 0
        left_depth = self.max_depth(root.left)
        right_depth = self.max_depth(root.right)
        return max(left_depth+1, right_depth+1)

    def get_deep_node2(self, root):
        """
        先获取二叉树的深度，然后前序遍历二叉树，找到深度和最大深度一致的节点，返回一个就可以了
        先出的最右端的最深子节点
        :param root:
        :return:
        """
        depth = self.max_depth(root)
        stack = [root]
        index = 0
        while stack:
            node = stack.pop()
            index += 1
            if index == depth:
                return node.val
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)


if __name__ == "__main__":
    head = TreeNode("A")
    head.left = TreeNode("B")
    head.left.left = TreeNode("E")
    head.left.left.left = TreeNode("F")
    head.left.left.right = TreeNode("M")
    head.right = TreeNode("C")
    head.right.right = TreeNode("D")
    head.right.right.right = TreeNode("Z")
    s = Solution()
    # s.get_deep_node(head)
    print(s.max_depth(head))
    print(s.get_deep_node2(head))