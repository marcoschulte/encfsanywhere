package de.voot.encfsanywhere.client.view;

import com.google.gwt.user.client.ui.Widget;

public interface View<P> {
	public Widget asWidget();

	public void setPresenter(P presenter);
}
