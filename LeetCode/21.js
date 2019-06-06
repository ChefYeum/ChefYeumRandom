/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    if (fst == null) return snd
    [fst, snd] = [l1,l2].sort((x,y) => {return x.value < y.value})
    next = snd 
    while (next.next.val <= snd.val){
       next = next.next
    }
    next.next = l2
    
    return mergeTwoLists(fst,snd) 
};




