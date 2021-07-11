import java.util.Objects;

public class ComplexNumber {
    public final int re, im;

    public ComplexNumber(int re, int im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ComplexNumber other = (ComplexNumber) object;
        return this.re == other.re && this.im == other.im;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}
