package de.voot.encfsanywhere.client.presenter;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;

import de.voot.encfsanywhere.client.gin.Injector;
import de.voot.encfsanywhere.client.gin.InjectorHolder;
import de.voot.encfsanywhere.client.view.View;

public class StorageConnectPresenter implements Presenter {

	public interface StorageConnectView extends View<StorageConnectPresenter> {
		public HasValue<Boolean> rememberUserChecked();
	}

	private final Injector injector = InjectorHolder.getInjector();
	private final StorageConnectView view = injector.getStorageConnectView();

	public StorageConnectPresenter() {
		view.setPresenter(this);
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
	}

	public void onDropboxConnectButtonClicked() {
		Boolean rememberUser = view.rememberUserChecked().getValue();
		injector.getStorageConnectController().connectToDropbox(rememberUser);
	}

}
