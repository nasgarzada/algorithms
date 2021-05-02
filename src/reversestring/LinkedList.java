package reversestring;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> last;

    public LinkedList() {
        this.head = new Node<>();
        this.last = this.head;
    }

    public static <T> List<T> of() {
        return new LinkedList<>();
    }

    public static <T> List<T> of(T... elements) {
        var list = new LinkedList<T>();
        for (T e : elements){
            list.add(e);
        }
        return list;
    }

    @Override
    public void add(T data) {
        this.last.data = data;
        this.last.next = new Node<>();
        this.last = this.last.next;
    }

    @Override
    public void print() {
        printHelper(this.head);
    }

    private void printHelper(Node<T> node) {
        if (node.next == null) {
            return;
        } else {
            System.out.print(node.data + " -> ");
        }
        printHelper(node.next);
    }

    private static class Node<T> {
        T data;
        Node<T> next;
    }
}
