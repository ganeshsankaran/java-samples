public class Generics {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3};
        Integer first = getFirst(integers);
        System.out.println(first);

        Pair<Integer, String> pair = new Pair<Integer, String>(1, "one");
        System.out.println(pair);
    }

    public static <T> T getFirst(T[] array) {
        if (array.length > 0) return array[0];
        return null;
    }
}

class Pair<T, U> {
    public T first;
    public U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return this.first + "," + this.second;
    }
}