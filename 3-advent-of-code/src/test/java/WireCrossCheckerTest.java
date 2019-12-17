import org.junit.Test;

import static org.junit.Assert.*;

public class WireCrossCheckerTest {

    @Test
    public void canInstantiateWireOne() {
        WireCrossChecker wireCrossChecker = new WireCrossChecker();
        assertEquals(301, wireCrossChecker.wireOne.size());
    }

    @Test
    public void canInstantiateWireTwo() {
        WireCrossChecker wireCrossChecker = new WireCrossChecker();
        assertEquals(301, wireCrossChecker.wireTwo.size());
    }

    @Test
    public void canStartPathOfWireOneAtOrigin() {
        WireCrossChecker wireCrossChecker = new WireCrossChecker();
        assertEquals(1, wireCrossChecker.pathCoOrdinatesOne.size());
    }

    @Test
    public void canGetDistances() {
        WireCrossChecker wireCrossChecker = new WireCrossChecker();
        assertEquals(890, wireCrossChecker.getWireDistance("U890"));
    }

    @Test
    public void canGetDirections() {
        WireCrossChecker wireCrossChecker = new WireCrossChecker();
        assertEquals("R", wireCrossChecker.getWireDirection("R6476"));
    }

    @Test
    public void canCreateWireOnePath() {
        WireCrossChecker wireCrossChecker = new WireCrossChecker();
        wireCrossChecker.createPathForWireOne();
//        System.out.println(wireCrossChecker.pathCoOrdinatesOne);
    }

    @Test
    public void canCreateWireTwoPath() {
        WireCrossChecker wireCrossChecker = new WireCrossChecker();
        wireCrossChecker.createPathForWireTwo();
        System.out.println(wireCrossChecker.pathCoOrdinatesTwo);
    }

    @Test
    public void canCheckWhereWiresCross() {
        WireCrossChecker wireCrossChecker = new WireCrossChecker();
        wireCrossChecker.makeArrayWhereWiresCross();
    }

    @Test
    public void canFindSmallestCrossingPoint() {
        WireCrossChecker wireCrossChecker = new WireCrossChecker();
        assertEquals(870, wireCrossChecker.findClosestPointToOrigin());
    }

    @Test
    public void canFindLeastNumberOfStepsToCrossingPoint() {
        WireCrossChecker wireCrossChecker = new WireCrossChecker();
        assertEquals(13700, wireCrossChecker.findLeastNumberOfSteps());
    }


}
