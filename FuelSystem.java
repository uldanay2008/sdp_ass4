public class FuelSystem {
    private static final int BASE_FUEL = 10000;
    private static final int FUEL_PER_KG = 2;
    private static final int TANK_CAPACITY = 20000;

    private int fuelAmount;

    public void refuel(CargoService cargo) {
        if (!cargo.isReady()) {
            throw new IllegalStateException(
                    "Load cargo before calculating fuel"
            );
        }

        int requiredFuel = BASE_FUEL
                + cargo.getCargoWeight() * FUEL_PER_KG;

        if (requiredFuel > TANK_CAPACITY) {
            throw new IllegalStateException(
                    "Required fuel exceeds tank capacity"
            );
        }

        fuelAmount = requiredFuel;

        System.out.println("Fuel loaded: " + fuelAmount + " liters");
    }

    public boolean isReady(CargoService cargo) {
        if (!cargo.isReady()) {
            return false;
        }

        int requiredFuel = BASE_FUEL
                + cargo.getCargoWeight() * FUEL_PER_KG;

        return fuelAmount >= requiredFuel;
    }
}