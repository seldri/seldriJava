package com.blueJ.chapter12.foxesAndRabbitsV2;

import java.util.List;

public interface Actor {
    public static int age = 10;
    public void act(List<Actor> newActors);
    public boolean isActive();
}
