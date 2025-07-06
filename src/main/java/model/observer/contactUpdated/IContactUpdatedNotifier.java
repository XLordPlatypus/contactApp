package model.observer.contactUpdated;

/**
 * The interface Contact updated notifier.
 */
public interface IContactUpdatedNotifier {
    /**
     * Add observer.
     *
     * @param observer the observer
     */
    void addObserver(IContactUpdatedObserver observer);

    /**
     * Remove observer.
     *
     * @param observer the observer
     */
    void removeObserver(IContactUpdatedObserver observer);

    /**
     * Notify observers.
     */
    void notifyObservers();
}
