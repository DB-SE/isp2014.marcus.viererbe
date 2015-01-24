public aspect Cosinus
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
		
		newOps[size] = new TCosinus();
		
		System.out.println("add TCosinus");
		
		proceed(newOps);
	}
	
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
}