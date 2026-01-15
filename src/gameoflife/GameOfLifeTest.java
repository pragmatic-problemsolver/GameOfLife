package gameoflife;

public class GameOfLifeTest {
    private static final GameOfLife gameTestInstance = new GameOfLife();

    public static void main(String[] args) {
        runTest("UnderPopulation", GameOfLifeTest::testUnderpopulation);
        runTest("OverCrowding", GameOfLifeTest::testOvercrowding);
        runTest("Survival", GameOfLifeTest::testSurvival);
        runTest("Reproduction", GameOfLifeTest::testReprodcution);

        System.out.println("\nAll the tests are completed...");
    }

    private static void runTest(String testName, Runnable test) {
        try{
            test.run();
            System.out.println("Test "+testName+" passed.");
        }
        catch(AssertionError e){
            System.err.println("Test "+testName+" failed: "+e.getMessage());
        }
    }

    //test cases
    private static void testUnderpopulation() {
        boolean[][] board = {
                {false, false, false},
                {false, true, false},
                {false, false, false}};
        boolean[][] result = gameTestInstance.nextGeneration(board);

        assertFalse(result[1][1], "Live cell with <2 neighbors should die");
    }

    private static void testOvercrowding() {
        boolean[][] board = {
                {true, true, true},
                {true, true, false},
                {false, false, false}};

        boolean[][] result = gameTestInstance.nextGeneration(board);
        assertFalse(result[1][1], "Live cell with >3 neighbors should die");
    }

    private static void testSurvival() {
        boolean[][] board = {
                {false, true, false},
                {true, true, false},
                {false, false, false}};
        boolean[][] result = gameTestInstance.nextGeneration(board);
        assertTrue(result[1][1], "Live cell with 2 or 3 meighbors should survive");
        }
    private static void testReprodcution() {
        boolean[][] board = {
                {true, true, false},
                {true, false, false},
                {false, false, false}};
        boolean[][] result = gameTestInstance.nextGeneration(board);

        assertTrue(result[1][1], "Dead cell with exactly 3 neighbors should become alive");
    }

    private static void assertTrue(boolean value, String message){
        if(!value){
            throw new AssertionError(message);
        }
    }

    private static void assertFalse(boolean value, String message){
        if(value){
            throw new AssertionError(message);
        }
    }
}