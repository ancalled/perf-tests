package uk.co.real_logic.aeron.samples.my.disruptor;

import uk.co.real_logic.aeron.samples.my.domain.Item;

public class Event implements Item {

    public Item value;

    public void setValue(Item value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Event{" +
                "value=" + value +
                '}';
    }
}