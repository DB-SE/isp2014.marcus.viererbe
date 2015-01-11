/**
 * TODO description
 */
public class calc
{
	private static IView getDateView()
	{
		return new TDateView(new TCalculator());
	}
}