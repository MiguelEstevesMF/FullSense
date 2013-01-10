package com.fullsystems.fullsense.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InputDialog extends DialogBox {
    // private FlexTable _parent;
    // private Panel _panel = new VerticalPanel();
    // private FlexTable _content;
    // private Panel _footer;
    // private Button _save;
    // private Button _cancel;

    InputDialog(final FlexTable parent, String caption, String... fields) {
        VerticalPanel panel = new VerticalPanel();
        final FlexTable table = new FlexTable();
        HorizontalPanel footer = new HorizontalPanel();
        Label warning = new Label(caption + " already exists.");
        warning.setVisible(false);
        Button save = new Button("Save", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                int row = parent.getRowCount() + 1;

                TextBox tb;
                for (int i = 0; i < table.getRowCount(); i++) {
                    tb = (TextBox) table.getWidget(i, 1);
                    parent.setText(row, i, tb.getText());
                }

            }
        });

        Button cancel = new Button("Cancel", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                table.clear();
//                TextBox tb;
//                for (int i = 0; i < table.getRowCount(); i++) {
//                    tb = (TextBox) table.getWidget(i, 1);
//                    tb.setText("");
//                }

                InputDialog.this.hide();
            }
        });

        int row = 0;
        for (String s : fields) {
            table.setText(row, 0, s);
            table.setWidget(row++, 1, new TextBox());
        }

        ((TextBox) table.getWidget(0, 1)).setFocus(true);

        panel.add(table);
        panel.add(footer);
        footer.add(save);
        footer.add(cancel);

        setText(caption);
        setWidget(panel);
    }
}
