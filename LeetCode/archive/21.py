class ListNode():
    def __init__(self, values):
        if len(values) == 1:
            self.val = values[0]
            self.next = None
        else:
            self.val = values[0]
            self.next = ListNode(values[1:])
    def __repr__(self):
        output = "[" + str(self.val)
        nextNode = self.next 

        while nextNode != None:
            output += ", " + str(nextNode.val) 
            nextNode = nextNode.next

        return output + "]"
    def toList(self):
        output = [self.val]
        nextNode = self.next

        while nextNode != None:
            output.append(nextNode.val)
            nextNode = nextNode.next
        return output

def mergeTwoLists(l1, l2):
    if l1 == None:
        return l2
    elif l2 == None:
        return l1
    else:
        [fst, snd] = sorted([l1,l2], key=lambda l: l.val)
        nextNode = fst 
        while nextNode.next != None and nextNode.next.val <= snd.val:
            nextNode = nextNode.next
        sliced = nextNode.next
        nextNode.next = snd 
        return mergeTwoLists(fst, sliced)
         
        
def randSortedList():
    import random
    output = []
    for r in range(random.randint(1,99)):
        output.append(random.randint(0,999))
    return sorted(output)

if __name__ == '__main__':
    for i in range(64):
        listA = randSortedList()
        listB = randSortedList() 
        fst = mergeTwoLists(ListNode(listA),ListNode(listB)).toList() 
        snd = sorted(listA+listB)
        if (fst != snd):
            print ("error:\n %s %s" % (fst, snd))
            print ("A: %s\n B: %s" % (listA,listB))
        



