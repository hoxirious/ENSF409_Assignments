

class Colour implements Cloneable
{
    private String colour;
    
    
	public Colour(String s) {
		colour = new String(s);
	}
	
    public void setColour(String newColour){
    	colour = newColour;
    }
    
	@Override
	public String toString(){
		return colour;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
