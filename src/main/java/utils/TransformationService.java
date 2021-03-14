package utils;

import exceptions.UnreachableResultException;
import functions.logarithms.LogarithmNatural;
import functions.trigonometrics.Cosine;

public class TransformationService {

    public static double transformSinToCos(double theta, double accuracy) throws UnreachableResultException {
        return Cosine.compCos(Math.PI/2 - theta, accuracy);
    }

    public static double transformCosToSec(double theta, double accuracy) throws UnreachableResultException {
        return 1/Cosine.compCos(theta, accuracy);
    }

    public static double transformSinToCsc(double theta, double accuracy) throws UnreachableResultException {
        return 1/transformSinToCos(theta, accuracy);
    }

    public static double transformLogNToLogK(double theta, double accuracy, int base) throws UnreachableResultException {
        if (base == 1){
            throw new UnreachableResultException("Division by zero");
        }
        return LogarithmNatural.compLogN(theta, accuracy)/LogarithmNatural.compLogN(base, accuracy);
    }
}
