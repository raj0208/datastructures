package com.company;

public class UnitTesting {
    private String name;
    private boolean happy = false;

    public UnitTesting(String name) {
        if (name.isEmpty()) {
            throw new IllegalStateException();
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHappy() {
        return happy;
    }

    public void playWithRock() {
        happy = true;
    }

    public String getHappyMessage() {
//        if (!happy) {
//            throw new IllegalStateException();
//        }

        return "I'm happy!";
    }

    public int getFevNumber() {
        return 0;
    }

    public void waitTillHappy() {
        while (!happy) {
            //
        }
    }
}
