package functions.logarithms;

import exceptions.UnreachableResultException;
import functions.Function;

public class LogarithmNatural extends Function {

    public static double compLogN(double theta, double accuracy) throws UnreachableResultException {
        if (theta <= 0){
            throw new UnreachableResultException("Theta must be > 0 to calculate logarithm");
        }
        if (accuracy < 0){
            throw new UnreachableResultException("The accuracy below zero");
        }
        double result = 0;
        double step = (theta - 1)/(theta + 1);
        int i;
        for (i = 1; step > accuracy && i != Integer.MAX_VALUE; i+=2){
            result += 1/(float) i*step;
            if (!Double.isFinite(result) || !Double.isFinite(step)){
                throw new UnreachableResultException("Can't reach the accuracy");
            }
            step *=step*step;
        }
        result *=2;
        if (i == Integer.MAX_VALUE || !Double.isFinite(result)){
            throw new UnreachableResultException("Can't reach the accuracy");
        }
        return result;
    }

    @Override
    public double comp(double theta) throws UnreachableResultException {
        return LogarithmNatural.compLogN(theta, this.accuracy);
    }
}
