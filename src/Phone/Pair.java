package Phone;

public class Pair <T, Y>{
    public Pair(T first, Y second) {
        this.first = first;
        this.second = second;
    }

    private T first;
    private Y second;

    public T getFirst() {
        return first;
    }

    public Y getSecond() {
        return second;
    }
}
