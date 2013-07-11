package de.voot.encfsanywhere.client.controller;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;

import de.voot.encfsanywhere.client.event.AlertEvent;
import de.voot.encfsanywhere.client.event.AlertEventHandler;
import de.voot.encfsanywhere.client.gin.Injector;
import de.voot.encfsanywhere.client.gin.InjectorHolder;
import de.voot.encfsanywhere.client.presenter.AlertPresenter;

public class AlertController implements Controller {

	private Injector injector = InjectorHolder.getInjector();
	private HandlerManager eventBus = injector.getHandlerManager();
	private HasWidgets container;

	@Override
	public void init(HasWidgets container) {
		this.container = RootPanel.get("alertContainer");
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(AlertEvent.TYPE, new AlertEventHandler() {
			@Override
			public void showDialog(String caption, String text) {
				AlertPresenter alertPresenter = injector.getAlertPresenter();
				alertPresenter.go(container);
				alertPresenter.show(caption, text);
			}
		});
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {

	}

}
