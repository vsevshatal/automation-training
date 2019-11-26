package com.ta.cleancode.entity.planes;

import com.ta.cleancode.types.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private MilitaryType militaryType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = type;
    }

    public MilitaryType getType() {
        return militaryType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + militaryType +
                '}');
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MilitaryPlane) || (!super.equals(object)) ) {
            return false;
        }
        return militaryType == ((MilitaryPlane) object).militaryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }
}
