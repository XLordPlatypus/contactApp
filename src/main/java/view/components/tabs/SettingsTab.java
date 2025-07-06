package view.components.tabs;

import view.components.dialogues.ContactDialog;
import view.constants.ViewConstants;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

/**
 * The type Settings tab.
 */
public class SettingsTab extends JPanel {
    private JList list = new JList();

    /**
     * Instantiates a new Settings tab.
     *
     * @param dialog the dialog
     */
    public SettingsTab(ContactDialog dialog) {
        this.setBackground(ViewConstants.DARK_COLOR_LAYER_6);
        this.setForeground(Color.WHITE);
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement(ViewConstants.PRIVATE_INFO_TAB_TITLE);
        listModel.addElement(ViewConstants.BUSINESS_INFO_TAB_TITLE);
        listModel.addElement(ViewConstants.SOCIAL_INFO_TAB_TITLE);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setModel(listModel);

        dialog.createDeleteButton(this);

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedValue = (String) list.getSelectedValue();
                switch (selectedValue) {
                    case ViewConstants.PRIVATE_INFO_TAB_TITLE:
                        dialog.addTab(selectedValue, new PrivateInfoTab(UUID.randomUUID(), ViewConstants.TAB_WIDTH, ViewConstants.TAB_HEIGHT, dialog));
                        break;
                    case ViewConstants.BUSINESS_INFO_TAB_TITLE:
                        dialog.addTab(selectedValue, new BusinessInfoTab(UUID.randomUUID(), ViewConstants.TAB_WIDTH, ViewConstants.TAB_HEIGHT, dialog));
                        break;
                    case ViewConstants.SOCIAL_INFO_TAB_TITLE:
                        dialog.addTab(selectedValue, new SocialMediaTab(UUID.randomUUID(), ViewConstants.TAB_WIDTH, ViewConstants.TAB_HEIGHT, dialog));
                        break;
                }
            }
        });
        this.add(list);
    }
}
