import java.util.Scanner;
public class PostFixEvaluator
{
	static long value;
	static long operand1;
	static long operand2;
	static long result;
	static String operator;
	//String expression;
	
	static UnboundedStackInterface<Long> stack = new LinkedStack<Long>("stack");

	

	public static long evaluate(String pfExp)
	{
		Scanner tokenizer = new Scanner(pfExp);
		
		while (tokenizer.hasNext())
		{
			if (tokenizer.hasNextLong())
			{
				value = tokenizer.nextLong();
				stack.push(value);
			}
			else 
			{
				operator = tokenizer.next();
				
				if (stack.isEmpty()) throw new PostFixException("Not enough operands - stack underflow");
				
				operand2 = stack.top();
				stack.pop();
				
				if (stack.isEmpty()) throw new PostFixException("Not enough operands - stack underflow");
				
				operand1 = stack.top();
				stack.pop();
				
				switch (operator)
				{
				case "+": result = operand1 + operand2; break;				
				case "-": result = operand1 - operand2; break;
				case "*": result = operand1 * operand2; break;
				case "x": result = operand1 * operand2; break;
				case "/": result = operand1 / operand2; break;
				case "^": result = (long) Math.pow(operand1,operand2); break;
				case "Q": result = (long) Math.sqrt(operand1); break;
				case "C": result = (long) Math.cbrt(operand1); break;
				case "<": result = operand1 << operand2; break;
				case ">": result = operand1 >>> operand2; break;
				case "%": result = operand1 % operand2; break;
				}
				
				stack.push(result);
				
			}
		}
		
		if (stack.isEmpty()) throw new PostFixException("Not enough operands");
		result = stack.top();
		stack.pop(); 																		//stack should be empty
		
		if (!stack.isEmpty()) throw new PostFixException("Too many operands");
		//tokenizer.close();
		return result;	
	}
	

}
