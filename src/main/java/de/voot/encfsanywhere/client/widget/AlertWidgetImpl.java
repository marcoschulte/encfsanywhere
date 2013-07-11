package de.voot.encfsanywhere.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import de.voot.encfsanywhere.client.presenter.AlertPresenter;
import de.voot.encfsanywhere.client.presenter.AlertPresenter.AlertWidget;

public class AlertWidgetImpl extends Composite implements AlertWidget {

	private static AlertWidgetImplUiBinder uiBinder = GWT.create(AlertWidgetImplUiBinder.class);

	interface AlertWidgetImplUiBinder extends UiBinder<Widget, AlertWidgetImpl> {
	}

	private AlertPresenter presenter;

	@UiField
	HeadingElement caption;
	@UiField
	Label text;
	@UiField
	Button closeButton;

	public AlertWidgetImpl() {
		initWidget(uiBinder.createAndBindUi(this));

		closeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.onHideButtonClicked();
			}
		});
	}

	@Override
	public void setPresenter(AlertPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void show(String caption, String text) {
		this.caption.setInnerText(caption);
		this.text.setText(text);
	}

}
