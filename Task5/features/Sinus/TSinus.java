/**
 * TODO description
 */
public class TSinus implements ISingleOperation
{
	private String _op;
	
	public TSinus()
	{
		_op = "sin";
	}
	
	public String getOperation()
	{
		return _op;
	}
	
	public boolean isOperation(String op)
	{
		return op.equalsIgnoreCase(_op);
	}

	public double calculate(int value)
	{
		return calculate((double)value);
	}
	
	public double calculate(double value)
	{
		return Math.sin(value);
	}
}