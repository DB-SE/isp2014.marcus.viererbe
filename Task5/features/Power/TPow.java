/**
 * TODO description
 */
public class TPow implements IDoubleOperation
{
	private String _op;
	
	public TPow()
	{
		_op = "pow";
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
		return Math.pow(valueA, valueB);
	}
}