# Space Mission Launch — Facade Pattern

Assignment 4 for the Software Design Patterns course.

## Overview

This Java application simulates the preparation and launch of a space mission. It uses the Facade structural design pattern to provide a simple interface for a subsystem with five collaborating classes.

The client calls one method:

```java
MissionFacade mission = new MissionFacade();
mission.launchMission("Mars Explorer", 4, 1200);
```

The parameters are the mission name, crew size, and cargo weight in kilograms.

## Project Structure

```text
src/
├── Main.java
├── MissionFacade.java
├── CrewService.java
├── CargoService.java
├── FuelSystem.java
├── SafetySystem.java
└── LaunchSystem.java
```

## Pattern Components

| Role | Class | Responsibility |
|---|---|---|
| Client | Main | Uses only the facade |
| Facade | MissionFacade | Coordinates mission preparation and launch |
| Subsystem | CrewService | Validates and assigns the crew |
| Subsystem | CargoService | Validates and loads cargo |
| Subsystem | FuelSystem | Calculates and loads the required fuel |
| Subsystem | SafetySystem | Checks crew, cargo, and fuel readiness |
| Subsystem | LaunchSystem | Requests safety checks and launches the rocket |

## How It Works

1. The facade validates the mission name and checks whether the rocket has already launched.
2. CrewService validates and assigns the crew.
3. CargoService validates and loads the cargo.
4. FuelSystem calculates the required fuel using the cargo weight and refuels the rocket.
5. LaunchSystem requests a safety check from SafetySystem.
6. If all checks pass, LaunchSystem launches the mission.

The preparation order matters: cargo must be loaded before the fuel requirement can be calculated.

## Why Facade?

Without the facade, the client would need to create the subsystem objects and coordinate their calls in the correct order.

MissionFacade hides this coordination behind the launchMission method. Main does not create or call subsystem objects directly.

The subsystem classes do not reference MissionFacade. They remain available for direct use by advanced clients.

## Validation and Error Handling

The application checks the following conditions:

- The mission name must not be null or blank.
- The crew size must be between 1 and 6.
- The cargo weight must be between 0 and 5000 kg.
- Cargo must be loaded before refueling.
- Required fuel must not exceed the tank capacity.
- Crew, cargo, and fuel must be ready before launch.
- The same rocket cannot launch twice.

Invalid arguments cause IllegalArgumentException. Invalid subsystem states cause IllegalStateException. Main catches these exceptions and displays an error message.

## Clean Code Principles

### 1. Meaningful Names

Names such as assignCrew, loadCargo, and launchMission clearly describe each operation.

### 2. Single Responsibility

Each subsystem handles one area of mission preparation. MissionFacade coordinates the operations and delegates subsystem logic to the responsible classes.

### 3. Small and Focused Methods

Methods perform specific tasks, such as checking readiness, loading cargo, or assigning the crew.

### 4. No Magic Numbers

Named constants such as MAX_CREW, MAX_CARGO_KG, and TANK_CAPACITY explain the meaning of limits and make them easier to change.

### 5. Encapsulation

Subsystem state is stored in private fields. The facade does not expose subsystem objects through its public interface.

### 6. Clear Error Handling

Exceptions include descriptive messages that explain why preparation or launch failed.

## Requirements

- JDK 8 or later
- No external libraries

## How to Run

### IntelliJ IDEA

1. Open the project.
2. Configure a Java SDK.
3. Open src/Main.java.
4. Run Main.main().

### Terminal

Run these commands from the project root:

```bash
javac -d out src/*.java
java -cp out Main
```

## Expected Output

```text
Preparing mission: Mars Explorer
Crew assigned: 4
Cargo loaded: 1200 kg
Fuel loaded: 12400 liters
Safety checks passed
Mission launched: Mars Explorer
```

The application uses a simplified educational fuel formula:

```text
Required fuel = 10000 + cargo weight × 2
```

For 1200 kg of cargo, the required fuel is 12400 liters.

## Limitations

This is a console simulation. It does not control real equipment.

If preparation fails, completed preparation steps are not automatically rolled back. A new MissionFacade object represents a separate rocket and mission preparation process.

## Author

Bazarbay Uldanay  
Astana IT University  
Software Design Patterns
