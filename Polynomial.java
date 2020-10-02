import java.util.*;
public class Polynomial extends AbstractPolynomial {
   public Polynomial(String s) {
      // complete this code
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
   
   /****************
    * MAIN FUNCTION
    ****************/
    
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
         System.out.println("User Input\n***************************");
         Utility.run(p, q);
      }
      //Default test case
      else{
         p = new Polynomial(" X^5");
         q = new Polynomial("X^2 - X + 1");
         System.out.println("Default Input\n***************************");
         Utility.run(p, q);
      }
   }
}