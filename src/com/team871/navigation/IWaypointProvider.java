package com.team871.navigation;

import java.util.Iterator;

public interface IWaypointProvider<T extends Waypoint> extends Iterator<T>{
    void reset();
}
