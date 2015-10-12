
public class LLNode<T>
{
	
	 private T info;
	 private LLNode<T> link;
	  
  public LLNode(T info)
  {
	  this.info = info;
	  link = null;
  }
	 
  public void setInfo(T info)						 // sets info string of this node
  {
	  this.info = info;
  }

  public T getInfo()								// returns info string of this node

  {
	    return info;
  }

  public void setLink(LLNode link)				// sets link of this node
  {
	    this.link = link;
  }

  public LLNode getLink()							// returns link of this node.
  {
	    return link;
  }
}


