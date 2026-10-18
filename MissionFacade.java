public class MissionFacade {
    private final CrewService crew = new CrewService();
    private final CargoService cargo = new CargoService();
    private final FuelSystem fuel = new FuelSystem();
    private final SafetySystem safety = new SafetySystem();
    private final LaunchSystem launch = new LaunchSystem();

    public void launchMission(
            String missionName,
            int crewSize,
            int cargoWeight
    ) {
        if (missionName == null || missionName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Mission name cannot be empty"
            );
        }

        if (launch.hasLaunched()) {
            throw new IllegalStateException(
                    "This mission has already launched"
            );
        }

        System.out.println("Preparing mission: " + missionName);

        crew.assignCrew(crewSize);
        cargo.loadCargo(cargoWeight);
        fuel.refuel(cargo);
        launch.launch(missionName, safety, crew, cargo, fuel);
    }
}