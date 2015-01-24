public aspect Produkt
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
		
		newOps[size] = new TProdukt();
		
		System.out.println("add TProdukt");
		
		proceed(newOps);
	}
	
	class TProdukt implements IDoubleOperation
	{
		private String _op;
		
		public TProdukt()
		{
			_op = "prod";
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
			double prod;
			
			for (prod = 1; start <= stop; ++start)
			{
				prod *= start;
			}
			
			return prod;
		}
	}
}