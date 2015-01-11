/**
 * TODO description
 */
public class TCosinus implements ISingleOperation
{
	private String _op;
	
	public TCosinus()
	{
		_op = "cos";
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
		return Math.cos(value);
	}
}