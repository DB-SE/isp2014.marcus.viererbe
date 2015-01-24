public aspect Sinus
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
		
		newOps[size] = new TSinus();
		
		System.out.println("add TSinus");
		
		proceed(newOps);
	}
	
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
}