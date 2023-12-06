package lab0;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab0.Variant;
import lab0.Variant.GRADE;

public class VariantTest {

    ////////////////////////////////////////////////

    @Test(dataProvider = "integerProvider")
    public void inputTest(int p1, int p3) {
        assertEquals(new Variant().integerNumbersTask(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 3600, 0 }, { 5400, 1800 } };
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3) {
        assertEquals(new Variant().ifTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 2, 3, 1 }, { -2, 3, 2 }, { 3, -5, 4 }, { -7, -3, 3 }};
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, boolean p3) {
        assertEquals(new Variant().booleanTask(p1), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 123, true }, { 312, false }, { 566, false }, { 567, true } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, GRADE p2) {
        assertEquals(new Variant().switchTask(p1), p2);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 5, GRADE.EXCELLENT }, { 3, GRADE.SATISFYING }, { 2, GRADE.UNSATISFYING} };
    }

/*

    @Test(expectedExceptions = AssertionError.class)
    public void switchNegativeTest() {
        new Variant().forTask(10);
    }

 */

    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(double p1, int p2, double p3) {
        assertEquals(new Variant().forTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] {
                { 2.0, 5, 7.0 },
        };
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int p1, boolean p2) {
        assertEquals(new Variant().whileTask(p1), p2);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 2, true }, { 4, false }, { 3, true }, { 93, false} };
    }

    //////////////////////////////////////////

    @Test(dataProvider = "minmaxProvider")
    public void minmaxTest(int p1, int[] p2, int[] p3){
        assertEquals(new Variant().minmaxTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] minmaxProvider(){
        return new Object[][] {
                { 5, new int[] { 5, 2, 8, 1, 6 }, new int[] { 1, 2 } },
                { 4, new int[] { 10, 7, 8, 5 }, new int[] { 5, 7 } },
                { 3, new int[] { 1, 2, 3 }, new int[] { 1, 2 } }
        };
    }

    //////////////////////////////////////////


    @Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] p1, int p2, int p3, double p4) {
        assertEquals(new Variant().arrayTask(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] {
                { new double[] { 10, 2, 13 }, 5, 9, 25.0 },
        };
    }



    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void matrixTest(int[][] p1, int p2, int p3, int p4) {
        assertEquals(new Variant().matrixTask(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input1 = {  {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}   };

        int[][] input2 = {  {2, 4, 6},
                            {1, 3, 5},
                            {0, 2, 4}   };

        int[][] input3 = {  {1, 0, 3, 0},
                            {4, 0, 6, 0},
                            {7, 0, 9, 0}    };

        return new Object[][] {
                { input1, 3, 3, 15 },
                { input2, 3, 3, 9 },
                { input3, 3, 4, 0 }
        };

    }

}