package de.voot.encfsanywhere.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface AlertEventHandler extends EventHandler {
	public void showDialog(String caption, String text);
}
