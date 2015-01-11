/**
 * TODO description
 */
public class TLogarithmus implements IDoubleOperation
{
	private String _op;
	
	public TLogarithmus()
	{
		_op = "log";
	}
	
	public String getOperation()
	{
		return _op;
	}
	
	public boolean isOperation(String op)
	{
		return op.equalsIgnoreCase(_op);
	}

	public double calculate(double valueA, double valueB)
	{
		return Math.log10(valueB) / Math.log10(valueA);
	}
}