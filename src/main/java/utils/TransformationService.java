package utils;

import exceptions.UnreachableResultException;
import functions.logarithms.LogarithmNatural;
import functions.trigonometrics.Cosine;

import static java.lang.Math.abs;

public class TransformationService {

    public static double transformSinToCos(double theta, double accuracy) throws UnreachableResultException {
        return Cosine.compCos(Math.PI/2 - theta, accuracy);
    }

    public static double transformCosToSec(double theta, double accuracy) throws UnreachableResultException {
        double divisor = Cosine.compCos(theta, accuracy);
        if (abs(divisor) <= accuracy) throw new UnreachableResultException("Division by zero");
        return 1/divisor;
    }

    public static double transformSinToCsc(double theta, double accuracy) throws UnreachableResultException {
        double divisor = transformSinToCos(theta, accuracy/100);
        if (abs(divisor) <= accuracy) throw new UnreachableResultException("Division by zero");
        return 1/divisor;
    }

    public static double transformLogNToLogK(double theta, double accuracy, int base) throws UnreachableResultException {
        if (base == 1){
            throw new UnreachableResultException("Division by zero");
        }
        return LogarithmNatural.compLogN(theta, accuracy)/LogarithmNatural.compLogN(base, accuracy);
    }
}
