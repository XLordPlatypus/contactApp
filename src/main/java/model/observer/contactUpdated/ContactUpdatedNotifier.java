package model.observer.contactUpdated;

import java.util.ArrayList;
import java.util.List;

/**
 * DataChangedObserver
 * Notifies when Contact data changes
 */
public class ContactUpdatedNotifier implements IContactUpdatedNotifier {
    private final List<IContactUpdatedObserver> observers = new ArrayList<>();

    /**
     * Adds a new Observer
     * @param observer the new Observer Object
     */
    @Override
    public void addObserver(IContactUpdatedObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an Observer
     * @param observer the Observer Object to remove
     */
    @Override
    public void removeObserver(IContactUpdatedObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all Observers
     */
    @Override
    public void notifyObservers() {
        List<IContactUpdatedObserver> observersCopy = new ArrayList<>(observers);
        for (IContactUpdatedObserver observer : observersCopy) {
            observer.onDataChanged();
        }
    }
}
