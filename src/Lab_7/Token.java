package Lab_7;

import Lab_3.Location;

public class Token {
    private int first;
    private int second;
    private int value;

    public Token(int first, int second, int value) {
        setFirst(first);
        setSecond(second);
        setValue(value);
    }

    public Token (int first, int second) {
        setFirst(first);
        setSecond(second);
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("(").append(first).append(", ").append(second).append(")");
        return str.toString();
    }
}
