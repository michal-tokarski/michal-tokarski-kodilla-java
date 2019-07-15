package com.kodilla.testing.shape;

import org.junit.*;

import static org.junit.Assert.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;
    private ShapeCollector iniShapes = null;

    @BeforeClass
    public static void beforeAllTests() {

        System.out.println("Test suite has begun ...");

    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.print("Executing test no. " + testCounter + " " + "...");
    }

    @After
    public void after(){
        System.out.println(" - done");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Test suite complete.");
    }

    @Test
    public void testAddFigure(){

        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape myCircle = new Circle(11);
        Shape mySquare = new Square(21);
        Shape myTriangle = new Triangle(31);
        //When
        shapes.addFigure(myCircle);
        shapes.addFigure(mySquare);
        shapes.addFigure(myTriangle);
        //Then
        assertEquals(3, shapes.getSize());
        assertTrue(shapes.getShapes().contains(myCircle));
        assertTrue(shapes.getShapes().contains(mySquare)) ;
        assertTrue(shapes.getShapes().contains(myTriangle)) ;

    }

    @Test
    public void testRemoveFigure(){

        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape myCircle = new Circle(38);
        Shape mySquare = new Square(48);
        Shape myTriangle = new Triangle(58);
        shapes.addFigure(myCircle);
        shapes.addFigure(mySquare);
        shapes.addFigure(myTriangle);
        //When
        shapes.removeFigure(myCircle);
        shapes.removeFigure(mySquare);
        shapes.removeFigure(myTriangle);
        //Then
        assertEquals(0, shapes.getSize());
        assertFalse(shapes.getShapes().contains(myCircle));
        assertFalse(shapes.getShapes().contains(mySquare));
        assertFalse(shapes.getShapes().contains(myTriangle));

    }

    @Test
    public void testGetFigure() {

        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape myCircle = new Circle(43);
        Shape mySquare = new Square(53);
        Shape myTriangle = new Triangle(63);
        shapes.addFigure(myCircle);
        shapes.addFigure(mySquare);
        shapes.addFigure(myTriangle);
        //When
        Shape figure1 = shapes.getFigure(0);
        Shape figure2 = shapes.getFigure(1);
        Shape figure3 = shapes.getFigure(2);
        //Then
        assertEquals(figure1, myCircle);
        assertEquals(figure2, mySquare);
        assertEquals(figure3, myTriangle);

    }

    @Test
    public void testShowFigures(){

        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape myCircle = new Circle(100);
        Shape mySquare = new Square(200);
        Shape myTriangle = new Triangle(300);
        shapes.addFigure(myCircle);
        shapes.addFigure(mySquare);
        shapes.addFigure(myTriangle);
        //When
        String result = shapes.toString();
        //Then
        assertEquals("[circle 100.0, square 200.0, triangle 300.0]", result);

    }

}
