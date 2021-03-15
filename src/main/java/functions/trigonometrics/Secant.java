package functions.trigonometrics;

import exceptions.UnreachableResultException;
import functions.Function;
import utils.TransformationService;

public class Secant extends Function {

    public Secant(double accuracy){
        super(accuracy);
    }

    public static double compSec(double theta, double accuracy) throws UnreachableResultException {
        return TransformationService.transformCosToSec(theta, accuracy);
    }

    @Override
    public double comp(double theta) throws UnreachableResultException {
        return Secant.compSec(theta, this.accuracy);
    }
}