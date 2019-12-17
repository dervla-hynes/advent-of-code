import java.util.ArrayList;

public class Layer {
    ArrayList<Integer> LayerValues;

    // constructor
    public Layer() {
        LayerValues = new ArrayList<>();
    }

    // layer build static method
    public static Layer build() { return new Layer();}
}
