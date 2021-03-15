package utils;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class RangeValueService {

    private static final double accuracy = 10e-6;

    public static boolean checkRangeValueFirstFunction(double theta){
        return abs(theta % (PI * 2)) >= accuracy;
    }

    public static boolean checkRangeValueSecondFunction(double theta){
        return  abs(theta - 1) <= accuracy;
    }
}
