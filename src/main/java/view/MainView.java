package view;

import controller.MainController;
import view.dtoHandler.contactDto.ContactDTO;
import view.dtoHandler.contactDto.ContactDTOList;
import model.observer.contactCreated.IContactCreatedObserver;
import model.observer.contactUpdated.IContactUpdatedObserver;
import view.components.contact.ContactButton;
import view.components.dialogues.ContactDialog;
import view.components.tabs.BaseInfoTab;
import view.constants.ViewConstants;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.UUID;

/**
 * The type Main view.
 */
public class MainView extends JFrame implements IContactCreatedObserver, IContactUpdatedObserver {
    private final JPanel navPanel;
    private final JPanel displayPanel;
    private JPanel contactPanel;
    private final JPanel actionBarPanel;
    private ContactDialog contactDialog;
    private JButton createButton;
    private int contactButtonCount = 0;
    private JTextField searchField;
    private JButton searchButton;
    private boolean isSearching = false;

    /**
     * Instantiates a new Main view.
     *
     * @param title       the title
     * @param frameWidth  the frame width
     * @param frameHeight the frame height
     */
    public MainView(String title, int frameWidth, int frameHeight) {
        this.setTitle(title);
        this.setSize(frameWidth, frameHeight);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ViewHelper.cleanupEmptyContacts();
                System.exit(200);
            }
        });
        this.setLayout(new BorderLayout());

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updatePanelSizes();
            }
        });

        MainController.getInstance().getContactCreatedNotifier().addObserver(this);
        MainController.getInstance().getContactUpdatedNotifier().addObserver(this);

        this.navPanel = new JPanel();
        this.navPanel.setLayout(new GridBagLayout());
        this.navPanel.setPreferredSize(new Dimension(ViewConstants.NAV_PANEL_WIDTH, ViewConstants.NAV_PANEL_HEIGHT));
        this.navPanel.setBackground(ViewConstants.DARK_COLOR_LAYER_4);

        this.contactPanel = new JPanel(new GridBagLayout());
        this.contactPanel.setBackground(ViewConstants.DARK_COLOR_LAYER_7);
        this.contactPanel.setPreferredSize(new Dimension(ViewConstants.CONTACT_PANEL_WIDTH, ViewConstants.CONTACT_PANEL_HEIGHT));

        JScrollPane scrollableContactPanel = new JScrollPane(this.contactPanel);
        scrollableContactPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollableContactPanel.setPreferredSize(new Dimension(ViewConstants.CONTACT_PANEL_WIDTH, 1000));

        this.actionBarPanel = new JPanel();
        this.actionBarPanel.setLayout(new BoxLayout(actionBarPanel, BoxLayout.Y_AXIS));
        this.actionBarPanel.add(this.navPanel);
        this.actionBarPanel.add(scrollableContactPanel);

        this.displayPanel = new JPanel(new BorderLayout());
        this.displayPanel.setPreferredSize(new Dimension(ViewConstants.DISPLAY_PANEL_WIDTH, ViewConstants.DISPLAY_PANEL_HEIGHT));
        this.displayPanel.setBackground(ViewConstants.DARK_COLOR_LAYER_6);

        this.getContentPane().add(BorderLayout.WEST, actionBarPanel);
        this.getContentPane().add(BorderLayout.EAST, this.displayPanel);

        setupNavButtons();
        updateContactButtons(MainController.getInstance().getAllContacts());



        this.displayPanel.revalidate();
        this.displayPanel.repaint();
        this.setVisible(true);
    }

    private void setupNavButtons() {
        searchButton = new JButton(ViewConstants.SEARCH_ICON);
        searchButton.setPreferredSize(new Dimension(ViewConstants.NAV_BUTTON_WIDTH, ViewConstants.NAV_BUTTON_HEIGHT));
        searchButton.setSize(new Dimension(ViewConstants.NAV_BUTTON_WIDTH, ViewConstants.NAV_BUTTON_HEIGHT));
        searchButton.addActionListener(e -> {
            if (!isSearching) {
                isSearching = true;
                this.searchField.setVisible(true);
                this.searchButton.setVisible(false);
            } else {
                isSearching = false;
                this.searchField.setVisible(false);
                this.searchButton.setVisible(true);
            }
            this.navPanel.revalidate();
            this.navPanel.repaint();
        });

        createButton = new JButton(ViewConstants.ADD_ICON);
        createButton.setPreferredSize(new Dimension(ViewConstants.NAV_BUTTON_WIDTH, ViewConstants.NAV_BUTTON_HEIGHT));
        createButton.setSize(new Dimension(ViewConstants.NAV_BUTTON_WIDTH, ViewConstants.NAV_BUTTON_HEIGHT));
        createButton.addActionListener(e -> {
            contactDialog = new ContactDialog(this);

            this.displayPanel.removeAll();
            MainController.getInstance().createContact();

            BaseInfoTab baseInfoTab = new BaseInfoTab(ViewConstants.DIALOG_WIDTH, ViewConstants.DIALOG_HEIGHT, contactDialog);
            contactDialog.getTabs().add(baseInfoTab);
            contactDialog.addTab(ViewConstants.PRIVATE_INFO_TAB_TITLE, baseInfoTab);

            this.displayPanel.add(contactDialog);
            this.displayPanel.revalidate();
            this.displayPanel.repaint();
        });

        this.searchField = new JTextField(10);
        this.searchField.setPreferredSize(new Dimension(400, 25));
        this.searchField.setSize(new Dimension(400, 25));
        this.searchField.setToolTipText("Enter search text");
        this.searchField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        this.searchField.setForeground(Color.WHITE);
        this.searchField.setBackground(ViewConstants.DARK_COLOR_LAYER_3);
        this.searchField.setVisible(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        navPanel.add(createButton, gbc);

        gbc.gridy = 0;
        gbc.gridx = 0;
        navPanel.add(searchButton, gbc);
        navPanel.add(searchField, gbc);
        this.displayPanel.revalidate();
        this.displayPanel.repaint();

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!searchField.getText().isEmpty()) {
                    updateContactButtons(MainController.getInstance().searchContact(searchField.getText()));
                } else {
                    updateContactButtons(MainController.getInstance().getAllContacts());
                    isSearching = false;
                    searchField.setVisible(false);
                    searchButton.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!searchField.getText().isEmpty()) {
                    updateContactButtons(MainController.getInstance().searchContact(searchField.getText()));
                } else {
                    updateContactButtons(MainController.getInstance().getAllContacts());
                    isSearching = false;
                    searchField.setVisible(false);
                    searchButton.setVisible(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    }

    private void createContactButton(ContactDTO contact) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contactButtonCount++;
        gbc.gridx = 0;
        gbc.gridy = contactButtonCount + 1;
        contactPanel.add(new ContactButton(contact, this), gbc);
    }

    /**
     * Update contact buttons.
     *
     * @param dtoList the dto list
     */
    public void updateContactButtons(ContactDTOList dtoList) {
        this.contactPanel.removeAll();
        if (dtoList != null) {
            for (int i = 0; i < dtoList.getContactDTOS().size(); i++) {
                createContactButton(dtoList.getContactDTOS().get(i));
            }
        }
        this.contactPanel.revalidate();
        this.contactPanel.repaint();
    }

    /**
     * Update panel sizes.
     */
    public void updatePanelSizes() {
        this.navPanel.setSize(this.getWidth() / 4, this.getHeight() / 4);
        this.navPanel.setPreferredSize(new Dimension(this.getWidth() / 4, this.getHeight() / 4));
        this.displayPanel.setSize(this.getWidth() / 4 * 3, this.getHeight());
        this.displayPanel.setPreferredSize(new Dimension(this.getWidth() / 4 * 3, this.getHeight()));
        this.contactPanel.setSize(this.getWidth() / 4, this.getHeight() / 4 * 3);
        this.contactPanel.setPreferredSize(new Dimension(this.getWidth() / 4, this.getHeight() / 4 * 3));
        this.repaint();
        this.revalidate();
    }

    @Override
    public void onContactCreated(UUID contactId) {
        updateContactButtons(MainController.getInstance().getAllContacts());
    }

    @Override
    public void onDataChanged() {
        updateContactButtons(MainController.getInstance().getAllContacts());
    }

    /**
     * Gets nav panel.
     *
     * @return the nav panel
     */
    public JPanel getNavPanel() {
        return navPanel;
    }

    /**
     * Gets display panel.
     *
     * @return the display panel
     */
    public JPanel getDisplayPanel() {
        return displayPanel;
    }

    /**
     * Gets contact dialog.
     *
     * @return the contact dialog
     */
    public ContactDialog getContactDialog() {
        return contactDialog;
    }

    /**
     * Sets contact dialog.
     *
     * @param contactDialog the contact dialog
     */
    public void setContactDialog(ContactDialog contactDialog) {
        this.contactDialog = contactDialog;
    }

    /**
     * Gets create button.
     *
     * @return the create button
     */
    public JButton getCreateButton() {
        return createButton;
    }

    /**
     * Sets create button.
     *
     * @param createButton the create button
     */
    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    /**
     * Gets contact button count.
     *
     * @return the contact button count
     */
    public int getContactButtonCount() {
        return contactButtonCount;
    }

    /**
     * Sets contact button count.
     *
     * @param contactButtonCount the contact button count
     */
    public void setContactButtonCount(int contactButtonCount) {
        this.contactButtonCount = contactButtonCount;
    }
}
