
public interface IOperation
{
	String getOperation();
	boolean isOperation(String op);
}

interface IConstant extends IOperation
{
	double calculate();
}

interface ISingleOperation extends IOperation
{
	double calculate(int value);
	double calculate(double value);
}

interface IDoubleOperation extends IOperation
{
	double calculate(double valueA, double valueB);
}
