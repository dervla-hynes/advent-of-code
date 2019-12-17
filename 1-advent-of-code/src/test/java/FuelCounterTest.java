import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuelCounterTest {
    @Test
    public void canScanAllMassesFromFile() {
        FuelCounter fuelCounter = new FuelCounter();
        assertEquals(100, fuelCounter.rockets.size());
    }

    @Test
    public void canCalculateTheTotalFuel() {
        FuelCounter fuelCounter = new FuelCounter();
        assertEquals(4974073, fuelCounter.getTotalFuel());
    }

}
