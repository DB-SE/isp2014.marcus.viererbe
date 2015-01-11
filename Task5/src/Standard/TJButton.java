import java.awt.event.ActionListener; 
import javax.swing.*; 

public  class  TJButton  extends JButton {
	
	private static final long serialVersionUID = 1L;

	
	private String _operation;

	
	private boolean _isNumber;

	
	private int _number;

	

	public TJButton(String text, String operation, ActionListener onClick)
	{
		super(text);
		super.addActionListener(onClick);
		_operation = operation;
		_isNumber = false;
		_number = -1;
	}

	
	
	public TJButton(String text, ActionListener onClick) 
	{
		this(text, text, onClick);
	}

	
	
	public TJButton(int number, ActionListener onClick)
	{
		super(Integer.toString(number));
		super.addActionListener(onClick);
		_operation = null;
		_isNumber = true;
		_number = number;
	}

	
	
	public TJButton(String text) 
	{
		super(text);
		_operation = null;
		_isNumber = false;
		_number = -1;
	}

	
	
	public String getOperation()
	{
		return _operation;
	}

	
	
	public boolean IsNumber()
	{
		return _isNumber;
	}

	
	
	public int getNumber()
	{
		return _number;
	}


}
