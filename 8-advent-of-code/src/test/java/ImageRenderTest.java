import org.junit.Test;
import static org.junit.Assert.*;

public class ImageRenderTest {

    @Test
    public void imageRenderCanInstantiateWithTheImage() {
        ImageRender myImageRender = ImageRender.build();
        assertNotNull(myImageRender.image);
    }

    @Test
    public void imageRenderCanInitialiseThePrintedLayer() {
        ImageRender myImageRender = ImageRender.build();
        assertNotNull(myImageRender.printedLayer);
    }

    @Test
    public void imageRenderCanProcessOneLayer() {
        ImageRender myImageRender = ImageRender.build();
        Layer layerOne = myImageRender.image.imageLayers.get(0);
        myImageRender.processLayer(layerOne);
        int thirdValue = myImageRender.printedLayer.LayerValues.get(2);
        assertEquals(2, thirdValue);
    }

    @Test
    public void imageRenderCanLoopThroughLayersAndSetPrintedLayerValues() {
        ImageRender myImageRender = ImageRender.build();
        myImageRender.renderAllLayers();
    }

    @Test
    public void runtime() {
        long startTime = System.nanoTime();
        ImageRender myImageRender = ImageRender.build();
        myImageRender.renderAllLayers();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("MilliSeconds taken to run Part 1: " + duration / 1000000.0);
    }
}
