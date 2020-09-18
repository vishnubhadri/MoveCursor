
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

class moveCursor {

    public static void main(String args[]) throws Exception {
        Timer timer = new Timer("mouse");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Robot cursor = new Robot();
                    Robot scroll = new Robot();
                    cursor.setAutoDelay(Integer.parseInt(args[0]));
                    {
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
        },
                Integer.parseInt(args[0]) ,1000L
        );
    }
}
