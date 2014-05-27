package sudokupuzzle;
import java.util.*;

/**
 *
 * @author Shelby Foster 10216798
 */
public class SudokuPuzzle {
    
    public int[] puzzle = new int[81];
    
    /**
     * Creates a Sudoku puzzle with empty spaces.
     */
    public SudokuPuzzle(){
        puzzle = new int []        {0,0,0, 0,0,0, 0,0,0,
                                    0,0,0, 0,0,0, 0,0,0,
                                    0,0,0, 0,0,0, 0,0,0,
                                    
                                    0,0,0, 0,0,0, 0,0,0,
                                    0,0,0, 0,0,0, 0,0,0,
                                    0,0,0, 0,0,0, 0,0,0,
                                    
                                    0,0,0, 0,0,0, 0,0,0,
                                    0,0,0, 0,0,0, 0,0,0,
                                    0,0,0, 0,0,0, 0,0,0};
                                     
    }
    
    /**
     * Creates a Sudoku puzzle from inputted parameters, in the following format:
     * squares A B C on top, D E F in middle, G H I at bottom.
     * Numbers are read from left to right starting from the first row.
     * @param all Insert numbers 1-9 to create a Sudoku Puzzle
     * 
     */
    public SudokuPuzzle(int a1,int a2,int a3, int b1,int b2,int b3, int c1,int c2,int c3,
                        int a4,int a5,int a6, int b4,int b5,int b6, int c4,int c5,int c6,
                        int a7,int a8,int a9, int b7,int b8,int b9, int c7,int c8,int c9,
                        int d1,int d2,int d3, int e1,int e2,int e3, int f1,int f2,int f3,
                        int d4,int d5,int d6, int e4,int e5,int e6, int f4,int f5,int f6,
                        int d7,int d8,int d9, int e7,int e8,int e9, int f7,int f8,int f9,
                        int g1,int g2,int g3, int h1,int h2,int h3, int i1,int i2,int i3,
                        int g4,int g5,int g6, int h4,int h5,int h6, int i4,int i5,int i6,
                        int g7,int g8,int g9, int h7,int h8,int h9, int i7,int i8,int i9){
         
        puzzle = new int []    {a1,a2,a3, b1,b2,b3, c1,c2,c3,
                                a4,a5,a6, b4,b5,b6, c4,c5,c6,
                                a7,a8,a9, b7,b8,b9, c7,c8,c9,
                                    
                                d1,d2,d3, e1,e2,e3, f1,f2,f3,
                                d4,d5,d6, e4,e5,e6, f4,f5,f6,
                                d7,d8,d9, e7,e8,e9, f7,f8,f9,
                                    
                                g1,g2,g3, h1,h2,h3, i1,i2,i3,
                                g4,g5,g6, h4,h5,h6, i4,i5,i6,
                                g7,g8,g9, h7,h8,h9, i7,i8,i9,};
        
    }
    
    public static void main(String[] args) {
       SudokuPuzzle s = new SudokuPuzzle
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
                       
               s.generateEasyPuzzle();
		    s.printPuzzle();
                    s.solver();
                    s.printPuzzle();
       
    }
    
    /**
    * Prints the current puzzle state to the terminal window in a Sudoku Format: 9 x 9
    * 
    */
    public void printPuzzle(){
        String s = " Sudoku Puzzle\n\n";
        for(int i=0; i < 81; i++ ) {
            if(i == 8 || i == 17 || i == 26 || i == 35 || i == 44 || i == 53 || i == 62 || i == 71 || i == 80){  //determines if the end of the puzzle line is reached (9 numbers)
                s = s + " " + puzzle[i] + "\n";        //prints on a new line
            }
            else{
            s = s + " " + puzzle[i];    //prints number
            }
        }
        System.out.println(s);      //prints puzzle
    }
    
    /**
    * Checks to see if the puzzle has been completed successfully with 
    * no duplicates or empty spaces
    * 
    * @return True if the puzzle contains no empty spaces or duplicates, otherwise False
    */
    public boolean checkPuzzle(){
        if(!checkColumns() || !checkRows() || !checkSquares()){     //checks if any of these methods are false
            System.out.println("This puzzle is invalid");
            return false;
        }
        System.out.println("Puzzle Completed Successfully");
        return true;
    }
    
    /**
    * Checks through each of the 9 rows to see if the method checkRow() is true or false
    * 
    * @return True if the method checkRow returns true for each of the 9 rows, otherwise False
    */
    public boolean checkRows(){
        for(int i = 0; i < 9; i++){     //iterates through 9 rows
            if(!checkRow(i)){           //checks if method returns false(contains duplicates or empty spaces)
                return false;
            }
        }
        return true;
    }
    
    /**
    * checkRow()
    * Checks for the numbers 1-9 within a row starting at position "x" in the 
    * array, cannot contain duplicates or empty spaces (0).
    * 
    * @param x the row you would like to check (0-8)
    * @return True if the row contains no duplicates or empty spaces, otherwise False
    */
    public boolean checkRow(int x){
        boolean [] items = new boolean []{false, false, false, false,false,     //array of booleans to check for duplicates 
            false, false, false, false, false};
        for(int i = 0; i < 9; i++){     //iterates through 9 positions in the array (each row)
            if(puzzle[9*x+i] == 0){     //checks if cell position is 0
                return false;
            }
            int value = puzzle[9*x+i];  //stores value at given position
            
            if(items[value]){       //checks if the value is already true in items
                return false;
            }
            items [value] = true;   //sets position of the value in items to true
        }
        return true;
        }
    
    /**
    * Checks through each column to see if checkColumn() is true.
    * 
    * @return True if the method checkColumn returns true for each of the 9 columns, otherwise False
    */
    public boolean checkColumns(){ 
        for(int i = 0; i < 9; i++){     //iterates through 9 columns
            if(!checkColumn(i)){        //checks if method returns false(contains duplicates or empty spaces)
                return false;
            }
        }
        return true;
    }
    
    /**
    * Checks for the numbers 1-9 within a column starting at position "x" in the
    * array, cannot contain duplicates or empty spaces (0).
    * 
    * @param x the column you would like to check (0-8).
    * @return True if the column contains no duplicates or empty spaces, otherwise False
    */  
    public boolean checkColumn(int x){
        boolean [] items = new boolean []{false, false, false, false,false,     //array of booleans to check for duplicates 
            false, false, false, false, false};
        
        for(int i = 0; i < 9; i++){     //iterates through 9 positions in the array (each column)
            if(puzzle[x+9*i] == 0){     //checks if cell position is 0
                return false;
            }
            
            int value = puzzle[x+9*i];      //stores value at given position
            
            if(items[value]){           //checks if the value is already true in items
                return false;
            }
            items [value] = true;       //sets position of the value in items to true
        }
        return true;
    }

    /**
    * Checks through each square to see if checkSquare() is true.
    * 
    * @return True if the method checkSquare returns true for each of the 9 squares, otherwise False
    */
    public boolean checkSquares(){
        //checks all squares in the puzzle
        if(!checkSquare(0) || !checkSquare(3) || !checkSquare(6) ||         //checks if method returns false(contains duplicates or empty spaces) for any of the 9 squares
           !checkSquare(27) || !checkSquare(30) || !checkSquare(33) ||
           !checkSquare(54) || !checkSquare(57) || !checkSquare(60)){
            return false;
        }

            return true;
    }
    
    /**
    * Checks for the numbers 1-9 within a square starting at position "s" in the
    * array, cannot contain duplicates or empty spaces (0).
    * 
    * @param s position in puzzle of which square you would like to check - 0,3,6,27,30,33,54,57,60
    * @return True if the square contains no duplicates or empty spaces, otherwise False
    */ 
    public boolean checkSquare(int s){ 
        boolean [] items = new boolean []{false, false, false, false,false,         //array of booleans to check for duplicates 
            false, false, false, false, false};
        
        for(int i = 0; i < 3; i++){     //iterates down 3 rows
        
            for(int x = 0; x < 3; x++){     //iterates through 3 positions in the row
                if(puzzle[s+x+9*i] == 0){       //checks if cell position is 0
                    return false;
                }
            
                int value = puzzle[s+x+9*i];    //stores value at given position
            
                if(items[value]){        //checks if the value is already true in items
                    return false;
                }   
                items [value] = true;   //sets position of the value in items to true
            }
        
        }
        return true;
   }
    
    /**
    * Changes a position within the puzzle to a number 1-9.
    * 
    * @param position determines what position in the array that should be changed
    * @param number determines what number to place in the array
    * 
    */ 
   //user input number in position given by the params
   public void changeNumber(int position, int number){
       if((number >= 0 && number < 10) && (position >= 0 && position <=80)){     //determines if number is 1-9 and position is 0-80
            puzzle[position] = number;      //changes the position in the array to the number
            printPuzzle();
       }
       else{
           System.out.println("This move is invalid");
       }
   }
   
   
   
   /**
    * Flips the puzzle horizontally and then flips the puzzle vertically.
    */  
   public void flipPuzzleHorizontalVertical(){
       for(int i = 0; i < 41; i++){
            int start = puzzle[i];      //determines start
            int end = puzzle[80 - i];   //determines end
            puzzle[i] = end;      //switches start value to the end value
            puzzle[80 - i] = start;     //switches end value with the start
        }
            printPuzzle();
   }
   
    /**
    * Flips the puzzle horizontally.
    */  
   public void flipPuzzleHorizontal(){
       for(int r = 0; r < 9; r++){      //goes through 9 rows
           for(int c = 0; c < 4; c++){      //goes through first 4 positions in each row
               int start = puzzle[9*r+c];   //determines value at start of the row
               int x = (9*r+8)-c;       //determines position of the end of the row
               int y = 9*r+c;       //determines position of the start
               int end = puzzle[x];     //determines value in end position
               puzzle[y] = end;         //stores the end value in the start value
               puzzle[x] = start;       //stores the start value in the end value
           }
       }
       printPuzzle();
   }
   
   /**
    * Flips the puzzle vertically.
    */  
   public void flipPuzzleVertical(){
       for(int r = 0; r < 9; r++){      //goes through 9 columns
           for(int c = 0; c < 4; c++){      //goes through first 4 positions in each column
               int start = puzzle[r+9*c];   //determines value at start of the column
               int x = ((72 + r)-(9*c));    //determines position of the end of the column
               int y = r+9*c;       //determines position of the start
               int end = puzzle[x];     //determines value in end position
               puzzle[y] = end;     //stores the end value in the start value
               puzzle[x] = start;       //stores the start value in the end value
           }
       }
       printPuzzle();
   }
   
   /**
    * Flips the rows 0-2 with rows 3-5 then flips 3-5 with 6-8.
    */  
   public void flipPuzzleRows1(){
       for(int r = 0; r < 6; r++){      //iterates through 6 rows
           for(int c = 0; c < 9; c++){      //iterates through 9 positions in each row
               int start = puzzle[9*r+c];   //determines start value
               int x = (9*r+c)+ 27;     //adds 27 to start position to get the end position
               int y = 9*r+c;       //determines start position
               int end = puzzle[x];     //determines end value  
               puzzle[y] = end;     //stores the end value in the start value
               puzzle[x] = start;   //stores the start value in the end value
           }
       }
       printPuzzle();
   }
   
   /**
    * Flips the rows 0-2 with rows 3-5.
    */  
      public void flipPuzzleRows2(){
       for(int r = 0; r < 3; r++){      //iterates through 3 rows
           for(int c = 0; c < 9; c++){      //iterates through 9 positions in each row
               int start = puzzle[9*r+c];   //determines start value
               int x = (9*r+c)+ 27;     //adds 27 to start position to get the end position
               int y = 9*r+c;   //determines start position
               int end = puzzle[x];     //determines end value  
               puzzle[y] = end;     //stores the end value in the start value
               puzzle[x] = start;       //stores the start value in the end value
           }
       }
       printPuzzle();
   }
      
  /**
   * Flips the rows 3-5 with rows 6-8.
   */  
   public void flipPuzzleRows3(){
       for(int r = 3; r < 6; r++){      //iterates through middle 3 rows
           for(int c = 0; c < 9; c++){      //iterates through 9 positions in each row
               int start = puzzle[9*r+c];   //determines start value
               int x = (9*r+c)+ 27;     //adds 27 to start position to get the end position
               int y = 9*r+c;       //determines start position
               int end = puzzle[x];     //determines end value  
               puzzle[y] = end;     //stores the end value in the start value
               puzzle[x] = start;       //stores the start value in the end value
           }
       }
       printPuzzle();
   }
   
   /**
   * Flips the rows 0-2 with rows 6-8.
   */       
   public void flipPuzzleRows4(){
       for(int r = 0; r < 3; r++){      //iterates through 3 rows
           for(int c = 0; c < 9; c++){      //iterates through 9 positions in each row
               int start = puzzle[9*r+c];   //determines start value
               int x = (9*r+c)+ 54;      //adds 54 to start position to get the end position
               int y = 9*r+c;       //determines start position
               int end = puzzle[x];     //determines end value  
               puzzle[y] = end;     //stores the end value in the start value
               puzzle[x] = start;   //stores the start value in the end value
           }
       }
       printPuzzle();
   }
   
   /**
   * Flips the columns 0-2 with 3-5.
   */
   public void flipPuzzleColumn1(){     
       for(int r = 0; r < 3; r++){      //iterates through 3 columns
           for(int c = 0; c < 9; c++){      //iterates through 9 positions in each column
               int start = puzzle[r+9*c];   //determines start value
               int x = (r+9*c)+ 3;       //adds 3 to start position to get the end position
               int y = r+9*c;        //determines start position
               int end = puzzle[x];     //determines end value  
               puzzle[y] = end;     //stores the end value in the start value
               puzzle[x] = start;    //stores the start value in the end value
           }
       }
       printPuzzle();
   }
   
   /**
   * Flips the columns 0-2 with 6-8.
   */
   public void flipPuzzleColumn2(){
       for(int r = 0; r < 3; r++){      //iterates through 3 columns
           for(int c = 0; c < 9; c++){       //iterates through 9 positions in each column
               int start = puzzle[r+9*c];       //determines start value
               int x = (r+9*c)+ 6;      //adds 6 to start position to get the end position
               int y = r+9*c;       //determines start position
               int end = puzzle[x];     //determines end value  
               puzzle[y] = end;     //stores the end value in the start value
               puzzle[x] = start;       //stores the start value in the end value
           }
       }
       printPuzzle();
   }
   
   /**
   * Flips the columns 3-5 with 6-8.
   */
   public void flipPuzzleColumn3(){ 
       for(int r = 3; r < 6; r++){      //iterates through middle 3 columns
           for(int c = 0; c < 9; c++){      //iterates through 9 positions in each column
               int start = puzzle[r+9*c];   //determines start value
               int x = (r+9*c)+ 3;      //adds 3 to start position to get the end position
               int y = r+9*c;       //determines start position
               int end = puzzle[x];     //determines end value  
               puzzle[y] = end;     //stores the end value in the start value
               puzzle[x] = start;       //stores the start value in the end value
           }
       }
       printPuzzle();
   }
 
   /**
   * Checks that only one number can be in a given cell by looking at the
   * row/column/square the position lies on, without any of these containing 
   * any duplicates.
   * 
   * @param a The position that should be checked if there is only one choice available
   * @return Returns the number if there is only one number that can be in that position without duplicates, else it will return 0
   */
   public int checkOneChoice(int a){
       boolean [] items = new boolean []{true, false, false, false,false, 
            false, false, false, false, false};
                int n = a;
                //determines where column starts (eg. 1-8)
                for(int m = 0; m < 9; m++){
                    if(n > 8){
                        n = n - 9;
                    }
                }
                
                //determines which row it lies on
                int i = a/9;
                
                //checking off values in row a is contained in
                for(int c = 0; c < 9; c++){
                      int value = puzzle[9*i+c];
                      items [value] = true;
                      //////////System.out.println("" + value);
                }
                ///////////System.out.println("Columns");
                
                //checking off values in column a is contained in
                for(int c = 0; c < 9; c++){
                      int value = puzzle[n+9*c];
                      items [value] = true;
                      ///////////System.out.println("" + value);
                }
                
                
                //square1
                if((a >= 0 && a < 3) || (a > 8 && a < 12) ||(a > 17 && a < 21)){
                    for(int f = 0; f < 3; f++){
                        for(int j = 0; j < 3; j++){
                             int value = puzzle[0+j+9*f];
                             items [value] = true;
                        }
                    }
                }
                //square2
                else if((a > 2 && a < 6) || (a > 11 && a < 15) ||(a > 17 && a < 24)){
                    for(int f = 0; f < 3; f++){
                        for(int j = 0; j < 3; j++){
                             int value = puzzle[3+j+9*f];
                             items [value] = true;
                        }
                    }
                }
                //square3
                else if((a > 5 && a < 9) || (a > 14 && a < 18) ||(a > 23 && a < 27)){
                    for(int f = 0; f < 3; f++){
                        for(int j = 0; j < 3; j++){
                             int value = puzzle[6+j+9*f];
                             items [value] = true;
                        }
                    }
                }
                //square4
                else if((a > 26 && a < 30) || (a > 35 && a < 39) ||(a > 44 && a < 48)){
                    for(int f = 0; f < 3; f++){
                        for(int j = 0; j < 3; j++){
                             int value = puzzle[27+j+9*f];
                             items [value] = true;
                        }
                    }
                }
                //square5
                else if((a > 29 && a < 33) || (a > 38 && a < 42) ||(a > 47 && a < 51)){
                    for(int f = 0; f < 3; f++){
                        for(int j = 0; j < 3; j++){
                             int value = puzzle[30+j+9*f];
                             items [value] = true;
                        }
                    }
                }
                //square6
                else if((a > 32 && a < 36) || (a > 41 && a < 45) ||(a > 50 && a < 54)){
                    for(int f = 0; f < 3; f++){
                        for(int j = 0; j < 3; j++){
                             int value = puzzle[33+j+9*f];
                             items [value] = true;
                        }
                    }
                }
                //square7
                else if((a > 53 && a < 57) || (a > 62 && a < 66) ||(a > 71 && a < 75)){
                    for(int f = 0; f < 3; f++){
                        for(int j = 0; j < 3; j++){
                             int value = puzzle[54+j+9*f];
                             items [value] = true;
                        }
                    }
                }
                //square8
                else if((a > 56 && a < 60) || (a > 65 && a < 69) ||(a > 74 && a < 78)){
                    for(int f = 0; f < 3; f++){
                        for(int j = 0; j < 3; j++){
                             int value = puzzle[57+j+9*f];
                             items [value] = true;
                        }
                    }
                }
                //square9
                else{
                    for(int f = 0; f < 3; f++){
                        for(int j = 0; j < 3; j++){
                             int value = puzzle[60+j+9*f];
                             items [value] = true;
                        }
                    }
                }

                
                
                //counting false values && storing array position of false value
                int f = 0;
                int s = 0;
                for(int o = 1; o<10; o++){
                    boolean b = items[o];
                    if(b == false){
                        f++;
                        s = o;
                    }
                }
 
                //returns index if only 1 false, else returns 0
                if(f == 1){
                    //System.out.println(s);
                    return s;
                }
                else{
                    return 0;
                }
                

   }
   
   /**
   * Solves a puzzle that has been generated, removing the empty spaces (0)'s 
   * and filling them with the correct number.
   */
   public void solver(){
       int z = 0;
       for(int i = 0; i < 81; i++){     //determines how many 0's are in the puzzle
                 if(puzzle[i] == 0){
                     z++;
                 }
       }
       while(z > 0){        //while the puzzle still contains 0's
            for(int i = 0; i < 81; i++){
                 if(puzzle[i] == 0){
                     int s = checkOneChoice(i);     //check if only one position available, if so store the value in s
                     puzzle[i] = s;     //set position to s
                     if(s > 0){
                         z = z -1;  //if number is changed, subtract 1 from z (number of 0's in puzzle)
                         System.out.println(z);
                         System.out.println("Position: " + i + " -> " + s + "\n");
                         printPuzzle();
                     }
                 }
             }
       }
       System.out.println("Solved Puzzle");
       printPuzzle();
   }
   
   /**
   * Generates a puzzle by removing random positions within the array that only 
   * have one number for each empty cell, this is checked by using checkOneChoice().
   */
   public void generateEasyPuzzle(){
       Random r = new Random();
       int low = 0;
       int high = 80;
       
       //System.out.println("Positions that was changed to 0");
       
       for(int i = 0; i < 50; i++){         //iterates through 40 times
           int R = r.nextInt(high-low)+low;     //generates random number
            if(checkOneChoice(R) == 0){     //checks that checkOneChoice only has 1 number it can be at the position of the random number
                 puzzle[R] = 0;     //sets position to 0
            }
            System.out.println(i);
            System.out.println(R + " -> 0");
            //printPuzzle();
       }
       //printPuzzle();
   }

}