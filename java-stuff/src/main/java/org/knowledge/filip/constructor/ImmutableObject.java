package org.knowledge.filip.constructor;

/**
 * We make an immutable object either by:
 *  - declaring its fields final private & creating no setters
 *  - declaring its fields final, but returning a new instance on setters
 * and:
 *  - making the class final, so that it cannot be extended
 */
public class ImmutableObject {

    static class ImmutableNoSetters {
        private final String name;
        private final int age;
        private final SomeClass someClass;

        public ImmutableNoSetters(String name, int age, SomeClass someClass) {
            this.name = name;
            this.age = age;
            this.someClass = someClass;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public SomeClass getSomeClass() {
            return someClass;
        }
    }

    static class ImmutableWithSetters {
        private String name;
        private int age;
        private SomeClass someClass;

        public ImmutableWithSetters(String name, int age, SomeClass someClass) {
            this.name = name;
            this.age = age;
            this.someClass = someClass;
        }

        public ImmutableWithSetters setName(String name) {
            return new ImmutableWithSetters(name, this.age, this.someClass);
        }

        public ImmutableWithSetters setAge(int age) {
            return new ImmutableWithSetters(this.name, age, this.someClass);
        }

        public ImmutableWithSetters setSomeClass(SomeClass someClass) {
            return new ImmutableWithSetters(this.name, this.age, someClass);
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public SomeClass getSomeClass() {
            return someClass;
        }
    }
}

class SomeClass {
    @Override
    public String toString() {
        return "Just a basic class";
    }
}
