
class LinkedList <T>  {
	
	private int sizeM;
    private Node<T> headM;
    private Node<T> cursorM;
			
    
    public LinkedList()
	{
		sizeM = 0;
		headM = null;
		cursorM = null;
	}

	public int size() 
	{
	  return sizeM;
	}

	public boolean cursor_ok()    
	{
	  return cursorM != null;
	}

	public Integer  cursor_key()    
	{
	  assert(cursor_ok());
	  return cursorM.keyM;
	}

	public T cursor()   
	{
	  assert(cursor_ok());
	  return cursorM.itemM; 
	}

    public void push_back(Integer keyA, T itemA){
	  Node <T> new_node = new Node<T> (itemA, keyA, null );
	  if(headM == null)
		  headM = new_node;
	  else {
	      cursorM = headM.nextM;
	      Node<T> p = headM;
	      while (cursorM != null){
		    cursorM = cursorM.nextM;
		    p = p.nextM;
	      }
	      p.nextM = new_node;
       }  
	   sizeM++;
     }
    
    
	public void insert (Integer keyA, T datumA)
	{
	  if (headM == null || keyA.compareTo(headM.keyM) < 0) 
	  {
		Node<T> new_node = new Node<T> (datumA,keyA, null);
	    headM = new_node;
	    sizeM++;
	  }
	  else if (keyA.compareTo(headM.keyM) == 0) {
	    headM.itemM = datumA;
	  }
		
		
	  else {
	    Node <T> before= headM;
	    Node <T> after=headM.nextM;
			
	    while(after!= null && (keyA.compareTo(after.keyM)) > 0)
			{
				before=after;
				after=after.nextM;
			}
	    
			if(after!= null && keyA.compareTo(after.keyM) ==0)
			{
				after.itemM=datumA;
			}
			else
			{
				Node <T> new_node = new Node<T>(datumA, keyA, null);
				before.nextM = new_node;
				sizeM++;
			}
	  }
	}



	void   remove(Integer keyA )
	{
		
	  if (headM == null || keyA.compareTo(headM.keyM) < 0)
	    return;
	  Node <T> doomed_node = null;

	  if (keyA.compareTo(headM.keyM) == 0) {
	    doomed_node = headM;
	    headM = headM.nextM;
	    doomed_node.nextM = null;
	    sizeM--;
	  }
	  else {
	    Node <T> before = headM;
	    Node <T> maybe_doomed = headM.nextM;
	    while(maybe_doomed != null && keyA.compareTo(maybe_doomed.keyM) >0 ) {
	      before = maybe_doomed;
	      maybe_doomed = maybe_doomed.nextM;
	    }
			
	    if (maybe_doomed != null && (maybe_doomed.keyM.compareTo(keyA)== 0)) {
	     // doomed_node = maybe_doomed;
	      before. nextM = maybe_doomed.nextM;
	      maybe_doomed = null;
	      sizeM--;
	    }      
	  } 
	  cursorM = null;
	  doomed_node = null;  // Does nothing if doomed_node == 0.
	  
		
	}


	void   find(Integer keyA )
	{
	  Node <T> ptr=headM;
	  while (ptr!= null && (ptr.keyM.compareTo(keyA) >0 || ptr.keyM.compareTo(keyA) < 0))
		{
			ptr=ptr.nextM;
			
		}
		
		cursorM = ptr;
		
	}

	void   go_to_first()
	{
	  cursorM = headM;
	}

	void   step_fwd()
	{
	  assert(cursor_ok());
	  cursorM = cursorM .  nextM;
	}

	void   make_empty()
	{
      headM = null;
	  sizeM = 0;
	  cursorM = null;
	}

	public void print()
	{ 
	  cursorM = headM;
	  while (cursorM != null){ 
		  System.out.println("Key: " + cursorM.keyM + " || " + cursorM.itemM );
		  cursorM = cursorM.nextM;
	  }
	}
	
	public String toString()
	{
		String s;
		 if (cursor_ok())
			    s = "Key: " + cursor_key() + " || " + cursor();
			  else
			    s = "Not Found.";
		 return s;
	}

}
