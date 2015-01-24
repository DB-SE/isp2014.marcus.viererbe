public aspect Fakultaet
{
	pointcut onNewTCalculator(IOperation[] ops) : 
		execution(TCalculator.new(IOperation[])) && args(ops);
	
	void around(IOperation[] ops) : onNewTCalculator(ops)
	{
		int size = ops.length;
		
		IOperation[] newOps = new IOperation[size + 1];
		
		for (int i = 0; i < size; ++i)
		{
			newOps[i] = ops[i];
		}
		
		newOps[size] = new TFakultaet();
		
		System.out.println("add TFakultaet");
		
		proceed(newOps);
	}
	
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
}