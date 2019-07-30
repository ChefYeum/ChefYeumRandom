from util.LinkedList import ListNode

class ListNodeRef(ListNode):
    def __init__(self, x):
        super().__init__(x)
    def __repr__(self):
        return str(id(self))

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        been = []
        while head:
            if head.next in been:
                return been.index(head.next)
            else:
                been.append(head)
                head = head.next
        return -1

if __name__ == "__main__":
    s = Solution()
    cycledList = ListNodeRef([3,2,0,-4])
    cycledList.next.next = cycledList.next
    print (str(cycledList))
    print (s.detectCycle(cycledList))
