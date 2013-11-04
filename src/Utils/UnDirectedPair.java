package levallois.clement.utils;

public class UnDirectedPair<L extends Comparable<? super L>, R extends Comparable<? super R>> implements Comparable<UnDirectedPair<L, R>> {

    private final L left;
    private final R right;

    public UnDirectedPair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        return left.hashCode() ^ right.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof UnDirectedPair)) {
            return false;
        }
        UnDirectedPair pairo = (UnDirectedPair) o;
        return (this.left.equals(pairo.getLeft())
                && this.right.equals(pairo.getRight()) | this.left.equals(pairo.right)
                && this.right.equals(pairo.left));
    }

    @Override
    public int compareTo(UnDirectedPair<L, R> other) {
        int cmp = this.left.compareTo(other.left);
        if (cmp == 0) {
            cmp = this.right.compareTo(other.right);
        }
        return cmp;
    }
}