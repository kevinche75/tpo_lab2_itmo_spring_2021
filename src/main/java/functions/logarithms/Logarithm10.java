package functions.logarithms;

import exceptions.UnreachableResultException;
import functions.Function;
import utils.TransformationService;

public class Logarithm10 extends Function {

    public static double compLog10(double theta, double accuracy) throws UnreachableResultException {
        return TransformationService.transformLogNToLogK(theta, accuracy, 10);
    }

    @Override
    public double comp(double theta) throws UnreachableResultException{
        return Logarithm10.compLog10(theta, this.accuracy);
    }
}
