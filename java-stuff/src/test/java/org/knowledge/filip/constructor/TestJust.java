package org.knowledge.filip.constructor;

import org.testng.annotations.Test;

public class TestJust {

    @Test
    public void testLeImplemented() {
        LeImplementer leImplementer = new LeImplementer();

        leImplementer.doAction();

        leImplementer = new LeImplementer("new action");
        leImplementer.doAction();

        AbstactClass leAbstract = new LeImplementer("stupid");
        leAbstract.doAction();

        AbstactClass leVersatile = new LeImplementer("smart", "something different");
        leVersatile.doAction();
    }


}
