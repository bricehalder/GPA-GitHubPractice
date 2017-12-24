import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/** GPA Calculator.
*
*/

public class GPA {

   static double pointSum = 0;
   static double creditSum = 0;
   static double GPA;
   static int courseCount;

   /**
      Main method to start execution.
      @param args not used
   */

   public static void main(String[] args) {
   
      Scanner in = new Scanner(System.in);
      
      System.out.println("Welcome to the GPA Calculator!\nBy: Brice Halder\n");
      
      System.out.println("Do you know how many courses you are taking? (YES or NO)" + 
         "\n(Course-by-course input vs. free input)");
      
      String answer = in.next();
      
      if(Character.toString(answer.charAt(0)).equalsIgnoreCase("Y")) {
         System.out.println("\nHow many graded courses are you taking?");
      
         courseCount = in.nextInt();
         
         Course[] courses = new Course[courseCount];
         
         System.out.println("\nEnter grades and credits for each course: " +
            "\nExample input: \nA- 3\nC+ 4\nA 3\n");
      
         for (int i = 0; i < courses.length; i++) {
         
            System.out.print("course " + (i + 1) + " of " + courseCount + ": ");
         
            courses[i] = new Course(in.next(), in.nextDouble());
         
         //System.out.println(courses[i]);
         
            pointSum += courses[i].getPoints();
         
         // System.out.println(courses[i].getPoints());
         
            creditSum += courses[i].getCredits();
         
            GPA = calculateGPA(pointSum, creditSum);
         
            printCurrentStats(creditSum, GPA);
         
         }
      
      } else if (Character.toString(answer.charAt(0)).equalsIgnoreCase("N")) {
      
         List<Course> courseList = new ArrayList<Course>(6);
         
         courseCount = 0;
         
         System.out.println("\nEnter grades and credits for each course, QUIT to end: " +
            "\nExample input: \nA- 3\nC+ 4\nA 3\nQUIT\n");
         
         
         System.out.print("course " + (courseCount + 1) + ": ");
         
         String grade = in.next();
         double credits;
         
         while (!grade.equalsIgnoreCase("QUIT")) {
         
            credits = in.nextDouble();
            
            courseList.add(new Course(grade, credits));
            
            pointSum += courseList.get(courseList.size() - 1).getPoints();
            creditSum += courseList.get(courseList.size() - 1).getCredits();
            
            GPA = calculateGPA(pointSum, creditSum);
            
            printCurrentStats(creditSum, GPA);
            
            courseCount++;
            
            System.out.print("course " + (courseCount + 1) + ": ");
            
            grade = in.next();
            
         }
            
      }
            
      System.out.printf("\nYour GPA is %.2f%n", calculateGPA(pointSum, creditSum));
      if (pointSum / creditSum >= 3.5) {
         System.out.println("Dean's List\n");
      }
      if (pointSum / creditSum <= 2.0) {
         System.out.println("Uh-oh, Academic Probation\n");
      }
      
   }
      
   /** Calculates GPA.
      @param pointSum the points
      @param creditSum the credits
      @return the GPA
   */
   public static double calculateGPA(double pointSum, double creditSum) {
      return pointSum / creditSum;
   }
   
   /** Prints credits and GPA.
      @param creditSum the current credits
      @param GPA the current GPA
    */
   public static void printCurrentStats(double creditSum, double GPA) {
      System.out.printf("\ntotal credits: %.2f\n", creditSum);
      System.out.printf("current GPA: %.2f\n\n", GPA);
   }
}  

