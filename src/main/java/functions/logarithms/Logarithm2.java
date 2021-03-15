package functions.logarithms;

import exceptions.UnreachableResultException;
import functions.Function;
import utils.TransformationService;

public class Logarithm2 extends Function {

    public static double compLog2(double theta, double accuracy) throws UnreachableResultException {
        return TransformationService.transformLogNToLogK(theta, accuracy, 2);
    }

    @Override
    public double comp(double theta) throws UnreachableResultException{
        return Logarithm2.compLog2(theta, this.accuracy);
    }
}
