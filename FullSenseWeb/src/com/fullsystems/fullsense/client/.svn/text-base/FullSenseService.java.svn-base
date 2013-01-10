package com.fullsystems.fullsense.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("FullSenseService")
public interface FullSenseService extends RemoteService {
	
	
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static FullSenseServiceAsync instance;
		public static FullSenseServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(FullSenseService.class);
			}
			return instance;
		}
	}
	
	public boolean Logout();
	public boolean IsAuthenticated();
	public boolean Authentication(String username,String password, boolean rememberlogin);
	public void Redirect();
	public String GetSessionID();
	
}
