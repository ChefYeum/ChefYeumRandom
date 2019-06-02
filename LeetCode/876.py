class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        
        count = 1
        print ("count: ", count)
        mid = head.val
        print ("mid: ", mid)
        nextNode = head.next
        while (nextNode != None):
            count += 1
            if (count%2 == 0):  
                mid = nextNode.val 
            nextNode = head.next
        return mid
def stringToIntegerList(input):
    return json.loads(input)

def stringToListNode(input):
    # Generate list from the input
    numbers = stringToIntegerList(input)

    # Now convert that list into linked list
    dummyRoot = ListNode(0)
    ptr = dummyRoot
    for number in numbers:
        ptr.next = ListNode(number)
        ptr = ptr.next
    ptr = dummyRoot.next
    return ptr

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

if __name__ == "__main__":
    s = Solution()
    inputParsed = stringToListNode([1,2,3,4,5])
    print(s.middleNode(inputParsed))
