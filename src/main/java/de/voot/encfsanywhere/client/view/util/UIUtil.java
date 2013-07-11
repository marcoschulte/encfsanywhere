package de.voot.encfsanywhere.client.view.util;

public class UIUtil {

	public static final native void showLoadingAnimation() /*-{
		$wnd.$("#loadingBar").show();
	}-*/;

	public static final native void hideLoadingAnimation() /*-{
		$wnd.$("#loadingBar").hide();
	}-*/;

	public static final native void showKeyDerivationOverlay() /*-{
		$wnd.$("#derivatingKeyOverlay").show();
	}-*/;

	public static final native void hideKeyDerivationOverlay() /*-{
		$wnd.$("#derivatingKeyOverlay").hide();
	}-*/;

	public static final native void showPasswordPrompt() /*-{
		$wnd.$("#passwordEntryPrompt").show();
	}-*/;

	public static final native void hidePasswordPrompt() /*-{
		$wnd.$("#passwordEntryPrompt").hide();
	}-*/;
}
