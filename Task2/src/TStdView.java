import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TStdView extends JFrame
{
    /**
	 * von JFrame geforderte Variable
	 */
	private static final long serialVersionUID = 1L;

	// Objektreferenz zumwechseln der GUI Styles
	private TLookAndFeel _lookAndFeel;
	private ICalculator _calculator;
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
    private JTextField _display = new JTextField();
    private JTextField _historyDisplay;

    // Steuerungs Buttons
    private JButton _bnClear = new JButton();
    private JButton _bnClearAll = new JButton();

    // Funktions Bottonss
    private JButton _bnPlus = new JButton();
    private JButton _bnMinus = new JButton();
    private JButton _bnMulti = new JButton();
    private JButton _bnDivi = new JButton();
    private JButton _bnGleich = new JButton();
    private JButton _bnKomma = new JButton();
    private JButton _bnVorzeichen = new JButton();

    // Ziffern Buttons
    private JButton _bnNull = new JButton();
    private JButton _bnEins = new JButton();
    private JButton _bnZwei = new JButton();
    private JButton _bnDrei = new JButton();
    private JButton _bnVier = new JButton();
    private JButton _bnFuenf = new JButton();
    private JButton _bnSechs = new JButton();
    private JButton _bnSieben = new JButton();
    private JButton _bnAcht = new JButton();
    private JButton _bnNeun = new JButton();

	public TStdView(ICalculator calculator, boolean isHistory)
	{
		_calculator = calculator;

		_lookAndFeel = TLookAndFeel.getInstance();
		_lookAndFeel.setGUI(this);

		_clearOnNext = false;

		setGUI(isHistory);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setLocation(40,30);
		setTitle("Taschenrechner");
	}

	private void setGUI(boolean isHistory)
	{
		// MenuBar wird erzeugt
		_menuBar = new JMenuBar();

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

		if (!_lookAndFeel.IsDisabled)
		{
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

		// MainMenue anheften
		this.setJMenuBar(_menuBar);

		/*
		Hier werden ActionListener Events zu den GUI Elemente zugeordnet und
		deren etsprechenden Aktionen zugeordnet
		########################################################################
		*/
		_bnClose.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		bnClose_Click();
		}
		});

		// Short Key definieren  STRG+V
		_bnClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));

		for (int i = 0; i < _bnStyle.length; ++i)
		{
			final int a = i;

			_bnStyle[i].addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
			_lookAndFeel.showStyle(_bnStyle[a].getText());
			}
			});
		}
		
		_bnNull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputNumber(0);
			}});

		_bnEins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputNumber(1);
			}});

		_bnZwei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputNumber(2);
			}});

		_bnDrei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputNumber(3);
			}});

		_bnVier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputNumber(4);
			}});

		_bnFuenf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputNumber(5);
			}});

		_bnSechs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputNumber(6);
			}});

		_bnSieben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputNumber(7);
			}});

		_bnAcht.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e)
			{
				onInputNumber(8);
			}});

		_bnNeun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputNumber(9);
			}});

		_bnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputOperation("+");
			}});

		_bnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputOperation("-");
			}});

		_bnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputOperation("*");
			}});

		_bnDivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputOperation("/");
			}});

		_bnGleich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputOperation("=");
			}});

		_bnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputOperation("clear");
			}});

		_bnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputOperation("clearAll");
			}});

		_bnVorzeichen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputOperation("+-");
			}});

		_bnKomma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				onInputOperation(",");
			}});

		Container contentPane = this.getContentPane();

		// GUI Layout setzen
		contentPane.setLayout(new GridBagLayout());

		// virtuelles Panel erstellen f¸r die Anordnung der Buttons
		JPanel buttons = new JPanel();

		// virtuelles Panellayout setzen
		buttons.setLayout(new GridBagLayout());

		// Anzeigeschrift der Buttons setzen
		_bnClear.setText("Clear");
		_bnClearAll.setText("Clear All");
		_bnNull.setText("0");
		_bnEins.setText("1");
		_bnZwei.setText("2");
		_bnDrei.setText("3");
		_bnVier.setText("4");
		_bnFuenf.setText("5");
		_bnSechs.setText("6");
		_bnSieben.setText("7");
		_bnAcht.setText("8");
		_bnNeun.setText("9");
		_bnDivi.setText("/");
		_bnMulti.setText("*");
		_bnMinus.setText("-");
		_bnPlus.setText("+");
		_bnGleich.setText("=");
		_bnKomma.setText(",");
		_bnVorzeichen.setText("+/-");

		// Setzen der Buttons auf das Panel ButtonMatrix
		// ##################### Erste Zeile ####################################
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

		// ###################### Zweite Zeile ##################################
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

		// ##################### Dritte Zeile ##################################
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

		// ##################### Vierte Zeile ##################################
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
		// #####################################################################

		int cpY = 0;

		if (isHistory)
		{
			_historyDisplay = new JTextField();

			contentPane.add(_historyDisplay, new GridBagConstraints(0, cpY++, 3, 1, 100.0, 100.0,
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}

		contentPane.add(_display, new GridBagConstraints(0, cpY++, 3, 1, 100.0, 100.0, 
			GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		contentPane.add(_bnClearAll, new GridBagConstraints(0, cpY, 1, 1, 100.0, 100.0, 
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		contentPane.add(_bnClear, new GridBagConstraints(1, cpY, 1, 1, 100.0, 100.0, 
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		contentPane.add(_bnGleich, new GridBagConstraints(2, cpY++, 1, 1, 100.0, 100.0, 
			GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
			new Insets(insetSize, insetSize, insetSize, insetSize), 0, 0));

		contentPane.add(buttons, new GridBagConstraints(0, cpY, 3, 1, 100.0, 100.0, 
			GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
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
			Message("Fehler bei dem Beenden des Programms.");
		}
	}

	// Methode zum ‰ndern der Anzeige von auﬂen
	public void setDisplay(String Text)
	{
		_display.setText(Text);
	}

	// Methode zum Anzeigen einer MessageBox mit Textmeldung
	public void Message(String sMessage)
	{
		JOptionPane.showConfirmDialog(null, sMessage, "Taschenrechner", 
			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}
    
    private void onInputNumber(int value)
    {
    	if (_clearOnNext)
    	{
    		_clearOnNext = false;
    		
    		onInputOperation("clearAll");
    	}
    	
    	_display.setText(_display.getText() + value);
    }
    
    private void onInputOperation(String op)
    {
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
