/**
 * TODO description
 */
public class calc
{
	private static IView getScientificView()
	{
		return new TScientificView(new TCalculator());
	}
}