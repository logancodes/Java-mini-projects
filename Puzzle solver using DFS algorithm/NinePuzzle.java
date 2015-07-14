/* NinePuzzle.java
   CSC 225 - Summer 2014
   Assignment 5 - Template for the 9-puzzle
   
   This template includes some testing code to help verify the implementation.
   Input boards can be provided with standard input or read from a file.
   
   To provide test inputs with standard input, run the program with
	java NinePuzzle
   To terminate the input, use Ctrl-D (which signals EOF).
   
   To read test inputs from a file (e.g. boards.txt), run the program with
    java NinePuzzle boards.txt
	
   The input format for both input methods is the same. Input consists
   of a series of 9-puzzle boards, with the '0' character representing the 
   empty square. For example, a sample board with the middle square empty is
   
    1 2 3
    4 0 5
    6 7 8
   
   And a solved board is
   
    1 2 3
    4 5 6
    7 8 0
   
   An input file can contain an unlimited number of boards; each will be 
   processed separately.
  
   B. Bird - 07/11/2014
*/

import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;
import java.util.*;

public class NinePuzzle{

	//The total number of possible boards is 9! = 1*2*3*4*5*6*7*8*9 = 362880
	public static final int NUM_BOARDS = 362880;


	/*  SolveNinePuzzle(B)
		Given a valid 9-puzzle board (with the empty space represented by the 
		value 0),return true if the board is solvable and false otherwise. 
		If the board is solvable, a sequence of moves which solves the board
		will be printed, using the printBoard function below.
	*/
	public static boolean SolveNinePuzzle(int[][] B){
		/* ... Your code here ... */
		//construct the goal state board to get its index from get index from board function
		int goalstate[][]=new int[3][3];
		goalstate[0][0]=1;
		goalstate[0][1]=2;
		goalstate[0][2]=3;
		goalstate[1][0]=4;
		goalstate[1][1]=5;
		goalstate[1][2]=6;
		goalstate[2][0]=7;
		goalstate[2][1]=8;
		goalstate[2][2]=0;
		
		int goalstate_index=getIndexFromBoard(goalstate);//get index of goal state board vertex u
		int B_index=getIndexFromBoard(B);///get index of the given board-vertex v
		
		//all the different types of boards as indexes are stored in the arraylist called array with is 9!*4 dimension
		
		//initialising all idexes of the board with negative 1
		//this is because when there is an invalid move for the board that particular slot for the adjacency list (array) would be stayed as -1
		int [][] array=new int [362880][4];
		for(int i=0;i<NUM_BOARDS;i++){
			for(int j=0;j<4;j++){
				array[i][j]=-1;
			}
		}
		for(int i=0;i<NUM_BOARDS;i++){
				int[][] myboard=getBoardFromIndex(i);//for each indexes in the list you try to get the 
				int row=get_Row(myboard);	     //the board
				int col=get_Col(myboard);
				//check for different possible moves it can make...if theres no possible move the slot would remain unchanged with -1
				//get the index from the board and put it back to array list for each possible moves
				if(row>0){
					swap(myboard,row,col,row-1,col);
					int my_index=getIndexFromBoard(myboard);
					array[i][0]=my_index;
				}
				if(row<2){
					swap(myboard,row,col,row+1,col);
					int my_index=getIndexFromBoard(myboard);
					array[i][1]=my_index;
				}
				if(col>0){
					swap(myboard,row,col,row,col-1);
					int my_index=getIndexFromBoard(myboard);
					array[i][2]=my_index;
				}
				if(col<2){
					swap(myboard,row,col,row,col+1);
					int my_index=getIndexFromBoard(myboard);
					array[i][3]=my_index;
				}
		}
		//stack created to keep track of the path visited
		Stack<Integer> myStack = new Stack<Integer>();
		minlength(array,goalstate_index,B_index,myStack);
		try {
			int sizeOfStack=myStack.size();
			for(int i=1;i<=sizeOfStack;i++){
			int path=(Integer)myStack.peek(); //get the different indexes accordingly to dtermine the different boards when solving the board
			int [][]path_board=getBoardFromIndex(path);
			printBoard(path_board);//print each board at different indexes showing how the board is solvable
			myStack.pop();
			}
			return true;
					
		} catch (EmptyStackException e) {
			return false;
		}
	}
	//method to swap a row or a column
	 public static void swap(int[][] a, int row1, int col1, int row2, int col2 ) {
	 	 int temp = a[row1][col1];
	 	 a[row1][col1] = a[row2][col2];
	 	 a[row2][col2] = temp;
	 }
	 //method to get the column index of zero 
	public static int get_Col(int a[][]){
		int col=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(a[i][j]==0){
					col=j;
				}
			}
		}
		return col;
	}
	//method to get the row index of zero 
	public static int get_Row(int a[][]){
		int row=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(a[i][j]==0){
					row=i;
				}
			}
		}
		return row;
	}
	//method to find the shortest path to reach v from u
	//it uses BFS
	//this method's psedocode is being extracted from lab notes algorithm 23 page 88
	public static void minlength(int [][]array,int u,int v,Stack <Integer> myStack){
		boolean []covered=new boolean[362880];
		int [] P = new int [362880];
		for(int i=0;i<NUM_BOARDS;i++){
			P[i]=array[i][0];
		}
		P[u]=-1;
		Queue<Integer> Q= new LinkedList<Integer>();
		Q.add(u);
		while(!Q.isEmpty()){
			int current=Q.element();
			Q.remove();
			for(int w=0;w<current;w++){
				if(covered[w]==true){
					continue;
				}
				P[w]=current;
				Q.add(w);
			}
		}
		//Stack myStack = new Stack();
		int current=v;
		myStack.push(v);
		while(P[current]!=-1){
			current=P[current];
			myStack.push(current);
		}
	}
	
	/*  printBoard(B)
		Print the given 9-puzzle board. The SolveNinePuzzle method above should
		use this method when printing the sequence of moves which solves the input
		board. If any other method is used (e.g. printing the board manually), the
		submission may lose marks.
	*/
	public static void printBoard(int[][] B){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++)
				System.out.printf("%d ",B[i][j]);
			System.out.println();
		}
		System.out.println();
	}
	
	
	/* Board/Index conversion functions
	   These should be treated as black boxes (i.e. don't modify them, don't worry about
	   understanding them). The conversion scheme used here is adapted from
		 W. Myrvold and F. Ruskey, Ranking and Unranking Permutations in Linear Time,
		 Information Processing Letters, 79 (2001) 281-284. 
	*/
	public static int getIndexFromBoard(int[][] B){
		int i,j,tmp,s,n;
		int[] P = new int[9];
		int[] PI = new int[9];
		for (i = 0; i < 9; i++){
			P[i] = B[i/3][i%3];
			PI[P[i]] = i;
		}
		int id = 0;
		int multiplier = 1;
		for(n = 9; n > 1; n--){
			s = P[n-1];
			P[n-1] = P[PI[n-1]];
			P[PI[n-1]] = s;
			
			tmp = PI[s];
			PI[s] = PI[n-1];
			PI[n-1] = tmp;
			id += multiplier*s;
			multiplier *= n;
		}
		return id;
	}
		
	public static int[][] getBoardFromIndex(int id){
		int[] P = new int[9];
		int i,n,tmp;
		for (i = 0; i < 9; i++)
			P[i] = i;
		for (n = 9; n > 0; n--){
			tmp = P[n-1];
			P[n-1] = P[id%n];
			P[id%n] = tmp;
			id /= n;
		}
		int[][] B = new int[3][3];
		for(i = 0; i < 9; i++)
			B[i/3][i%3] = P[i];
		return B;
	}
	

	public static void main(String[] args){
		/* Code to test your implementation */
		/* You may modify this, but nothing in this function will be marked */

		
		Scanner s;

		if (args.length > 0){
			//If a file argument was provided on the command line, read from the file
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			//Otherwise, read from standard input
			s = new Scanner(System.in);
			System.out.printf("Reading input values from stdin.\n");
		}
		
		int graphNum = 0;
		double totalTimeSeconds = 0;
		
		//Read boards until EOF is encountered (or an error occurs)
		while(true){
			graphNum++;
			if(graphNum != 1 && !s.hasNextInt())
				break;
			System.out.printf("Reading board %d\n",graphNum);
			int[][] B = new int[3][3];
			int valuesRead = 0;
			for (int i = 0; i < 3 && s.hasNextInt(); i++){
				for (int j = 0; j < 3 && s.hasNextInt(); j++){
					B[i][j] = s.nextInt();
					valuesRead++;
				}
			}
			if (valuesRead < 9){
				System.out.printf("Board %d contains too few values.\n",graphNum);
				break;
			}
			System.out.printf("Attempting to solve board %d...\n",graphNum);
			long startTime = System.currentTimeMillis();
			boolean isSolvable = SolveNinePuzzle(B);
			long endTime = System.currentTimeMillis();
			totalTimeSeconds += (endTime-startTime)/1000.0;
			
			if (isSolvable)
				System.out.printf("Board %d: Solvable.\n",graphNum);
			else
				System.out.printf("Board %d: Not solvable.\n",graphNum);
		}
		graphNum--;
		System.out.printf("Processed %d board%s.\n Average Time (seconds): %.2f\n",graphNum,(graphNum != 1)?"s":"",(graphNum>1)?totalTimeSeconds/graphNum:0);

	}

}
