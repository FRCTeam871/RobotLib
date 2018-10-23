package com.team871.navigation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WaypointProviderFactory<T extends Waypoint>{

    private final Map<String, IWaypointProvider<T>> paths = new HashMap<>();

    public void addPath(String name, IWaypointProvider<T> points) {
        paths.putIfAbsent(name, points);
    }

    public IWaypointProvider<T> getProvider(String path) {

        final IWaypointProvider<T> pts = paths.get(path);

        if(pts == null) {
            throw new IllegalArgumentException("No such path \"" + path + "\"");
        }

        return paths.get(path);
    }
    
    public Collection<IWaypointProvider<T>> getProviders() {
        return paths.values();
    }

}
