/**
 * TODO description
 */
public class calc
{
	private static IView getProgrammerView()
	{
		return new TProgrammerView(new TProgrammerCalculator(new TCalculator()));
	}
}