/**
 * TODO description
 */
public class TMultiplikation implements IDoubleOperation
{
	private String _op;
	
	public TMultiplikation()
	{
		_op = "*";
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
		return valueA * valueB;
	}
}