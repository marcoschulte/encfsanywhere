package de.voot.encfsanywhere.client.event;

import com.google.gwt.event.shared.GwtEvent;

import de.voot.dropboxgwt.client.DropboxWrapper;

public class DropboxConnectedEvent extends GwtEvent<DropboxConnectedEventHandler> {
	public static Type<DropboxConnectedEventHandler> TYPE = new Type<DropboxConnectedEventHandler>();

	private DropboxWrapper dropboxWrapper;

	public DropboxConnectedEvent(DropboxWrapper dropboxWrapper) {
		this.dropboxWrapper = dropboxWrapper;
	}

	@Override
	public Type<DropboxConnectedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DropboxConnectedEventHandler handler) {
		handler.onDropboxConnected(dropboxWrapper);
	}

}
