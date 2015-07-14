//import java.util.*;
public class Test {

   public static void main(String args[]) {
   	   char s='c';
      System.out.println(digit(s));
      System.out.println(Character.isDigit('5'));
   }
   public static boolean digit(char x){
   	   if(Character.isDigit(x)==true)
   	   	   return true;
   	   else
   	   	   return false;
   	   
   }
}
