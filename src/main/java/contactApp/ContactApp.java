package contactApp;

import view.MainView;
import view.constants.ViewConstants;

/**
 * The type Contact app.
 */
public class ContactApp {
    /**
     * The entry point of application
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new ContactApp();
    }

    /**
     * Instantiates a new Contact app.
     */
    public ContactApp() {
        MainView mainView = new MainView(ViewConstants.TITLE, ViewConstants.DEFAULT_FRAME_WIDTH, ViewConstants.DEFAULT_FRAME_HEIGHT);
        mainView.pack();
    }
}
