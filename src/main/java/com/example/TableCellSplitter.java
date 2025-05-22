
package com.example;

/**
 * A simple Java application that demonstrates splitting table cells.
 */
public class TableCellSplitter {
    
    /**
     * Represents a table cell in a grid.
     */
    public static class Cell {
        private Object content;
        private int rowSpan;
        private int colSpan;
        
        public Cell(Object content) {
            this.content = content;
            this.rowSpan = 1;
            this.colSpan = 1;
        }
        
        public Cell(Object content, int rowSpan, int colSpan) {
            this.content = content;
            this.rowSpan = rowSpan;
            this.colSpan = colSpan;
        }
        
        public Object getContent() {
            return content;
        }
        
        public int getRowSpan() {
            return rowSpan;
        }
        
        public int getColSpan() {
            return colSpan;
        }
        
        @Override
        public String toString() {
            return content.toString();
        }
    }
    
    /**
     * Represents a table with cells that can be split.
     */
    public static class Table {
        private Cell[][] cells;
        
        public Table(int rows, int cols) {
            cells = new Cell[rows][cols];
            // Initialize with empty cells
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    cells[i][j] = new Cell("");
                }
            }
        }
        
        public void setCell(int row, int col, Cell cell) {
            cells[row][col] = cell;
        }
        
        public Cell getCell(int row, int col) {
            return cells[row][col];
        }
        
        /**
         * Split a cell horizontally into two cells.
         * @param row Row index of the cell
         * @param col Column index of the cell
         * @param topContent Content for the top cell after split
         * @param bottomContent Content for the bottom cell after split
         */
        public void splitCellHorizontally(int row, int col, Object topContent, Object bottomContent) {
            Cell originalCell = cells[row][col];
            
            // Create two new cells
            cells[row][col] = new Cell(topContent);
            
            // If there is space below, create the bottom cell
            if (row + 1 < cells.length) {
                cells[row + 1][col] = new Cell(bottomContent);
            } else {
                System.out.println("Warning: Cannot split cell horizontally - no space below");
            }
        }
        
        /**
         * Split a cell vertically into two cells.
         * @param row Row index of the cell
         * @param col Column index of the cell
         * @param leftContent Content for the left cell after split
         * @param rightContent Content for the right cell after split
         */
        public void splitCellVertically(int row, int col, Object leftContent, Object rightContent) {
            Cell originalCell = cells[row][col];
            
            // Create two new cells
            cells[row][col] = new Cell(leftContent);
            
            // If there is space to the right, create the right cell
            if (col + 1 < cells[0].length) {
                cells[row][col + 1] = new Cell(rightContent);
            } else {
                System.out.println("Warning: Cannot split cell vertically - no space to the right");
            }
        }
        
        /**
         * Display the table in a text representation.
         */
        public void printTable() {
            for (Cell[] row : cells) {
                for (Cell cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        // Create a 3x3 table
        Table table = new Table(3, 3);
        
        // Set some initial content
        table.setCell(0, 0, new Cell("A"));
        table.setCell(0, 1, new Cell("B"));
        table.setCell(0, 2, new Cell("C"));
        table.setCell(1, 0, new Cell("D"));
        table.setCell(1, 1, new Cell("E"));
        table.setCell(1, 2, new Cell("F"));
        table.setCell(2, 0, new Cell("G"));
        table.setCell(2, 1, new Cell("H"));
        table.setCell(2, 2, new Cell("I"));
        
        System.out.println("Original table:");
        table.printTable();
        
        // Split a cell horizontally
        System.out.println("\nAfter splitting cell 'E' horizontally:");
        table.splitCellHorizontally(1, 1, "E1", "E2");
        table.printTable();
        
        // Create a new table for vertical split demo
        Table table2 = new Table(3, 3);
        table2.setCell(0, 0, new Cell("A"));
        table2.setCell(0, 1, new Cell("B"));
        table2.setCell(0, 2, new Cell("C"));
        table2.setCell(1, 0, new Cell("D"));
        table2.setCell(1, 1, new Cell("E"));
        table2.setCell(1, 2, new Cell("F"));
        table2.setCell(2, 0, new Cell("G"));
        table2.setCell(2, 1, new Cell("H"));
        table2.setCell(2, 2, new Cell("I"));
        
        // Split a cell vertically
        System.out.println("\nAfter splitting cell 'E' vertically:");
        table2.splitCellVertically(1, 1, "E1", "E2");
        table2.printTable();
    }
}
