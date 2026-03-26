# 🚀 Warrior vs Aliens

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java Version](https://img.shields.io/badge/Java-24-blue)](https://www.oracle.com/java/)
[![Build Tool](https://img.shields.io/badge/Build-Maven-red)](https://maven.apache.org/)

A turn-based Java battle game developed as a university semester project to practice **Strategy** and **Observer** design patterns.

This repository reflects my semester-project implementation with selective AI-assisted help during development and cleanup.

## 📖 Table of Contents

- [About](#about)
- [Design Patterns](#design-patterns)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Game](#running-the-game)
- [How to Play](#how-to-play)
- [Project Structure](#project-structure)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## 🎮 About

**Warrior vs Aliens** is a console-based battle game where a lone warrior faces an army of extraterrestrial invaders. The project focuses on object-oriented programming practice and on the implementation of two core design patterns:

- **Strategy Pattern**: Defines different attack behaviors for both the warrior and aliens
- **Observer Pattern**: Implements detection systems (Satellite & Telescope) that monitor alien movements

This project was created as a semester assignment to demonstrate understanding of software design patterns in a small Java application.

## 🏗️ Design Patterns

### Strategy Pattern

The Strategy pattern allows the game to define a family of algorithms, encapsulate each one, and make them interchangeable at runtime.

#### Warrior Attack Strategies
- **`WarriorAttackStrategy`**: Interface for warrior attack behavior
- **`DefaultWarriorStrategy`**: Default implementation that combines intel from observers

#### Alien Attack Strategies
- **`AlienAttackStrategy`**: Interface for alien attack behavior
- **`FullAttackStrategy`**: All aliens attack simultaneously (more damage, easier to detect)
- **`PartialAttackStrategy`**: User-selected number of aliens attack (less damage, harder to detect)

### Observer Pattern

The Observer pattern establishes a one-to-many dependency between objects, so when one object changes state, all its dependents are notified.

- **`Subject`**: Interface for objects being observed
- **`Observer`**: Interface for observer objects
- **`AlienArmy`**: Implements Subject, notifies observers when attacks occur
- **`Satellite`**: Observer that detects partial attacks (detects ~50% of attackers)
- **`Telescope`**: Observer that detects full attacks (detects all attackers)

## ✨ Features

- **Turn-based combat**: Warrior attacks on odd rounds, aliens on even rounds
- **Dynamic difficulty**: Damage calculation based on visibility and attack type
- **Observer system**: Telescope and Satellite provide intel to the warrior
- **User interaction**: Choose attack types and number of attacking aliens
- **Victory conditions**: Win by destroying all aliens or lose when warrior's HP reaches 0
- **Structured codebase**: Clear separation of responsibilities across the main game classes
- **Basic testing**: Unit tests for core functionality

## 🚀 Getting Started

### Prerequisites

- **Java 24**
- **Maven 3.6+** (optional, for building from source)

### Installation

1. **Clone the repository**

```bash
git clone https://github.com/xrhstosk59/warrior-vs-aliens.git
cd warrior-vs-aliens
```

2. **Build the project**

Using Maven:

```bash
mvn clean package
```

This will compile the code, run tests, and create an executable JAR file.

### Running the Game

#### Option 1: Run with Maven

```bash
mvn exec:java -Dexec.mainClass="gr.university.warriorgame.Main"
```

#### Option 2: Run the executable JAR

```bash
java -jar target/warrior-vs-aliens-1.0.0-executable.jar
```

#### Option 3: Compile and run manually

```bash
# Compile
javac --release 24 -d target/classes -sourcepath src/main/java src/main/java/gr/university/warriorgame/*.java

# Run
java -cp target/classes gr.university.warriorgame.Main
```

## 🎯 How to Play

### Game Rules

1. **Warrior attacks on odd rounds (1, 3, 5, ...)**
   - Destroys all aliens detected by Satellite and Telescope
   - Gains +15% visibility after each attack

2. **Aliens attack on even rounds (2, 4, 6, ...)**
   - Choose between Full Attack or Partial Attack
   - Full Attack: All aliens participate, Telescope detects them all
   - Partial Attack: You choose how many attack, Satellite detects ~50%

3. **Victory Conditions**
   - **Win**: Destroy all aliens
   - **Lose**: Warrior's HP drops to 0

### Game Mechanics

- **Visibility**: Affects how much damage the warrior takes
  - Higher visibility = Better defense = Less damage
  - Decreases when aliens attack
  - Increases when warrior attacks

- **Damage Calculation**
  - Full Attack: `damage = number_of_aliens × (100 - visibility) / 100`
  - Partial Attack: `damage = number_of_attackers × (100 - visibility) / 200`

### Example Gameplay

```
=== ΠΑΙΧΝΙΔΙ ΜΑΧΗΣ: ΠΟΛΕΜΙΣΤΗΣ VS ΕΞΩΓΗΙΝΟΙ ===
------------------------------------------------

Πόσοι εχθροί θα σας επιτεθούν;
> 5

=== ΜΑΧΗ ===
HP Πολεμιστή: 100
Ορατότητα: 50%
Εχθροί: 5

---------- ΓΥΡΟΣ 1 ----------

Πολεμιστής: 100 HP | 50% ορατότητα | Άψογα!
Εχθροί: 5 από 5 | Πολλοί εχθροί ακόμα...
>> Επίθεση πολεμιστή
Ο πολεμιστής κατέστρεψε 0 εχθρούς!
```

## 📁 Project Structure

```
warrior-vs-aliens/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── gr/
│   │           └── university/
│   │               └── warriorgame/
│   │                   ├── Main.java                      # Entry point
│   │                   ├── Game.java                      # Game controller
│   │                   ├── Warrior.java                   # Warrior entity
│   │                   ├── Alien.java                     # Alien entity
│   │                   ├── AlienArmy.java                 # Army (Subject)
│   │                   ├── Subject.java                   # Observer pattern
│   │                   ├── Observer.java                  # Observer pattern
│   │                   ├── Satellite.java                 # Observer impl
│   │                   ├── Telescope.java                 # Observer impl
│   │                   ├── WarriorAttackStrategy.java     # Strategy pattern
│   │                   ├── DefaultWarriorStrategy.java    # Strategy impl
│   │                   ├── AlienAttackStrategy.java       # Strategy pattern
│   │                   ├── FullAttackStrategy.java        # Strategy impl
│   │                   └── PartialAttackStrategy.java     # Strategy impl
│   └── test/
│       └── java/
│           └── gr/
│               └── university/
│                   └── warriorgame/
│                       ├── AlienTest.java
│                       ├── WarriorTest.java
│                       └── ObserverPatternTest.java
├── pom.xml                                                # Maven configuration
├── LICENSE                                                # MIT License
├── README.md                                              # This file
└── CONTRIBUTING.md                                        # Contribution guidelines
```

## 🧪 Testing

The project includes comprehensive unit tests using JUnit 5.

### Run all tests

```bash
mvn test
```

### Run specific test class

```bash
mvn test -Dtest=WarriorTest
```

### Test Coverage

- `AlienTest`: Tests for Alien entity behavior
- `WarriorTest`: Tests for Warrior mechanics (power, visibility, defeat)
- `ObserverPatternTest`: Tests for Satellite and Telescope detection logic

## 🤝 Contributing

Contributions are welcome! Please read the [CONTRIBUTING.md](CONTRIBUTING.md) file for guidelines on how to contribute to this project.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍🎓 Academic Context

This project was developed as a semester assignment for the Computer Science Department. It demonstrates:

- Object-Oriented Programming (OOP) principles
- Design Patterns (Strategy, Observer)
- Clean Code practices
- Unit Testing
- Build automation with Maven
- Version control with Git

## 🙏 Acknowledgments

- University professors for the assignment requirements
- The Java community for excellent documentation
- Design Patterns: Elements of Reusable Object-Oriented Software (Gang of Four)

---

**Made with ❤️ for learning and demonstration purposes**
