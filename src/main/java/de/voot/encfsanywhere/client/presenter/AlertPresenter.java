package de.voot.encfsanywhere.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;
import de.voot.encfsanywhere.client.gin.InjectorHolder;
import de.voot.encfsanywhere.client.view.View;

public class AlertPresenter implements Presenter {

	public interface AlertWidget extends View<AlertPresenter> {
		public void show(String caption, String text);
	}

	private HasWidgets container;
	private AlertWidget widget = InjectorHolder.getInjector().getAlertWidget();

	@Override
	public void go(HasWidgets container) {
		this.container = container;
		widget.setPresenter(this);
	}

	public void show(String caption, String text) {
		widget.show(caption, text);
		container.add(widget.asWidget());
	}

	public void onHideButtonClicked() {
		container.remove(widget.asWidget());
	}

}
