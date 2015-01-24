public aspect Logarithmus
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
		
		newOps[size] = new TLogarithmus();
		
		System.out.println("add TLogarithmus");
		
		proceed(newOps);
	}
	
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
}