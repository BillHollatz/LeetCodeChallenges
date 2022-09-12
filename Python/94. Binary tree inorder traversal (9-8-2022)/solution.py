# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.list = []
        self.helper(root)
        return self.list

    def helper(self, root):
        if root != None:
            if root.left != None:
                self.helper(root.left)
            self.list.append(root.val)
            if root.right != None:
                self.helper(root.right)
