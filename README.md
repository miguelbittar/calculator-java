# Calculator Java

A simple Java console calculator with operation history stored in SQLite database.

## Features

* Basic arithmetic operations: addition, subtraction, multiplication, division
* Operation history with timestamps
* Clear history functionality  
* Support for decimal numbers (both comma and dot)
* Error handling for invalid inputs

## Technologies Used

* **Java 8+** - Programming language
* **SQLite** - Database for storing history
* **Strategy Pattern** - For mathematical operations
* **Repository Pattern** - For data persistence

## How to Run

1. Clone the repository:
```bash
git clone https://github.com/miguelbittar/calculator-java.git
cd calculator-java
```

2. Compile and run:
```bash
javac -d bin src/main/java/org/example/*.java
java -cp bin org.example.Main
```

## Usage Example

```
=== CALCULATOR ===
Enter expression (example: 5 + 3)
Type 'h' to view history
Type 'clear' to clear history
Type 'exit' to quit
> 10 + 5
Result: 15.0

> 2.5 * 4  
Result: 10.0

> h
=== OPERATION HISTORY ===
1. 2.5 * 4 = 10.0 (2024-01-15 10:35:42)
2. 10 + 5 = 15.0 (2024-01-15 10:35:20)
```

## Project Structure

```
calculator-java/
├── src/org/example/
│   ├── Main.java                 # Entry point
│   ├── Calculator.java           # Main calculation logic
│   ├── ConsoleInterface.java     # User interface
│   ├── Operation.java            # Operation interface
│   ├── Addition.java             # Addition operation
│   ├── Subtraction.java          # Subtraction operation
│   ├── Multiplication.java       # Multiplication operation
│   ├── Division.java             # Division operation
│   ├── OperationRepository.java  # Repository interface
│   ├── DatabaseManager.java      # Database implementation
│   └── ConnectionDB.java         # Database connection
└── README.md
```

## Commands

| Command | Description |
|---------|-------------|
| `5 + 3` | Calculate expression |
| `h` | Show history |
| `clear` | Clear history |
| `exit` | Exit program |

## Author

**Miguel Bittar** - [@miguelbittar](https://github.com/miguelbittar)
