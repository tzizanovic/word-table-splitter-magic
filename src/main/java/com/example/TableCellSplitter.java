
package com.example;

import com.aspose.words.*;
import java.io.File;

/**
 * A Java application that demonstrates table cell splitting using Aspose.Words.
 */
public class TableCellSplitter {
    
    /**
     * Main method to run the table cell splitting demonstration.
     */
    public static void main(String[] args) {
        try {
            // Create a new document
            Document doc = new Document();
            DocumentBuilder builder = new DocumentBuilder(doc);
            
            System.out.println("Creating a table and splitting cells using Aspose.Words...");
            
            // Create a basic 3x3 table
            Table table = createSampleTable(builder);
            
            // Add a paragraph after the table for spacing
            builder.writeln();
            builder.writeln("After splitting cell E horizontally:");
            builder.writeln();
            
            // Create another table for horizontal split demonstration
            Table horizontalSplitTable = createSampleTable(builder);
            
            // Split cell E horizontally
            Cell cellE = horizontalSplitTable.getRows().get(1).getCells().get(1);
            splitCellHorizontally(cellE, horizontalSplitTable, "E1", "E2");
            
            // Add a paragraph after the table for spacing
            builder.writeln();
            builder.writeln("After splitting cell E vertically:");
            builder.writeln();
            
            // Create another table for vertical split demonstration
            Table verticalSplitTable = createSampleTable(builder);
            
            // Split cell E vertically
            cellE = verticalSplitTable.getRows().get(1).getCells().get(1);
            splitCellVertically(cellE, verticalSplitTable, "E1", "E2");
            
            // Save the document to disk
            File outputDir = new File("output");
            if (!outputDir.exists()) {
                outputDir.mkdir();
            }
            
            doc.save("output/table_cell_split_demo.docx");
            doc.save("output/table_cell_split_demo.pdf");
            doc.save("output/table_cell_split_demo.html");
            
            System.out.println("Documents successfully created in the 'output' directory:");
            System.out.println("- table_cell_split_demo.docx");
            System.out.println("- table_cell_split_demo.pdf");
            System.out.println("- table_cell_split_demo.html");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Creates a sample 3x3 table with cells labeled A through I.
     * 
     * @param builder DocumentBuilder to create the table
     * @return The created table
     */
    private static Table createSampleTable(DocumentBuilder builder) throws Exception {
        // Start the table
        builder.startTable();
        
        // First row
        builder.insertCell();
        builder.write("A");
        builder.insertCell();
        builder.write("B");
        builder.insertCell();
        builder.write("C");
        builder.endRow();
        
        // Second row
        builder.insertCell();
        builder.write("D");
        builder.insertCell();
        builder.write("E");
        builder.insertCell();
        builder.write("F");
        builder.endRow();
        
        // Third row
        builder.insertCell();
        builder.write("G");
        builder.insertCell();
        builder.write("H");
        builder.insertCell();
        builder.write("I");
        builder.endRow();
        
        // End the table and get a reference to it
        builder.endTable();
        return (Table)builder.getCurrentNode().getAncestor(NodeType.TABLE);
    }
    
    /**
     * Splits a cell horizontally (one cell becomes two cells stacked vertically).
     * 
     * @param cell The cell to split
     * @param table The table containing the cell
     * @param topContent Content for the top cell
     * @param bottomContent Content for the bottom cell
     */
    private static void splitCellHorizontally(Cell cell, Table table, String topContent, String bottomContent) throws Exception {
        // Get the cell's row and column indices
        Row parentRow = cell.getParentRow();
        int rowIndex = parentRow.getParentTable().indexOf(parentRow);
        int cellIndex = parentRow.indexOf(cell);
        
        // Insert a new row after the current one
        Row newRow = (Row)parentRow.deepClone(true);
        table.getRows().insert(rowIndex + 1, newRow);
        
        // Update the content of the original (top) cell
        cell.getFirstParagraph().appendChild(new Run(cell.getDocument(), topContent));
        
        // Update the content of the new (bottom) cell
        Cell newCell = newRow.getCells().get(cellIndex);
        newCell.getFirstParagraph().getRuns().clear();
        newCell.getFirstParagraph().appendChild(new Run(cell.getDocument(), bottomContent));
    }
    
    /**
     * Splits a cell vertically (one cell becomes two cells side by side).
     * 
     * @param cell The cell to split
     * @param table The table containing the cell
     * @param leftContent Content for the left cell
     * @param rightContent Content for the right cell
     */
    private static void splitCellVertically(Cell cell, Table table, String leftContent, String rightContent) throws Exception {
        // Get original cell properties
        Row parentRow = cell.getParentRow();
        int cellIndex = parentRow.indexOf(cell);
        
        // Update the content of the original (left) cell
        cell.getFirstParagraph().getRuns().clear();
        cell.getFirstParagraph().appendChild(new Run(cell.getDocument(), leftContent));
        
        // Create a new cell to the right
        Cell newCell = new Cell(cell.getDocument());
        newCell.getFirstParagraph().appendChild(new Run(cell.getDocument(), rightContent));
        
        // Insert the new cell after the original one
        parentRow.getCells().insert(cellIndex + 1, newCell);
    }
}
