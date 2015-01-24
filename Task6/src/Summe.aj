public aspect Summe
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
		
		newOps[size] = new TSumme();
		
		System.out.println("add TSumme");
		
		proceed(newOps);
	}
	
	class TSumme implements IDoubleOperation
	{
		private String _op;
		
		public TSumme()
		{
			_op = "sum";
		}
		
		public String getOperation()
		{
			return _op;
		}
		
		public boolean isOperation(String op)
		{
			return op.equalsIgnoreCase(_op);
		}

		public double calculate(double start, double stop)
		{
			double sum;
			
			for (sum = 0; start <= stop; ++start)
			{
				sum += start;
			}
			
			return sum;
		}
	}
}