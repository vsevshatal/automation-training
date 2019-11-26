package com.ta.cleancode.runner;

import com.ta.cleancode.entity.airport.Airport;
import com.ta.cleancode.entity.planes.MilitaryPlane;
import com.ta.cleancode.entity.planes.PassengerPlane;
import com.ta.cleancode.types.MilitaryType;
import com.ta.cleancode.entity.planes.Plane;

import java.util.Arrays;
import java.util.List;

import static com.ta.cleancode.objects.PlaneObjects.planes;

public class Runner {


    public static void main(String[] args) {
        Airport airport = new Airport(planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());
        System.out.println("Military airport sorted by max distance: " + militaryAirport
                .sortByMaxDistance()
                .toString());
        System.out.println("Passenger airport sorted by max speed: " + passengerAirport
                .sortByMaxSpeed()
                .toString());

        System.out.println("Plane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
