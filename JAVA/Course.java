/** A course object to be used in GPA calculation. */
public class Course {
   
   private String name;
   
   private char designation;
   
   private double credits;
   
   private String grade;
   
   private double points;
   
   public Course(String nm, char dsg, String grd, double crd) {
      this.name = nm;
      this.designation = dsg;
      this.credits = crd;
      this.grade = grd;
      this.points = convert(this.grade) * this.credits;
   }
   
   public Course(String grd, double crd) {
      this.credits = crd;
      this.grade = grd;
      this.points = convert(this.grade) * this.credits;
   }
   
   public String getGrade() {
      return this.grade;
   }
   
   public double getPoints() {
      return this.points;
   }
   
   public double getCredits() {
      return this.credits;
   }
   
   public void setGrade(String grd) {
      this.grade = grd;
   }
   
   public void setName(String nm) {
      this.name = nm;
   }
   
   public void setDesig(char dsg) {
      this.designation = dsg;
   }
   
   /**
   *  Converts a letter grade to a point value.
      @param letter is the grade input
      @return point value
   */
   private static double convert(String letter) {
   
      String gradeGot = letter;
      double points = 0;   
      gradeGot = gradeGot.toUpperCase();
      char grade = gradeGot.charAt(0);
      //System.out.println(grade);
      
      switch (grade) {
         case 'A': points = 4;
            break;
         case 'B': points = 3;
            break;
         case 'C': points = 2;
            break;
         case 'D': points = 1;
            break;
         case 'F': points = 0;
            break;
         default: points = 0;
            break;
         
      }
      if ((gradeGot.indexOf("+") != -1) && gradeGot.indexOf("A") == -1 && gradeGot.indexOf("F") == -1) {
      
         points += 0.3;
      
      }
      
      if ((gradeGot.indexOf("-") != -1) && gradeGot.indexOf("D") == -1 && gradeGot.indexOf("F") == -1) {
      
         points -= 0.3;
      
      }
      
      return points;
   
   }
   
   public String toString() {
      return this.grade + " " + this.credits;
   }
}