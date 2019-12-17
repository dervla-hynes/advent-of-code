import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IntcodeComputer {
//    the instruction 1,2,3,4,
//    1 is the opcode;
//    2, 3, and 4 are the parameters.
//    The instruction 99 contains only an opcode and has no parameters.
    // index = 'address'
    //the address of current instruction is called the instruction pointer

    public ArrayList<Integer> intcode;
    public ArrayList<Integer> cleanIntcode;

    public IntcodeComputer() throws IOException {
        this.intcode = new ArrayList<>();
        addAllValuesToIntcode();
        this.cleanIntcode = intcode;
    }

    public void addAllValuesToIntcode() throws IOException {
        try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\dervla.hynes\\development\\java\\advent-of-code\\2-advent-of-code\\src\\main\\java\\codes"))) {
            String str;
            while ((str = in.readLine()) != null) {
                String[] stringArray = str.split(",");
                for (String value : stringArray) {
                    this.intcode.add(Integer.parseInt(value));
                }
            }
        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    public int readIntcode(int noun, int verb) {

//        before running the program, replace position 1 with the value 12 and replace position 2 with the value 2
        // value 12 is the 'noun'
        // value 2 is the 'verb'
        // (both will be between 0 and 99 inclusive)

        intcode.set(1, noun);
        intcode.set(2, verb);

        int startIndex = 0;
        while (startIndex <= intcode.size() - 1 ) {
            if (intcode.get(startIndex) == 1) {
                addValues(startIndex);
                startIndex += 4;
            } else if (intcode.get(startIndex) == 2) {
                multiplyValues(startIndex);
                startIndex += 4;
            } else if (intcode.get(startIndex) == 99) {
                break;
            }
        }
//        What value is left at position 0 after the program halts?
        return intcode.get(0);
    }

    public void addValues(int startIndex) {
        int firstPosition = intcode.get(startIndex + 1);
        int firstNumber = intcode.get(firstPosition);
        int secondPosition = intcode.get(startIndex + 2);
        int secondNumber = intcode.get(secondPosition);
        int total = firstNumber + secondNumber;
        int placePosition = intcode.get(startIndex + 3);
        intcode.set(placePosition, total);
    }

    public void multiplyValues(int startIndex) {
        int firstPosition = intcode.get(startIndex + 1);
        int firstNumber = intcode.get(firstPosition);
        int secondPosition = intcode.get(startIndex + 2);
        int secondNumber = intcode.get(secondPosition);
        int total = firstNumber * secondNumber;
        int placePosition = intcode.get(startIndex + 3);
        intcode.set(placePosition, total);
    }

    public void resetIntcode() {
        this.intcode = cleanIntcode;
    }


    public int findNounAndVerb() throws IOException {
        int noun = 0;
        int verb = 0;
        int finalValue = 0;
        for (int i = 0 ; i < 100 ; i++ ) {
            noun = i;
            for (int j = 0 ; j < 100 ; j++ ) {
                verb = j;
                finalValue = readIntcode(noun, verb);
                if (finalValue == 19690720) {
                    break;
                } else {
                    intcode.clear();
                    addAllValuesToIntcode();
                }
            }
            if (finalValue == 19690720) {
                break;
            } else {
                intcode.clear();
                addAllValuesToIntcode();
            }
        }
        return 100 * noun + verb;
    }
}
