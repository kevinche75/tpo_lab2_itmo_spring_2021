package utils;

import static java.lang.Math.abs;

public class RangeValueService {

    public static boolean checkRangeValueFirstFunction(double theta, double accuracy){
        return abs(theta) % (Math.PI / 2) <= accuracy;
    }

    public static boolean checkRangeValueSecondFunction(double theta, double accuracy){
        if (abs(theta - 1) <= accuracy){
            System.out.println(abs(theta - 1));
            System.out.println(abs(theta - 1) <= accuracy);
        }
        return  abs(theta - 1) <= accuracy;
    }
}
