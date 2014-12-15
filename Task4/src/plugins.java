// Plugin: TPi
class TPi implements IConstant
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

// Plugin: TSinus
class TSinus implements ISingleOperation
{
	private String _op;
	
	public TSinus()
	{
		_op = "sin";
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
		return calculate((double)value);
	}
	
	public double calculate(double value)
	{
		return Math.sin(value);
	}
}

//Plugin: TCosinus
class TCosinus implements ISingleOperation
{
	private String _op;
	
	public TCosinus()
	{
		_op = "cos";
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
		return calculate((double)value);
	}
	
	public double calculate(double value)
	{
		return Math.cos(value);
	}
}

//Plugin: TTangens
class TTangens implements ISingleOperation
{
	private String _op;
	
	public TTangens()
	{
		_op = "tan";
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
		return calculate((double)value);
	}
	
	public double calculate(double value)
	{
		return Math.tan(value);
	}
}

//Plugin: TFakultaet
class TFakultaet implements ISingleOperation
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

//Plugin: TPow
class TPow implements IDoubleOperation
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

//Plugin: TModulo
class TModulo implements IDoubleOperation
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

//Plugin: TLogarithmus
class TLogarithmus implements IDoubleOperation
{
	private String _op;
	
	public TLogarithmus()
	{
		_op = "log";
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
		return Math.log10(valueB) / Math.log10(valueA);
	}
}

//Plugin: TPlus
class TPlus implements IDoubleOperation
{
	private String _op;
	
	public TPlus()
	{
		_op = "+";
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
		return valueA + valueB;
	}
}

//Plugin: TMinus
class TMinus implements IDoubleOperation
{
	private String _op;
	
	public TMinus()
	{
		_op = "-";
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
		return valueA - valueB;
	}
}

//Plugin: TMultiplikation
class TMultiplikation implements IDoubleOperation
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

//Plugin: TDivision
class TDivision implements IDoubleOperation
{
	private String _op;
	
	public TDivision()
	{
		_op = "/";
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
		return valueA / valueB;
	}
}