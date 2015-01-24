import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public aspect Wissenschaftlich
{
	pointcut onGetViewName() : execution(String TStdView.getViewName());
	
	pointcut onGetExtendedPanel(TStdView stdView) : 
		execution(JPanel TStdView.getExtendedPanel()) && this(stdView);
	
	String around() : onGetViewName()
	{
		return "Wissenschaftlich";
	}
	
	JPanel around(TStdView stdView) : onGetExtendedPanel(stdView)
	{
		JPanel sBn = new JPanel();

		sBn.setLayout(new GridBagLayout());
		
		// Zeile 0
		
		sBn.add(new TJButton("sum", stdView), new GridBagConstraints(
			0, 0, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    sBn.add(new TJButton("prod", stdView), new GridBagConstraints(
			1, 0, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
		
	    // Zeile 1
	    
	    sBn.add(new TJButton("fak", stdView), new GridBagConstraints(
			0, 1, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    sBn.add(new TJButton("cos", stdView), new GridBagConstraints(
			1, 1, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    // Zeile 2
	    
	    sBn.add(new TJButton("sin", stdView), new GridBagConstraints(
			0, 2, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    sBn.add(new TJButton("tan", stdView), new GridBagConstraints(
			1, 2, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    // Zeile 3
	    
	    sBn.add(new TJButton("mod", stdView), new GridBagConstraints(
			0, 3, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    sBn.add(new TJButton("log", stdView), new GridBagConstraints(
			1, 3, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    // Zeile 4
	    
	    sBn.add(new TJButton("pow", stdView), new GridBagConstraints(
			0, 4, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    sBn.add(new TJButton("pi", stdView), new GridBagConstraints(
			1, 4, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));    
	    
	    return sBn;
	}
}