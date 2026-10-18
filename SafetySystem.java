public class SafetySystem {

    public void check(
            CrewService crew,
            CargoService cargo,
            FuelSystem fuel
    ) {
        if (!crew.isReady()) {
            throw new IllegalStateException("Crew is not ready");
        }

        if (!cargo.isReady()) {
            throw new IllegalStateException("Cargo is not ready");
        }

        if (!fuel.isReady(cargo)) {
            throw new IllegalStateException("Not enough fuel");
        }

        System.out.println("Safety checks passed");
    }
}