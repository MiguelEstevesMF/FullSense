package com.fullsystems.fullsense.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HTML;

public class ResourceManagementBox extends Composite {

    public ResourceManagementBox(String caption, String... columns) {
        DisclosurePanel panel = new DisclosurePanel();
        panel.setHeader(new HTML(caption));
        panel.setContent(new ManagementTable(caption, columns));

        initWidget(panel);
    }

}
