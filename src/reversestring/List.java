package reversestring;

public interface List<T> {

    static <T> List<T> of() {
        return LinkedList.of();
    }

    static <T> List<T> of(T... elements) {
        return LinkedList.of(elements);
    }

    void add(T data);

    void print();
}
