
public class TScientificCalculator implements ICalculator
{
	private ICalculator _basicCalc;
	private int _value;
	
	public TScientificCalculator(ICalculator basicCalc)
	{
		_basicCalc = basicCalc;
	}
	
	public void onNumber(int value)
	{
		_value = value;
		
		_basicCalc.onNumber(value);
	}

	public void onNumber(double value)
	{
		_basicCalc.onNumber(value);
	}
	
	public void onNumber(String value)
	{
		throw new UnsupportedOperationException("onNumber(String) is not supported");
	}
	
	private int fak(int value)
	{
		return value == 1 ? 1 : fak(value - 1) * value;
	}

	public void onOperation(String op)
	{
		if (op.equals("fak"))
		{
			_value = fak(_value);
		}
		else
		{
			_basicCalc.onOperation(op);
		}
	}

	public String getCalculation()
	{
		if (_value == -1)
		{
			return _basicCalc.getCalculation();
		}
		
		int value = _value;
		
		_value = -1;
		
		return Integer.toString(value);
	} 
}
