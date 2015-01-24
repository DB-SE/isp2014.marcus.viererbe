public aspect Modulo
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
		
		newOps[size] = new TModulo();
		
		System.out.println("add TModulo");
		
		proceed(newOps);
	}
	
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
}