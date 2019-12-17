

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WireCrossChecker {

    public ArrayList<String> wireOne;
    public ArrayList<String> wireTwo;
    public ArrayList<CoOrdinates> pathCoOrdinatesOne;
    public ArrayList<CoOrdinates> pathCoOrdinatesTwo;
    public CoOrdinates origin = new CoOrdinates(0,0);
    public ArrayList<CoOrdinates> listOfAllCrossingPoints;
    public ArrayList<Integer> numberOfSteps;

    public WireCrossChecker() {
        this.wireOne = new ArrayList<>();
        this.wireTwo = new ArrayList<>();
        pathCoOrdinatesOne = new ArrayList<>();
        pathCoOrdinatesTwo = new ArrayList<>();
        pathCoOrdinatesOne.add(origin);
        pathCoOrdinatesTwo.add(origin);
        readWiresFromFile();
        numberOfSteps = new ArrayList<>();
    }

    public void readWiresFromFile() {
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\dervla.hynes\\development\\java\\advent-of-code\\3-advent-of-code\\src\\main\\resources\\puzzleInput"));
            while (scanner.hasNextLine()) {
               String[] wireOneArray = scanner.nextLine().split(",");
               String[] wireTwoArray = scanner.nextLine().split(",");
               for (String value : wireOneArray) {
                   this.wireOne.add(value);
               }
                for (String value : wireTwoArray) {
                    this.wireTwo.add(value);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getWireDirection(String value) {
        return value.substring(0,1);
    }

    public static int getWireDistance(String value) {
        return Integer.parseInt(value.substring(1));
    }

    public void createPathForWireOne() {
        for (String value: wireOne) {
            int lastXValue = pathCoOrdinatesOne.get(pathCoOrdinatesOne.size() - 1).x;
            int lastYValue = pathCoOrdinatesOne.get(pathCoOrdinatesOne.size() - 1).y;
            String direction = getWireDirection(value);
            int distance = getWireDistance(value);
            switch (direction) {
                case "U":
                    for (int i = 1; i < distance + 1; i++) {
                        pathCoOrdinatesOne.add(new CoOrdinates(lastXValue + i, lastYValue));
                    }
                    break;
                case "D":
                    for (int i = 1; i < distance + 1; i++) {
                        pathCoOrdinatesOne.add(new CoOrdinates(lastXValue - i, lastYValue));
                    }
                    break;
                case "L":
                    for (int i = 1; i < distance + 1; i++) {
                        pathCoOrdinatesOne.add(new CoOrdinates(lastXValue, lastYValue - i));
                    }
                    break;
                case "R":
                    for (int i = 1; i < distance + 1; i++) {
                        pathCoOrdinatesOne.add(new CoOrdinates(lastXValue, lastYValue + i));
                    }
                    break;
            }

        }
    }

    public void createPathForWireTwo() {
        for (String value: wireTwo) {
            int lastXValue = pathCoOrdinatesTwo.get(pathCoOrdinatesTwo.size() - 1).x;
            int lastYValue = pathCoOrdinatesTwo.get(pathCoOrdinatesTwo.size() - 1).y;
            String direction = getWireDirection(value);
            int distance = getWireDistance(value);
            switch (direction) {
                case "U":
                    for (int i = 1; i < distance + 1; i++) {
                        pathCoOrdinatesTwo.add(new CoOrdinates(lastXValue + i, lastYValue));
                    }
                    break;
                case "D":
                    for (int i = 1; i < distance + 1; i++) {
                        pathCoOrdinatesTwo.add(new CoOrdinates(lastXValue - i, lastYValue));
                    }
                    break;
                case "L":
                    for (int i = 1; i < distance + 1; i++) {
                        pathCoOrdinatesTwo.add(new CoOrdinates(lastXValue, lastYValue - i));
                    }
                    break;
                case "R":
                    for (int i = 1; i < distance + 1; i++) {
                        pathCoOrdinatesTwo.add(new CoOrdinates(lastXValue, lastYValue + i));
                    }
                    break;
            }

        }
    }

    public void makeArrayWhereWiresCross() {
        createPathForWireOne();
        createPathForWireTwo();
        ArrayList<CoOrdinates> crossingArray = new ArrayList<>();
        int stepsOne = 0;
        int stepsTwo = 0;
        for (CoOrdinates coordOne: pathCoOrdinatesOne) {
            stepsTwo = 0;
            stepsOne++;
            int xOne = coordOne.x;
            int yOne = coordOne.y;
            for(CoOrdinates coordTwo: pathCoOrdinatesTwo) {
                stepsTwo++;
                int xTwo = coordTwo.x;
                int yTwo = coordTwo.y;
                if (xOne == xTwo && yOne == yTwo) {
                    crossingArray.add(coordOne);
                    System.out.println("adding: " + coordOne);
                    System.out.println("step one: " + stepsOne + ", step two: " + stepsTwo);
                    numberOfSteps.add(stepsOne + stepsTwo);
                    break;
                }
            }

        }
        System.out.println(numberOfSteps);
        this.listOfAllCrossingPoints = crossingArray;
        System.out.println(numberOfSteps.size() + " matches " + listOfAllCrossingPoints.size());
    }

    public int findClosestPointToOrigin() {
        makeArrayWhereWiresCross();
        System.out.println(listOfAllCrossingPoints);
        ArrayList<Integer> valuesOfPoints = listOfAllCrossingPoints
                .stream()
                .map(coOrdinates -> {
                    if (coOrdinates.x < 0) {
                        coOrdinates.x = coOrdinates.x * -1;
                    }
                    if (coOrdinates.y < 0) {
                        coOrdinates.y = coOrdinates.y * -1;
                    }
                    return coOrdinates.x + coOrdinates.y;
                })
                .collect(Collectors.toCollection(ArrayList::new));
        valuesOfPoints.remove(0);
        return Collections.min(valuesOfPoints);
    }

    public int findLeastNumberOfSteps() {
        makeArrayWhereWiresCross();
        numberOfSteps.remove(0);
        return Collections.min(numberOfSteps);
    }

}
