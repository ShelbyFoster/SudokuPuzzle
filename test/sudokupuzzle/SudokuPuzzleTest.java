/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokupuzzle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SHELB
 */
public class SudokuPuzzleTest {
    
    public SudokuPuzzleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
	 * Testing a Good Puzzle
	 */
	@Test
		public void testGoodPuzzle() {

			SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
                        
			//assertTrue (6, problem.puzzle[0]);
                        
                        //Checking rows 1, 5, 9
			assertTrue (problem.checkRow (0));
                        assertTrue (problem.checkRow (4));
                        assertTrue (problem.checkRow (8));
                        
                        //Checking columns 1, 6, 9
                        assertTrue (problem.checkColumn (0));
                        assertTrue (problem.checkColumn (5));
                        assertTrue (problem.checkColumn (8));
                        
                        //Checking squares 1, 4, 9 (using array positions where they start)
                        assertTrue (problem.checkSquare (0));
                        assertTrue (problem.checkSquare (27));
                        assertTrue (problem.checkSquare (60));
                        
                        //Checking Puzzle
			assertTrue (problem.checkPuzzle ());
		}

	/**
	 * Testing an empty puzzle
	 */
	@Test
		public void testBadPuzzle1() {

			SudokuPuzzle problem = new SudokuPuzzle (); // with the test array for incorrect puzzle
			//assertTrue (6, problem.puzzle[0]);
                        
                        //Checking rows 1, 4, 9 and all rows
			assertFalse (problem.checkRow (0));
			assertFalse (problem.checkRow (3));
                        assertFalse (problem.checkRow (8));
                        assertFalse (problem.checkRows());
                        
                        //Checking columns 1, 5, 9 and all columns
                        assertFalse (problem.checkColumn (0));
                        assertFalse (problem.checkColumn (4));
                        assertFalse (problem.checkColumn (8));
                        assertFalse (problem.checkColumns());
                        
                        //Checking squares 1, 5, 9 (using array positions where they start) and all squares
                        assertFalse (problem.checkSquare (0));
                        assertFalse (problem.checkSquare (30));
                        assertFalse (problem.checkSquare (60));
                        assertFalse (problem.checkSquares());
                        
                        //Checking Puzzle is false
			assertFalse (problem.checkPuzzle ());
		}

        
        
        /**
	 * Testing an empty puzzle
	 */
	@Test
		public void testBadPuzzle2() {

			SudokuPuzzle problem = new SudokuPuzzle 
                                   (2,9,5, 4,4,3, 8,6,1,
                                    4,3,1, 8,6,5, 9,2,7,
                                    8,7,6, 1,9,2, 5,4,3,
                                    
                                    3,8,7, 4,5,9, 2,1,6,
                                    6,1,2, 3,8,7, 4,9,5,
                                    5,4,9, 2,1,6, 7,3,8,
                                    
                                    7,6,3, 5,2,4, 1,8,9,
                                    9,2,8, 6,7,1, 3,0,4,
                                    1,5,4, 9,3,8, 6,7,2); // with the test array for incorrect puzzle
			//assertTrue (6, problem.puzzle[0]);
                        
                        //Check to see if it detects duplicate 4
			assertFalse (problem.checkRow (0));
                        assertFalse (problem.checkColumn (3));
                        assertFalse (problem.checkSquare (3));
                        
                        //Check to see if it detects the 0
                        assertFalse (problem.checkRow (7));
                        assertFalse (problem.checkColumn (7));
                        assertFalse (problem.checkSquare (60));
                        
                        //Checks to see if row 7 and column 6 is correct
                        assertTrue (problem.checkRow (6));
                        assertTrue (problem.checkColumn (5));
                        assertTrue (problem.checkSquare (54));
                        //Checks to see if row 5 and column 2 is correct
                        assertTrue (problem.checkRow (4));
                        assertTrue (problem.checkColumn (1));
                        assertTrue (problem.checkSquare (27));
                        
                        //Checking Puzzle is false
			assertFalse (problem.checkPuzzle ());
		}

        /**
	 * Testing an empty puzzle
	 */
	@Test
                public void testBadPuzzle3() {

			SudokuPuzzle problem = new SudokuPuzzle 
                                   (2,4,6, 6,5,7, 9,1,3,
                                    1,8,9, 6,0,3, 2,7,5,
                                    5,7,3, 2,9,1, 4,8,6,
                                    
                                    4,1,8, 3,2,9, 5,6,7,
                                    6,0,7, 4,8,5, 1,2,9,
                                    9,5,2, 1,7,6, 3,4,8,
                                    
                                    7,6,4, 5,3,2, 8,9,1,
                                    3,2,1, 9,6,8, 8,5,4,
                                    8,9,5, 7,1,4, 6,3,2);
                        
                        //Check to see if it detects duplicate 6
			assertFalse (problem.checkRow (0));
                        assertFalse (problem.checkColumn (3));
                        assertFalse (problem.checkSquare (3));
                        
                        //Check to see if it detects the 0
                        assertFalse (problem.checkRow (1));
                        assertFalse (problem.checkColumn (4));
                        assertFalse (problem.checkSquare (3));
                        
                        //Check to see if it detects duplicate 8
                        assertFalse (problem.checkRow (7));
                        assertFalse (problem.checkColumn (6));
                        assertFalse (problem.checkSquare (60));
                        
                        //Checks to see if row 2 and column 2 is correct
                        assertTrue (problem.checkRow (2));
                        assertTrue (problem.checkColumn (2));
                        assertTrue (problem.checkSquare (0));
                        //Checks to see if row 5 and column 7 is correct
                        assertTrue (problem.checkRow (5));
                        assertTrue (problem.checkColumn (7));
                        assertTrue (problem.checkSquare (33));
                        
                        //Checking Puzzle is false
			assertFalse (problem.checkPuzzle ());
                 }
        @Test
        public void testUserInteraction(){
            SudokuPuzzle problem = new SudokuPuzzle();
            problem.changeNumber(0, 9);
            problem.changeNumber(80, 4);
            problem.changeNumber(54, 7);
            problem.changeNumber(43, 3);
            problem.changeNumber(76, 5);

            assertTrue(problem.puzzle[0] == 9);
            assertTrue(problem.puzzle[80] == 4);
            assertTrue(problem.puzzle[54] == 7);
            assertTrue(problem.puzzle[43] == 3);
            assertTrue(problem.puzzle[76] == 5);
            assertTrue(problem.puzzle[66] == 0);
            assertTrue(problem.puzzle[50] == 0);
            
            problem.changeNumber(66, 20);
            problem.changeNumber(50, 10);
            
            
            assertTrue(problem.puzzle[66] == 0);
            assertTrue(problem.puzzle[50] == 0);
            
            
        }
        
        
        @Test
//tests flipPuzzleHorizontalVertical() method in the main class to ensure it is flipped correctly
        public void testFlipPuzzleHorizontalVertical() {
            SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
            problem.flipPuzzleHorizontalVertical();
            
            SudokuPuzzle problemtest = new SudokuPuzzle 
                                   (7,6,5,9,1,4,8,2,3,
                                    9,3,4,5,2,8,6,7,1,
                                    2,8,1,7,3,6,5,4,9,
                                    8,5,6,4,7,1,3,9,2,
                                    4,2,3,8,6,9,1,5,7,
                                    1,9,7,2,5,3,4,6,8,
                                    6,7,8,3,4,2,9,1,5,
                                    3,1,2,6,9,5,7,8,4,
                                    5,4,9,1,8,7,2,3,6);
            
              //Checking changed values
              assertTrue(problem.puzzle[0] == problemtest.puzzle[0]);
              assertTrue(problem.puzzle[8] == problemtest.puzzle[8]);
              assertTrue(problem.puzzle[27] == problemtest.puzzle[27]);
              assertTrue(problem.puzzle[35] == problemtest.puzzle[35]);
              assertTrue(problem.puzzle[54] == problemtest.puzzle[54]);
              assertTrue(problem.puzzle[62] == problemtest.puzzle[62]);
              assertTrue(problem.puzzle[72] == problemtest.puzzle[72]);
              assertTrue(problem.puzzle[80] == problemtest.puzzle[80]);
              
              //Checking puzzle has no duplicates
              assertTrue(problemtest.checkPuzzle());
              
            
        }



        @Test
//tests flipPuzzleHorizontal() method in the main class to ensure it is flipped correctly

        public void testFlipPuzzleHorizontal() {
            SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
            problem.flipPuzzleHorizontal();
            
            SudokuPuzzle problemtest = new SudokuPuzzle 
                                   (5,4,9, 1,8,7, 2,3,6,
                                    3,1,2, 6,9,5, 7,8,4,
                                    6,7,8, 3,4,2, 9,1,5,
                                    1,9,7, 2,5,3, 4,6,8,
                                    4,2,3, 8,6,9, 1,5,7,
                                    8,5,6, 4,7,1, 3,9,2,
                                    2,8,1, 7,3,6, 5,4,9,
                                    9,3,4, 5,2,8, 6,7,1,
                                    7,6,5, 9,1,4, 8,2,3);
            
              //Checking changed values
              assertTrue(problem.puzzle[0] == problemtest.puzzle[0]);
              assertTrue(problem.puzzle[8] == problemtest.puzzle[8]);
              assertTrue(problem.puzzle[27] == problemtest.puzzle[27]);
              assertTrue(problem.puzzle[35] == problemtest.puzzle[35]);
              assertTrue(problem.puzzle[54] == problemtest.puzzle[54]);
              assertTrue(problem.puzzle[62] == problemtest.puzzle[62]);
              assertTrue(problem.puzzle[72] == problemtest.puzzle[72]);
              assertTrue(problem.puzzle[80] == problemtest.puzzle[80]);
              
              //Checking puzzle has no duplicates
              assertTrue(problemtest.checkPuzzle());
              
            
        }

        @Test
//tests flipPuzzleVertical() method in the main class to ensure it is flipped correctly
        public void testFlipPuzzleVertical() {
            SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
            problem.flipPuzzleVertical();
            
            SudokuPuzzle problemtest = new SudokuPuzzle 
                                   (3,2,8, 4,1,9, 5,6,7,
                                    1,7,6, 8,2,5, 4,3,9,
                                    9,4,5, 6,3,7, 1,8,2,

                                    2,9,3, 1,7,4, 6,5,8,
                                    7,5,1, 9,6,8, 3,2,4,
                                    8,6,4, 3,5,2, 7,9,1,

                                    5,1,9, 2,4,3, 8,7,6,
                                    4,8,7, 5,9,6, 2,1,3,
                                    6,3,2, 7,8,1, 9,4,5);
            
              //Checking changed values
              assertTrue(problem.puzzle[0] == problemtest.puzzle[0]);
              assertTrue(problem.puzzle[8] == problemtest.puzzle[8]);
              assertTrue(problem.puzzle[27] == problemtest.puzzle[27]);
              assertTrue(problem.puzzle[35] == problemtest.puzzle[35]);
              assertTrue(problem.puzzle[54] == problemtest.puzzle[54]);
              assertTrue(problem.puzzle[62] == problemtest.puzzle[62]);
              assertTrue(problem.puzzle[72] == problemtest.puzzle[72]);
              assertTrue(problem.puzzle[80] == problemtest.puzzle[80]);
              
              //Checking puzzle has no duplicates
              assertTrue(problemtest.checkPuzzle());
              
            
        }


@Test
        public void testFlipPuzzleRows1() {
            SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
            problem.flipPuzzleRows1();
            
            SudokuPuzzle problemtest = new SudokuPuzzle 
                                   (8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7,

                                    6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6);
            
              //Checking changed values
              assertTrue(problem.puzzle[0] == problemtest.puzzle[0]);
              assertTrue(problem.puzzle[8] == problemtest.puzzle[8]);
              assertTrue(problem.puzzle[18] == problemtest.puzzle[18]);
              assertTrue(problem.puzzle[26] == problemtest.puzzle[26]);
              assertTrue(problem.puzzle[27] == problemtest.puzzle[27]);
              assertTrue(problem.puzzle[35] == problemtest.puzzle[35]);
              assertTrue(problem.puzzle[45] == problemtest.puzzle[45]);
              assertTrue(problem.puzzle[53] == problemtest.puzzle[53]);
              assertTrue(problem.puzzle[54] == problemtest.puzzle[54]);
              assertTrue(problem.puzzle[62] == problemtest.puzzle[62]);
              assertTrue(problem.puzzle[72] == problemtest.puzzle[72]);
              assertTrue(problem.puzzle[80] == problemtest.puzzle[80]);

              //Checking puzzle has no duplicates
              assertTrue(problemtest.checkPuzzle());
              
            
        }

        @Test
        public void testFlipPuzzleRows2() {
            SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
            problem.flipPuzzleRows2();
            
            SudokuPuzzle problemtest = new SudokuPuzzle 
                                   (8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                    
                                    6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
              //Checking changed values
              assertTrue(problem.puzzle[0] == problemtest.puzzle[0]);
              assertTrue(problem.puzzle[8] == problemtest.puzzle[8]);
              assertTrue(problem.puzzle[18] == problemtest.puzzle[18]);
              assertTrue(problem.puzzle[26] == problemtest.puzzle[26]);
              assertTrue(problem.puzzle[27] == problemtest.puzzle[27]);
              assertTrue(problem.puzzle[35] == problemtest.puzzle[35]);
              assertTrue(problem.puzzle[45] == problemtest.puzzle[45]);
              assertTrue(problem.puzzle[53] == problemtest.puzzle[53]);
              
              //Checking puzzle has no duplicates
              assertTrue(problemtest.checkPuzzle());
            
        }

@Test
//flips rows 3-5 with rows 6-8

        public void testFlipPuzzleRows3() {
            SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
            problem.flipPuzzleRows3();
            
            SudokuPuzzle problemtest = new SudokuPuzzle 

                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                                                        
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7,

                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8);
            

              //Checking changed values
              assertTrue(problem.puzzle[27] == problemtest.puzzle[27]);
              assertTrue(problem.puzzle[35] == problemtest.puzzle[35]);
              assertTrue(problem.puzzle[45] == problemtest.puzzle[45]);
              assertTrue(problem.puzzle[53] == problemtest.puzzle[53]);
              assertTrue(problem.puzzle[54] == problemtest.puzzle[54]);
              assertTrue(problem.puzzle[62] == problemtest.puzzle[62]);
              assertTrue(problem.puzzle[72] == problemtest.puzzle[72]);
              assertTrue(problem.puzzle[80] == problemtest.puzzle[80]);

              //Checking values that have stayed the same after the flip
              assertTrue(problem.puzzle[0] == problemtest.puzzle[0]);
              assertTrue(problem.puzzle[8] == problemtest.puzzle[8]);
              assertTrue(problem.puzzle[18] == problemtest.puzzle[18]);
              assertTrue(problem.puzzle[26] == problemtest.puzzle[26]);

              //Checking puzzle has no duplicates
              assertTrue(problemtest.checkPuzzle());
              
            
        }


@Test
//flips rows 0-2 with rows 6-8

        public void testFlipPuzzleRows4() {
            SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
            problem.flipPuzzleRows4();
            
            SudokuPuzzle problemtest = new SudokuPuzzle 
                                   (9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7,

                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,                                    

                                    6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6);
            
              //Checking changed values
              assertTrue(problem.puzzle[0] == problemtest.puzzle[0]);
              assertTrue(problem.puzzle[8] == problemtest.puzzle[8]);
              assertTrue(problem.puzzle[18] == problemtest.puzzle[18]);
              assertTrue(problem.puzzle[26] == problemtest.puzzle[26]);
              assertTrue(problem.puzzle[54] == problemtest.puzzle[54]);
              assertTrue(problem.puzzle[62] == problemtest.puzzle[62]);
              assertTrue(problem.puzzle[72] == problemtest.puzzle[72]);
              assertTrue(problem.puzzle[80] == problemtest.puzzle[80]);

              //Checking values that have stayed the same after the flip
              assertTrue(problem.puzzle[38] == problemtest.puzzle[38]);
              assertTrue(problem.puzzle[51] == problemtest.puzzle[51]);

              //Checking puzzle has no duplicates
              assertTrue(problemtest.checkPuzzle());
              
            
        }


@Test
//flips column 0-2 with 3-5

        public void testFlipPuzzleColumn1() {
            SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
            problem.flipPuzzleColumn1();
            
            SudokuPuzzle problemtest = new SudokuPuzzle 
                                   (7,8,1, 6,3,2, 9,4,5,
                                    5,9,6, 4,8,7, 2,1,3,
                                    2,4,3, 5,1,9, 8,7,6,
                                    
                                    3,5,2, 8,6,4, 7,9,1,
                                    9,6,8, 7,5,1, 3,2,4,
                                    1,7,4, 2,9,3, 6,5,8,
                                    
                                    6,3,7, 9,4,5, 1,8,2,
                                    8,2,5, 1,7,6, 4,3,9,
                                    4,1,9, 3,2,8, 5,6,7);
            

              //Checking changed values
              assertTrue(problem.puzzle[0] == problemtest.puzzle[0]);
              assertTrue(problem.puzzle[5] == problemtest.puzzle[5]);
              assertTrue(problem.puzzle[18] == problemtest.puzzle[18]);
              assertTrue(problem.puzzle[23] == problemtest.puzzle[23]);
              assertTrue(problem.puzzle[27] == problemtest.puzzle[27]);
              assertTrue(problem.puzzle[32] == problemtest.puzzle[32]);
              assertTrue(problem.puzzle[45] == problemtest.puzzle[45]);
              assertTrue(problem.puzzle[59] == problemtest.puzzle[59]);
              assertTrue(problem.puzzle[72] == problemtest.puzzle[72]);
              assertTrue(problem.puzzle[77] == problemtest.puzzle[77]);

              //Checking values that have stayed the same after the flip
              assertTrue(problem.puzzle[16] == problemtest.puzzle[16]);
              assertTrue(problem.puzzle[43] == problemtest.puzzle[43]);
              assertTrue(problem.puzzle[80] == problemtest.puzzle[80]);

              //Checking puzzle has no duplicates
              assertTrue(problemtest.checkPuzzle());
              
            
        }





@Test
//flips column 0-2 with 6-8

        public void testFlipPuzzleColumn2() {
            SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
            problem.flipPuzzleColumn2();
            
            SudokuPuzzle problemtest = new SudokuPuzzle 
                                   (9,4,5, 7,8,1, 6,3,2,
                                    2,1,3, 5,9,6, 4,8,7,
                                    8,7,6, 2,4,3, 5,1,9, 
                                    
                                    7,9,1, 3,5,2, 8,6,4,
                                    3,2,4, 9,6,8, 7,5,1, 
                                    6,5,8, 1,7,4, 2,9,3, 
                                    
                                    1,8,2, 6,3,7, 9,4,5, 
                                    4,3,9, 8,2,5, 1,7,6, 
                                    5,6,7, 4,1,9, 3,2,8);
            
            
              //Checking changed values
              assertTrue(problem.puzzle[0] == problemtest.puzzle[0]);
              assertTrue(problem.puzzle[8] == problemtest.puzzle[8]);
              assertTrue(problem.puzzle[18] == problemtest.puzzle[18]);
              assertTrue(problem.puzzle[25] == problemtest.puzzle[25]);
              assertTrue(problem.puzzle[28] == problemtest.puzzle[28]);
              assertTrue(problem.puzzle[43] == problemtest.puzzle[43]);
              assertTrue(problem.puzzle[45] == problemtest.puzzle[45]);
              assertTrue(problem.puzzle[61] == problemtest.puzzle[61]);
              assertTrue(problem.puzzle[72] == problemtest.puzzle[72]);
              assertTrue(problem.puzzle[80] == problemtest.puzzle[80]);

              //Checking values that have stayed the same after the flip
              assertTrue(problem.puzzle[12] == problemtest.puzzle[12]);
              assertTrue(problem.puzzle[49] == problemtest.puzzle[49]);
              assertTrue(problem.puzzle[77] == problemtest.puzzle[77]);
              
              //Checking puzzle has no duplicates
              assertTrue(problemtest.checkPuzzle());
              
            
        }



@Test
//flips column 3-5 with 6-8

        public void testFlipPuzzleColumn3() {
            SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
            problem.flipPuzzleColumn3();
            
            SudokuPuzzle problemtest = new SudokuPuzzle 
                                   (6,3,2, 9,4,5, 7,8,1,
                                    4,8,7, 2,1,3, 5,9,6, 
                                    5,1,9, 8,7,6, 2,4,3, 
                                    
                                    8,6,4, 7,9,1, 3,5,2, 
                                    7,5,1, 3,2,4, 9,6,8, 
                                    2,9,3, 6,5,8, 1,7,4, 
                                    
                                    9,4,5, 1,8,2, 6,3,7, 
                                    1,7,6, 4,3,9, 8,2,5, 
                                    3,2,8, 5,6,7, 4,1,9);
            
              //Checking changed values
              assertTrue(problem.puzzle[3] == problemtest.puzzle[3]);
              assertTrue(problem.puzzle[8] == problemtest.puzzle[8]);
              assertTrue(problem.puzzle[21] == problemtest.puzzle[21]);
              assertTrue(problem.puzzle[25] == problemtest.puzzle[25]);
              assertTrue(problem.puzzle[40] == problemtest.puzzle[40]);
              assertTrue(problem.puzzle[43] == problemtest.puzzle[43]);
              assertTrue(problem.puzzle[48] == problemtest.puzzle[48]);
              assertTrue(problem.puzzle[61] == problemtest.puzzle[61]);
              assertTrue(problem.puzzle[68] == problemtest.puzzle[68]);
              assertTrue(problem.puzzle[80] == problemtest.puzzle[80]);

              //Checking values that have stayed the same after the flip
              assertTrue(problem.puzzle[9] == problemtest.puzzle[9]);
              assertTrue(problem.puzzle[37] == problemtest.puzzle[37]);
              assertTrue(problem.puzzle[74] == problemtest.puzzle[74]);
              
              //Checking puzzle has no duplicates
              assertTrue(problemtest.checkPuzzle());
              
            
        }

@Test
    public void checkOneSolution(){
        SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,0, 9,0,5, 7,8,1,
                                    4,8,7, 2,1,3, 5,9,6, 
                                    5,1,9, 8,7,6, 2,4,3, 
                                    
                                    0,6,4, 0,9,1, 3,0,2, 
                                    7,5,1, 3,0,4, 9,6,8, 
                                    2,9,3, 6,5,8, 1,7,4, 
                                    
                                    9,4,5, 1,0,2, 6,0,7, 
                                    1,7,6, 4,3,9, 8,2,5, 
                                    3,2,0, 5,6,7, 4,1,9);
        
        
        assertTrue(problem.checkOneChoice(2) == 2);
        assertTrue(problem.checkOneChoice(40) == 2);
        assertTrue(problem.checkOneChoice(74) == 8);
        assertTrue(problem.checkOneChoice(34) == 5);
        
        assertTrue(problem.checkOneChoice(27) == 8);
        assertTrue(problem.checkOneChoice(30) == 7);
        assertTrue(problem.checkOneChoice(58) == 8);
        assertTrue(problem.checkOneChoice(4) == 4);
        
        
        assertTrue(problem.checkOneChoice(80) == 0);
        assertTrue(problem.checkOneChoice(17) == 0);
        assertTrue(problem.checkOneChoice(23) == 0);
        
        
        
}


@Test 
    public void checkSolver(){
        SudokuPuzzle problem = new SudokuPuzzle 
                                   (0,3,2, 7,0,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 0,5,2, 7,9,0,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,0, 0,8,2,
                                    1,0,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);

        SudokuPuzzle problem2 = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
      
        
            problem.solver();
            
            //checking positions that changed
            assertTrue(problem.puzzle[0] == 6);
            assertTrue(problem.puzzle[30] == 3);
            assertTrue(problem.puzzle[4] == 8);
            assertTrue(problem.puzzle[35] == 1);
            assertTrue(problem.puzzle[64] == 7);
            assertTrue(problem.puzzle[59] == 7);
            assertTrue(problem.puzzle[60] == 1);
            
            assertTrue(problem.puzzle[67] == 2);
            assertTrue(problem.puzzle[28] == 6);
            assertTrue(problem.puzzle[7] == 4);
            assertTrue(problem.puzzle[13] == 9);
            assertTrue(problem.puzzle[53] == 8);
            
            //checking if puzzle solved correctly
            assertTrue(problem.checkPuzzle());
            
    }

@Test 
    public void checkGenerateSolver(){
        SudokuPuzzle problem = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);

        SudokuPuzzle problem2 = new SudokuPuzzle 
                                   (6,3,2, 7,8,1, 9,4,5,
                                    4,8,7, 5,9,6, 2,1,3,
                                    5,1,9, 2,4,3, 8,7,6,
                                    
                                    8,6,4, 3,5,2, 7,9,1,
                                    7,5,1, 9,6,8, 3,2,4,
                                    2,9,3, 1,7,4, 6,5,8,
                                    
                                    9,4,5, 6,3,7, 1,8,2,
                                    1,7,6, 8,2,5, 4,3,9,
                                    3,2,8, 4,1,9, 5,6,7);
      
            problem.generateEasyPuzzle();
            problem.solver();
            
            assertTrue(problem.puzzle[0] == problem2.puzzle[0]);
            assertTrue(problem.puzzle[1] == problem2.puzzle[1]);
            assertTrue(problem.puzzle[2] == problem2.puzzle[2]);
            assertTrue(problem.puzzle[3] == problem2.puzzle[3]);
            assertTrue(problem.puzzle[4] == problem2.puzzle[4]);
            assertTrue(problem.puzzle[5] == problem2.puzzle[5]);
            assertTrue(problem.puzzle[6] == problem2.puzzle[6]);
            assertTrue(problem.puzzle[7] == problem2.puzzle[7]);
            assertTrue(problem.puzzle[8] == problem2.puzzle[8]);
            assertTrue(problem.puzzle[9] == problem2.puzzle[9]);
            assertTrue(problem.puzzle[10] == problem2.puzzle[10]);
            assertTrue(problem.puzzle[11] == problem2.puzzle[11]);
            assertTrue(problem.puzzle[12] == problem2.puzzle[12]);
            assertTrue(problem.puzzle[13] == problem2.puzzle[13]);
            assertTrue(problem.puzzle[14] == problem2.puzzle[14]);
            assertTrue(problem.puzzle[15] == problem2.puzzle[15]);
            assertTrue(problem.puzzle[16] == problem2.puzzle[16]);
            assertTrue(problem.puzzle[17] == problem2.puzzle[17]);
            assertTrue(problem.puzzle[18] == problem2.puzzle[18]);
            assertTrue(problem.puzzle[19] == problem2.puzzle[19]);
            assertTrue(problem.puzzle[20] == problem2.puzzle[20]);
            assertTrue(problem.puzzle[21] == problem2.puzzle[21]);
            assertTrue(problem.puzzle[22] == problem2.puzzle[22]);
            assertTrue(problem.puzzle[23] == problem2.puzzle[23]);
            assertTrue(problem.puzzle[24] == problem2.puzzle[24]);
            assertTrue(problem.puzzle[25] == problem2.puzzle[25]);
            assertTrue(problem.puzzle[26] == problem2.puzzle[26]);
            assertTrue(problem.puzzle[27] == problem2.puzzle[27]);
            assertTrue(problem.puzzle[28] == problem2.puzzle[28]);
            assertTrue(problem.puzzle[29] == problem2.puzzle[29]);
            assertTrue(problem.puzzle[30] == problem2.puzzle[30]);
            assertTrue(problem.puzzle[31] == problem2.puzzle[31]);
            assertTrue(problem.puzzle[32] == problem2.puzzle[32]);
            assertTrue(problem.puzzle[33] == problem2.puzzle[33]);
            assertTrue(problem.puzzle[34] == problem2.puzzle[34]);
            assertTrue(problem.puzzle[35] == problem2.puzzle[35]);
            assertTrue(problem.puzzle[36] == problem2.puzzle[36]);
            assertTrue(problem.puzzle[37] == problem2.puzzle[37]);
            assertTrue(problem.puzzle[38] == problem2.puzzle[38]);
            assertTrue(problem.puzzle[39] == problem2.puzzle[39]);
            assertTrue(problem.puzzle[40] == problem2.puzzle[40]);
            assertTrue(problem.puzzle[50] == problem2.puzzle[50]);
            assertTrue(problem.puzzle[61] == problem2.puzzle[61]);
            assertTrue(problem.puzzle[67] == problem2.puzzle[67]);
            assertTrue(problem.puzzle[80] == problem2.puzzle[80]);
            assertTrue(problem.puzzle[72] == problem2.puzzle[72]);
            assertTrue(problem.puzzle[58] == problem2.puzzle[58]);
            
            //checking if puzzle solved correctly
            assertTrue(problem.checkPuzzle());
            
            
            
    }

@Test 
    public void testWebsiteEasyPuzzle(){
        SudokuPuzzle problem = new SudokuPuzzle 
                                   (0,3,9, 0,2,0, 5,0,0,
                                    0,0,0, 8,0,6, 0,0,0,
                                    5,0,2, 0,3,0, 0,0,0,
                                    
                                    2,4,8, 0,0,5, 0,0,1,
                                    3,9,0, 2,0,1, 0,5,8,
                                    1,0,0, 7,0,0, 9,4,2,
                                    
                                    0,0,0, 0,7,0, 8,0,5,
                                    0,0,0, 3,0,8, 0,0,0,
                                    0,0,4, 0,6,0, 3,2,0);
        
        problem.solver();
        
            //checking changed positions
            assertTrue(problem.puzzle[0] == 6);
            assertTrue(problem.puzzle[3] == 1);
            assertTrue(problem.puzzle[5] == 7);
            assertTrue(problem.puzzle[7] == 8);
            assertTrue(problem.puzzle[8] == 4);
            assertTrue(problem.puzzle[9] == 4);
            assertTrue(problem.puzzle[10] == 7);
            assertTrue(problem.puzzle[11] == 1);
            assertTrue(problem.puzzle[13] == 5);
            assertTrue(problem.puzzle[15] == 2);
            assertTrue(problem.puzzle[16] == 9);
            assertTrue(problem.puzzle[17] == 3);
            assertTrue(problem.puzzle[19] == 8);
            assertTrue(problem.puzzle[21] == 9);
            assertTrue(problem.puzzle[23] == 4);
            assertTrue(problem.puzzle[24] == 1);
            assertTrue(problem.puzzle[25] == 7);
            assertTrue(problem.puzzle[26] == 6);          
            assertTrue(problem.puzzle[30] == 6);
            assertTrue(problem.puzzle[31] == 9);
            assertTrue(problem.puzzle[33] == 7);
            assertTrue(problem.puzzle[34] == 3);        
            assertTrue(problem.puzzle[38] == 7);
            assertTrue(problem.puzzle[40] == 4);
            assertTrue(problem.puzzle[42] == 6);      
            assertTrue(problem.puzzle[46] == 5);
            assertTrue(problem.puzzle[47] == 6);
            assertTrue(problem.puzzle[49] == 8);
            assertTrue(problem.puzzle[50] == 3);
            assertTrue(problem.puzzle[54] == 9);
            assertTrue(problem.puzzle[55] == 6);
            assertTrue(problem.puzzle[56] == 3);
            assertTrue(problem.puzzle[57] == 4);
            assertTrue(problem.puzzle[59] == 2);
            assertTrue(problem.puzzle[61] == 1);       
            assertTrue(problem.puzzle[63] == 7);
            assertTrue(problem.puzzle[64] == 2);
            assertTrue(problem.puzzle[65] == 5);
            assertTrue(problem.puzzle[67] == 1);
            assertTrue(problem.puzzle[69] == 4);
            assertTrue(problem.puzzle[70] == 6);
            assertTrue(problem.puzzle[71] == 9); 
            assertTrue(problem.puzzle[72] == 8);
            assertTrue(problem.puzzle[73] == 1);
            assertTrue(problem.puzzle[75] == 5);
            assertTrue(problem.puzzle[77] == 9);
            assertTrue(problem.puzzle[80] == 7);
            
            //checking positions that didn't change
            assertTrue(problem.puzzle[20] == 2);
            assertTrue(problem.puzzle[41] == 1);
            assertTrue(problem.puzzle[53] == 2);
            assertTrue(problem.puzzle[76] == 6);
            assertTrue(problem.puzzle[62] == 5);
            
            //checking if puzzle solved correctly
            assertTrue(problem.checkPuzzle());
            
            
}



}
