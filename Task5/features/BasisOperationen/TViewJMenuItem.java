import java.awt.event.ActionListener;
import javax.swing.*;

public class TViewJMenuItem extends JMenuItem
{
	private static final long serialVersionUID = 1L;

	private IView _view; 
	
	public TViewJMenuItem(IView view, ActionListener onClick)
	{
		super(view.getViewName());
		super.addActionListener(onClick);
		
		_view = view;
	}
	
	public IView getView()
	{
		return _view;
	}
}