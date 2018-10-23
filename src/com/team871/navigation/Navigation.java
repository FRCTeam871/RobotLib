package com.team871.navigation;


import com.team871.io.sensor.IDisplacementSensor;
import com.team871.subsystem.IDriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Navigation is field oriented, so that the only point shifting between matches is the starting point of the robot.
 * We feel this is more clear to understand than a robot oriented system, which would require shifting the entire path for each starting position.
 *
 * @author Team871-TPfaffe
 */
public class Navigation {
    private IDriveTrain drive;
    private IDisplacementSensor displaceSense;
    private IWaypointProvider<? extends Waypoint> waypointProvider;
    private Coordinate initialPos;
    private Coordinate currentLocation;
    private Waypoint nextWaypoint;
    private boolean isDone;

    private double DIST_THRESHOLD = 3.0;
    /**
     * @param displaceSense The displacement sensor
     * @param waypointProvider The object that provides our waypoints
     * @param startLocation The absolute starting position of the robot on the field.
     */
    public Navigation(IDriveTrain drive, IDisplacementSensor displaceSense, IWaypointProvider<? extends Waypoint> waypointProvider, Coordinate startLocation) {
        this.displaceSense    = displaceSense;
        this.waypointProvider = waypointProvider;
        this.initialPos       = startLocation;
        this.drive            = drive;
        this.isDone           = false;

        currentLocation = new Coordinate(startLocation);

        //updates location
        updateLocation();

        //enables heading hold
        drive.setHeadingHoldEnabled(true);
    }

    public void setWaypointProvider(IWaypointProvider<? extends Waypoint> provider) {
        waypointProvider = provider;
        resetPath();
    }

    /**
     * Is called on loop during autonomous phase to navigate to differing locations
     */
    public void navigate() {
        if(nextWaypoint == null) {
            nextWaypoint = getNextWaypoint();
        }

        updateLocation();

        if (this.isDone) {
            drive.setHeadingHoldEnabled(false);
            drive.stop();//stop
        } else {
            final double distance = currentLocation.getDistance(nextWaypoint);
            double direction = currentLocation.getAngle(nextWaypoint);
            final double magnitude = nextWaypoint.getSpeed();
            
            if(magnitude < 0) {
                direction = ((direction + 360) % 360) - 180; // works because magic
            }
            
            SmartDashboard.putNumber("navDist", distance);
            SmartDashboard.putNumber("navDir", direction);
            SmartDashboard.putNumber("navMag", magnitude);
            SmartDashboard.putString("navCurrLocation", currentLocation.toString());
            SmartDashboard.putString("navNextWaypoint", nextWaypoint.toString());

            if(distance >= DIST_THRESHOLD) {
                drive.drive(drive.isAtHeading() ? magnitude : 0, 0);
                drive.setHeadingHold(direction);
            } else {
                //If we are at the waypoint, do the action
                drive.stop();
                nextWaypoint.getAction().execute();

                //if the action is complete move on
                if(nextWaypoint.getAction().isComplete()) {
                    //since we got to the waypoint and performed it's action, get the next one
                    if (waypointProvider.hasNext()) {
                        nextWaypoint = getNextWaypoint();
                    } else {
                        //done with navigation
                        this.isDone = true;
                    }
                }
            }
        }
    }

    public void resetPath() {
        System.out.println("Navigation: Resetting Path!");
        stop();
        waypointProvider.reset();
        isDone = false;
        System.out.println("Navigation: Done Resetting Path");
    }
    
    public void reset() {
        System.out.print("Navigation: Resetting!");
        stop();
        waypointProvider.reset();
        currentLocation.copy(initialPos);
        isDone = false;
        System.out.print("Navigation: Done Resetting!");
    }

    public void stop() {
        if(!nextWaypoint.getAction().isComplete()) {
            nextWaypoint.getAction().abort();
        }

        drive.setHeadingHoldEnabled(false);
        drive.stop();//stop
    }

    /**
     * Updates current location, angle, and speed of the robot from displace sensor
     */
    private void updateLocation() {
        currentLocation.copy(displaceSense.getDisplacement(DistanceUnit.INCH));
        currentLocation.plus(initialPos);
    }
    
    public boolean isDone() {
        return isDone;
    }
    
    private Waypoint getNextWaypoint() {
        Waypoint p = waypointProvider.next();
        p.getAction().init();
        return p;
    }

    public boolean hasPath() {
        return waypointProvider != null;
    }
}