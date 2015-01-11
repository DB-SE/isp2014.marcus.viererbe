/**
 * TODO description
 */
public class TFakultaet implements ISingleOperation
{
	private String _op;
	
	public TFakultaet()
	{
		_op = "fak";
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
		return fak(value);
	}

	public double calculate(double value)
	{
		return calculate((int)value);
	}
	
	private int fak(int value)
	{
		return value < 2 ? 1 : fak(value - 1) * value;
	}
}