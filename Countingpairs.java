
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

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

    public static int countPairs(List<Integer> numbers, int k) {
        HashSet<Integer> contains = new HashSet<>(numbers);
        int ans = 0;
        for (int j : contains) {
            if (contains.contains(j + k)) {
                ans += 1;
            }
        }
        return ans;
    }
}