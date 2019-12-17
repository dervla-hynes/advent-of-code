import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class IntcodeComputerTest {
    @Test
    public void canScanAllMassesFromFile() throws IOException {
        IntcodeComputer myComputer = new IntcodeComputer();
        assertEquals(129, myComputer.intcode.size());
    }

    @Test
    public void canGetTheCorrectFinalCode() throws IOException {
        IntcodeComputer myComputer = new IntcodeComputer();
        assertEquals(3790689, myComputer.readIntcode(12, 2));
    }

    @Test
    public void canFindNounAndVerbOfFinalValue() throws IOException {
        IntcodeComputer myComputer = new IntcodeComputer();
        assertEquals(6533, myComputer.findNounAndVerb());
    }

//    Find the input noun and verb that cause the program to produce the output 19690720.

}
