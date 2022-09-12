# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def tree2str(self, root):
        """
        :type root: TreeNode
        :rtype: str
        """
        
        string = self.helper(root)
        return string
    def helper(self,root):
        if root != None:
            string = str(root.val)
            if root.left != None:
                
                string = string+"("+self.helper(root.left)+")"
            if root.right != None and root.left == None:
                string = string+"()("+self.helper(root.right)+")"
            if root.right != None and root.left != None:
                string = string+"("+self.helper(root.right)+")"
        else:
            string = ""
        
        
        
        return string
    
    
        