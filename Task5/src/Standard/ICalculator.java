/**
 * TODO description
 */
public  interface  ICalculator {
	
	// Event-Methoden
	public void onNumber(int value);

	
	public void onNumber(double value);

	
	public void onNumber(String value);

	
	public boolean onOperation(String op);

	
	
	// liefert Ergebnis der bis dato angefallenen Berechnungen
	public String getCalculation();


}
