public class CrewService {
    private static final int MAX_CREW = 6;

    private int assignedCrew;

    public void assignCrew(int crewSize) {
        if (crewSize < 1 || crewSize > MAX_CREW) {
            throw new IllegalArgumentException(
                    "Crew size must be between 1 and " + MAX_CREW
            );
        }

        assignedCrew = crewSize;
        System.out.println("Crew assigned: " + assignedCrew);
    }

    public boolean isReady() {
        return assignedCrew > 0;
    }
}