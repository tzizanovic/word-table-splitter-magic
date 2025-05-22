
# Table Cell Splitter with Aspose.Words

A Java application that demonstrates the concept of splitting table cells both horizontally and vertically using the Aspose.Words library.

## Features

- Create tables with cells using Aspose.Words
- Split cells horizontally (one cell becomes two cells vertically arranged)
- Split cells vertically (one cell becomes two cells horizontally arranged)
- Generate output in multiple formats (DOCX, PDF, HTML)

## Requirements

- Java 11 or higher
- Maven

## Dependencies

This project uses Aspose.Words for Java. The dependency is automatically fetched from the Aspose repository as defined in the pom.xml file.

## How to Build

This project uses Maven for build management. To build the project:

```bash
mvn clean package
```

## How to Run

After building, run the application using:

```bash
java -cp target/table-cell-splitter-1.0-SNAPSHOT.jar:target/lib/* com.example.TableCellSplitter
```

Or on Windows:

```bash
java -cp "target/table-cell-splitter-1.0-SNAPSHOT.jar;target/lib/*" com.example.TableCellSplitter
```

## Output

The application generates the following output files in the 'output' directory:

1. table_cell_split_demo.docx - Microsoft Word document
2. table_cell_split_demo.pdf - PDF document
3. table_cell_split_demo.html - HTML document

Each document demonstrates:
- A 3x3 table with cells labeled A through I
- Splitting cell 'E' horizontally into 'E1' and 'E2'
- Splitting cell 'E' vertically into 'E1' and 'E2' (in a separate table)

## Implementation Details

The code provides key methods:
- `createSampleTable`: Creates a 3x3 table with labeled cells
- `splitCellHorizontally`: Splits a cell horizontally into two cells
- `splitCellVertically`: Splits a cell vertically into two cells

## Aspose.Words Usage

Aspose.Words is a powerful document processing API that allows manipulation of Word documents. In this application, we use it to:
- Create tables programmatically
- Manipulate table structure by splitting cells
- Generate output in multiple formats
