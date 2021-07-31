
class Node <T>
{
	Integer keyM;
	T itemM;
	Node <T> nextM;
	
	public Node()
	{
		keyM = null;
		itemM=  null; 
		nextM  = null;
	
	}
	public Node (T itemA, Integer keyA, Node<T>  nextA)
	
	{
		itemM = itemA;
		keyM = keyA;
		nextM = nextA;
	}

}
