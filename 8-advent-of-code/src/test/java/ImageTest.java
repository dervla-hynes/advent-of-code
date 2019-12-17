import org.junit.Test;
import static org.junit.Assert.*;

public class ImageTest {

    @Test
    public void imageCanBeReadFromFileWithoutError() {
        Image image = Image.build();
        assertNotNull(image.imageLayers);
    }

    @Test
    public void imageHas100Layers() {
        Image image = Image.build();
        assertEquals(100, image.imageLayers.size());
    }

    @Test
    public void oneLayerContains150Values() {
        Image image = Image.build();
        assertEquals(150, image.imageLayers.get(0).LayerValues.size());
    }

    @Test
    public void layerOneContainsDifferentValuesToLayerTwo() {
        Image image = Image.build();
        int layerOneThirdValue = image.imageLayers.get(0).LayerValues.get(3);
        int layerTwoThirdValue = image.imageLayers.get(1).LayerValues.get(3);
        assertNotEquals(layerOneThirdValue, layerTwoThirdValue);
    }

    @Test
    public void canGetTheCountOfAllZerosInALayer() {
        Image image = Image.build();
        Layer layerOne = image.imageLayers.get(0);
        assertEquals(17, image.getCountOfZeros(layerOne));
    }

    @Test
    public void canReturnTheLayerWithTheLeastZeros() {
        Image image = Image.build();
        assertEquals(9, image.getLayerIndexWithLeastZeros());
        //layer at index 9 has least zeros
    }

    @Test
    public void canGetCountOfOnesInALayer() {
        Image image = Image.build();
        Layer layerOne = image.imageLayers.get(0);
        assertEquals(8, image.getCountOfOnes(layerOne));
    }

    @Test
    public void canGetCountOfTwosInALayer() {
        Image image = Image.build();
        Layer layerOne = image.imageLayers.get(0);
        assertEquals(125, image.getCountOfTwos(layerOne));

    }

    @Test
    public void canGetCountOfOnesInLayerWithLeastZeros() {
        Image image = Image.build();
        Layer layerWithLeastZeros = image.imageLayers.get(image.getLayerIndexWithLeastZeros());
        assertEquals(17, image.getCountOfOnes(layerWithLeastZeros));
    }

    @Test
    public void canReturnCountOfTwosInLayerWithLeastZeros() {
        Image image = Image.build();
        Layer layerWithLeastZeros = image.imageLayers.get(image.getLayerIndexWithLeastZeros());
        assertEquals(128, image.getCountOfTwos(layerWithLeastZeros));
    }

    @Test
    public void canReturnCountOfZerosInLayerWithLeastZeros() {
        Image image = Image.build();
        Layer layerWithLeastZeros = image.imageLayers.get(image.getLayerIndexWithLeastZeros());
       assertEquals(5, image.getCountOfZeros(layerWithLeastZeros));
    }

    @Test
    public void canReturnCountOfOnesTimesCountOfTwosInLayerWithLeastZeros() {
        Image image = Image.build();
        assertEquals(2176, image.getFinalTotalForLayerWithLeastZeros());
    }

    @Test
    public void runtime() {
        long startTime = System.nanoTime();
        Image image = Image.build();
        assertEquals(2176, image.getFinalTotalForLayerWithLeastZeros());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("MilliSeconds taken to run Part 1: " + duration / 1000000.0);
    }
}
