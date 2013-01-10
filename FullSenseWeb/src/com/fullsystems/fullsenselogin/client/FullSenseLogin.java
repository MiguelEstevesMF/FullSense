package com.fullsystems.fullsenselogin.client;

import java.util.Date;

import com.extjs.gxt.themes.client.Slate;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.util.ThemeManager;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FullSenseLogin implements EntryPoint {
	private final FullSenseLoginServiceAsync fullsenseservice = FullSenseLoginService.Util
			.getInstance();

	public void onModuleLoad() {
		//ThemeManager.register(Slate.SLATE);
		//GXT.setDefaultTheme(Slate.SLATE, true);
		
		RootPanel rootPanel = RootPanel.get("rootpanellogin");

		final Login login = new Login();

		login.addLoginHandler(new EventListener() {

			@Override
			public void onBrowserEvent(Event event) {
				// TODO Auto-generated method stub
				fullsenseservice.Authentication(login.getUsername(), login
						.getPassword(), login.getRememberLogin(),
						new AsyncCallback<Boolean>() {

							@Override
							public void onSuccess(Boolean result) {
								if (result) {
									if (login.getRememberLogin()) {
										fullsenseservice
												.GetSessionID(new AsyncCallback<String>() {

													@Override
													public void onFailure(
															Throwable caught) {
														// TODO Auto-generated
														// method stub

													}

													@Override
													public void onSuccess(
															String result) {
														// TODO Auto-generated
														// method stub
														final long DURATION = 1000*3600*24*365; 
														Date expires = new Date(
																System
																		.currentTimeMillis()
																		+ DURATION);
														Cookies.setCookie(
																"JSESSIONID",
																result,
																expires, null,
																"/", false);
													}
												});
									}
									Window.open(GWT.getHostPageBaseURL()+"FullSenseWeb.jsp", "_self",
											"");
								} else
									Info.display("Error",
											"Login or Password incorrect");
							}

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								Window.alert("ERRO");
							}
						});
			}

		});
		rootPanel.add(login);
	}
}
