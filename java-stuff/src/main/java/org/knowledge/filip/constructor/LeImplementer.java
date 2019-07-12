package org.knowledge.filip.constructor;

public class LeImplementer extends AbstactClass {

    private String action;

    public LeImplementer() {
        this.action = "le default";
    }

    public LeImplementer(String action) {
        this.action = action;
    }

    public LeImplementer(String action, String description) {
        super(description);
        this.action = action;
    }

    @Override
    protected void doTheAction() {
        System.out.println(action);
    }
}
