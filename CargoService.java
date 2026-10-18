public class CargoService {
    private static final int MAX_CARGO_KG = 5000;

    private int cargoWeight;
    private boolean loaded;

    public void loadCargo(int weightKg) {
        if (weightKg < 0 || weightKg > MAX_CARGO_KG) {
            throw new IllegalArgumentException(
                    "Cargo weight must be between 0 and "
                            + MAX_CARGO_KG + " kg"
            );
        }

        cargoWeight = weightKg;
        loaded = true;

        System.out.println("Cargo loaded: " + cargoWeight + " kg");
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public boolean isReady() {
        return loaded;
    }
}