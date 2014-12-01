
public class TProgrammerCalculator implements ICalculator
{
	private ICalculator _basicCalc;
	private String _value;
	
	public TProgrammerCalculator(ICalculator basicCalc)
	{
		_basicCalc = basicCalc;
		_value = null;
	}
	
	public void onNumber(String value)
	{
		System.out.println("onNumber: String");
		_value = value;
	}
	
	public void onNumber(int value)
	{
		System.out.println("onNumber: int");
		_basicCalc.onNumber(value);
	}

	public void onNumber(double value)
	{
		_basicCalc.onNumber(value);
	}

	public void onOperation(String op)
	{
		if (op.matches("^[a-z]{3}:[a-z]{3}$"))
		{
			if (_value == null || _value.length() == 0)
			{
				return;
			}
			
			String[] ops = op.split(":");
			
			int decValue;
			
			if (ops[0].equals("bin"))
			{
				decValue = Integer.parseInt(_value, 2);
			}
			else if (ops[0].equals("oct"))
			{
				decValue = Integer.parseInt(_value, 8);
			}
			else if (ops[0].equals("dec"))
			{
				decValue = Integer.parseInt(_value, 10);
			}
			else
			{
				decValue = Integer.parseInt(_value, 16);
			}
			
			if (ops[1].equals("bin"))
			{
				_value = Integer.toBinaryString(decValue);
			}
			else if (ops[1].equals("oct"))
			{
				_value = Integer.toOctalString(decValue);
			}
			else if (ops[1].equals("dec"))
			{
				_value = Integer.toString(decValue);
			}
			else
			{
				_value = Integer.toHexString(decValue);
			}
		}
		else
		{
			_basicCalc.onOperation(op);
		}
	}

	public String getCalculation()
	{
		if (_value == null)
		{
			return _basicCalc.getCalculation();
		}
		
		String value = _value;
		
		_value = null;
		
		return value;
	} 
}
