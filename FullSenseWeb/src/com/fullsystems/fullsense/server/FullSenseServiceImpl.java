package com.fullsystems.fullsense.server;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.fullsystems.fullsense.client.FullSenseService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class FullSenseServiceImpl extends RemoteServiceServlet implements
		FullSenseService {

	// private User user;

	@Override
	public boolean Authentication(String username, String password, boolean rememberlogin) {
		// Authentication in the business layer; return User

		String userfromserver = "teste";
		String passwordfromserver = "teste";
		// for testing
		if (username.equals(userfromserver) && password.equals(passwordfromserver)) {
			HttpSession session = this.getThreadLocalRequest().getSession();
			session.setAttribute("authUser", username);
			if(rememberlogin)
				session.setMaxInactiveInterval(3600*24*365);
			//this.Redirect();
			return true;
		}
		return false;
	}

	@Override
	public boolean IsAuthenticated() {
		boolean res = false;
		res = this.getThreadLocalRequest().getSession()
				.getAttribute("authUser") != null;
		return res;
	}

	@Override
	public boolean Logout() {
		HttpSession session = this.getThreadLocalRequest().getSession();
		session.removeAttribute("authUser");
		session.invalidate();
		return true;
	}

	@Override
	public void Redirect() {
		//if (this.IsAuthenticated()) {
			try {
				System.out.println("fodase");
				this.getThreadLocalResponse().sendRedirect(
						"http://www.google.pt");
				System.out.println("HEHEHEHE");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}

	}

	@Override
	public String GetSessionID() {
		// TODO Auto-generated method stub
		if(IsAuthenticated())
			return this.getThreadLocalRequest().getSession().getId();
		return null;
	}



}
