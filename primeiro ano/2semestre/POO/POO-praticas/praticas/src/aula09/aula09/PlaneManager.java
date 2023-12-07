package aula09;

import java.util.ArrayList;
import java.util.List;

public class PlaneManager {
    private ArrayList<Plane> fleet = new ArrayList<>(); 

    public void addPlane(Plane plane) {
        fleet.add(plane);
    }

    public void removePlane(String id) {
        Plane planeToRemove = null;
        for (Plane plane : fleet) {
            if (plane.getId().equals(id)) {
                planeToRemove = plane;
                break;
            }
        }
        if (planeToRemove != null) {
            fleet.remove(planeToRemove);
        }
    }

    public Plane searchPlane(String id) {
        for (Plane plane : fleet) {
            if (plane.getId().equals(id)) {
                return plane;
            }
        }
        return null;
    }

    public List<CommercialPlane> getCommercialPlanes() {
        ArrayList<CommercialPlane> commercialPlanes = new ArrayList<>();
        for (Plane plane : fleet) {
            if (plane instanceof CommercialPlane) {
                commercialPlanes.add((CommercialPlane) plane);
            }
        }
        return commercialPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        ArrayList<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : fleet) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public void printAllPlanes() {
        for (Plane plane : fleet) {
            System.out.println(plane.toString());
        }
    }
    public void printCommercialPlanes() {
        for (Plane plane : fleet) {
            if (plane instanceof CommercialPlane) {
                System.out.println(plane.toString());
            }
        }
    }
    public void printMilitaryPlanes() {
        for (Plane plane : fleet) {
            if (plane instanceof MilitaryPlane) {
                System.out.println(plane.toString());
            }
        }
    }

    public Plane getFastestPlane() {
        Plane fastestPlane = null;
        double maxSpeed = 0;
        for (Plane plane : fleet) {
            if (plane.getMaxSpeed() > maxSpeed) {
                maxSpeed = plane.getMaxSpeed();
                fastestPlane = plane;
            }
        }
        return fastestPlane;
    }
}
