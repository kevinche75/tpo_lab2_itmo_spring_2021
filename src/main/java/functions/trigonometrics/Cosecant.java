package functions.trigonometrics;

import exceptions.UnreachableResultException;
import functions.Function;
import utils.TransformationService;

public class Cosecant extends Function {

    public Cosecant(double accuracy){
        super(accuracy);
    }

    public static double compCsc(double theta, double accuracy) throws UnreachableResultException {
        return TransformationService.transformSinToCsc(theta, accuracy);
    }

    @Override
    public double comp(double theta) throws UnreachableResultException {
        return Cosecant.compCsc(theta, this.accuracy);
    }
}
