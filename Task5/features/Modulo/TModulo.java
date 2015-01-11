/**
 * TODO description
 */
public class TModulo implements IDoubleOperation
{
	private String _op;
	
	public TModulo()
	{
		_op = "mod";
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
		return valueA % valueB;
	}
}