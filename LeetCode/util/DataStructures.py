# Definition for a singly linked list
# val cannot be List type
class ListNode:
    def __init__(self, x):
        if type(x) == list:
            self.next = ListNode(x[1:]) if len(x) > 1 else None
            self.val = x[0]
        else:
            self.val = x
            self.next = None
    def __repr__(self):
        return f"{self.val} -> {repr(self.next)}"
    def append(self, val):
        mv = self
        while mv.next:
            mv = mv.next
        mv.next = ListNode(val)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        # TODO: Other iterables?
        # TODO: Error for [1,2,None,4]
        if type(x) is list:
            if not x[0]: # Null check
                raise TypeError
            else:
                if len(x) == 1:
                    self.val = x.pop(0)
                    self.left = None
                    self.right = None
                elif len(x) == 2:
                    self.val = x.pop(0)
                    self.left = TreeNode(x.pop(0)) if x[0] else None
                    self.right = None
                else:
                    self.val = x.pop(0)
                    leftVal, rightVal = x.pop(0), x.pop(0)
                    self.left = TreeNode([leftVal] + x) if leftVal else None
                    self.right = TreeNode([rightVal] + x) if rightVal else None
        else: # Cases where x is not a list
            self.val = x
            self.left = None
            self.right = None

    # TODO: Finish implementation
    def __str__(self):
        if self.left or self.right:
            lines = []
            lines.append(self.val)
            #lines.append("/ \\")
            lines.append(f"{str(self.left)} {str(self.right)}")
            return ("\n".join(lines))
        else:
            return str(self.val)

