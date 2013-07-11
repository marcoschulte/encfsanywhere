package de.voot.encfsanywhere.client.view.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class FlatUIHelper {

	public static void initCheckboxOrRadio(Element element) {
		doInitCheckboxOrRadio(element);
	}

	private static native void doInitCheckboxOrRadio(JavaScriptObject wrap) /*-{
		// rearrange tags to confirm with flat-ui
		wrap = $wnd.$(wrap);
		var inp = wrap.children("input");
		var lbl = wrap.children("label");
		lbl.append(inp);
		lbl.insertBefore(lbl.parent());
		lbl.addClass("checkbox");
		wrap.remove();

		// First let's prepend icons (needed for effects)
		lbl
				.prepend("<span class='icon'></span><span class='icon-to-fade'></span>");

		lbl.click(function() {
			$wnd.updateCheckboxRadioLabels();
		});
		$wnd.updateCheckboxRadioLabels();
	}-*/;
}
