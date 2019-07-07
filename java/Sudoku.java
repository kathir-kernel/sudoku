import java.util.*;

class Box {

    public static int count = 0;

    private int value = 0;
    private final boolean original;
    private List<Integer> possibilities = new LinkedList<>();

    public Box(int value) {
	this.value = value;

	if (value == 0) {
	    original = false;
	    for (int i = 1; i < 10; i++) {
		possibilities.add(i);
	    }
	} else {
	    count++;
	    original = true;
	}
    }

    public int resolve() {
	if (possibilities.size() == 1) {
	    this.value = possibilities.get(0);
	    count++;
	    System.out.println("WWWOWWWWOWOWWW " + this.value);
	    System.out.println("origin " + this.original);
	    possibilities.clear();
	    return this.value;
	}
	return 0;
    }

    public void removePossibiliy(int i) {
	possibilities.remove((Object)i);
    }

    public int getValue() {
	return this.value;
    }
}

class Container {
	
    Box[][] boxes = new Box[9][9];
	
    public Container(int[][] input) {
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		boxes[i][j] = new Box(input[i][j]);
	    }
	}
    }

    public void initialResolve() {
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		if (boxes[i][j].getValue() != 0)
		    refreshPossibilities(i, j, boxes[i][j].getValue());
	    }
	}
    }

    public void resolve() {
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		int value = boxes[i][j].resolve();
		if (value != 0) {
		    System.out.println("i = " + i + " , j = " + j + " value = " + value);
		    refreshPossibilities(i, j, value);
		}
	    }
	}
    }
	
    public void refreshPossibilities(int i, int j, int value) {
	refreshRow(i, value);
	refreshColumn(j, value);
	refreshSquare(i, j, value);
    }
    public void refreshRow(final int row, final int value) {
	for (int j = 0; j < 9; j++) {
	    boxes[row][j].removePossibiliy(value);
	}
    }
    public void refreshColumn(final int column, final int value) {
	for (int i = 0; i < 9; i++) {
	    boxes[i][column].removePossibiliy(value);
	}
    }
    public void refreshSquare(final int i, final int j, final int value) {
	// TODO
    }

    public void printAsSudoku() {
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		System.out.print(boxes[i][j].getValue() + ",");
	    }
	    System.out.println();
	}
    }
}


public class Sudoku {
	
    public static void printAsSudoku(int[][] input) {
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		System.out.print(input[i][j] + ",");
	    }
	    System.out.println();
	}
    }
	
    public static int[][] convertToInt(String input) {
	String[] str = input.split(",");
	if (str.length != 81) {
	    throw new IllegalArgumentException("Input number of elements: excpected 81, Given " + str.length);
	}
		
	int[][] inputArray = new int[9][9];
		
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		inputArray[i][j] = Integer.parseInt(str[(i * 9) + j]);
	    }
	}
		

	return inputArray;
    }
	
    public static void main(String ... args) {
	String input =
	    "5,3,0,0,7,0,0,0,0," +
	    "6,0,0,1,9,5,3,4,8," +
	    "0,9,8,0,0,0,0,6,0," +
	    "8,0,0,0,6,0,0,0,3," +
	    "4,0,0,8,0,3,0,0,1," +
	    "7,0,0,0,2,0,0,0,6," +
	    "0,6,0,0,0,0,2,8,0," +
	    "0,0,0,4,1,9,0,0,5," +
	    "0,0,0,0,8,0,0,7,9";

	int[][] inputArray = convertToInt(input);
	printAsSudoku(inputArray);
	Container container = new Container(inputArray);
	container.initialResolve();
	container.resolve();

	// while(Box.count < 35) {
	//     container.resolve();
	//     container.initialResolve();
	// }
	container.printAsSudoku();
	System.out.println("Box count " + Box.count);
    }
}
