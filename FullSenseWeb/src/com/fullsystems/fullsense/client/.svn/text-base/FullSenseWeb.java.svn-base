package com.fullsystems.fullsense.client;


import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Date;

import com.extjs.gxt.themes.client.Slate;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.util.ThemeManager;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.fullsystems.fullsense.client.components.AccordionEventListener;
import com.fullsystems.fullsense.client.components.AccordionMenu;
import com.fullsystems.fullsense.client.components.UserInfo;
import com.fullsystems.fullsense.client.roles.RoleClassTest;
import com.fullsystems.fullsense.client.utility.FullSenseNames;
import com.fullsystems.fullsense.client.utility.RoleID;
import com.fullsystems.fullsense.client.utility.Service;
import com.fullsystems.fullsense.client.utility.ServiceID;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker; 

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FullSenseWeb implements EntryPoint,EventListener {
	private final FullSenseServiceAsync fullsenseservice = FullSenseService.Util.getInstance();


	
	private Button clickMeButton;
	private TreeMap<RoleID,ArrayList<ServiceID>> mapRoleService;
	private TreeMap<ServiceID,Service> mapIDService;
	public void onModuleLoad() {
		staticFields();
		loadServices(RoleID.User);
		//ThemeManager.register(Slate.SLATE);
		//GXT.setDefaultTheme(Slate.SLATE, true);
		
		final VerticalPanel loginPanel = new VerticalPanel();
        final VerticalPanel layout = new VerticalPanel();
        
        

        layout.setSize("800px", "600px");
        layout.setBorderWidth(0);
        
        //LUIS ESTE CODIGO TEM DE FICAR ASSIM PARA INICIAR O USERINFO
        
        //inicio
        UserInfo userinfo = new UserInfo(Window.getClientWidth(),Window.getClientHeight());
        userinfo.addClickHandler(new EventListener() {
			
			@Override
			public void onBrowserEvent(Event event) {
				// TODO Auto-generated method stub
				Window.open(GWT.getHostPageBaseURL()+"FullSenseLogin.jsp", "_self",
				"");
			}
		});
        layout.add(userinfo);
        //fim

        // Header
        HorizontalPanel header = new HorizontalPanel();
        Image fsLogo = new Image();
        fsLogo.setTitle("Full Sense");
        fsLogo.setUrl("images/fullsense.png");
        header.add(fsLogo);
        
        
        //header.setCellHorizontalAlignment(logoutbutton,
          //      HasHorizontalAlignment.ALIGN_RIGHT);
        layout.add(header);
        layout.setCellVerticalAlignment(fsLogo, HasVerticalAlignment.ALIGN_TOP);
        layout.setCellHeight(fsLogo, "100px");
        
        //TESTES AccordionMenu
        
        
        ArrayList<Service> services = new ArrayList<Service>(mapIDService.values());
        
        
        AccordionMenu panel = new AccordionMenu(services);
        panel.addClickHandler(new AccordionEventListener() {
			
			@Override
			public void onBrowserEvent(Event event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void OnAccordionClickEvent(ServiceID id) {
				// TODO Auto-generated method stub
				Info.display("DEBUGING",FullSenseNames.getServiceName(id));
			}
		});
        /*
        
        ContentPanel panel = new ContentPanel();
        panel.setHeading("FullSense");
        panel.setBodyBorder(false);
        panel.setLayout(new AccordionLayout());
        
        
        
        ContentPanel cp = new ContentPanel();  
        cp.setAnimCollapse(false);  
        cp.setHeading("Administration");  
        cp.setLayout(new FitLayout());  
        
        
        Button bt = new Button("Teste1");
        Button bt1 = new Button("Teste2");
        
        ContentPanel cp2 = new ContentPanel();
        
        
        
        cp2.add(bt);
        cp2.add(bt1);
        
        cp.add(cp2);
        
        panel.add(cp);
        
        cp = new ContentPanel();  
        cp.setAnimCollapse(false);  
        cp.setHeading("Resources Manager");  
        cp.setLayout(new FitLayout());  
        panel.add(cp); 
        
        panel.setSize(200, 325); 
        */
        
        
        VerticalPanel content = new VerticalPanel();
        
        HorizontalPanel body = new HorizontalPanel();
        
        // Content
        TabPanel tabs = new TabPanel();

        /***********************
         * Request Resources
         ***********************/
        Panel resources = new VerticalPanel();
        resources.add(new Label("Select resource:"));
        ListBox lbResource = new ListBox();
        lbResource.addItem("");
        lbResource.addItem("#RES001");
        lbResource.addItem("#RES002");
        resources.add(lbResource);
        HorizontalPanel dates = new HorizontalPanel();
        dates.setSpacing(1);
        VerticalPanel from = new VerticalPanel();
        VerticalPanel to = new VerticalPanel();
        dates.add(from);
        dates.add(to);
        Label lblFrom = new Label("From:");
        from.add(lblFrom);
        DatePicker datePickerFrom = new DatePicker();
        from.add(datePickerFrom);
        final Label textFrom = new Label();
        from.add(textFrom);
        // Set the value in the text box when the user selects a date
        datePickerFrom.addValueChangeHandler(new ValueChangeHandler<Date>() {
            public void onValueChange(ValueChangeEvent<Date> event) {
                Date date = event.getValue();
                String dateString = DateTimeFormat.getMediumDateFormat()
                        .format(date);
                textFrom.setText(dateString);
            }
        });

        // Set the default value
        datePickerFrom.setValue(new Date(), true);

        Label lblTo = new Label("To:");
        to.add(lblTo);
        DatePicker datePickerTo = new DatePicker();
        to.add(datePickerTo);
        final Label textTo = new Label();
        to.add(textTo);

        // Set the value in the text box when the user selects a date
        datePickerTo.addValueChangeHandler(new ValueChangeHandler<Date>() {
            public void onValueChange(ValueChangeEvent<Date> event) {
                Date date = event.getValue();
                String dateString = DateTimeFormat.getMediumDateFormat()
                        .format(date);
                textTo.setText(dateString);
            }
        });

        // Set the default value
        datePickerTo.setValue(new Date(), true);

        resources.add(dates);

        resources.add(new Button("Request"));

        /***********************
         * Reporting
         ***********************/
        Panel reporting = new VerticalPanel();
        reporting.add(new Label("Select report:"));
        final FlexTable report = new FlexTable();
        final ListBox lb = new ListBox();
        lb.addItem("");
        lb.addItem("My currently requested resources");
        lb.addItem("Who has viewed my logs");
        lb.addChangeHandler(new ChangeHandler() {

            @Override
            public void onChange(ChangeEvent event) {
                String[][] data = new String[5][4];

                switch (lb.getSelectedIndex()) {
                    case 1:
                        data[0][0] = "Resource Id";
                        data[0][1] = "From";
                        data[0][2] = "To";
                        data[1][0] = "#RES001";
                        data[1][1] = "01/12/2009 08:30:00";
                        data[1][2] = "01/12/2009 10:30:00";
                        data[2][0] = "#RES002";
                        data[2][1] = "01/12/2009 08:30:00";
                        data[2][2] = "01/12/2009 10:30:00";
                        data[3][0] = "#RES005";
                        data[3][1] = "05/12/2009 12:30:00";
                        data[3][2] = "06/12/2009 18:30:00";
                        break;
                    case 2:
                        data[0][0] = "Login";
                        data[0][1] = "Name";
                        data[0][2] = "When";
                        data[1][0] = "pvp";
                        data[1][1] = "Pedro Pinto";
                        data[1][2] = "05/12/2009 12:30:00";
                        data[2][0] = "rss";
                        data[2][1] = "Ricardo Santos Silva";
                        data[2][2] = "07/12/2009 10:00:00";
                        data[3][0] = "lc";
                        data[3][1] = "Luis Claro";
                        data[3][2] = "07/12/2009 09:57:00";
                        data[4][0] = "al";
                        data[4][1] = "Alberto Gomes";
                        data[4][2] = "07/12/2009 09:00:00";
                        break;
                    default:
                        break;
                }

                for (int row = 0; row < data.length; row++) {
                    for (int column = 0; column < data[row].length; column++) {
                        report.setText(row, column, data[row][column]);
                    }
                }
            }
        });

        reporting.add(lb);
        reporting.add(report);

        /***********************
         * Resource Management
         ***********************/
        Panel administration = new VerticalPanel();
        tabs.add(resources, "Request Resource");
        tabs.add(reporting, "Reporting");
        tabs.add(administration, "Resource Management");
        tabs.selectTab(2);
        
        content.add(tabs);
        content.setCellVerticalAlignment(tabs, HasVerticalAlignment.ALIGN_TOP);
        content.setCellHeight(tabs, "450px");
        
        body.add(panel);
        body.add(content);
        
        layout.add(body);
        //layout.setCellVerticalAlignment(tabs, HasVerticalAlignment.ALIGN_TOP);
        //layout.setCellHeight(tabs, "450px");
        tabs.setSize("100%", "100%");
        administration.add(new ResourceManagementBox("User", "Login", "Name"));
        administration.add(new ResourceManagementBox("Resource", "Id", "Name",
                "Type"));

        // Footer
        HTML footer = new HTML("2009, Full Systems");
        layout.add(footer);
        layout.setCellHorizontalAlignment(footer,
                HasHorizontalAlignment.ALIGN_CENTER);
        layout.setCellVerticalAlignment(footer, HasVerticalAlignment.ALIGN_TOP);
        layout.setCellHeight(footer, "50px");

        RootPanel.get("rootpanelweb").add(layout);

        // RootPanel.get("container").add(layout);
    }

    @Override
    public void onBrowserEvent(Event event) {
        // TODO Auto-generated method stub
    }
    
    private void staticFields() {
    	mapRoleService = new TreeMap<RoleID,ArrayList<ServiceID>>();
    	ArrayList<ServiceID> aSI = new ArrayList<ServiceID>();
    	aSI.add(ServiceID.ChangeUserInfo);
    	aSI.add(ServiceID.CheckyourLog);
    	aSI.add(ServiceID.RequestResource);
    	
    	mapRoleService.put(RoleID.User, aSI);
    	aSI = new ArrayList<ServiceID>();
    	aSI.add(ServiceID.ChangeUserInfo);
    	aSI.add(ServiceID.CheckyourLog);
    	aSI.add(ServiceID.RequestResource);
    	aSI.add(ServiceID.FindResource);
    	aSI.add(ServiceID.RentResource);
    	aSI.add(ServiceID.EndofResourceRenting);
    	aSI.add(ServiceID.RemoveResource);
    	aSI.add(ServiceID.NewResourceRegistration);
    	mapRoleService.put(RoleID.ResourcesManager, aSI);
    	
    	aSI = new ArrayList<ServiceID>();
    	aSI.add(ServiceID.ChangeUserInfo);
    	aSI.add(ServiceID.CheckyourLog);
    	aSI.add(ServiceID.RequestResource);
    	aSI.add(ServiceID.NewUserRegistration);
    	aSI.add(ServiceID.NewTemporaryUserRegistration);
    	aSI.add(ServiceID.RemoveTemporaryUser);
    	aSI.add(ServiceID.RemoveUser);
    	
    	mapRoleService.put(RoleID.HumanManager, aSI);
    	aSI = new ArrayList<ServiceID>();
    	aSI.add(ServiceID.ChangeUserInfo);
    	aSI.add(ServiceID.CheckyourLog);
   	aSI.add(ServiceID.RequestResource);
    	aSI.add(ServiceID.NewUserRegistration);
    	aSI.add(ServiceID.NewTemporaryUserRegistration);
    	aSI.add(ServiceID.RemoveTemporaryUser);
    	aSI.add(ServiceID.RemoveUser);
    	aSI.add(ServiceID.FindResource);
    	aSI.add(ServiceID.RentResource);
    	aSI.add(ServiceID.EndofResourceRenting);
    	aSI.add(ServiceID.RemoveResource);
    	aSI.add(ServiceID.NewResourceRegistration);
    	aSI.add(ServiceID.ViewLog);
    	aSI.add(ServiceID.ViewRegister);
    	aSI.add(ServiceID.ExportLog);
    	
    	mapRoleService.put(RoleID.LogsManager, aSI);
    }
    
    public Service createService(ServiceID sid) {
    	switch(sid){
    	case ChangeUserInfo:
    		RoleClassTest t = new RoleClassTest();
    		return (Service)t;
    	}
    	return null;
    }
    
    private void loadServices(RoleID rID) {
    	mapIDService = new TreeMap<ServiceID, Service>();
    	for(ServiceID sid: this.mapRoleService.get(rID)){
    		Service s = createService(sid);
    		if(s!=null)
    			mapIDService.put(sid, s);
    	}
    }

}

