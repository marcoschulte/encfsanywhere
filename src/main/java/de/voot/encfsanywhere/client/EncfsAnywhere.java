package de.voot.encfsanywhere.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import de.voot.encfsanywhere.client.controller.AppController;

public class EncfsAnywhere implements EntryPoint {

	private static final Logger LOG = Logger.getLogger("EncfsAnywhere");

	@Override
	public void onModuleLoad() {
		LOG.info("EncfsAnywhere loaded. Starting AppController.");

		AppController appController = new AppController();
		appController.init(RootPanel.get("content"));
	}

}
