public aspect Verlauf
{
	pointcut onSetGUI(boolean isHistory) : 
		execution(void TStdView.setGUI(boolean)) && args(isHistory);
	
	void around(boolean isHistory) : onSetGUI(isHistory)
	{
		proceed(true);
	}
}