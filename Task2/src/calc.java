
public class calc
{
	public static void main(String[] args)
	{	
		boolean isLookAndFeel = false;
		boolean isHistory = false;
		
		for (int i = 0; i < args.length; ++i)
		{
			if (args[i].equalsIgnoreCase("lookAndFeel"))
			{
				isLookAndFeel = true;
			}
			else if (args[i].equalsIgnoreCase("history"))
			{
				isHistory = true;
			}
		}
		
		TLookAndFeel.getInstance().IsDisabled = !isLookAndFeel;
		
		new TStdView(new TBasicCalculator(), isHistory).setVisible(true);
	}
}
