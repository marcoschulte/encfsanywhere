package de.voot.encfsanywhere.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AsyncCallFinishedEvent extends GwtEvent<AsyncCallFinishedEventHandler> {
	public static Type<AsyncCallFinishedEventHandler> TYPE = new Type<AsyncCallFinishedEventHandler>();

	@Override
	public Type<AsyncCallFinishedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AsyncCallFinishedEventHandler handler) {
		handler.handle();
	}

}
