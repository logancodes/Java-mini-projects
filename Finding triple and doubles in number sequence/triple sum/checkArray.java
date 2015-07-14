import java.util.*;
import java.io.*;

public class checkArray{
	public static void main(String [] args)throws FileNotFoundException{
		Scanner s=new Scanner(new File("HasTriple_1000b.txt"));
		Vector<Integer> inputVector = new Vector<Integer>();

		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);

		int[] array = new int[inputVector.size()];

		for (int i = 0; i < array.length; i++){
			array[i] = inputVector.get(i);
		}
		
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		Arrays.sort(array);
		System.out.println();
		System.out.println();
		System.out.println();
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		
		///////////////////////////////////
		int []a=new int[225];
		int min=array[0];
		for(int i=0;i<225;i++){
			for(int j=0;j<a.length;j++){
				if(
			}
			
		}
		
		/* ... Your code here ... */
		/*
		int [] a=new int[225];
		int min=array[0];
		int count=0;
		int temp=0;
		
		for(int i=0;i<225;i++){
			while(count<array.length){
				if(array[i]<=min&&array[i]<=225){
					temp=count;
					min=array[temp];
				}
				count++;
			}
			a[i]=min;
			count=0;
			temp=0;
		}
		for(int i=0;i<225;i++){
			System.out.println(a[i]);
		}*/
		
	}
}
