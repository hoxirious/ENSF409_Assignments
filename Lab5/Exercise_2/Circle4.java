


class Circle extends Shape 
{
	private Double radius;

	Circle(Double x_origin, Double y_origin, Double newradius,  String name, Colour colour){
		super(x_origin, y_origin, name, colour);
		radius = newradius;
	}
	
	
	public void set_radius(Double newradius){
		radius = newradius;
	}
	
	public Double get_radius() {
		return radius;
	}
	
	public Double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public Double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	public Double  volume(){
		return 0.0;
	}
	
	
	public String toString(){
		String s = super.toString()+ "\nRadius: " + radius;
		return s;
	}


	@Override
	public void shrink(Double divisor) throws SizeFactorException {
		// TODO Auto-generated method stub
		if (divisor < LIMIT) {
			throw new SizeFactorException();
		}
		radius = radius/divisor;
	}


	@Override
	public void enlarge(Double multiplier) throws SizeFactorException {
		// TODO Auto-generated method stub
		if (multiplier < LIMIT) {
			throw new SizeFactorException();
		}
		radius = radius*multiplier;
	}
         
}