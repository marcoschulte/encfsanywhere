package de.voot.encfsanywhere.client.gin;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import de.voot.dropboxgwt.client.DropboxWrapper;
import de.voot.encfsanywhere.client.controller.AlertController;
import de.voot.encfsanywhere.client.controller.ListController;
import de.voot.encfsanywhere.client.controller.StorageConnectController;
import de.voot.encfsanywhere.client.controller.UISugarController;
import de.voot.encfsanywhere.client.presenter.AlertPresenter;
import de.voot.encfsanywhere.client.presenter.ListPresenter;
import de.voot.encfsanywhere.client.presenter.StorageConnectPresenter;
import de.voot.encfsanywhere.client.presenter.AlertPresenter.AlertWidget;
import de.voot.encfsanywhere.client.presenter.ListPresenter.ListView;
import de.voot.encfsanywhere.client.presenter.StorageConnectPresenter.StorageConnectView;

@GinModules(GinModule.class)
public interface Injector extends Ginjector {

	public HandlerManager getHandlerManager();

	public DropboxWrapper getDropboxWrapper();

	public UISugarController getUiSugarController();

	public StorageConnectPresenter getStorageConnectPresenter();

	public StorageConnectView getStorageConnectView();

	public StorageConnectController getStorageConnectController();


	public ListController getListController();

	public ListView getListView();

	public ListPresenter getListPresenter();

	public AlertWidget getAlertWidget();

	public AlertController getAlertController();

	public AlertPresenter getAlertPresenter();

}
