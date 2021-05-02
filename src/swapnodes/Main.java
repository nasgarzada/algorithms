package swapnodes;

import reversestring.LinkedList;

public class Main {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(5)));
        swapPairs(node);
        printHelper(node);
    }

    private static ListNode swapPairs(ListNode head) {
        swapHelper(head);
        return head;
    }

    private static void swapHelper(ListNode node) {
        if (node == null || node.next == null)
            return;
        var temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;
        swapHelper(node.next.next);
    }

    private static void printHelper(ListNode node) {
        System.out.print(node.val);
        if (node.next == null) {
            return;
        } else {
            System.out.print(" -> ");
        }
        printHelper(node.next);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
