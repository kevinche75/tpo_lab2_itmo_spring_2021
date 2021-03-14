package functions.logarithms;

import exceptions.UnreachableResultException;
import utils.TransformationService;

public class LogarithmK {
    public static double compLogK(double theta, double accuracy, int base) throws UnreachableResultException {
        return TransformationService.transformLogNToLogK(theta, accuracy, base);
    }
}
