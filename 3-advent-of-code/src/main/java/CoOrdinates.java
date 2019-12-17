
public class CoOrdinates {
    public int x;
    public int y;

    public CoOrdinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x +
                "," + y +
                ']';
    }
}
