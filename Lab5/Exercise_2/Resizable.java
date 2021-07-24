
public interface Resizable {
	final public Double LIMIT = 1.0;
	public void shrink(Double divisor) throws SizeFactorException;
	public void enlarge(Double multiplier) throws SizeFactorException;
}
