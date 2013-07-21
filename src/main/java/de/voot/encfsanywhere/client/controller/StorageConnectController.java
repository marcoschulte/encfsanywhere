/*
  	Copyright (C) 2013 Marco Schulte

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.voot.encfsanywhere.client.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.Callback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

import de.voot.dropboxgwt.client.DropboxWrapper;
import de.voot.dropboxgwt.client.overlay.ApiError;
import de.voot.encfsanywhere.client.HistoryItems;
import de.voot.encfsanywhere.client.event.AsyncCallFinishedEvent;
import de.voot.encfsanywhere.client.event.AsyncCallStartedEvent;
import de.voot.encfsanywhere.client.event.DropboxConnectedEvent;
import de.voot.encfsanywhere.client.gin.Injector;
import de.voot.encfsanywhere.client.gin.InjectorHolder;

public class StorageConnectController implements Controller {

	private static final Logger LOG = Logger.getLogger("de.voot.encfsanywhere.client.controller.StorageConnectController");

	private Injector injector = InjectorHolder.getInjector();
	private HandlerManager eventBus = injector.getHandlerManager();
	private HasWidgets container;

	@Override
	public void init(HasWidgets container) {
		this.container = container;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			if (token.equals(HistoryItems.STORAGE_CONNECT)) {
				injector.getStorageConnectPresenter().go(container);
			} else if (token.startsWith(HistoryItems.STORAGE_AUTO_CONNECT)) {
				autoConnect();
			} else if (token.startsWith(HistoryItems.STORAGE_CONNECT_NO_REMEMBER)) {
				authDropbox(false);
			} else if (token.startsWith(HistoryItems.STORAGE_CONNECT_REMEMBER)) {
				authDropbox(true);
			}
		}
	}

	private void dropboxConnected(DropboxWrapper dropboxWrapper) {
		LOG.log(Level.INFO, "Connected to dropbox");
		eventBus.fireEvent(new DropboxConnectedEvent(dropboxWrapper));
		History.newItem(HistoryItems.LIST_PREFIX);
	}

	private void autoConnect() {
		LOG.log(Level.INFO, "Trying autoconnect");
		final DropboxWrapper dropboxWrapper = injector.getDropboxWrapper();
		dropboxWrapper.isAuthenticated(new Callback<Boolean, ApiError>() {
			@Override
			public void onFailure(ApiError reason) {
				LOG.log(Level.WARNING, "There was an error auto-reconnecting. Error is: " +  reason.getResponseText());
			}

			@Override
			public void onSuccess(Boolean result) {
				LOG.log(Level.INFO, "Autoconnect result: " + result);
				if (result) {
					dropboxConnected(dropboxWrapper);
				} else {
					History.newItem(HistoryItems.STORAGE_CONNECT);
				}
			}
		});
	}

	public void connectToDropbox(boolean rememberUser) {
		LOG.log(Level.INFO, "Starting new dropbox auth sequence. Remember set to: " + rememberUser);
		if (rememberUser) {
			History.newItem(HistoryItems.STORAGE_CONNECT_REMEMBER, false);
		} else {
			History.newItem(HistoryItems.STORAGE_CONNECT_NO_REMEMBER, false);
		}

		authDropbox(rememberUser);
	}

	private void authDropbox(boolean rememberUser) {
		LOG.log(Level.INFO, "Authing with dropbox. Saving oauth tokens: " + rememberUser);
		final DropboxWrapper dropboxWrapper = injector.getDropboxWrapper();

		eventBus.fireEvent(new AsyncCallStartedEvent());
		dropboxWrapper.authenticate(rememberUser, new Callback<Void, ApiError>() {
			@Override
			public void onSuccess(Void result) {
				eventBus.fireEvent(new AsyncCallFinishedEvent());
				dropboxConnected(dropboxWrapper);
			}

			@Override
			public void onFailure(ApiError reason) {
				LOG.log(Level.WARNING, "Couldn't connect to dropbox. Reason is: " + reason.getResponseText());
				eventBus.fireEvent(new AsyncCallFinishedEvent());
				History.newItem(HistoryItems.STORAGE_CONNECT);
			}
		});

	}

}
