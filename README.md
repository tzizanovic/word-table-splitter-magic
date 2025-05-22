
# Table Cell Splitter

A simple Java application that demonstrates the concept of splitting table cells both horizontally and vertically.

## Features

- Create tables with cells
- Split cells horizontally (one cell becomes two cells vertically arranged)
- Split cells vertically (one cell becomes two cells horizontally arranged)
- Display tables in console output

## How to Build

This project uses Maven for build management. To build the project:

```bash
mvn clean package
```

## How to Run

After building, run the application using:

```bash
java -jar target/table-cell-splitter-1.0-SNAPSHOT.jar
```

## Example Output

The application demonstrates:

1. A 3x3 table with cells labeled A through I
2. Splitting cell 'E' horizontally into 'E1' and 'E2'
3. Splitting cell 'E' vertically into 'E1' and 'E2' (in a separate table)

## Implementation Details

The code provides two key classes:
- `Cell`: Represents a table cell with content and span properties
- `Table`: Represents a table with methods for cell manipulation and splitting
