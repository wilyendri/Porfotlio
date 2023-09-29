package com.wilyendri.portfolio.solarSystemProject;

import java.time.Duration;

public class SolarSystemCalculator {
    public static void main(String[] args) {
        Planet mars = new Planet(25.2);
        long totalSeconds = (long) (mars.getDayLength() * 3600);
        Duration duration = Duration.ofSeconds(totalSeconds);

        System.out.println("The following is the total duration of Earth days in Mars: ");
        System.out.println(duration.toHours() + ":" + duration.toMinutesPart() + ":" + duration.toSecondsPart());


    }
}
