import java.util.Scanner;
public class PostFixConsole
{
	static String line;
	static String again;
	static long result;
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		do
		{
			System.out.println("Enter an infix expression to evaluate: ");
			line = input.nextLine();
			
			try 
			{
				InfixConverter.convert(line);
				result = PostFixEvaluator.evaluate(line);
				System.out.println();
				System.out.println("Result: " + line + " = " + result);
				
			}		//closes try
			
			catch (PostFixException error)
			{
				System.out.println();
				System.out.println("Error in expression - " + error.getMessage());
			}
			
			
			System.out.println();
			System.out.print("Evaluate another expression? (Y = yes): ");
			again = input.nextLine();
			System.out.println();
		}		//closes do
		
		while (again.equalsIgnoreCase("y"));
		
		System.out.println("Program Complete");
		
	}		//closes main
	

}		//closes class
