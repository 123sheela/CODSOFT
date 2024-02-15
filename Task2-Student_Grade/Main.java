import java.util.*;
class GradeCalculator
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("************************************************************");
        System.out.println("*---------------> STUDENT GRADE CALCULATOR <---------------*");
        System.out.println("************************************************************");
        // The number of sujects have to be entered.
        System.out.println("\n Enter the Number of Subjects: ");
        int subjects = sc.nextInt();
        System.out.println("---------------------------------------");
        int totalMarks = 0;
         
        // The subjects will be increased based on the number of subjects entered above.
        for(int i=1; i<= subjects; i++)
        {
            System.out.println("Enter the Mark obtained in Subject "+ i + ":");
            int marks = sc.nextInt();
            totalMarks += marks;
            System.out.println("---------------------------------------");
        }

        double avgPercentage = (double) totalMarks / subjects;
         
        char grade;

        if( avgPercentage >= 90)
        {
            grade = 'A';
        }
        else if( avgPercentage >=80 && avgPercentage <90)
        {
            grade = 'B';
        }
        else if( avgPercentage >=70 && avgPercentage <80)
        {
            grade = 'C';
        }
        else if ( avgPercentage >=60 && avgPercentage <70)
        {
            grade = 'D';
        }
        else 
        {
            grade = 'F';
        }
        System.out.println("Total Marks: "+ totalMarks);
        System.out.printf("\nAverage Percentage: %.2f%%\n", avgPercentage);
        System.out.println("_____________________");
        System.out.println("\n      Grade: "+ grade );
        System.out.println("_____________________");

        sc.close();
    }
}