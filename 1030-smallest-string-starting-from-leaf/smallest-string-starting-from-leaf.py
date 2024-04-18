# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
         stack = [(root,chr(root.val+97))]
         min = ''
         
         while stack:
            node , val = stack.pop()
            if not node.left and not node.right:
                #print(val)
                if min == '':
                    min = val
                elif val < min:
                    min = val
            if node.left:
                print(val+chr(node.left.val+65))
                stack.append((node.left,(chr(node.left.val+97)+val)))
            if node.right:
                print(val+chr(node.right.val+65))
                stack.append((node.right,(chr(node.right.val+97)+val)))
        
         return min


        