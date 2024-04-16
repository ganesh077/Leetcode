# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        dep = 1
        stack = [(root,dep)]
        if not root:
            node = TreeNode(val)
            return node
        if not root.left  and not root.right:
            node = TreeNode(val)
            node.left = root
            root = node
            return node
        if depth - 1 == 0:
            node = TreeNode(val)
            node.left = root
            root = node
            return node

        while stack:
            node, curr_dep = stack.pop()
            if curr_dep + 1 == depth:
                if node.left:
                    newnode = TreeNode(val)
                    newnode.left = node.left
                    node.left = newnode
                else:
                    newnode = TreeNode(val)
                    node.left = newnode
                if node.right:
                    newnode = TreeNode(val)
                    newnode.right = node.right
                    node.right = newnode
                else:
                    newnode = TreeNode(val)
                    node.right = newnode  
            if node.left:
                stack.append((node.left,curr_dep+1))
            if node.right:
                stack.append((node.right,curr_dep+1))
        return root

            


            
        




        