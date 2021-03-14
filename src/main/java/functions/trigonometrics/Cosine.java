package functions.trigonometrics;

import exceptions.UnreachableResultException;

public class Cosine {

    public static double compCos(double theta, double accuracy) throws UnreachableResultException {
        if (accuracy < 0){
            throw new UnreachableResultException("The accuracy below zero");
        }
        double theta_norm = Math.abs(theta);
        String[] parts = String.valueOf(theta_norm/Math.PI/2).split("[.]");
        theta_norm -= Double.parseDouble(parts[0])*2*Math.PI;
        double result = 1;
        double step = 1;
        int i;
        for (i = 1; step > accuracy && i != Integer.MAX_VALUE; i++){
            step = step*theta_norm*theta_norm/(2*i-1)/(2*i);
            if (i % 2 == 1){
                result -= step;
            } else {
                result += step;
            }
        }
        return result;
    }
}