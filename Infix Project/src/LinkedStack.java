
public class LinkedStack<T> implements UnboundedStackInterface<T>
{
	protected String name;
	protected LLNode<T> top;
	protected int size;											//counts how many nodes are in the list
	
	public LinkedStack(String name)								//creates new stack
	{				
		top = null;												//starts it off empty
		this.name = name;										//sets the name
	}
	
	
	public void clear()											//clears the list
	{
		top = null;												//removes any reference to the nodes. They get picked up as garbage.
		size = 0;												//resets size counter
	}
	
	public String getName()										//returns list name
	{
		return name;
	}
	
	public String toString()									//returns a formatted numbered list
	{
		String logString = "Log: " + name + "\n\n";
		int count = 0;											//holds a count of nodes
		LLNode<T> node;										//used in traversing the list
		
		node = top;												//start at top of the list
		while (node != null)									//while there's a node
		{
			count++;											//increment count
			logString = logString + count + ". " + node.getInfo() +"\n";	//format so it reads #. info and create a new line
			node = node.getLink();								//move to next node
		}
		return logString;										//returns formatted list
	}

	@Override
	public void pop() throws StackUnderFlowException
	{
		if(!isEmpty())
		{
			top = top.getLink();
			size--;
		}
		else throw new StackUnderFlowException("Pop attempted on empty stack.");
		
	}

	@Override
	public T top() throws StackUnderFlowException
	{
		if(!isEmpty())
		{
			return top.getInfo();
		}
		else throw new StackUnderFlowException("Top attempted on empty stack.");
	}

	@Override
	public boolean isEmpty()
	{
		return (top == null);
	}

	@Override
	public void push(T element)
	{
		{
			LLNode<T> newNode = new LLNode<T>(element);		//makes new node with data 
			newNode.setLink(top);									//sets the link of the new node to the node at the top of the stack
			top = newNode;											//puts the node at the top of the stack
			size++;													//increments size counter
		}
		
	}
}
