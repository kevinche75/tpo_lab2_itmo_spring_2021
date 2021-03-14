package functions.trigonometrics;

import exceptions.UnreachableResultException;
import utils.TransformationService;

public class Secant {
    public static double compSec(double theta, double accuracy) throws UnreachableResultException {
        return TransformationService.transformCosToSec(theta, accuracy);
    }
}