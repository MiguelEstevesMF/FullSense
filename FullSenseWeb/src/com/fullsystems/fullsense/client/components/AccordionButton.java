package com.fullsystems.fullsense.client.components;

import com.extjs.gxt.ui.client.widget.button.Button;
import com.fullsystems.fullsense.client.utility.ServiceID;

public class AccordionButton extends Button {

	private ServiceID service;
	

	public ServiceID getService() {
		return service;
	}

	public void setService(ServiceID service) {
		this.service = service;
	}
	
	
	
}
