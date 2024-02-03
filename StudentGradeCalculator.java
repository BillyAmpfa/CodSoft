import java.util.*;

public class StudentGradeCalculator
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//assume student has 7 subjects
		int[] marks = new int[7];
		
		System.out.println("\t\t\t\tStudent Mark Calculator\n\n");
		//1. getting input
		
		for(int i =0; i<marks.length; i++)
		{
			System.out.print("Enter marks for subject " + (i+1) + ": ");
			marks[i] = in.nextInt();
			//checking if correct input
			while(marks[i]>100 || marks[i]<0)
			{
				System.out.print("INVAILD INPUT!! MARK SHOULD BE BETWEEN 0 & 100 \nEnter marks for subject " + (i+1) + ": ");
				marks[i] = in.nextInt();
			}
		}
		
		//Call method to calculate Total Marks
		int totalMarks = calculateTotalMark(marks);
		
		//Call method to calculate Average Percentage
		double average = calculateAverage(totalMarks, marks.length);
		
		//call method to get grade
		String grade = getGrade(average);
		
		//5. Display Results
		System.out.println("\nTotal Marks:\t\t" + totalMarks +
							"\nAverage Percentage:\t" + Math.round(average) + 
							"%\nGrade:\t\t\t" + grade);
		
	}
	
	public static int calculateTotalMark(int[] marks)
	{
		int totalMarks = 0;
		//2. Calculate total mark
		for(int i=0; i<marks.length; i++)
		{
			totalMarks+= marks[i];
		}
		
		return totalMarks;
	}
	
	public static double calculateAverage(int totalMarks, int numberOfSubjects)
	{
		//3. calculate average
		double average = totalMarks/numberOfSubjects;
		
		return average;
	}
	
	public static String getGrade(double average)
	{
		String grade = "null";
		
		//4. Get grade
		if(average<50)
		{
			grade = "Fail";
		}
		else if(average<75)
		{
			grade= "Pass";
		}
		else if(average<=100)
		{
			grade = "Pass with Distinction";
		}
		
		return grade;
	}
}