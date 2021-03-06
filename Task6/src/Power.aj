public aspect Power
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
		
		newOps[size] = new TPow();
		
		System.out.println("add TPow");
		
		proceed(newOps);
	}
	
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
}