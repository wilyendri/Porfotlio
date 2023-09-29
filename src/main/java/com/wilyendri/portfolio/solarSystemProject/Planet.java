package com.wilyendri.portfolio.solarSystemProject;

public class Planet {
    final double EARTH_AXIAL_TILT = 23.5; // Earth's axial tilt in degrees
    final double EARTH_AVERAGE_DAY_LENGTH = 24.0; // Earth's average day length in hours
    private String planetName; // Name of the planet
    private double semiMajorAxis; // Represents the average distance from a planet to the sun
    private double eccentricity; // Represents the shape of the orbit
    private double planetAxialTilt; // Represents the angle between the planet's rotational axis and its orbital plane

    public Planet(String planetName, double semiMajorAxis, double eccentricity, double planetAxialTilt) {
        this.planetName = planetName;
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.planetAxialTilt = planetAxialTilt;
    }

    public Planet(double planetAxialTilt) {
        this.planetAxialTilt = planetAxialTilt;
    }

    public double getPlanetAxialTilt() {
        return planetAxialTilt;
    }

    public void setPlanetAxialTilt(double planetAxialTilt) {
        this.planetAxialTilt = planetAxialTilt;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }

    @Override
    public String toString() {
        return "CelestialBody{" +
                "planetName='" + planetName + '\'' +
                ", semiMajorAxis=" + semiMajorAxis +
                ", eccentricity=" + eccentricity +
                '}';
    }

    public double getDayLength() {
        double tiltFactor = Math.sin(Math.toRadians(planetAxialTilt)) - Math.toRadians(EARTH_AXIAL_TILT);

        return EARTH_AVERAGE_DAY_LENGTH + (EARTH_AVERAGE_DAY_LENGTH * tiltFactor);
    }


}
