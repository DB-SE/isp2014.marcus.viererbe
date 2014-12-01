
public class TDateCalculator implements ICalculator
{
	private ICalculator _basicCalc;
	
	public TDateCalculator(ICalculator basicCalc)
	{
		_basicCalc = basicCalc;
	}

	public void onNumber(int value)
	{
		_basicCalc.onNumber(value);
	}

	public void onNumber(double value)
	{
		_basicCalc.onNumber(value);
	}

	public void onNumber(String value)
	{
		_basicCalc.onNumber(value);
	}

	public void onOperation(String op)
	{
		_basicCalc.onOperation(op);
	}

	public String getCalculation()
	{
		return _basicCalc.getCalculation();
	}
}
