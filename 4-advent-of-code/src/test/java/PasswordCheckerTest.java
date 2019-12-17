import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PasswordCheckerTest {

    @Test
    public void checkThatPasswordCheckerIsInitialised() {
        PasswordChecker checker = new PasswordChecker(240298, 784956);
        assertEquals(240298, checker.start);
        assertEquals(784956, checker.end);
    }

    @Test
    public void checkThatPasswordCanBeRead() {
        PasswordChecker checker = new PasswordChecker(240298, 784956);
        assertEquals(748, checker.checkPasswordCriteria());
    }

    @Test
    public void checkThatAdjacentNumbersAreSameMethodReturnsTrueFor112233() {
        PasswordChecker checker = new PasswordChecker(240298, 784956);
        List<Integer> myArray = Arrays.asList(1, 1, 2, 2, 3, 3);
        assertTrue(checker.checkThatAdjacentNumbersAreSame(0, myArray));
    }

    @Test
    public void checkThatAdjacentNumbersAreSameMethodReturnsFalseFor123444() {
        PasswordChecker checker = new PasswordChecker(240298, 784956);
        List<Integer> myArray = Arrays.asList(1, 2, 3, 4, 4, 4);
        assertFalse(checker.checkThatAdjacentNumbersAreSame(3, myArray));
    }

    @Test
    public void checkThatAdjacentNumbersAreSameMethodReturnsTrueFor111122() {
        PasswordChecker checker = new PasswordChecker(240298, 784956);
        List<Integer> myArray = Arrays.asList(1, 1, 1, 1, 2, 2);
        assertTrue(checker.checkThatAdjacentNumbersAreSame(4, myArray));
    }
}

