package system;

import exceptions.UnreachableResultException;
import functions.Function;
import functions.trigonometrics.Cosecant;
import functions.trigonometrics.Cosine;
import functions.trigonometrics.Secant;
import functions.trigonometrics.Sinus;
import utils.RangeValueService;

public class FirstFunction extends Function {

    private Secant sec;
    private Cosine cos;
    private Sinus sin;
    private Cosecant csc;

    public FirstFunction(double accuracy){
        super(accuracy);
        sec = new Secant(accuracy);
        cos = new Cosine(accuracy);
        sin = new Sinus(accuracy);
        csc = new Cosecant(accuracy);
    }

    public double comp(double x) throws UnreachableResultException {
        if (RangeValueService.checkRangeValueFirstFunction(x, accuracy))
            throw new UnreachableResultException("X doesn't math the range of acceptable values");
        return (sec.comp(x)*cos.comp(x)/ sin.comp(x) + sin.comp(x)) * csc.comp(x);
    }

    @Override
    public String toString(){
        return "(sec(x)*cos(x)/sin(x)+sin(x))*csc(x)";
    }
}
