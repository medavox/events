package com.elucid.events;

/**
 * @author Adam Howard
on 24/07/16
 * An event with a shallow subtype (not type in the OO sense) from a predefined group.
 * Extend this to create a family of related events (using a single Class) relating to a single concern, with differing EventTypes.
 */
public abstract class TypedEvent<T extends TypedEvent.EventType> extends Event {
    /**The subtype of event, eg DEVICE_DISCONNECTED, DEVICE_DISCOVERED, DEVICE_ERROR.
     * Classes implementing TypedEvent should use an enum here.*/
    T eventType;
    public TypedEvent(Object caller, T type) {
        super(caller);
        this.eventType = type;
    }

    /**The Event's sub-type. Useful for describing a family of related events.
     * For instance, a CupboardEvent whose EventTypes consist of CupboardEventType.OPENED,
     * CupboardEventType.CLOSED, and CupboardEventType.ITEM_REMOVED.
     * Should be implemented with an Enum.*/
    public interface EventType{}

    /**Returns the Event's sub-type.
     * Implementing classes should provide a version of this method
     * whose signature's return type implements EventType,
     * to avoid users of this class having to cast this method to the implementer.
     * Example: public ExampleImplementingEventType getEventType {return event} */
    public T getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return "Event class: \'"+this.getClass().getSimpleName()+"\'; subtype: \'"+eventType+"\'; caller: \'"+getCaller()+"\'";
    }
}
