


class Prism extends Rectangle  {
	private Double height;
	
	public Prism(Double x, Double y, Double l, Double w, Double h, String  name, Colour colour)
	{
		super(x, y, l, w, name, colour);
		height = h;
	}
	
	public void  set_height(Double h)
	{
		height = h;
	}
	
	public Double  height() 
	{
		return height;
	}
	
	public Double  area()
	{
		return  2 * (length * width) + 2 * (height * length) + 2 * (height * width); 
	}
	
	public Double  perimeter()
	{
		return  width  * 2 + length * 2;
	}
	
	public Double  volume()
	{
		return  width  * length * height;
	}
	
	
	public String toString()
	{
		String s = super.toString()+ "\nHeight: " + height;
		return s;
	}
	
	public void shrink(Double divisor) throws SizeFactorException {
		super.shrink(divisor);
		if (divisor < LIMIT) {
			throw new SizeFactorException();
		}
		height = height / divisor;
	}
	
	public void enlarge(Double multiplier) throws SizeFactorException {
		super.enlarge(multiplier);
		if (multiplier < LIMIT) {
			throw new SizeFactorException();
		}
		height = height * multiplier;
	}
}