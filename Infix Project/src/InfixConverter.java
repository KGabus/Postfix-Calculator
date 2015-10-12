//Converts infix notation to postfix notation and solves
//Start Date 9/27/2015
//Due Date 10/12/2015
//Written by Kaylee Gabus

//import java.util.Scanner;


public class InfixConverter
{
	 static UnboundedStackInterface<String> stack = new LinkedStack<String>("stack");
	
	 //String infixExp = "";												//inputed infix expression
	 static String pfExp = "";													//resulting postfix expression			
	
/*	public static void main(String[] args)
	{
		System.out.println("Enter an infix expression: ");
		Scanner input = new Scanner(System.in);
		infixExp = input.nextLine();
		infixExp.replace(" ","");												//removes spaces
		infixExp += " ";
		convert();																//converts to postfix
		
		System.out.print(pfExp);
		input.close();
	}		//closes main  */
	
	public static void convert(String infixExp)
	{
		int i = 0;		
		String top;
		
		infixExp.replace(" ","");												//removes spaces
		infixExp += " ";														//adds a space at the end to prevent null pointer error	
		
		while (i < infixExp.length())											//while there are more tokens in expression
		{
			top = infixExp.charAt(i) + "";										//get the next token	
			if (isOperator(top)) {processOperator(top); i++;}					//if operator, process operator with method
			else if (top.equals("(")) {stack.push(top); i++;}					//if left paren, push on stack
			else if (top.equals(")")) {processRightParen();	i++;}				//if right paren, process with method
			else if (isDigit(top))											 	//if number, add to postFix expression with space 
			{
				int j = i+1;
				while (isDigit(infixExp.charAt(j) +"")) 
					{
						top += infixExp.charAt(j);
						i++; 
						j = i+1;
					}
				
				pfExp += top + " ";	
				i++;
				
			}
			else if (top.equalsIgnoreCase(" ")) {i++;}
			else System.out.println("Invalid input - " + top + " not reconized.");
		}
		
		if(!stack.isEmpty())														//if the stack still has something on it
			{
			pfExp += stack.top();													//add it to postfix expression
			stack.pop();																
			}
		
	}
	
	public static boolean isOperator(String top)
	{
		String operators = "+-x*/QC^<>%";		
		return (operators.indexOf(top) >= 0);
	}
	
	public static boolean isDigit(String top)
	{
		String digits = "0123456789";
		return (digits.indexOf(top) >= 1);
	}
	
	public static void processRightParen()
	{
		String operator = stack.top();
		while (!(operator.equals("(")))
		{
			pfExp += operator + " ";
			stack.pop();
			if (!stack.isEmpty()) operator = stack.top();
		}
		
		stack.pop();
	}
	
	public static void processOperator(String top)
	{
		if (!stack.isEmpty())
		{
			String operator = stack.top();
		
			while (!stack.isEmpty() && !(operator.equals("(")))
			{
				stack.pop();
				pfExp += operator+ " ";
				if (!stack.isEmpty()) operator = stack.top();
			}
		}
		stack.push(top);
	}
}
