
import javax.swing.*; 
import javax.swing.UIManager.*; 
import java.util.*; 

public  class  TLookAndFeel {
	
    private static TLookAndFeel _lookAndFeel = new TLookAndFeel();

	
    private JFrame _gui;

	
    
    public boolean IsDisabled;

	

    private TLookAndFeel()
    {
    	IsDisabled = false;
    }

	

    public static TLookAndFeel getInstance()
    {
        return _lookAndFeel;
    }

	

    // diese Methode weist der privaten Referenz eine Refernz zu
    public void setGUI(JFrame gui)
    {
        _gui = gui;
    }

	

    // diese Methode liefert die Anzahl der auf dem OS installierten Styles
    public int getInstalledLookAndFeels()
    {
        return IsDisabled ? 0 : UIManager.getInstalledLookAndFeels().length;
    }

	

    // ändert den Style der GUI, wenn der Übergebende Stylename vorhanden ist
    public void showStyle(String lookAndFeelName)
    {
    	if (IsDisabled)
    	{
    		return;
    	}
    	
    	LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
    	
    	String className = null;
    	
        // die Schleife sucht den ClassName raus
        for (int i = 0; i < infos.length && className == null; ++i)
        {
            if (lookAndFeelName.equals(infos[i].getName()))
            {
            	className = infos[i].getClassName();
            }
        }
        
        // GUI wird auf invisible gesetzt um änderung zu erzwingen
        _gui.setVisible(false);
        
        // try catch Block, um Fehler abzufangen
        try
        {
            // setzen des Styles mit UIManager
            UIManager.setLookAndFeel(className);
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Fehler im TLookAndFeel");
        }
        
        // GUI wird auf visible gesetzt
        _gui.setVisible(true);
    }

	

    // liefert einen Iterator um über die Styles zu gehen (Faktory-Methode)
    public Iterator getIterator()
    {
        return IsDisabled ? null : new LookAndFeelIterator(UIManager.getInstalledLookAndFeels());
    }

	

    // innere Klasse, die den Iterator implementiert
    private  class  LookAndFeelIterator  implements Iterator {
		
        private LookAndFeelInfo[] _laf;

		
        private int i;

		

        public LookAndFeelIterator(LookAndFeelInfo[] laf)
        {
            _laf = laf;
            i = 0;
        }

		

        // remove wird nicht unterstützt
        public void remove()
        {
            throw new UnsupportedOperationException();
        }

		

        // liefert Objekt (String) und Incrementiert i
        public Object next()
        {
            return _laf[i++].getName();
        }

		

        // liefert boolschen wert, ob es noch einen Nachfolger gibt
        public boolean hasNext()
        {
            return i < _laf.length;
        }


	}


}
