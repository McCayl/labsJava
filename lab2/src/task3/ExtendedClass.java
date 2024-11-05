package task3;

import java.util.Objects;

public class ExtendedClass {
    private byte b;
    private int i;
    private double d;
    private String s;

    public byte getB() {
        return b;
    }

    public ExtendedClass setB(byte b) {
        this.b = b;
        return this;
    }

    public int getI() {
        return i;
    }

    public ExtendedClass setI(int i) {
        this.i = i;
        return this;
    }

    public double getD() {
        return d;
    }

    public ExtendedClass setD(double d) {
        this.d = d;
        return this;
    }

    public String getS() {
        return s;
    }

    public ExtendedClass setS(String s) {
        this.s = s;
        return this;
    }

    @Override
    public String toString() {
        return "ExtendedClass{" +
                "b=" + b +
                ", i=" + i +
                ", d=" + d +
                ", s='" + s + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtendedClass that = (ExtendedClass) o;
        return b == that.b && i == that.i && Double.compare(that.d, d) == 0 && s.equals(that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(b, i, d, s);
    }
}
