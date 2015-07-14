/*
Created by:Ushanth Loganathan
	   v00810681
Credits:No credits
Program description:
    This program is a simple calculator that performs basic binary operations and 
    it outputs the results or it outputs an error message stating that its and invalid 
    expression.

*/
import java.util.*;
import java.lang.*;
public class Calc{
	public static void main(String [] args){
		LLStack<String> mystack=new LLStack<String>();
			int args_length=args.length;
			if(arguement_length(args_length)==true){//checks the length of the characters typed in 
				int number=0;                   //the command prompt
				int operator=0;
				for(int i=0;i<args.length;i++){
					String input=args[i];
					if(isInteger(input)==true){//if string is a number?
						number++;
					}
					else{
						operator++;
					}
				}
				if(operator+1!=number){//if operators is one greater than the numbers
					System.out.println("Invalid Expression");
					System.exit(-1);
				}
				try{
				for(int i=0;i<args.length;i++){
					String input=args[i];
					operator_performer(input,mystack);
				}
				int output=Integer.parseInt(mystack.pop());
				System.out.println(output);
				
				}
				catch(StackEmptyException e){
					System.out.println("Invalid Expression");
				}
				catch(NumberFormatException ex){
					System.out.println("Invalid Expression");
				}
		}
		else{
			System.exit(-1);
		}
	}
	//method to check whether the string is a number or actually a string
	//returns true if it is a number else returns false
	public static boolean isInteger(String string) {
		try {
			Integer.valueOf(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	//method to check if the number characters in the arguement(Typed in CLI) is even or odd)
	//if even return invalid expression
	//else return true
	public static boolean arguement_length(int args){
		if(args%2==0){
			System.out.println("Invalid Expression");
			return false;
		}
		else{
			return true;
		}
	}
	//this method performs the basic binay operations
	//does only one operation at a time
	//output is by the LLStack by poping out the last number
	public static void operator_performer(String input,LLStack<String> mystack){
		try{
		if(isInteger(input)==true){//check if it is an integer or not
			mystack.push(input);
		}
		else if(isInteger(input)==false){
			if(input.equals("+")||input.equals("x")||input.equals("/")||input.equals("-")){
				String val1=mystack.pop();
				String val2=mystack.pop();
				int num1=Integer.parseInt(val1);
				int num2=Integer.parseInt(val2);
				if(input.equals("+")){
					add(num1,num2,mystack);
				}else if(input.equals("-")){
					subtract(num1,num2,mystack);
				}
				else if(input.equals("x")){
					multiply(num1,num2,mystack);
				}
				else if(input.equals("/")){
					divide(num1,num2,mystack);
				}
				else{
					System.out.println("Invalid expression");
				}
			}
		}
		}
		catch(StackEmptyException e){
			System.out.println("Invalid Expression");
		}
		catch(NumberFormatException ex){
			System.out.println("Invalid Expression");
		}
	}
	//method created to add two operands and push it to stack
	public static void add(int num1,int num2,LLStack<String>mystack){
		int result=num1+num2;
		String output=Integer.toString(result);
		mystack.push(output);
	}
	//method created to subtract two operands and push it to stack
	public static void subtract(int num1,int num2,LLStack<String>mystack){
		int result=num2-num1;
		String output=Integer.toString(result);
		mystack.push(output);
	}
	//method created to multiply two operands and push it to stack
	public static void multiply(int num1,int num2,LLStack<String>mystack){
		int result=num1*num2;
		String output=Integer.toString(result);
		mystack.push(output);
	}
	//method created to divide two operands and push it to stack
	public static void divide(int num1,int num2,LLStack<String>mystack){
		int result=num2/num1;
		String output=Integer.toString(result);
		mystack.push(output);
	}
}
