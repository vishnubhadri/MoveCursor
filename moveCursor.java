
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

class moveCursor {

    final static int default_time_interval = 60000;

    public static void main(String args[]) throws Exception {
        /*Computing time interval*/
        final int time_interval = moveCursor.getDefault(args);

        Timer timer = new Timer("mouse");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Robot cursor = new Robot();
                    Robot scroll = new Robot();
                    cursor.setAutoDelay(time_interval);
                    {
                        /*Change cursor location*/
                        cursor.mouseMove(300, 300);//0,0
                        scroll.mouseWheel(1);
                        scroll.mouseWheel(-1);
                        cursor.mouseMove(500, 300);//1,0
                        scroll.mouseWheel(1);
                        scroll.mouseWheel(-1);
                        cursor.mouseMove(500, 500);//1,1
                        scroll.mouseWheel(1);
                        scroll.mouseWheel(-1);
                        cursor.mouseMove(300, 500);//0,1
                        scroll.mouseWheel(1);
                        scroll.mouseWheel(-1);

                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }, time_interval, 1000L
        );
    }

    public static int getDefault(String[] time) {
        try {
            int checkNegTime=(Integer.parseInt(time[0]));
            if(checkNegTime<0)
            {
                System.err.println("Invalid param. Negative time:" + checkNegTime);
                System.err.println("Using default time interval:" + moveCursor.default_time_interval);
                checkNegTime=moveCursor.default_time_interval;
            }
            return checkNegTime;
        } catch (Exception e) {
            System.err.println("Invalid param. Using default time interval:" + moveCursor.default_time_interval);
            return (moveCursor.default_time_interval);
        }
    }
}
