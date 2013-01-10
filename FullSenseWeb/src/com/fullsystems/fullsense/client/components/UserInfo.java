package com.fullsystems.fullsense.client.components;



import java.util.ArrayList;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.fx.Draggable;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.AnchorLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.fullsystems.fullsense.client.FullSenseService;
import com.fullsystems.fullsense.client.FullSenseServiceAsync;
import com.fullsystems.fullsense.client.utility.FullSenseNames;
import com.fullsystems.fullsense.client.utility.RoleID;
import com.fullsystems.fullsense.client.utility.Service;
import com.fullsystems.fullsense.client.utility.ServiceID;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.extjs.gxt.ui.client.widget.Window;  

public class UserInfo extends LayoutContainer {

	private ArrayList<EventListener>    listeners;
	
	private ContentPanel panel;
	
	private final FullSenseServiceAsync fullsenseservice = FullSenseService.Util.getInstance();
	
	private int w = 200;
	private int h = 200;
	
	private int windw = 0;
	private int windh = 0;
	
	public UserInfo(int w, int h){
		this.listeners = new ArrayList<EventListener>();
		this.windw = w;
		this.windh = h;
	}
	
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		setLayout(new FlowLayout(10));
		final Window complex = new Window();  
		complex.setMaximizable(false);
		complex.setMinimizable(false);
		complex.setCollapsible(true);
		complex.setClosable(false);
		complex.setResizable(false);
		complex.setIconStyle("user_icon");
		complex.setHeading("User Information");  
		complex.setWidth(w);  
		complex.setHeight(h);
		
		complex.setPagePosition(windw-w-5,5);
		
		Text username = new Text();
		username.setText("Sou o Teste");
		complex.add(username);
		
		Text ultimologin = new Text();
		ultimologin.setText("15/12/2009 15:45");
		complex.add(ultimologin);
		Button logoutbutton = new Button();
		logoutbutton.setText("Logout");
		logoutbutton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			
			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				fullsenseservice.Logout(new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-g
						
					}

					@Override
					public void onSuccess(Boolean result) {
						// TODO Auto-generated method stub
						onClicked();
						
					}
				});
			}
		});
        complex.add(logoutbutton);
		/*
		ContentPanel cp = new ContentPanel();  
		cp.setCollapsible(true);  
		cp.setBodyStyle("padding: 4 8px;fontSize: 12px");  
		cp.setHeading("User Information");    
		cp.addText("Drags can only be started from the header.");  
		cp.setWidth(200);  
		add(cp);
		Draggable d = new Draggable(cp, cp.getHeader());  
		d.setContainer(this);  
		d.setUseProxy(false);*/  
				
		complex.show();
	}
	public void addClickHandler(EventListener listener)
    {
        listeners.add(listener);
    }

    public void removeClickHandler(EventListener listener)
    {
        listeners.remove(listener);
    }

    public void onClicked()
    {
        for (EventListener it : listeners)
        {
        	it.onBrowserEvent(null);
        }
    }
}
