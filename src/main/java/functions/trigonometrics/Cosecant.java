package functions.trigonometrics;

import exceptions.UnreachableResultException;
import utils.TransformationService;

public class Cosecant {

    public static double compCsc(double theta, double accuracy) throws UnreachableResultException {
        return TransformationService.transformSinToCsc(theta, accuracy);
    }
}
