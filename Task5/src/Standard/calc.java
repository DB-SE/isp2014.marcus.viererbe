/**
 * TODO description
 */
public  class  calc {
	
	public static void main(String[] args)
	{
		IView[] views = new IView[4];
		
		views[0] = new TStdView(new TCalculator());
		views[1] = getScientificView();
		views[2] = getProgrammerView();
		views[3] = getDateView();
		
		for (int i = 0; i < views.length; ++i)
		{
			if (views[i] != null)
			{
				views[i].setViews(views);
			}
		}
		
		views[0].setVisible(true);
	}

	
	
	private static IView getScientificView()
	{
		return null;
	}

	
	
	private static IView getProgrammerView()
	{
		return null;
	}

	
	
	private static IView getDateView()
	{
		return null;
	}


}
