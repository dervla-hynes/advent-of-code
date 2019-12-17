import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FuelCounter {
    public ArrayList<Module> rockets;
// The Fuel Counter-Upper needs to know the total fuel requirement. To find it, individually calculate
// the fuel needed for the mass of each module (your puzzle input), then add together all the fuel values.

    public FuelCounter() {
        this.rockets = new ArrayList<>();
        addAllModulesToFuelCounter();
    }

    public void addAllModulesToFuelCounter() {
        try {
            Scanner scanner = new Scanner(new File("/Users/DervlaHynes/java/1-advent-of-code/src/main/java/masses"));
            while (scanner.hasNextLine()) {
                Module nextModule = new Module(scanner.nextInt());
                rockets.add(nextModule);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getTotalFuel() {
        int totalFuel = 0;
        for(Module module: rockets) {
            int fuelAmount = module.getFuelAmount();
            totalFuel += fuelAmount;
            while(calcNextFuel(fuelAmount) >= 0) {
                totalFuel += calcNextFuel(fuelAmount);
                fuelAmount = calcNextFuel(fuelAmount);
            }
        }
        return totalFuel;
    }

    public int calcNextFuel(int fuel) {
        int fuelAmount = (int) Math.floor(( fuel / 3)) - 2;
        return fuelAmount;
    }

}
