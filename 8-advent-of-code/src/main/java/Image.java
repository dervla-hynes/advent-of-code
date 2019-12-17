import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Image {
    public ArrayList<Layer> imageLayers;

    // constructor
    public Image() {
        this.imageLayers = new ArrayList<>();
        readImageFromFile();
    }

    // image builder static method
    public static Image build() {
        return new Image();
    }

    // method to read the code from file and add to the image
    private void readImageFromFile() {
        try(BufferedReader in = new BufferedReader(new FileReader("src/main/resources/puzzle-input"))) {
            String stringInFile;
            while ((stringInFile = in.readLine()) != null) {
                processString(stringInFile);
            }
        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    // method to process one line of the file
    private void processString(String stringInFile) {
        int numberInRow;
        int timesValue = 0;
        String[] valueArray = stringInFile.split("");
        for (int i = 0; i < (valueArray.length / 150); i++) {
            numberInRow = 0;
            Layer layer = new Layer();
            while (numberInRow < 150) {
                layer.LayerValues.add(Integer.parseInt(valueArray[numberInRow + (150 * timesValue)]));
                numberInRow++;
                if (numberInRow == 150) {
                    imageLayers.add(layer);
                    timesValue++;
                }
            }
        }
    }

    // method to get the count of zeros in a layer of integer values
    public int getCountOfZeros(Layer layerToCheck) {
        return getNumberCount(layerToCheck, 0);
    }

    // method to get the count of ones in a layer of integer values
    public int getCountOfOnes(Layer layerToCheck) {
        return getNumberCount(layerToCheck, 1);
    }

    // method to get the count of twos in a layer of integer values
    public int getCountOfTwos(Layer layerToCheck) {
        return getNumberCount(layerToCheck, 2);
    }

    // method to return the index of the layer that contains the least zeros
    public int getLayerIndexWithLeastZeros() {
        ArrayList<Integer> listOfZeroCountsPerLayer = new ArrayList<>();
        for (Layer layer: imageLayers) {
            listOfZeroCountsPerLayer.add(getCountOfZeros(layer));
        }
        int leastZeroCount = Collections.min(listOfZeroCountsPerLayer);
        return listOfZeroCountsPerLayer.indexOf(leastZeroCount);
    }

    // method to get the final value of countOfOnes times countOfTwos for layer with least zeros
    public int getFinalTotalForLayerWithLeastZeros() {
        int indexOfLayerWithLeastZeros = getLayerIndexWithLeastZeros();
        Layer layerWithLeastZeros = imageLayers.get(indexOfLayerWithLeastZeros);
        return calculateFinalValue(layerWithLeastZeros);
    }

    // method to return value of countOfOnes times countOfTwos in a layer
    private int calculateFinalValue(Layer layerWithLeastZeros) {
        int countOfOnes = getCountOfOnes(layerWithLeastZeros);
        int countOfTwos = getCountOfTwos(layerWithLeastZeros);
        return countOfOnes * countOfTwos;
    }

    // method to count a given number value in a layer
    private int getNumberCount(Layer layerToCheck, int valueToCount) {
        int count = 0;
        for (int i = 0; i < layerToCheck.LayerValues.size(); i++) {
            if (layerToCheck.LayerValues.get(i) == valueToCount) {
                count++;
            }
        }
        return count;
    }
}
