
public class calc
{
	public static void main(String[] args)
	{
		IOperation[] ops = new IOperation[4];
		
		ops[0] = new TPlus();
		ops[1] = new TMinus();
		ops[2] = new TMultiplikation();
		ops[3] = new TDivision();
		
		new TStdView(new TCalculator(ops), false).setVisible(true);
	}
}
