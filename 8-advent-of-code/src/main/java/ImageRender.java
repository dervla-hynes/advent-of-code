import java.util.Collections;

public class ImageRender {
    public Image image;
    public Layer printedLayer;

    // constructor
    private ImageRender(Image image) {
        this.image = image;
        initialisePrintedLayer();
    }

    // image render builder static method
    public static ImageRender build() {
        return new ImageRender(Image.build());
    }

    // method to initialise printed layer with values of the last layer in image layer array
    private void initialisePrintedLayer() {
        Collections.reverse(image.imageLayers);
        printedLayer = image.imageLayers.get(0);
    }

    // method to take each value in a layer and set values in printed layer based on each one
    public void processLayer(Layer layer) {
        for (int i = 0; i < layer.LayerValues.size(); i++) {
            int value = layer.LayerValues.get(i);
            switch (value) {
                case 0:
                    printedLayer.LayerValues.set(i, 1);
                    break;
                case 1:
                    printedLayer.LayerValues.set(i, 0);
                    break;
            }
        }
    }

    // method to loop through the reversed layers array and process each layer
    public void renderAllLayers() {
        // loops through the reversed layers array and processes the layers
        for (Layer currentLayer: image.imageLayers) {
            processLayer(currentLayer);
        }
        // system out the final display
        displayAllValuesInPrintedLayer();
    }

    // method to print the code in the console as 1's and 0's
    private void displayAllValuesInPrintedLayer() {
        System.out.println(printedLayer.LayerValues.subList(0,25));
        System.out.println(printedLayer.LayerValues.subList(25,50));
        System.out.println(printedLayer.LayerValues.subList(50,75));
        System.out.println(printedLayer.LayerValues.subList(75,100));
        System.out.println(printedLayer.LayerValues.subList(100,125));
        System.out.println(printedLayer.LayerValues.subList(125,150));
    }
}
