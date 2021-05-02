package reverselinkedlist;

public class Main {
    public static void main(String[] args) {
        var list = new ListNode(331);
        addNode(list, 2);
        addNode(list, 6);
        addNode(list, 8);
        addNode(list, 9);
        addNode(list, 12);
        addNode(list, 122);

        printHelper(
                reverseList(list)
        );
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next==null)
            return head;
        return reverseListHelper(new ListNode(), head);
    }

    private static ListNode reverseListHelper(ListNode replacer, ListNode head) {
        replacer.val = head.val;

        if (head.next == null)
            return replacer;

        return reverseListHelper(new ListNode(0, replacer), head.next);
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

    private static void addNode(ListNode head, int val) {
        if (head == null)
            return;

        if (head.next == null) {
            head.next = new ListNode(val);
            return;
        }
        addNode(head.next, val);
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

