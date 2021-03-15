package functions.logarithms;

import exceptions.UnreachableResultException;
import functions.Function;
import utils.TransformationService;

public class Logarithm3 extends Function {

    public static double compLog3(double theta, double accuracy) throws UnreachableResultException {
        return TransformationService.transformLogNToLogK(theta, accuracy, 3);
    }

    @Override
    public double comp(double theta) throws UnreachableResultException{
        return Logarithm3.compLog3(theta, this.accuracy);
    }
}
