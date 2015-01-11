/**
 * TODO description
 */
public class TTangens implements ISingleOperation
{
	private String _op;
	
	public TTangens()
	{
		_op = "tan";
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
		return Math.tan(value);
	}
}