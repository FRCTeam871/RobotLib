package com.team871.navigation;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Provides waypoints in a list one by one with no modification to the waypoints for navigation
 */
public class ListWaypointProvider<T extends Waypoint> implements IWaypointProvider<T> {
    private Iterator<T> it;
    private final List<T> waypointArrayList;
    private String name;

    private static String generateName() {
        return "ListWaypointProvider - " + System.currentTimeMillis();
    }
    
    public ListWaypointProvider(String name, List<T> waypoints) {
        this.waypointArrayList = waypoints;
        it = waypointArrayList.iterator();
        this.name = name;
    }
    
    public ListWaypointProvider(List<T> waypoints) {
        this(generateName(), waypoints);
    }
    
    public ListWaypointProvider(T... points) {
        this(generateName(), Arrays.asList(points));
    }
    
    public ListWaypointProvider(String name, T... points) {
        this(name, Arrays.asList(points));
    }

    @Override
    public void reset() {
        it = waypointArrayList.iterator();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public T next() {
        return it.next();
    }

}
