package de.voot.encfsanywhere.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AsyncCallStartedEvent extends GwtEvent<AsyncCallStartedEventHandler> {
	public static Type<AsyncCallStartedEventHandler> TYPE = new Type<AsyncCallStartedEventHandler>();

	@Override
	public Type<AsyncCallStartedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AsyncCallStartedEventHandler handler) {
		handler.handle();
	}

}
