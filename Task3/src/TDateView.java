
public class TDateView extends TStdView
{
	private static final long serialVersionUID = 1L;

	public TDateView(ICalculator calculator, boolean isHistory)
	{
		super(calculator, isHistory);
	}
	
	public String getViewName()
	{
		return "Datumsberechnung";
	}
}
