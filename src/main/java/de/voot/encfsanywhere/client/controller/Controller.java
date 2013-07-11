package de.voot.encfsanywhere.client.controller;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public interface Controller extends ValueChangeHandler<String> {
	public void init(HasWidgets container);
}
