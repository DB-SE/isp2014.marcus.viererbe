/**
 * TODO description
 */
public  interface  IView {
	
	public String getViewName();

	
	public void setViews(IView[] views);

	
	public void setVisible(boolean isVisible);

	
	public void showMessage(String sMessage);


}
