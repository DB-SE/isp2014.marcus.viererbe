import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TStdView extends JFrame implements ActionListener, IView
{
	/**
	 * von JFrame geforderte Variable
	 */
	private static final long serialVersionUID = 1L;

	// Objektreferenz zumwechseln der GUI Styles
	private TLookAndFeel _lookAndFeel;
	protected ICalculator _calculator;
	private boolean _clearOnNext;

    // MenueBar
    private JMenuBar _menuBar;
    
    // Hauptmenueeintr‰ge
    private JMenu _bnDatei;
    private JMenu _bnAnsicht;

    // UnterMenueeintrr‰ge
    private JMenuItem _bnClose;
    private JMenuItem[] _bnStyle;

    // Anzeige
    protected JTextField _display;
    protected JTextField _historyDisplay;

    // Steuerungs Buttons
    private TJButton _bnClear;
    private TJButton _bnClearAll;

    // Funktions Bottonss
    private TJButton _bnPlus;
    private TJButton _bnMinus;
    private TJButton _bnMulti;
    private TJButton _bnDivi;
    private TJButton _bnGleich;
    private TJButton _bnKomma;
    private TJButton _bnVorzeichen;
    
    // Ziffern Buttons
    protected TJButton _bnNull;
    protected TJButton _bnEins;
    protected TJButton _bnZwei;
    protected TJButton _bnDrei;
    protected TJButton _bnVier;
    protected TJButton _bnFuenf;
    protected TJButton _bnSechs;
    protected TJButton _bnSieben;
    protected TJButton _bnAcht;
    protected TJButton _bnNeun;
    
	public TStdView(ICalculator calculator, boolean isHistory)
	{
		_calculator = calculator;

		_lookAndFeel = TLookAndFeel.getInstance();
		_lookAndFeel.setGUI(this);

		_clearOnNext = false;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setGUI(isHistory);
	}

	private void setGUI(boolean isHistory)
	{
		int width = 400;
		int height = 300;
		
		setSize(width, height);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int xLocation = (screenSize.width / 2) - (width / 2);
		int yLocation = (screenSize.height / 2) - (height / 2);
		
		setLocation(xLocation, yLocation);
		
		setTitle("Taschenrechner");
		// MenuBar wird erzeugt
		_menuBar = new JMenuBar();

		_display = new JTextField();
		
		// Anzeigeschrift wird gesetzt
		_display.setFont(new Font("Arial", 0, 32));

		// Haupzmenueeintrag Bearbeiten und Ansicht
		_bnDatei = new JMenu("Datei");
		_bnAnsicht = new JMenu("Ansicht");

		// Untermenueeintrag Bearbeiten
		_bnClose = new JMenuItem("Schlieﬂen");

		// Untermenueeintr‰ge hinzufuegen
		_bnDatei.add(_bnClose);

		// Hauptmenueeintrag hinzufuegen
		_menuBar.add(_bnDatei);

		_bnStyle = new JMenuItem[_lookAndFeel.getInstalledLookAndFeels()];

		setViews(null);
		
		_menuBar.add(_bnAnsicht);
		
		// MainMenue anheften
		this.setJMenuBar(_menuBar);
		
		_bnNull = new TJButton(0, this);
	    _bnEins = new TJButton(1, this);
	    _bnZwei = new TJButton(2, this);
	    _bnDrei = new TJButton(3, this);
	    _bnVier = new TJButton(4, this);
	    _bnFuenf = new TJButton(5, this);
	    _bnSechs = new TJButton(6, this);
	    _bnSieben = new TJButton(7, this);
	    _bnAcht = new TJButton(8, this);
	    _bnNeun = new TJButton(9, this);
		
		_bnClear = new TJButton("Clear", "clear", this);
		_bnClearAll = new TJButton("Clear All", "clearAll", this);
		
		_bnPlus = new TJButton("+", this);
	    _bnMinus = new TJButton("-", this);
	    _bnMulti = new TJButton("*", this);
	    _bnDivi = new TJButton("/", this);
	    _bnGleich = new TJButton("=", this);
	    _bnKomma = new TJButton(",", this);
	    _bnVorzeichen = new TJButton("+/-", "+-", this);

		/*
		Hier werden ActionListener Events zu den GUI Elemente zugeordnet und
		deren etsprechenden Aktionen zugeordnet
		########################################################################
		*/
		_bnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				bnClose_Click();
			}});

		// Short Key definieren  STRG+V
		_bnClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));

		for (int i = 0; i < _bnStyle.length; ++i)
		{
			final int a = i;

			_bnStyle[i].addActionListener(new ActionListener()  {
				public void actionPerformed(ActionEvent e)
				{
					_lookAndFeel.showStyle(_bnStyle[a].getText());
				}});
		}
		
		Container contentPane = this.getContentPane();

		// GUI Layout setzen
		contentPane.setLayout(new GridBagLayout());

		// virtuelles Panel erstellen f¸r die Anordnung der Buttons
		JPanel buttons = new JPanel();

		// virtuelles Panellayout setzen
		buttons.setLayout(new GridBagLayout());

		// Setzen der Buttons auf das Panel ButtonMatrix
		// ------------------------------ Erste Zeile ------------------------------
		int insetSize = 1;

		buttons.add(_bnSieben, new GridBagConstraints(
			0, 0, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnAcht, new GridBagConstraints(
			1, 0, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnNeun, new GridBagConstraints(
			2, 0, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnDivi, new GridBagConstraints(
			3, 0, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		// ------------------------------ Zweite Zeile ------------------------------
		buttons.add(_bnVier, new GridBagConstraints(
			0, 1, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnFuenf, new GridBagConstraints(
			1, 1, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnSechs, new GridBagConstraints(
			2, 1, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnMulti, new GridBagConstraints(
			3, 1, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		// ------------------------------ Dritte Zeile ------------------------------
		buttons.add(_bnEins, new GridBagConstraints(
			0, 2, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnZwei, new GridBagConstraints(
			1, 2, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnDrei, new GridBagConstraints(
			2, 2, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnMinus, new GridBagConstraints(
			3, 2, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		// ------------------------------ Vierte Zeile ------------------------------
		buttons.add(_bnNull, new GridBagConstraints(
			0, 3, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnVorzeichen, new GridBagConstraints(
			1, 3, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnKomma, new GridBagConstraints(
			2, 3, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		buttons.add(_bnPlus, new GridBagConstraints(
			3, 3, 1, 1, 100.0, 100.0,
			GridBagConstraints.CENTER,
			GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));
	    
		// Anzeige, ClearButtons und die ButtonMatrix auf GUI setzen
		// ------------------------------------------------------------

		int cpY = 0;

		if (isHistory)
		{
			_historyDisplay = new JTextField();

			contentPane.add(_historyDisplay, new GridBagConstraints(0, cpY++, 4, 1, 100.0, 100.0,
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}

		contentPane.add(_display, new GridBagConstraints(0, cpY++, 4, 1, 100.0, 100.0, 
			GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		contentPane.add(_bnClearAll, new GridBagConstraints(0, cpY, 1, 1, 100.0, 100.0, 
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		contentPane.add(_bnClear, new GridBagConstraints(1, cpY, 1, 1, 100.0, 100.0, 
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		contentPane.add(_bnGleich, new GridBagConstraints(2, cpY, 1, 1, 100.0, 100.0, 
			GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));
		
		JPanel extPanel = getExtendedPanel();
		
		if (extPanel != null)
		{
			contentPane.add(extPanel, new GridBagConstraints(3, cpY, 1, 2, 100.0, 100.0, 
					GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 1, 1, 1), 0, 0));
		}
		
		contentPane.add(buttons, new GridBagConstraints(0, ++cpY, 3, 1, 100.0, 100.0, 
			GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		
	}
	
	protected JPanel getExtendedPanel()
	{
		return null;
	}
	
	public String getViewName()
	{
		return "Standard";
	}
	
	public void setViews(IView[] views)
	{
		_bnAnsicht.removeAll();
		
		if (views != null)
		{
			for (int i = 0; i < views.length; ++i)
			{
				if (views[i] != null)
				{
					_bnAnsicht.add(new TViewJMenuItem(views[i], this));
				}
			}
		}
		
		if (!_lookAndFeel.IsDisabled)
		{
			if (views != null)
			{
				_bnAnsicht.add(new JSeparator());
			}
			
			int i = 0;

			Iterator LAFIter = _lookAndFeel.getIterator();

			while (LAFIter.hasNext())
			{
				_bnStyle[i++] = new JMenuItem(((String) LAFIter.next()));
			}

			for (i = 0; i < _bnStyle.length; ++i)
			{
				_bnAnsicht.add(_bnStyle[i]);
			}

			_menuBar.add(_bnAnsicht);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
        if (e.getSource() instanceof TJButton)
        {
        	TJButton bn = (TJButton)e.getSource();
        	
        	if (bn.IsNumber())
        	{
        		onInputNumber(bn.getNumber());
        	}
        	else
        	{
        		onInputOperation(bn.getOperation());
        	}
        }
        else if (e.getSource() instanceof TViewJMenuItem)
        {
        	this.setVisible(false);
        	
        	((TViewJMenuItem)e.getSource()).getView().setVisible(true);
        }
	}

	// private Methode zum schlieﬂen des Programms
	private void bnClose_Click()
	{
		try
		{
			System.exit(0);
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			showMessage("Fehler bei dem Beenden des Programms.");
		}
	}

	// Methode zum Anzeigen einer MessageBox mit Textmeldung
	public void showMessage(String sMessage)
	{
		JOptionPane.showConfirmDialog(null, sMessage, "Taschenrechner", 
			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}
    
    protected void onInputNumber(int value)
    {
    	if (_clearOnNext)
    	{
    		_clearOnNext = false;
    		
    		onInputOperation("clearAll");
    	}
    	
    	_display.setText(_display.getText() + value);
    }
    
    protected void onInputOperation(String op)
    {
    	if (op == null)
    	{
    		return;
    	}
    	
    	if (_clearOnNext)
    	{
    		_clearOnNext = false;
    		
    		String text = _display.getText();
    		
    		onInputOperation("clearAll");
    		
    		_display.setText(text);
    	}
    	
    	if (op.equals("clear"))
    	{
    		_display.setText("");
    	}
    	else if (op.equals("clearAll"))
    	{
    		_display.setText("");
    		
    		if (_historyDisplay != null)
    		{
    			_historyDisplay.setText("");
    		}
    	}
    	else if (op.equals(","))
    	{
    		_display.setText( _display.getText() + ",");
    	}
    	else if (op.equals("+-"))
    	{
    		String text = _display.getText();
    		
    		if (text.startsWith("-"))
    		{
    			text = text.replaceFirst("-", "");
    		}
    		else
    		{
    			text = "-" + text;
    		}
    		
    		_display.setText(text);
    	}
    	else
    	{
    		if (_historyDisplay != null)
    		{
    			_historyDisplay.setText(_historyDisplay.getText() + _display.getText() + " " + op + " ");
    		}
    		
    		String text = _display.getText();
    		
    		if (text.matches("^-?[0-9]+$"))
    		{
    			_calculator.onNumber(Integer.parseInt(text));
    		}
    		else if (text.matches("^[0-9]+,[0-9]+$"))
    		{
    			text = text.replaceFirst(",", ".");
    			
    			_calculator.onNumber(Double.parseDouble(text));
    		}
    		else
    		{
    			_display.setText("INVALID");
    			
    			_clearOnNext = true;
    			
    			return;
    		}
    		
    		_display.setText("");
    		
    		if (op.equals("="))
        	{
        		_display.setText(_calculator.getCalculation().replaceFirst("\\.", ","));
        		
        		_clearOnNext = true;
        	}
    		else
    		{
    			_calculator.onOperation(op);
	    	}
    	}
    }
}
