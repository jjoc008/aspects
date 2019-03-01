package co.com.jjoc.aspects.utils;

public class LogUtils {

    public static long getInitialTime(){
       return System.currentTimeMillis();
    }

    public static long getFinalTime(long initialTime){

        long stopTime = System.currentTimeMillis();
        return stopTime - initialTime;
    }

}
