
public class TBasicCalculator implements ICalculator
{
	private double _value;
	private char _lastOp;
	
	public TBasicCalculator()
	{
		_value = 0;
		_lastOp = 0;
	}
	
	public void onNumber(int value)
	{
		onNumber((double)value);
	}

	public void onNumber(double value)
	{
		if (_lastOp == 0)
		{
			_value = value;
		}
		else
		{
			if (_lastOp == '+')
			{
				_value += value;
			}
			else if (_lastOp == '-')
			{
				_value -= value;
			}
			else if (_lastOp == '*')
			{
				_value *= value;
			}
			else if (_lastOp == '/')
			{
				_value /= value;
			}
			
			_lastOp = 0;
		}
	}
	
	public void onNumber(String value)
	{
		throw new UnsupportedOperationException("onNumber(String) is not supported");
	}

	public void onOperation(String op)
	{
		_lastOp = op.charAt(0);
	}

	public String getCalculation()
	{
		double lastValue = _value;
		
		_value = 0;
		
		_lastOp = 0;
		
		return lastValue + "";
	}
}
