package com.blueJ.chapter12.foxesAndRabbitsV2;

import java.util.List;

public abstract class Actor {
    abstract public void act(List<Actor> newActors);
    abstract public boolean isActive();
}
