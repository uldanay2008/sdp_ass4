public class Main {

    public static void main(String[] args) {
        MissionFacade mission = new MissionFacade();

        try {
            mission.launchMission("Mars Explorer", 4, 1200);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Launch failed: " + e.getMessage());
        }
    }
}