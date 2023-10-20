package com.cg.havherrank;

class Result {
    public static SinglyLinkedListNode condense(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;
        SinglyLinkedListNode cur = head;
        HashSet<Integer> nodeSet = new HashSet<>();
        nodeSet.add(head.data);
        while (node.next != null) {
            if (!nodeSet.contains(node.next.data)) {
                cur.next = node.next;
                cur = cur.next;
                nodeSet.add(cur.data);
            }
            node = node.next;
        }
        cur.next = null;
        return head;
    }
}
