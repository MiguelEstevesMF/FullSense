package com.fullsystems.fullsense.client.components;

import java.util.ArrayList;
import java.util.TreeMap;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.AnchorLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.fullsystems.fullsense.client.utility.FullSenseNames;
import com.fullsystems.fullsense.client.utility.RoleID;
import com.fullsystems.fullsense.client.utility.Service;
import com.fullsystems.fullsense.client.utility.ServiceID;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

public class AccordionMenu extends LayoutContainer {

	private ArrayList<Service> services;
	private TreeMap<RoleID, ContentPanel> panels;
	private ContentPanel panel;
	private ArrayList<AccordionEventListener>    listeners;

	public AccordionMenu(ArrayList<Service> services) {
		listeners = new ArrayList<AccordionEventListener>();
		this.services = new ArrayList<Service>();
		for (Service serv : services) {
			this.services.add(serv);
		}

		this.panels = new TreeMap<RoleID, ContentPanel>();
	}
	
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		setLayout(new FlowLayout(10));

		panel = new ContentPanel();
		panel.setHeading("FullSense Services");
		panel.setBodyBorder(false);
		panel.setLayout(new AccordionLayout());

		for (Service serv : this.services) {
			if (!this.panels.containsKey(serv.getRoleID())) {
				ContentPanel cp = new ContentPanel();
				cp.setAnimCollapse(true);
				cp.setHeading(FullSenseNames.getHeading(serv.getRoleID()));
				cp.setLayout(new AnchorLayout());
				this.panels.put(serv.getRoleID(), cp);
			}
			AccordionButton bt = new AccordionButton();
			bt.setText(FullSenseNames.getServiceName(serv.getServiceID()));
			bt.setService(serv.getServiceID());
			bt.setStyleAttribute("width", "100%");
			bt.addSelectionListener(new SelectionListener<ButtonEvent>() {
	         	public void componentSelected(ButtonEvent ce) {
	         	}
	         	public void handleEvent(ButtonEvent e) {
	         		onClick(((AccordionButton) e.getButton()).getService());	  
	         	}
	         });
			this.panels.get(serv.getRoleID()).add(bt);
		}

		if(this.panels.containsKey(RoleID.HumanManager)){
			panel.add(this.panels.get(RoleID.HumanManager));
		}
		if(this.panels.containsKey(RoleID.LogsManager)){
			panel.add(this.panels.get(RoleID.LogsManager));
		}
		if(this.panels.containsKey(RoleID.User)){
			panel.add(this.panels.get(RoleID.User));
		}
		if(this.panels.containsKey(RoleID.ResourcesManager)){
			panel.add(this.panels.get(RoleID.ResourcesManager));
		}
		
		panel.setSize(200, 325);

		add(panel);
	}

	
	public void addClickHandler(AccordionEventListener listener)
    {
        listeners.add(listener);
    }

    public void removeClickHandler(AccordionEventListener listener)
    {
        listeners.remove(listener);
    }

    public void onClick(ServiceID id)
    {
        for (AccordionEventListener it : listeners)
        {
        	it.OnAccordionClickEvent(id);
        }
    }
}
