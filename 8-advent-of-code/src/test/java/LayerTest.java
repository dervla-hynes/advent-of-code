import org.junit.Test;
import static org.junit.Assert.*;

public class LayerTest {

    @Test
    public void canInstantiateOneLayer() {
        Layer layer = Layer.build();
        assertNotNull(layer.LayerValues);
    }
}
