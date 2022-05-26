package Vue;

public class Time {


    public static void second(float i) {
        try {
            Thread.sleep(Long.valueOf((long) (i * 1000)));//使当前进程沉睡i秒
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
