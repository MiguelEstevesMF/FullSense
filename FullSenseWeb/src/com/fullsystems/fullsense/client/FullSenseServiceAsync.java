package com.fullsystems.fullsense.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FullSenseServiceAsync {
	
	
	public void Logout(AsyncCallback<Boolean> callback);
	public void IsAuthenticated(AsyncCallback<Boolean> callback);
	public void Authentication(String username,String password, boolean rememberlogin, AsyncCallback<Boolean> callback);
	public void Redirect(AsyncCallback<Void> callback);
	public void GetSessionID(AsyncCallback<String> callback);
	
}
