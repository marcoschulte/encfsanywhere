package de.voot.encfsanywhere.client.controller;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

import de.voot.encfsanywhere.client.event.AsyncCallFinishedEvent;
import de.voot.encfsanywhere.client.event.AsyncCallFinishedEventHandler;
import de.voot.encfsanywhere.client.event.AsyncCallStartedEvent;
import de.voot.encfsanywhere.client.event.AsyncCallStartedEventHandler;
import de.voot.encfsanywhere.client.gin.Injector;
import de.voot.encfsanywhere.client.gin.InjectorHolder;
import de.voot.encfsanywhere.client.view.util.UIUtil;

public class UISugarController implements Controller {
	private Injector injector = InjectorHolder.getInjector();
	private HandlerManager eventBus = injector.getHandlerManager();

	private int asyncCallsPlaced = 0;

	@Override
	public void init(HasWidgets container) {
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(AsyncCallStartedEvent.TYPE, new AsyncCallStartedEventHandler() {
			@Override
			public void handle() {
				if (asyncCallsPlaced == 0) {
					UIUtil.showLoadingAnimation();
				}
				asyncCallsPlaced++;
			}
		});

		eventBus.addHandler(AsyncCallFinishedEvent.TYPE, new AsyncCallFinishedEventHandler() {
			@Override
			public void handle() {
				asyncCallsPlaced--;
				if (asyncCallsPlaced == 0) {
					UIUtil.hideLoadingAnimation();
				}
			}
		});

	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
	}
}
