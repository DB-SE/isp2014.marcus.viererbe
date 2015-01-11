import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class TStdView extends JFrame implements ActionListener, IView
{
	// Objektreferenz zumwechseln der GUI Styles
	private TLookAndFeel _lookAndFeel;
	
	private JMenuItem[] _bnStyle;
	
	private void setGUI(boolean isHistory)
	{
		_lookAndFeel = TLookAndFeel.getInstance();
		_lookAndFeel.setGUI(this);
		
		original(isHistory);
	}
	
	public void setViews(IView[] views)
	{
		original(views);
		
		if (!_lookAndFeel.IsDisabled)
		{
			if (views != null)
			{
				_bnAnsicht.add(new JSeparator());
			}
			
			_bnStyle = new JMenuItem[_lookAndFeel.getInstalledLookAndFeels()];
			
			int i = 0;

			Iterator LAFIter = _lookAndFeel.getIterator();

			while (LAFIter.hasNext())
			{
				_bnStyle[i++] = new JMenuItem(((String) LAFIter.next()));
			}

			for (i = 0; i < _bnStyle.length; ++i)
			{
				final int a = i;
				
				_bnStyle[i].addActionListener(new ActionListener()  {
					public void actionPerformed(ActionEvent e)
					{
						_lookAndFeel.showStyle(_bnStyle[a].getText());
					}});
				
				_bnAnsicht.add(_bnStyle[i]);
			}

			_menuBar.add(_bnAnsicht);
		}
	}
	
}