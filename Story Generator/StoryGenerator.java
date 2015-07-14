/*
  ID: v00810681 Ushanth Loganathan
  Program name: Story Generator
  Program description: This is a story generator which inputs a file with words to be replaced. 
  The words input by the user will be replaced by the previous words and output into a new file called Newstory.txt
  Program input: words typed by the user
  Program output: output the words typed by the user into newstory file
*/
import java.util.*;
import java.io.*;
public class StoryGenerator{
	public static void main(String[] args){
		File file=Filecheck();
		textedit(file);
	}
	/*
	purpose: method created to check whether the user has input the correct file
	output: output the words typed by user into file named newstory.txt
	*/
	public static File Filecheck(){
	 	Scanner console = new Scanner(System.in); 
		System.out.print("Type a file name to use: ");
		String filename = console.nextLine();
		File file = new File(filename);
		while (!file.exists()) {//checks if the file exist or not
			System.out.print("File not found! Try again: ");
			filename = console.nextLine();
			file = new File(filename);
		}
		return file;
	}
	/*
	purpose: read the story.txt file replace the words within "<>".
	prompt user for new word
	output: prints the input word to a new file named Newstory.txt
	*/
	public static void textedit(File file){
	String fullstory="";
		Scanner console = new Scanner(System.in);
		try{
			Scanner input = new Scanner(file); // open the file
			PrintStream output = new PrintStream(new File("NewStory.txt"));
			while (input.hasNext()){//read the words in the file one by one
				String text=input.next();
				if(text.startsWith("<")){//if the string start with "<"
					while(!text.endsWith(">")){
						text = text+" "+input.next();
					}
						System.out.println("Please enter a:"+" "+text.substring(1,text.length()-1));
						text=console.nextLine();
				}
				fullstory+=text+" ";
			}
			fullstory=replacespace(fullstory);
			output.print(fullstory);
		}
		catch(java.io.FileNotFoundException ex){	
		}	
	}
	/*
	purpose:remove extra space before the fullstop and comma
	output: when there are extra space before a comma
	*/
	public static String replacespace(String fullstory){
	fullstory=fullstory.replaceAll(" \\.",".");
	fullstory=fullstory.replaceAll(" ,",",");
	return fullstory;
	}	
}
