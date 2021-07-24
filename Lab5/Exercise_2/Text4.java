
class Text implements Resizable
{
	
	private final Double DEFAULT_SIZE = 10.0;
	
    private Colour colour;
    private Double fontSize;
    
    private String text;


	public Text(String text) {
       this.text = text;
       fontSize = DEFAULT_SIZE;
	}
	
	public Double getFontSize(){
		return fontSize;
	}
	
	public void setColour(String s){
		colour = new Colour(s);
	}
	
	public void setText(String newText){
		text = newText;
	}
	
	public String getText(){
		return text ;
	}
	
	@Override
	public String toString(){
		return (text);
	}

	@Override
	public void shrink(Double divisor) throws SizeFactorException {
		// TODO Auto-generated method stub
		if (divisor < LIMIT) {
			throw new SizeFactorException();
		}
		fontSize = fontSize/divisor;
	}

	@Override
	public void enlarge(Double multiplier) throws SizeFactorException {
		// TODO Auto-generated method stub
		if (multiplier < LIMIT) {
			throw new SizeFactorException();
		}
		fontSize = fontSize*multiplier;
	}

       
}
