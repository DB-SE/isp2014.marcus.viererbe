
public class calc
{
	public static void main(String[] args)
	{	
		//#ifdef Verlauf
//@		boolean isHistory = true;
		//#else
		boolean isHistory = false;
		//#endif
		
		//#ifdef UI_Manager
//@		TLookAndFeel.getInstance().IsDisabled = true;
		//#endif
		
		ICalculator calculator = new TBasicCalculator();
		
		int size = 0;
		IView[] views = new IView[4];
		
		views[size++] = new TStdView(calculator, isHistory);
		
		//#ifdef Wissenschaftlich
		views[size++] = new TScientificView(new TScientificCalculator(calculator), isHistory);
		//#endif
		
		//#ifdef Programmierer
		views[size++] = new TProgrammerView(new TProgrammerCalculator(calculator), isHistory);
		//#endif
		
		//#ifdef Datumsberechnungen
//@		views[size++] = new TDateView(new TDateCalculator(calculator), isHistory);
		//#endif
		
		for (int i = 0; i < size; ++i)
		{
			views[i].setViews(views);
		}
		
		views[0].setVisible(true);
	}
}
