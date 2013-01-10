package com.fullsystems.fullsenselogin.client;

import java.util.ArrayList;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.layout.FormData;

public class Login extends Composite {
	
    
	private ArrayList<EventListener>    listeners;
    private TextField<String> textBoxUsername;
    private TextField<String> password;
    
    private VerticalPanel vp;
	private CheckBox chckbxRemember;
    
    
    public Login() {  
    	listeners    = new ArrayList<EventListener>();
    	vp = new VerticalPanel();
		initWidget(vp);
		
        FormPanel simple = new FormPanel();  
        simple.setHeading("FullSense Login");  
        simple.setFrame(true);  
        simple.setWidth(350);  
      
        textBoxUsername = new TextField<String>();  
        textBoxUsername.setFieldLabel("Name");  
        textBoxUsername.setAllowBlank(false);  
        simple.add(textBoxUsername);  
      
        password = new TextField<String>();  
        password.setFieldLabel("Password");  
        password.setAllowBlank(false); 
        password.setPassword(true);
        simple.add(password);  
        Button button = new Button("Reset");
        button.addSelectionListener(new SelectionListener<ButtonEvent>() {
        	public void componentSelected(ButtonEvent ce) {
        	}
        	public void handleEvent(ButtonEvent e) {
        		textBoxUsername.setValue("");
        		password.setValue("");
        		textBoxUsername.focus();
        	}
        });
        simple.addButton(button);  
      
        simple.setButtonAlign(HorizontalAlignment.CENTER);  
        
      
         Button b = new Button("Login");
         b.addSelectionListener(new SelectionListener<ButtonEvent>() {
         	public void componentSelected(ButtonEvent ce) {
         	}
         	public void handleEvent(ButtonEvent e) {
         		//Window.alert(password.getValue()+" "+textBoxUsername.getValue());
         		if (password.getValue()==null || textBoxUsername.getValue()==null) {
         			Info.display("Warning", "Username or password is empty");
         				
					}
				else
					onLogin();
         	}
         });
         
         simple.addButton(b);
         
         chckbxRemember = new CheckBox();
         simple.add(chckbxRemember, new FormData("100%"));
         chckbxRemember.setWidth("150px");
         chckbxRemember.setBoxLabel("Remember login");
         chckbxRemember.setHideLabel(true);
      
        vp.add(simple);  
      }  

	
	public void addLoginHandler(EventListener listener)
    {
        listeners.add(listener);
    }

    public void removeLoginHandler(EventListener listener)
    {
        listeners.remove(listener);
    }

    public void onLogin()
    {
        for (EventListener it : listeners)
        {
        	it.onBrowserEvent(null);
        }
    }
    
    public String getUsername(){
    	return textBoxUsername.getValue();
    }

    public String getPassword(){
    	return password.getValue();
    }
    
    public boolean getRememberLogin(){
    	return chckbxRemember.getValue();
    }
}
