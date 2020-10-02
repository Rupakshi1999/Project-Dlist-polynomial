import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Polynomial extends AbstractPolynomial {
   public Polynomial(String a) throws Exception {
      
    DList<Term> list = this.data;
    ArrayList<Term> array = new ArrayList<Term>();

     double coeff =1 ;
    int deg = 0;
    int sign = 1;

      a= a.replaceAll(" ", "");   //removes all the white space
      a= a.replaceAll(".0","");   //removes the decimal if it's not necessary
      int i = 0;
      
         while ( i<a.length())    //it will iterate through the entire polynomial string
     {
      //checks if the coefficient is negative and when the loop is at the new term of the function
      if (a.charAt(i)=='-') { 
        sign = -1; coeff=1; deg =0; i++; }
      else if (a.charAt(i)=='+'){ 
        sign = 1; coeff=1; deg=0; i++;    }
   
    boolean change = false;
    String coef = "";
    
    //finds and adds the coefficient of polynomial term to coeff variable
        while(i<a.length() && Character.isDigit(a.charAt(i)) )
         { 
         coef +=a.charAt(i);
        change = true;
         i++;}
         if (change) coeff=Double.parseDouble(coef);
         if (sign<0 && coeff >0){ 
         coeff *= sign;}
      
      //finds and add degree of the polynomial variable to the deg varaiable 
        if(i < a.length()-1 && Character.isLetter(a.charAt(i))){
           i++;
        if(a.charAt(i)=='^') {
          String d="";
          while (i < a.length()-1 && Character.isDigit(a.charAt(++i))){
            d+=a.charAt(i);
          }
            deg = Integer.parseInt(d);
        }
        else  deg = 1; 
            
        }
        else if (i ==a.length() -1 && Character.isLetter(a.charAt(i)))
           { deg =1; i++;}
        
       //Creates a few term object for each new coeff and degree 
        Term term = new Term(coeff,deg);
        array.add(term);  //adding terms to the arraylist
       
   }  
      merge(array);   //merging the elements with same dengrees
      Collections.sort(array,new MylistComp());  //sorting the array
      for (int z = 0; z < array.size(); z++) 
         list.addLast(array.get(z));
   }
   
   //Sorts the ArrayList by using compare method
   class MylistComp implements Comparator<Term>{
 
    @Override
    public int compare(Term e1, Term e2) {
      
        if(e1.getDegree() < e2.getDegree()){
            return 1;
        } else {
            return -1;
        }
    }
}

//finds if any element of the array has the same degree and merges them together
 public void merge(ArrayList<Term> arr){
    
    for (int i = 0; i < arr.size(); i++) 
      for (int j = 0; j < arr.size(); j++)
         if (arr.get(i).getDegree() ==arr.get(j).getDegree() && i!=j){
            arr.get(i).setCoefficient(arr.get(i).getCoefficient()+arr.get(j).getCoefficient());
            arr.remove(j);
            }
    }
   

   public Polynomial() {
      super();
   }

   public AbstractPolynomial add(AbstractPolynomial p) {
      AbstractPolynomial ans = new Polynomial();
      // complete this code
      return ans;
   }

   public AbstractPolynomial subtract(AbstractPolynomial p) {
      AbstractPolynomial ans = new Polynomial();
      // complete this code
      return ans;
   }

   public AbstractPolynomial multiply(AbstractPolynomial p) {
      AbstractPolynomial ans = new Polynomial();
      // complete this code
      return ans;
   }
   
   /**
    * MAIN FUNCTION
    **/
    
   public static void main(String args[]) throws Exception {
      //Variables
      Scanner scnr = new Scanner(System.in);
      AbstractPolynomial p, q;
      String testInput = "";
      //Custom test case
      if(scnr.hasNext()){
         testInput = scnr.nextLine();
         p = new Polynomial(testInput);
         testInput = scnr.nextLine();
         q = new Polynomial(testInput);
         System.out.println("User Input\n*****");
         Utility.run(p, q);
      }
      //Default test case
      else{
         p = new Polynomial(" X^5");
         q = new Polynomial("X^2 - X + 1");
         System.out.println("Default Input\n*****");
         Utility.run(p, q);
      }
   }
}
