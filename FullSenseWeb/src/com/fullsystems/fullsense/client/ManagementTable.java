package com.fullsystems.fullsense.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ManagementTable extends Composite {
    Panel       _panel;
    Panel       _header;
    Panel       _footer;
    FlexTable   _contentTable;
    PushButton  _addButton;
    PushButton  _remButton;
    SuggestBox  _searchBox;
    InputDialog _dialogBox;
    FlexTable   _inputLayout;

    ManagementTable(String caption, String... columns) {
        _dialogBox = new InputDialog(caption, columns);
        _panel = new VerticalPanel();
        _header = new HorizontalPanel();
        _addButton = new PushButton("Add new", new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                _dialogBox.center();
                _dialogBox.show();
            }
        });

        _remButton = new PushButton("Remove selected", new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                CheckBox cb;
                for (int r = _contentTable.getRowCount(); r > 1; r--) {
                    cb = (CheckBox) _contentTable.getWidget(r - 1, 0);
                    if (cb.getValue()) {
                        _contentTable.removeRow(r - 1);
                    }
                }

                if (_contentTable.getRowCount() < 2) {
                    _remButton.setEnabled(false);
                    cb = ((CheckBox) _contentTable.getWidget(0, 0));
                    cb.setValue(false);
                    cb.setEnabled(false);
                }
            }
        });

        _remButton.setEnabled(false);
        _searchBox = new SuggestBox();
        _header.add(_addButton);
        _header.add(_remButton);
        _header.add(_searchBox);
        _panel.add(_header);

        int c = 0;
        _contentTable = new FlexTable();
        // _contentTable.setBorderWidth(1);
        final CheckBox chkBox = new CheckBox();
        chkBox.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                setSelection(chkBox.getValue());

            }
        });

        chkBox.setEnabled(false);
        _contentTable.setWidget(0, c++, chkBox);
        for (String s : columns) {
            _contentTable.setWidget(0, c++, new HTML(s));
        }
        _panel.add(_contentTable);

        initWidget(_panel);
    }

    private class InputDialog extends DialogBox {
        FlexTable table = new FlexTable();

        InputDialog(String caption, String... fields) {
            VerticalPanel panel = new VerticalPanel();
            HorizontalPanel footer = new HorizontalPanel();
            final Label warning = new Label(caption + " already exists.");
            warning.setVisible(false);

            Button save = new Button("Save", new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    int row = _contentTable.getRowCount();

                    if (!exists(1, ((TextBox) table.getWidget(0, 1)).getText())) {
                        TextBox tb;
                        _contentTable.setWidget(row, 0, new CheckBox());
                        for (int i = 0; i < table.getRowCount(); i++) {
                            tb = (TextBox) table.getWidget(i, 1);
                            _contentTable.setText(row, i + 1, tb.getText());
                        }
                        ((CheckBox) _contentTable.getWidget(0, 0))
                                .setEnabled(true);
                        _remButton.setEnabled(true);
                        warning.setVisible(false);
                        clearInput();
                        hide();
                    } else {
                        warning.setVisible(true);
                    }

                }
            });

            Button cancel = new Button("Cancel", new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    clearInput();
                    hide();
                }
            });

            int row = 0;
            TextBox tb;
            for (String s : fields) {
                tb = new TextBox();
                table.setText(row, 0, s);
                table.setWidget(row++, 1, tb);
            }

            panel.add(table);
            panel.add(warning);
            panel.add(footer);
            footer.add(save);
            footer.add(cancel);

            setText(caption);
            setWidget(panel);
        }

        private void clearInput() {
            TextBox tb;
            for (Object o : table) {
                if (o instanceof TextBox) {
                    tb = (TextBox) o;
                    tb.setText("");
                }
            }
        }

    }

    private boolean exists(int c, String id) {
        boolean found = false;
        int r = 1;

        try {
            while (!found && r < _contentTable.getRowCount()) {
                found = _contentTable.getText(r++, c).equalsIgnoreCase(id);
            }
        } finally {
        }

        return found;
    }

    private void setSelection(boolean value) {
        try {
            CheckBox cb;
            for (int r = 1; r < _contentTable.getRowCount(); r++) {
                cb = (CheckBox) _contentTable.getWidget(r, 0);
                cb.setValue(value);
            }
        } finally {
        }
    }
}
