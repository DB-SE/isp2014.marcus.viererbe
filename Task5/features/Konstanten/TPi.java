/**
 * TODO description
 */
public class TPi implements IConstant
{
	private String _op;
	
	public TPi()
	{
		_op = "pi";
	}
	
	public String getOperation()
	{
		return _op;
	}
	
	public boolean isOperation(String op)
	{
		return op.equalsIgnoreCase(_op);
	}

	public double calculate()
	{
		return Math.PI;
	}
}