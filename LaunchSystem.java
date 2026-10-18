public class LaunchSystem {
    private boolean launched;

    public void launch(
            String missionName,
            SafetySystem safety,
            CrewService crew,
            CargoService cargo,
            FuelSystem fuel
    ) {
        if (launched) {
            throw new IllegalStateException(
                    "Rocket has already launched"
            );
        }

        safety.check(crew, cargo, fuel);

        launched = true;

        System.out.println("Mission launched: " + missionName);
    }

    public boolean hasLaunched() {
        return launched;
    }
}