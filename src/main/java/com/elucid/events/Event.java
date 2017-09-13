package com.elucid.events;

/**@author Adam Howard
on 22/07/2016
 */
/**The standard event object, which all other events must inherit from.*/
public abstract class Event {

    /**The internal reference to this Event's instantiating object.*/
    protected Object caller;

    /**Create a new Event, specifying the object instantiating it. Passing "this" suffices;
     * or in a static method the class, eg Object.class.
     * This ensures a proper audit trail for event debugging.*/
    public Event(Object caller) {
        this.caller = caller;
    }

    /**Get a reference to the object which instantiated this Event.
     * This is usually also the object which called EventBus.post() with it.
     * @return the object reference provided at construction.
     *      Should be a reference to the object which instantiated this.*/
    public Object getCaller(){
        return caller;
    }

    @Override
    public String toString() {
        return "<"+this.getClass().getSimpleName()+"> caller: \'"+caller+"\'";
    }
}
