package de.voot.encfsanywhere.client.event;

import com.google.gwt.event.shared.EventHandler;

import de.voot.dropboxgwt.client.DropboxWrapper;

public interface DropboxConnectedEventHandler extends EventHandler {
	public void onDropboxConnected(DropboxWrapper dropboxWrapper);
}
