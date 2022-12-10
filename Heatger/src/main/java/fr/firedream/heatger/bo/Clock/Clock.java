package fr.firedream.heatger.bo.Clock;


import fr.firedream.heatger.exception.HeatgerException;

import java.util.*;

public abstract class Clock  {
    private Timing currentTiming;
    private Timer timer;

    public Clock() {
        timer = new Timer();
    }

    public void init(List<Timing> timingList) {
        for(int i=0;i<timingList.size();i++) {
            System.out.println("INIT : " + timingList.get(i).getDayTime());
            if(i+1 < timingList.size()) {
                timingList.get(i).setNextTiming(timingList.get(i+1));
            }
            if(i-1 >= 0) {
                timingList.get(i).setPreviousTiming(timingList.get(i-1));
            } else {
                timingList.get(i).setPreviousTiming(timingList.get(timingList.size()-1));
            }
        }
        timingList.get(timingList.size()-1).setNextTiming(timingList.get(0));
        currentTiming = timingList.get(0);
    }

    public void start() throws Exception {
        findNextTiming();
        currentTiming = currentTiming.previous();
        nextTimer();
    }

    public void stop() {
        timer.cancel();
    }

    private void findNextTiming() throws Exception {
        if(currentTiming == null)
            throw new HeatgerException(ClockErrors.ERROR_NO_TIMING);

        Date date = Calendar.getInstance().getTime();

        while(true) {
            System.out.print("COMPARE : " + date);
            System.out.print(" AND " + currentTiming.getDayTime());
            System.out.println(" = " + date.compareTo(currentTiming.getDayTime()));
            if(date.compareTo(currentTiming.getDayTime()) < 0) {
                System.out.println("NEXT : " + currentTiming.getDayTime());
                return;
            }
            currentTiming = currentTiming.next();
        }
    }

    private void nextTimer() {
        currentTiming = currentTiming.next();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                nextTimer();
            }
        }, currentTiming.getDayTime().getTime());
    }

    public Date getNextTiming() {
        return currentTiming.getDayTime();
    }

    public State getNextState() {
        return currentTiming.getState();
    }

    public abstract void timedOut(Timing timing);
}
