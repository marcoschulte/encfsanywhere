package de.voot.encfsanywhere.client.gin;

import com.google.gwt.event.shared.HandlerManager;
import com.google.inject.Provider;

public class HandlerManagerProvider implements Provider<HandlerManager> {

	@Override
	public HandlerManager get() {
		return new HandlerManager(null);
	}

}
