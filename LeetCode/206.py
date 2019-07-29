# Definition for singly-linked list.
from util.LinkedList import ListNode

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        current = head
        next =  current.next if current else None
        print (f"({prev},{current.val},{next.val})")

        while next:
            current.next = prev
            tempNext = next.next
            next.next = current

            prev = current
            current = next
            next = tempNext

            # print (f"({prev.val},{current.val},{next.val if next else 'None'})")
            print (f"({prev},{current},{next})")

        return current

    def reverseList(self, head: ListNode) -> ListNode:
        prev = None

        while head:
            current = head
            head = head.next

            current.next = prev
            prev = current

        return prev

if __name__ == "__main__":
    s = Solution()
    result = s.reverseList(ListNode([1,2,3,4]))
    print (f"result: {result}")
