package org.knowledge.filip.constructor;

import java.util.Collections;

public abstract class AbstactClass {
    private String description;
    private final int COUNT = 50;

    public AbstactClass() {
        this("default");
    }

    public AbstactClass(String description) {
        this.description = description;
    }

    public void doAction() {
        System.out.println("Doing something here... " + description);
        doTheAction();
        System.out.println(String.join("", Collections.nCopies(COUNT, "-")).concat("\n"));
    }

    protected abstract void doTheAction();
}
