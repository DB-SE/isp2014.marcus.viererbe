
public aspect Konstanten
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
		
		newOps[size] = new TPi();
		
		System.out.println("add TPi");
		
		proceed(newOps);
	}
	
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
}