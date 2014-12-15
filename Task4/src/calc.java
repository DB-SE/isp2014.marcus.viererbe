
public class calc
{
	public static void main(String[] args)
	{
		/*
		 * Plugins werden durch drei Interfaces beschrieben (IConstant, ISingleOperation und IDoubleOperation).
		 * Diese erben ein Interface namens IOperation. Alle Interfaces sind in der Datei IOperation beschrieben.
		 * Alle Plugins sind in der Datei plugins.java enthalten.
		 */
		IOperation[] operationPlugins = new IOperation[12];
		
		operationPlugins[0] = new TPlus();
		operationPlugins[1] = new TMinus();
		operationPlugins[2] = new TMultiplikation();
		operationPlugins[3] = new TDivision();
		
		operationPlugins[4] = new TPi();
		operationPlugins[5] = new TSinus();
		operationPlugins[6] = new TCosinus();
		operationPlugins[7] = new TTangens();
		operationPlugins[8] = new TFakultaet();
		operationPlugins[9] = new TPow();
		operationPlugins[10] = new TModulo();
		operationPlugins[11] = new TLogarithmus();
		
		new TScientificView(new TCalculator(operationPlugins)).setVisible(true);
	}
}
