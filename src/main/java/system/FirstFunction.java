package system;

import exceptions.UnreachableResultException;
import functions.Function;
import functions.trigonometrics.Cosecant;
import functions.trigonometrics.Cosine;
import functions.trigonometrics.Secant;
import functions.trigonometrics.Sinus;
import utils.RangeValueService;

public class FirstFunction extends Function {

    public Secant sec;
    public Cosine cos;
    public Sinus sin;
    public Cosecant csc;

    public FirstFunction(double accuracy){
        super(accuracy/100);
        sec = new Secant(accuracy/100);
        cos = new Cosine(accuracy/100);
        sin = new Sinus(accuracy/100);
        csc = new Cosecant(accuracy/100);
    }

    public double comp(double x) throws UnreachableResultException {
        if (RangeValueService.checkRangeValueFirstFunction(x, accuracy))
            throw new UnreachableResultException("X doesn't math the range of acceptable values");
        return (sec.comp(x)*cos.comp(x)/ sin.comp(x) + cos.comp(x) + sin.comp(x)) * csc.comp(x);
    }

    @Override
    public String toString(){
        return "(sec(x)*cos(x)/sin(x)+cos(x)+sin(x))*csc(x)";
    }
}
