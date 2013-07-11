package de.voot.encfsanywhere.client.gin;

import com.google.gwt.core.client.GWT;

public class InjectorHolder {

	private static final Injector injector = GWT.create(Injector.class);

	private InjectorHolder() {
	}

	public static Injector getInjector() {
		return injector;
	}
}
