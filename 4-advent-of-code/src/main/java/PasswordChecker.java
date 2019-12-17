import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordChecker {
    public int start;
    public int end;

    public PasswordChecker(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int checkPasswordCriteria() {
        int numberOfValidPasswords = 0;

        while(start <= end) {
            int checkedNumber = start;
            //making array of the digits of the checked number:
            ArrayList<Integer> intList = new ArrayList<Integer>();
            while(checkedNumber > 0){
                intList.add(checkedNumber % 10);
                checkedNumber = checkedNumber / 10;
            }
            Collections.reverse(intList);

            int index = 0;
            //checking for two adjacent digits same and all digits are less than or equal:
            for (index = 0; index <= 4; index++) {
                if (checkThatAdjacentNumbersAreSame(index, intList) && checkThatNumbersAreIncreasing(intList)) {
                    numberOfValidPasswords++;
                    break;
                }
            }
            start++;
        }
        return numberOfValidPasswords;
    }

    public boolean checkThatAdjacentNumbersAreSame(int index, List<Integer> intList) {
        if (index == 4) {
            return (intList.get(index) == intList.get(index + 1) && intList.get(index) != intList.get(index - 1));
        } else if (index == 0) {
            return (intList.get(index) == intList.get(index + 1) && intList.get(index) != intList.get(index + 2));
        } else return (intList.get(index) == intList.get(index + 1) && intList.get(index) != intList.get(index + 2) && intList.get(index) != intList.get(index - 1));
    }

    public boolean checkThatNumbersAreIncreasing(List<Integer> intList) {
        if (    intList.get(0) <= intList.get(1) &&
                intList.get(1) <= intList.get(2) &&
                intList.get(2) <= intList.get(3) &&
                intList.get(3) <= intList.get(4) &&
                intList.get(4) <= intList.get(5)) {
            return true;
        } else return false;
    }
}
