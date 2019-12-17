
public class Module {
    public int fuel;
    public int mass;

    public Module(int mass) {
        this.mass = mass;
    }

    public int getFuelAmount() {
        int fuelAmount = (int) Math.floor((mass / 3)) - 2;
        this.fuel = fuelAmount;
        return fuelAmount;
    }

    @Override
    public String toString() {
        return "rocket { mass: " + this.mass + " }";
    }
}
