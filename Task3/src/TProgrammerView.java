import javax.swing.*;

import java.awt.*;

public class TProgrammerView extends TStdView
{
	private static final long serialVersionUID = 1L;
	
	private TJButton _bnBin;
	private TJButton _bnOct;
	private TJButton _bnDec;
	private TJButton _bnHex;
	
	private TJButton _bnActive;
	
	private TJButton _bnA;
	private TJButton _bnB;
	private TJButton _bnC;
	private TJButton _bnD;
	private TJButton _bnE;
	private TJButton _bnF;
	
	public TProgrammerView(ICalculator calculator, boolean isHistory)
	{
		super(calculator, isHistory);
	}

	public String getViewName()
	{
		return "Programmierer";
	}
	
	protected JPanel getExtendedPanel()
	{
		JPanel sBn = new JPanel();

		sBn.setLayout(new GridBagLayout());
		
		// Zeile 0
		
		_bnBin = new TJButton("Bin", "bin", this);
		_bnOct = new TJButton("Okt", "oct", this);
		
		sBn.add(_bnBin, new GridBagConstraints(
			0, 0, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
		
		sBn.add(_bnOct, new GridBagConstraints(
			1, 0, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
		
	    // Zeile 1
	    
		_bnDec = new TJButton("Dez", "dec", this);
		_bnHex = new TJButton("Hex", "hex", this);
		
		sBn.add(_bnDec, new GridBagConstraints(
			0, 1, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
		sBn.add(_bnHex, new GridBagConstraints(
			1, 1, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
		
	    // Zeile 2
	    
		_bnA = new TJButton("A", this);
		_bnB = new TJButton("B", this);
		
		sBn.add(_bnA, new GridBagConstraints(
			0, 2, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
		sBn.add(_bnB, new GridBagConstraints(
			1, 2, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
	    // Zeile 3
	    
		_bnC = new TJButton("C", this);
		_bnD = new TJButton("D", this);
		
		sBn.add(_bnC, new GridBagConstraints(
			0, 3, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
		sBn.add(_bnD, new GridBagConstraints(
			1, 3, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
		// Zeile 4
	    
		_bnE = new TJButton("E", this);
		_bnF = new TJButton("F", this);
		
		sBn.add(_bnE, new GridBagConstraints(
			0, 4, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
	    
		sBn.add(_bnF, new GridBagConstraints(
			1, 4, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(1, 1, 1, 1), 0, 0));
		
		_bnActive = _bnHex;
		setButtonAsActive(_bnDec);
		
	    return sBn;
	}
	
	private void setButtonAsActive(TJButton bn)
	{
		if (_bnActive == _bnHex)
		{
			_bnA.setEnabled(false);
			_bnB.setEnabled(false);
			_bnC.setEnabled(false);
			_bnD.setEnabled(false);
			_bnE.setEnabled(false);
			_bnF.setEnabled(false);
		}
		else
		{
			_bnZwei.setEnabled(true);
			_bnDrei.setEnabled(true);
			_bnVier.setEnabled(true);
			_bnFuenf.setEnabled(true);
			_bnSechs.setEnabled(true);
			_bnSieben.setEnabled(true);
			_bnAcht.setEnabled(true);
			_bnNeun.setEnabled(true);
		}
		
		_bnActive.setEnabled(true);
		_bnActive = bn;
		_bnActive.setEnabled(false);
		
		if (_bnActive == _bnBin)
		{
			_bnZwei.setEnabled(false);
			_bnDrei.setEnabled(false);
			_bnVier.setEnabled(false);
			_bnFuenf.setEnabled(false);
			_bnSechs.setEnabled(false);
			_bnSieben.setEnabled(false);
			_bnAcht.setEnabled(false);
			_bnNeun.setEnabled(false);
		}
		else if (_bnActive == _bnOct)
		{
			_bnAcht.setEnabled(false);
			_bnNeun.setEnabled(false);
		}
		else if (_bnActive == _bnHex)
		{
			_bnA.setEnabled(true);
			_bnB.setEnabled(true);
			_bnC.setEnabled(true);
			_bnD.setEnabled(true);
			_bnE.setEnabled(true);
			_bnF.setEnabled(true);
		}
	}
	
	protected void onInputOperation(String op)
	{
		if (op.matches("^[a-zA-Z]$"))
		{
			_display.setText( _display.getText() + op);
		}
		else if (op.equalsIgnoreCase("bin"))
		{
			_calculator.onNumber(_display.getText());
			
			_calculator.onOperation(_bnActive.getOperation() + ":" + op);
			
			setButtonAsActive(_bnBin);
			
			_display.setText(_calculator.getCalculation());
		}
		else if (op.equalsIgnoreCase("oct"))
		{
			_calculator.onNumber(_display.getText());
			
			_calculator.onOperation(_bnActive.getOperation() + ":" + op);
			
			setButtonAsActive(_bnOct);
			
			_display.setText(_calculator.getCalculation());
		}
		else if (op.equalsIgnoreCase("dec"))
		{
			_calculator.onNumber(_display.getText());
			
			_calculator.onOperation(_bnActive.getOperation() + ":" + op);
			
			setButtonAsActive(_bnDec);
			
			_display.setText(_calculator.getCalculation());
		}
		else if (op.equalsIgnoreCase("hex"))
		{
			_calculator.onNumber(_display.getText());
			
			_calculator.onOperation(_bnActive.getOperation() + ":" + op);
			
			setButtonAsActive(_bnHex);
			
			_display.setText(_calculator.getCalculation());
		}
		else
		{			
			super.onInputOperation(op);
		}
	}
}

