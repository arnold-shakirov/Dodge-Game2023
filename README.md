# Dodge Game 2023

## Overview
The **Game Demo** project is a Java-based 2D game where the player interacts with the environment using bullets, a player character, and an intuitive interface. The game involves moving a player character, shooting bullets, and managing the game state through various panels and logic.

## Features
- **Player Movement**: Control the player character and move them within the game world.
- **Bullet Mechanics**: Shoot bullets from the player character and interact with other elements in the game.
- **Game Panel**: A main panel that displays the game and interacts with player input.
- **Game Logic**: The core game loop, player interaction, and bullet mechanics are controlled through various game classes.
- **Voronoi Calculation**: A utility for calculating Voronoi diagrams for use within the game.

## Class Overview
- **`bullets1.java`**: Handles bullet mechanics, allowing the player to shoot and interact with the game world.
- **`game1.java`**: Manages the core game logic, including player actions, collisions, and the game loop.
- **`Main.java`**: The entry point of the game, initializing and running the game components.
- **`MainPanel.java`**: Manages the main game display and interaction, handling rendering and input.
- **`player.java`**: Manages the player character, including movement, actions, and interaction with bullets.
- **`VoronCalc.java`**: Utility class for calculating Voronoi diagrams, potentially used in the game for map generation or tactical features.

## How to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/arnold-shakirov/Dodge-Game2023.git
    ```

2. Navigate to the project directory:
    ```bash
    cd Dodge-Game2023
    ```

3. Compile the Java files:
    ```bash
    javac Main.java
    ```

4. Run the game:
    ```bash
    java Main
    ```

## Requirements
- **Java 8** or higher.

## Installation
1. Clone or download the repository.
2. Compile the Java files using any Java-compatible IDE or from the terminal.
3. Run the `Main.java` file to start the game.

## Contact

For any questions or suggestions, feel free to reach out to me at [ashakirov@stetson.edu].
