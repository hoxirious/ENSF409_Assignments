

class Rectangle extends Shape implements Resizable
{
	protected Double width, length;
	
	public Rectangle(Double x_origin, Double y_origin, Double newlength, Double newwidth, String  name, Colour colour){
		super(x_origin, y_origin, name, colour);
		length= newlength;
		width =newwidth;
	}
	
	protected void  set_length(Double newlength){
		length = newlength;
	}
	
	protected Double  get_length() {
		return length;
	}
	
	protected Double  area(){
		return  width *length;
	}
	
	protected Double  perimeter(){
		return  width  * 2 + length * 2;
	}
	
	protected Double  volume(){
		return 0.0;
	}
	
	@Override
	public String toString(){
		String s = super.toString()+ "\nWidth: " + width + "\nLength: " + length;
		return s;
	}

	@Override
	public void shrink(Double divisor) throws SizeFactorException {
		// TODO Auto-generated method stub
		if (divisor < LIMIT) {
			throw new SizeFactorException();
		}
		this.length = this.length / divisor;
		this.width = this.width / divisor;
	}

	@Override
	public void enlarge(Double multiplier) throws SizeFactorException{
		// TODO Auto-generated method stub
		if (multiplier < LIMIT) {
			throw new SizeFactorException();
		}
		this.length = this.length * multiplier;
		this.width = this.width * multiplier;
	}
        	
}