package com.fullsystems.fullsenselogin.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("FullSenseLoginService")
public interface FullSenseLoginService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static FullSenseLoginServiceAsync instance;
		public static FullSenseLoginServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(FullSenseLoginService.class);
			}
			return instance;
		}
	}
	
	public boolean IsAuthenticated();
	public boolean Authentication(String username,String password, boolean rememberlogin);
	public String GetSessionID();
	
}
