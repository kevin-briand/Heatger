package fr.firedream.heatger.bll;

import fr.firedream.heatger.bo.Clock.Clock;
import fr.firedream.heatger.bo.Clock.Timing;
import fr.firedream.heatger.bo.Zone;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ClockManager {
    private Clock zone1;
    private Clock zone2;

    public ClockManager() throws Exception {
        zone1 = new Clock() {
            @Override
            public void timedOut(Timing timing) {

            }
        };
        zone2 = new Clock() {
            @Override
            public void timedOut(Timing timing) {

            }
        };

        test();
    }

    public void test() throws Exception {
        Calendar time = Calendar.getInstance();
        List<Timing> test = new ArrayList<>();

        test.add(new Timing(time.getTime()));

        time.set(Calendar.HOUR_OF_DAY,19);
        time.set(Calendar.MINUTE, 30);
        test.add(new Timing(time.getTime()));

        time.set(Calendar.DAY_OF_WEEK, 1);
        test.add(new Timing(time.getTime()));

        zone1.init(test);
        zone1.start();
    }

    /**
     * Return the remaining time before the next state change
     * @param zone
     * @return
     */
    public int getRemainingTime(Zone zone) {
        if(zone == Zone.ZONE1)
            return (int) ((zone1.getNextTiming().toInstant().toEpochMilli() - Calendar.getInstance().getTimeInMillis()) / 1000L);
        else
            return (int) ((zone1.getNextTiming().toInstant().toEpochMilli() - Calendar.getInstance().getTimeInMillis()) / 1000L);
    }
}
