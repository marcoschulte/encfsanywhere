package de.voot.encfsanywhere.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AlertEvent extends GwtEvent<AlertEventHandler> {
	public static Type<AlertEventHandler> TYPE = new Type<AlertEventHandler>();

	private String caption;
	private String text;

	public AlertEvent(String caption, String text) {
		this.caption = caption;
		this.text = text;
	}

	@Override
	public Type<AlertEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AlertEventHandler handler) {
		handler.showDialog(caption, text);
	}

}
