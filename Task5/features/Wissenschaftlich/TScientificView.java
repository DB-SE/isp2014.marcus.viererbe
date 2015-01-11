import javax.swing.*;
import java.awt.*;

public class TScientificView extends TStdView
{
	private static final long serialVersionUID = 1L;
	
	public TScientificView(ICalculator calculator)
	{
		super(calculator);
	}
	
	public String getViewName()
	{
		return "Wissenschaftlich";
	}

	protected JPanel getExtendedPanel()
	{
		JPanel sBn = new JPanel();

		sBn.setLayout(new GridBagLayout());
		
		// Zeile 0
		
		sBn.add(new TJButton("sum", this), new GridBagConstraints(
			0, 0, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    sBn.add(new TJButton("prod", this), new GridBagConstraints(
			1, 0, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
		
	    // Zeile 1
	    
	    sBn.add(new TJButton("fak", this), new GridBagConstraints(
			0, 1, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    sBn.add(new TJButton("cos", this), new GridBagConstraints(
			1, 1, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    // Zeile 2
	    
	    sBn.add(new TJButton("sin", this), new GridBagConstraints(
			0, 2, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    sBn.add(new TJButton("tan", this), new GridBagConstraints(
			1, 2, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    // Zeile 3
	    
	    sBn.add(new TJButton("mod", this), new GridBagConstraints(
			0, 3, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    sBn.add(new TJButton("log", this), new GridBagConstraints(
			1, 3, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    // Zeile 4
	    
	    sBn.add(new TJButton("pow", this), new GridBagConstraints(
			0, 4, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    sBn.add(new TJButton("pi", this), new GridBagConstraints(
			1, 4, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));    
	    
	    return sBn;
	}
}
