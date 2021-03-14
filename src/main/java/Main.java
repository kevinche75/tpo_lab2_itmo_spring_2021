import exceptions.UnreachableResultException;
import functions.trigonometrics.Cosine;

public class Main {
    public static void main(String[] args) throws UnreachableResultException {
        System.out.println(Cosine.compCos(4.5*Math.PI, 0.12));
    }
}
