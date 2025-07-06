package view.constants;

import javax.swing.*;
import java.awt.*;

/**
 * The type View constants.
 */
public class ViewConstants {
    /**
     * The constant IS_COLOR_MODE_DARK.
     */
    public static final boolean IS_COLOR_MODE_DARK = true;
    /**
     * The constant DEFAULT_FRAME_WIDTH.
     */
    public static final int DEFAULT_FRAME_WIDTH = 1920;
    /**
     * The constant DEFAULT_FRAME_HEIGHT.
     */
    public static final int DEFAULT_FRAME_HEIGHT = 1080;
    /**
     * The constant NAV_PANEL_WIDTH.
     */
    public static final int NAV_PANEL_WIDTH = DEFAULT_FRAME_WIDTH / 4;
    /**
     * The constant NAV_PANEL_HEIGHT.
     */
    public static final int NAV_PANEL_HEIGHT = DEFAULT_FRAME_HEIGHT / 4;
    /**
     * The constant CONTACT_PANEL_WIDTH.
     */
    public static final int CONTACT_PANEL_WIDTH = DEFAULT_FRAME_WIDTH / 4;
    /**
     * The constant CONTACT_PANEL_HEIGHT.
     */
    public static final int CONTACT_PANEL_HEIGHT = DEFAULT_FRAME_HEIGHT / 4 * 3;
    /**
     * The constant DISPLAY_PANEL_WIDTH.
     */
    public static final int DISPLAY_PANEL_WIDTH = DEFAULT_FRAME_WIDTH / 4 * 3;
    /**
     * The constant DISPLAY_PANEL_HEIGHT.
     */
    public static final int DISPLAY_PANEL_HEIGHT = DEFAULT_FRAME_HEIGHT;
    /**
     * The constant TITLE.
     */
    public static final String TITLE = "Contact App";

    /**
     * The constant DIALOG_WIDTH.
     */
// dialog constants
    public static final int DIALOG_WIDTH = 700;
    /**
     * The constant DIALOG_HEIGHT.
     */
    public static final int DIALOG_HEIGHT = 900;

    /**
     * The constant TAB_WIDTH.
     */
    public static final int TAB_WIDTH = 700;
    /**
     * The constant TAB_HEIGHT.
     */
    public static final int TAB_HEIGHT = 800;

    // tab constants

    /**
     * The constant NAV_BUTTON_WIDTH.
     */
// button constants
    public static final int NAV_BUTTON_WIDTH = 120;
    /**
     * The constant NAV_BUTTON_HEIGHT.
     */
    public static final int NAV_BUTTON_HEIGHT = 60;

    /**
     * The constant DISPLAY_BUTTON_WIDTH.
     */
    public static final int DISPLAY_BUTTON_WIDTH = 120;
    /**
     * The constant DISPLAY_BUTTON_HEIGHT.
     */
    public static final int DISPLAY_BUTTON_HEIGHT = 60;

    /**
     * The constant TAB_ACTION_BUTTON_WIDTH.
     */
    public static final int TAB_ACTION_BUTTON_WIDTH = 200;
    /**
     * The constant TAB_ACTION_BUTTON_HEIGHT.
     */
    public static final int TAB_ACTION_BUTTON_HEIGHT = 100;

    /**
     * The constant SETTINGS_TAB_TITLE.
     */
// tab names
    public static final String SETTINGS_TAB_TITLE = "Settings";
    /**
     * The constant BASE_INFO_TAB_TITLE.
     */
    public static final String BASE_INFO_TAB_TITLE = "Base Info";
    /**
     * The constant PRIVATE_INFO_TAB_TITLE.
     */
    public static final String PRIVATE_INFO_TAB_TITLE = "Private Info";
    /**
     * The constant BUSINESS_INFO_TAB_TITLE.
     */
    public static final String BUSINESS_INFO_TAB_TITLE = "Business Info";
    /**
     * The constant SOCIAL_INFO_TAB_TITLE.
     */
    public static final String SOCIAL_INFO_TAB_TITLE = "Social Info";

    /**
     * The constant DARK_COLOR_LAYER_1.
     */
// colors
    public static final Color DARK_COLOR_LAYER_1 = new Color(18, 18, 18, 255);
    /**
     * The constant DARK_COLOR_LAYER_2.
     */
    public static final Color DARK_COLOR_LAYER_2 = new Color(30, 30, 30);
    /**
     * The constant DARK_COLOR_LAYER_3.
     */
    public static final Color DARK_COLOR_LAYER_3 =  new Color(34, 34, 34);
    /**
     * The constant DARK_COLOR_LAYER_4.
     */
    public static final Color DARK_COLOR_LAYER_4 = new Color(36, 36, 36);
    /**
     * The constant DARK_COLOR_LAYER_5.
     */
    public static final Color DARK_COLOR_LAYER_5 =  new Color(39, 39, 39);
    /**
     * The constant DARK_COLOR_LAYER_6.
     */
    public static final Color DARK_COLOR_LAYER_6 =  new Color(44, 44, 44);
    /**
     * The constant DARK_COLOR_LAYER_7.
     */
    public static final Color DARK_COLOR_LAYER_7 = new Color(46, 46, 46);
    /**
     * The constant DARK_COLOR_LAYER_8.
     */
    public static final Color DARK_COLOR_LAYER_8 = new Color(51, 51, 51);
    /**
     * The constant DARK_COLOR_LAYER_9.
     */
    public static final Color DARK_COLOR_LAYER_9 = new Color(52, 52, 52);
    /**
     * The constant DARK_COLOR_LAYER_10.
     */
    public static final Color DARK_COLOR_LAYER_10 = new Color(56, 56, 56);

    /**
     * The constant IMAGE_WIDTH.
     */
// assets
    public static final int IMAGE_WIDTH = 35;
    /**
     * The constant IMAGE_HEIGHT.
     */
    public static final int IMAGE_HEIGHT = 35;

    /**
     * The constant ADD_IMAGE.
     */
    public static final Image ADD_IMAGE = new ImageIcon("assets/add.png").getImage();
    /**
     * The constant ADD_ICON.
     */
    public static final ImageIcon ADD_ICON = new ImageIcon(ADD_IMAGE.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));

    /**
     * The constant SEARCH_IMAGE.
     */
    public static final Image SEARCH_IMAGE = new ImageIcon("assets/search.png").getImage();
    /**
     * The constant SEARCH_ICON.
     */
    public static final ImageIcon SEARCH_ICON = new ImageIcon(SEARCH_IMAGE.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));

    /**
     * The constant PENCIL_IMAGE.
     */
    public static final Image PENCIL_IMAGE = new ImageIcon("assets/pencil.png").getImage();
    /**
     * The constant PENCIL_ICON.
     */
    public static final ImageIcon PENCIL_ICON = new ImageIcon(PENCIL_IMAGE.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));

    /**
     * The constant CLOSE_TAB_IMAGE.
     */
    public static final Image CLOSE_TAB_IMAGE = new ImageIcon("assets/close-tab.png").getImage();
    /**
     * The constant CLOSE_TAB_ICON.
     */
    public static final ImageIcon CLOSE_TAB_ICON = new ImageIcon(CLOSE_TAB_IMAGE.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));

    /**
     * The constant TRASH_IMAGE.
     */
    public static final Image TRASH_IMAGE = new ImageIcon("assets/trash.png").getImage();
    /**
     * The constant TRASH_ICON.
     */
    public static final ImageIcon TRASH_ICON = new ImageIcon(TRASH_IMAGE.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));

    /**
     * The constant SAVE_IMAGE.
     */
    public static final Image SAVE_IMAGE = new ImageIcon("assets/diskette.png").getImage();
    /**
     * The constant SAVE_ICON.
     */
    public static final ImageIcon SAVE_ICON = new ImageIcon(SAVE_IMAGE.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));

    /**
     * The constant CANCEL_IMAGE.
     */
    public static final Image CANCEL_IMAGE = new ImageIcon("assets/cancel.png").getImage();
    /**
     * The constant CANCEL_ICON.
     */
    public static final ImageIcon CANCEL_ICON = new ImageIcon(CANCEL_IMAGE.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));
}
