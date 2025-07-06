package model.observer.contactCreated;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ContactCreatedObserver
 * Notifies when a new Contact is created
 */
public class ContactCreatedObserver implements IContactCreatedNotifier {
    private final List<IContactCreatedObserver> observers = new ArrayList<>();

    /**
     * Adds a new Observer
     * @param observer the new Observer Object
     */
    @Override
    public void addObserver(IContactCreatedObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an Observer
     * @param observer the Observer Object to remove
     */
    @Override
    public void removeObserver(IContactCreatedObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all Observers
     * @param newContactId the id of the newly created Contact
     */
    // FIXME: Help me :(
    @Override
    public void notifyObservers(UUID newContactId) {
        observers.get(observers.size() - 1).onContactCreated(newContactId);
    }
}
