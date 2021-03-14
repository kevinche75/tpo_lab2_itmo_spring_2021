package functions.trigonometrics;
import exceptions.UnreachableResultException;
import utils.TransformationService;

public class Sinus {
    public static double compSin(double theta, double accuracy) throws UnreachableResultException {
        return TransformationService.transformSinToCos(theta, accuracy);
    }
}
