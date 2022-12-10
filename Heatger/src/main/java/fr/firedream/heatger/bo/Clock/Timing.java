package fr.firedream.heatger.bo.Clock;

import java.util.Date;

public class Timing {
    private Timing nextTiming;
    private Timing previousTiming;
    private Date dayTime;

    private State state;

    public Timing(Date dayTime) {
        this.dayTime = dayTime;
    }

    public void setPreviousTiming(Timing previousTiming) {
        this.previousTiming = previousTiming;
    }

    public void setNextTiming(Timing nextTiming) {
        this.nextTiming = nextTiming;
    }

    public Timing next() {
        return nextTiming;
    }

    public Timing previous() {
        return previousTiming;
    }

    public Date getDayTime() {
        return dayTime;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
