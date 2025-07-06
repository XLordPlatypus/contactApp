package view.components.tabs;

/**
 * The interface Editable tab.
 */
public interface IEditableTab {
    /**
     * Gets is editing.
     *
     * @return the is editing
     */
    boolean getIsEditing();

    /**
     * Sets is editing.
     *
     * @param isEditing the is editing
     */
    void setIsEditing(boolean isEditing);

    /**
     * Update on edit.
     */
    void updateOnEdit();

    /**
     * Update on cancel.
     */
    void updateOnCancel();
}
