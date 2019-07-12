package org.knowledge.filip.constructor;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestImmutableObject {

    @Test
    public void testImmutability() {
        ImmutableObject.ImmutableNoSetters immutableNoSetters = new ImmutableObject
                .ImmutableNoSetters("1", 1, new SomeClass());

        // Cannot test immutableNoSetters, because it does not have setter methods so there is no other way to change
        // it's values. Just with Reflexion API.


        SomeClass someClass = new SomeClass();
        ImmutableObject.ImmutableWithSetters immutableWithSetters = new ImmutableObject
                .ImmutableWithSetters("2", 2, someClass);

        immutableWithSetters.setAge(3);
        immutableWithSetters.setName("John");
        immutableWithSetters.setSomeClass(new SomeClass());

        Assert.assertEquals(2, immutableWithSetters.getAge());
        Assert.assertEquals("2", immutableWithSetters.getName());
        Assert.assertEquals(someClass, immutableWithSetters.getSomeClass());
    }
}
