package model.observer.contactCreated;

import java.util.UUID;

/**
 * The interface Contact created notifier.
 */
public interface IContactCreatedNotifier {
    /**
     * Add observer.
     *
     * @param observer the observer
     */
    void addObserver(IContactCreatedObserver observer);

    /**
     * Remove observer.
     *
     * @param observer the observer
     */
    void removeObserver(IContactCreatedObserver observer);

    /**
     * Notify observers.
     *
     * @param newContactId the new contact id
     */
    void notifyObservers(UUID newContactId);
}
