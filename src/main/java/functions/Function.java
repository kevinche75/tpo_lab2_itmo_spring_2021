package functions;

import exceptions.UnreachableResultException;

public abstract class Function{

    public double accuracy;

    public Function(double accuracy){
        this.accuracy = accuracy;
    }

    public Function(){
        this.accuracy = 10e-5;
    }

    public abstract double comp(double theta) throws UnreachableResultException;
}
