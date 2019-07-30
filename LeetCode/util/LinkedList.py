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
