package com.zachlittle.android.aca.marsrobot;

/**
 * Created by Zach on 8/24/16.
 */
public class MarsRobot {
    String status;
    int speed;
    float temperature;

    void checkTemperature() {
        if (temperature < -80) {
            status = "returning home";
            speed = 5;

        }
    }

    void showAttributes() {
        System.out.println("Status: " + status);
        System.out.println("Speed: " + speed);
        System.out.println("Temperature: " + temperature);
    }

}
