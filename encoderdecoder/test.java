/*
V00810681
 Program name: Story Generator
 Program description: this is a cryptography program which takes in an input file, encrypt it it to a new file acoording to user entered 
 key and decode it and find the key using crack method
 Program output: output the encrypted file
                 output the decrpyt file
                 output key
*/
import java.util.*;
import java.io.*;
public class test{
	public static void main(String [] args){//this main method uses command argument and call each method

		String operation=args[0];
		String infilename=args[1];
		File input= new File (infilename);
		String outfilename=args[2];
		if(input.exists()){
			Scanner afterinput=null;
			try{
				afterinput=new Scanner(input);
				if(operation.equals("encode")) {
					int numbkey=Integer.parseInt(args[3]);
					encoding(afterinput,numbkey,outfilename);
				}
				else if(operation.equals("decode")) {
					int numbkey=Integer.parseInt(args[3]);
					decoding(afterinput,numbkey, outfilename);
				}
				else if(operation.equals("crack")){
					crack(afterinput,outfilename);
				}
			}
			catch(java.io.FileNotFoundException ex) {
			System.out.println("Your Input File Does NOT EXISTS");
			}
		}
	}
	/*
	purpose: this method encode the file by swifting the letters according to user key
	output: output the encrypt file
	*/
	public static int encoding(Scanner inputfile,int key,String newfilename1){
		try{
		
		PrintStream output= new PrintStream(new File(newfilename1));
		//Scanner input= new Scanner(new File(inputfile));
		while(inputfile.hasNextLine()){
			String line=inputfile.nextLine();
			char [] letters = line.toCharArray();
				for (int i=0; i< letters.length;i++){
					char new_letter;
					char letter = line.charAt(i);
					int ascii=(int)letter;
					if(ascii!=32){//when its not equal to the numerical value of space
						ascii-=97;//subtract the numerical val of a
						ascii+=key;
						ascii=ascii%26;
						new_letter = ((char) (ascii+97));
					}
					else{
						new_letter=' ';
					}
					output.print(new_letter);//output to file
					
					}
				}
				
			}
			catch(java.io.FileNotFoundException ex){	
			}
			return 0;
	}
	/*
	purpose: method created to decode the file by swifting back to original characters
	output: output a new file with new name acoording to user. this file contains original charcaters of the inputfile that was encrypted
	*/
	public static int decoding(Scanner decodingfile,int key, String newfilename2){
		try{
		PrintStream output= new PrintStream(new File(newfilename2));
		while(decodingfile.hasNextLine()){
			String line=decodingfile.nextLine();
			char [] letters = line.toCharArray();
				for (int i=0; i< letters.length;i++){
					char new_letter;
					char letter = line.charAt(i);
					int ascii=(int)letter;
					if(ascii!=32){
						ascii-=97;
						ascii-=key;
						if (ascii>=0){
							ascii=ascii%26;
						}
						else{
						ascii=ascii+26;
						}
						new_letter = ((char) (ascii+97));
					}
					else{
						new_letter=' ';
					}
					output.print(new_letter);
					
					}
				}
				
			}
			catch(java.io.FileNotFoundException ex){	
			}
			return 0;	
	}/*
	purpose: method created to crack the file and display the key and output a new file i.e the original file
	output: output cracked new file i.e the original file
	*/
	public static int crack(Scanner crackingfile,String newfilename3)throws FileNotFoundException{
		int key=0;
		//try{
		//PrintStream output= new PrintStream(new File(newfilename3));
		int [] b= new int[26];
			String line=crackingfile.nextLine();
			char [] letters = line.toCharArray();
			for(int i=0; i<letters.length;i++){
				if (letters[i]!=' '){
					b[letters[i]-'a']++;
				}
			}
			int max=b[0];
			int maxIndex=0; 
			char maxalphabet= (char) max;
			for(int i=1; i<b.length-1;i++){
				if(b[i+1]>max){
					max=b[i+1];
					maxIndex=i+1;
				}
			}
			key=maxIndex-4;
			if(key<0){
				key+=26;
			}
	
			System.out.println("The key is "+key);//outputs the key value
			decoding(crackingfile,key,newfilename3); 
		//}
		//catch(java.io.FileNotFoundException ex){
		//}
		

		return 0;
	}
}
