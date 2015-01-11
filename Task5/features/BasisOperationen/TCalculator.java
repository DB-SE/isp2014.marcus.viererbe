/**
 * TODO description
 */
public class TCalculator implements ICalculator
{	
	private int _vIndex;
	private double[] _value;
	
	private int _selectedOp;
	private IOperation[] _ops;
	
	public TCalculator()
	{
		_ops = new IOperation[4];
		
		_ops[0] = new TPlus();
		_ops[1] = new TMinus();
		_ops[2] = new TMultiplikation();
		_ops[3] = new TDivision();
		
		_vIndex = 0;
		_value = null;
		
		_selectedOp = -1;
	}
	
	private void addOperation(IOperation op)
	{	
		int size = _ops.length;
		
		IOperation[] newOps = new IOperation[size + 1];
		
		for (int i = 0; i < size; ++i)
		{
			newOps[i] = _ops[i];
		}
		
		newOps[size] = op;
		
		_ops = newOps;
	}
	
	public void onNumber(int value)
	{
		onNumber((double)value);
	}

	public void onNumber(double value)
	{
		if (_value != null && _vIndex < _value.length)
		{
			_value[_vIndex++] = value;
		}
	}
	
	public void onNumber(String value)
	{
		throw new UnsupportedOperationException("onNumber(String) is not supported");
	}

	public boolean onOperation(String op)
	{
		System.out.println("onOperation: " + op);
		
		for (int i = 0; i < _ops.length; ++i)
		{
			if (_ops[i].isOperation(op))
			{
				_vIndex = 0;
				_selectedOp = i;
				
				System.out.println("selected: " + _ops[i].getOperation());
				
				if (_ops[i] instanceof IConstant)
				{
					_value = null;
				}
				else if (_ops[i] instanceof ISingleOperation)
				{
					_value = new double[1];
				}
				else
				{
					_value = new double[2];
				}
				
				return true;
			}
		}
		
		return false;
	}

	public String getCalculation()
	{
		System.out.println("getCalculation: " + _selectedOp);
		
		if (_selectedOp == -1)
		{
			return null;
		}
		
		double value;
		
		if (_ops[_selectedOp] instanceof IConstant)
		{
			System.out.println(_ops[_selectedOp].getOperation());
			
			value = ((IConstant)_ops[_selectedOp]).calculate();
		}
		else if (_ops[_selectedOp] instanceof ISingleOperation)
		{
			System.out.println(_ops[_selectedOp].getOperation() + "(" + _value[0] + ")");
			
			value = ((ISingleOperation)_ops[_selectedOp]).calculate(_value[0]);	
		}
		else
		{
			System.out.println(_ops[_selectedOp].getOperation() + "(" + _value[0] + ", " + _value[1] + ")");
			
			value = ((IDoubleOperation)_ops[_selectedOp]).calculate(_value[0], _value[1]);
		}
		
		_vIndex = 0;
		_value = null;
		_selectedOp = -1;
		
		return Double.toString(value);
	} 
}