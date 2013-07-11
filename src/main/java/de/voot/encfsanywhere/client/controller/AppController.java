package de.voot.encfsanywhere.client.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

import de.voot.encfsanywhere.client.HistoryItems;
import de.voot.encfsanywhere.client.gin.Injector;
import de.voot.encfsanywhere.client.gin.InjectorHolder;

public class AppController implements Controller {

	private static final Logger LOG = Logger.getLogger("ListController");

	private Injector injector = InjectorHolder.getInjector();
	private HasWidgets container;

	@Override
	public void init(HasWidgets container) {
		this.container = container;

		bind();
		initControllers();

		if ("".equals(History.getToken())) {
			History.newItem(HistoryItems.STORAGE_AUTO_CONNECT);
		} else {
			History.fireCurrentHistoryState();
		}
	}

	private void bind() {
		History.addValueChangeHandler(this);
	}

	private void initControllers() {
		LOG.log(Level.INFO, "Initializing controllers");

		Controller[] controllers = new Controller[] { injector.getStorageConnectController(), injector.getAlertController(), injector.getListController(),
				injector.getUiSugarController() };
		for (Controller controller : controllers) {
			controller.init(container);
		}
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {

	}

}
