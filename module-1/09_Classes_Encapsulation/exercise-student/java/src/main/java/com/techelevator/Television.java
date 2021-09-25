package com.techelevator;

public class Television {
    //PROPERTIES OF TELEVISION CLASS
    private boolean isOn;
    private int currentChannel = 3;
    private int currentVolume = 2;

    //GETTERS AND SETTERS

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    //METHODS

    public void turnOff() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;

    }

    public void changeChannel(int newChannel) {
        if (isOn) {
            if (newChannel >= 3 && newChannel <= 18) {
                currentChannel = newChannel;
            }
        }

    }

    public void channelUp() {
        if (isOn) {
            if ((currentChannel >= 3 && currentChannel <= 17)) {
                currentChannel++;
            } else {
                currentChannel = 3;
            }
        }
    }

    public void channelDown() {
        if (isOn) {
            if ((currentChannel > 3 && currentChannel < 18)) {
                currentChannel--;
            } else {
                currentChannel = 18;
            }
        }
    }

    public void raiseVolume() {
        if (isOn && currentVolume < 10) {
            currentVolume++;
        }
    }

    public void lowerVolume() {
        if (isOn && currentVolume > 0) {
            currentVolume--;
        }

    }


}
