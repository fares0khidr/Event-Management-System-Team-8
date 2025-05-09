package org.example.t8amm;

public class Event {
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Event(Category category) {
        this.category = category;
    }
}

