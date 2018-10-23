package com.team871.navigation;


public class WaypointArrayWrapper {

    private final Waypoint[] waypoints;
    private String name;

    public WaypointArrayWrapper(String name, Waypoint[] waypoints) {
        this.name = name;
        this.waypoints = waypoints;
    }

    public Waypoint[] getWaypoints() {
        return waypoints;
    }

    public String getName() {
        return name;
    }

}
