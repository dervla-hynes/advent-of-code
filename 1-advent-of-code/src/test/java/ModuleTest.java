import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class ModuleTest {
    @Test
    public void canCalculateFuelNeededForModuleOfMass12() {
        Module module = new Module(12);
        assertEquals(2, module.getFuelAmount());
    }

    @Test
    public void canCalculateFuelNeededForModuleOfMass14() {
        Module module = new Module(14);
        assertEquals(2, module.getFuelAmount());
    }

    @Test
    public void canCalculateFuelNeededForModuleOfMass1969() {
        Module module = new Module(1969);
        assertEquals(654, module.getFuelAmount());
    }

    @Test
    public void canCalculateFuelNeededForModuleOfMass100756() {
        Module module = new Module(100756);
        assertEquals(33583, module.getFuelAmount());
    }
}
