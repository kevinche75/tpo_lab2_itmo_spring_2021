package functions.logarithms;

import exceptions.UnreachableResultException;
import functions.Function;

public class LogarithmNatural extends Function {

    public LogarithmNatural(double accuracy){
        super(accuracy);
    }

    public static double compLogN(double theta, double accuracy) throws UnreachableResultException {
        if (theta <= 0){
            throw new UnreachableResultException("Theta must be > 0 to calculate logarithm");
        }
        if (accuracy < 0){
            throw new UnreachableResultException("The accuracy below zero");
        }
        double result = 0;
        double multiplier = (theta - 1)/(theta + 1);
        double step = multiplier * 2;
        int i;
        for (i = 1; Math.abs(step) > accuracy && i != Integer.MAX_VALUE-2; i+=2){
            step = 2/(float) (i) * Math.pow(multiplier, i);
            result += step;
            if (!Double.isFinite(result) || !Double.isFinite(multiplier)){
                throw new UnreachableResultException("Can't reach the accuracy");
            }
        }
        if (i == Integer.MAX_VALUE || !Double.isFinite(result)){
            throw new UnreachableResultException("Can't reach the accuracy");
        }
        return result;
    }

    @Override
    public double comp(double theta) throws UnreachableResultException {
        return LogarithmNatural.compLogN(theta, this.accuracy);
    }

    @Override
    public String toString(){
        return "logN(x)";
    }
}
