import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Stack;

class Labyrynth
{

	/**
	*	TODO:
	*	1. На краях поля происходит что-то непонятное | sloved
	*	2. Волна не может распоространиться пока не закончится проход по одной из линий.
	*	3. Прямоугольное поле
	**/

	enum Direction {
		TOP, LEFT, RIGHT, BOTTOM
	}

	static class Start { public static int x, y; }
	static class Finish { public static int x, y; }

	static final int SIZE = 6;
	static int field[][] = new int[SIZE][SIZE];
	static Random r = new Random();
	static boolean way = false;
	static Stack<Direction> backtrace = new Stack<Direction>();

	private static int check(int x, int y) {
		return (x >= SIZE || y >= SIZE || x < 0 || y < 0 || field[x][y] == 3 || field[x][y] == 0) ? 100000000 : field[x][y];
	}

	private static int min(int x, int y) {
		int min = check(x-1,y);
		int t = check(x+1,y);
		min = (t < min ? t : min);
		t = check(x,y-1);
		min = (t < min ? t : min);
		t = check(x,y+1);
		min = (t < min ? t : min);
		return min;
	}

	private static boolean end(int x, int y) { // works
		return field[x][y] == 2;
	}

	private static boolean begin(int x, int y) {
		return field[x][y] == 1 || field[x][y] == 10;
	}

	private static boolean canStep(int x, int y, int counter) { // works
		return (x >= 0 && y >= 0 && x < SIZE && y < SIZE) && (field[x][y] == 0 || field[x][y] > counter || field[x][y] == 2);
	}

	private static boolean step(int x, int y, int counter) {
		try
		{
			if (end(x, y)) {
				way = true;
				return true; // переделать, просматриваются не все варианты путей до этой точки
			}
			field[x][y] = counter;
			counter++;
			//printField();
			if (canStep(x+1, y, counter)) step(x+1, y, counter);
			if (canStep(x, y+1, counter)) step(x, y+1, counter);
			if (canStep(x-1, y, counter)) step(x-1, y, counter);
			if (canStep(x, y-1, counter)) step(x, y-1, counter);
		}
		catch (Exception e)
		{
			cout(e + " x =  " + x + " y = " + y);
		}
		return false; // возвращается когда из точки больше некуда шагнуть (тупик)
	}

	private static void stepBack(int x, int y) {
		if (begin(x, y)) return;
		int min = min(x, y);
		if ((x-1 >= 0 && y >= 0 && x-1 < SIZE && y < SIZE) && field[x-1][y] == min) {
			backtrace.push(Direction.BOTTOM);
			stepBack(x-1,y);
		}
		if ((x+1 >= 0 && y >= 0 && x+1 < SIZE && y < SIZE) && field[x+1][y] == min) {
			backtrace.push(Direction.TOP);
			stepBack(x+1,y);
		}
		if ((x >= 0 && y-1 >= 0 && x < SIZE && y-1 < SIZE) && field[x][y-1] == min) {
			backtrace.push(Direction.RIGHT);
			stepBack(x,y-1);
		}
		if ((x >= 0 && y+1 >= 0 && x < SIZE && y+1 < SIZE) && field[x][y+1] == min) {
			backtrace.push(Direction.LEFT);
			stepBack(x,y+1);
		}
	}

	private static void generate() {
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				field[i][j] = r.nextInt(5) < 3 ? 0 : 3;
		Start.x = r.nextInt(SIZE);
		Start.y = r.nextInt(SIZE);
		Finish.x = r.nextInt(SIZE);
		Finish.y = r.nextInt(SIZE);
		field[Start.x][Start.y] = 1;
		field[Finish.x][Finish.y] = 2;
	}

	private static void printField() {
		cout("");
		for (int i = 0; i < SIZE; i++)
			cout(Arrays.toString(field[i]));
	}

	private static void cout(String arg) {
		System.out.println(arg);
	}

	public static void main(String[] args) {
		cout("Starting...");
		generate();
		printField();
		boolean flag = step(Start.x, Start.y, 10);
		cout("There is" + (way ? "" : " no") + " way from 1 to 2.");
		stepBack(Finish.x, Finish.y);
		cout(min(Finish.x, Finish.y) + "");
		cout(backtrace + "");
		printField();
	}
}
