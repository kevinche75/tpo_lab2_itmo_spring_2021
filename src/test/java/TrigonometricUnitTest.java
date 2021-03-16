import exceptions.UnreachableResultException;
import functions.trigonometrics.Cosecant;
import functions.trigonometrics.Cosine;
import functions.trigonometrics.Secant;
import functions.trigonometrics.Sinus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TrigonometricUnitTest {

    private final double accuracy = 10e-5;

    @Test
    @DisplayName("Cos: The accuracy below zero")
    void testMethod_0(){
        double value = 2.543;
        assertThrows(UnreachableResultException.class, () -> Cosine.compCos(value, -1));
    }

    @Test
    @DisplayName("Cos The accuracy zero")
    void testMethod_1(){
        double value = 2.543;
        assertDoesNotThrow(() -> Cosine.compCos(value, 0));
    }

    @DisplayName("Cos: params")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {0, 30, 45, 60, 90, 180, 270, 360, 23})
    void testMethod_2(double value) throws UnreachableResultException {
        double x = value/180*Math.PI;
        assertEquals(Math.cos(x), Cosine.compCos(x, accuracy), accuracy);
    }

    @Test
    @DisplayName("Cos: Parity")
    void testMethod_3() throws UnreachableResultException {
        double value = 2.543;
        assertEquals(Cosine.compCos(value, accuracy), Cosine.compCos(-value, accuracy));
    }

    @Test
    @DisplayName("Sin: The accuracy below zero")
    void testMethod_4(){
        double value = 2.543;
        assertThrows(UnreachableResultException.class, () -> Sinus.compSin(value, -1));
    }

    @Test
    @DisplayName("Sin: The accuracy zero")
    void testMethod_5(){
        double value = 2.543;
        assertDoesNotThrow(() -> Sinus.compSin(value, 0));
    }

    @DisplayName("Sin: params")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {0, 30, 45, 60, 90, 180, 270, 360, 23})
    void testMethod_6(double value) throws UnreachableResultException {
        double x = value/180*Math.PI;
        assertEquals(Math.sin(x), Sinus.compSin(x, accuracy), accuracy);
    }

    @Test
    @DisplayName("Sin: Parity")
    void testMethod_7() throws UnreachableResultException {
        double value = 2.543;
        assertEquals(Sinus.compSin(value, accuracy), -Sinus.compSin(-value, accuracy), accuracy);
    }

    @Test
    @DisplayName("Sec: The accuracy below zero")
    void testMethod_8(){
        double value = 2.543;
        assertThrows(UnreachableResultException.class, () -> Secant.compSec(value, -1));
    }

    @Test
    @DisplayName("Sec: The accuracy zero")
    void testMethod_9(){
        double value = 2.543;
        assertDoesNotThrow(() -> Secant.compSec(value, 0));
    }

    @DisplayName("Sec: params")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {0, 30, 45, 60, 180, 360, 23})
    void testMethod_10(double value) throws UnreachableResultException {
        double x = value/180*Math.PI;
        assertEquals(1/Math.cos(x), Secant.compSec(x, accuracy), accuracy);
    }

    @DisplayName("Sec: params ")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {-90, 90, 270, 450})
    void testMethod_11(double value) {
        double x = value/180*Math.PI;
        assertThrows(UnreachableResultException.class, () -> Secant.compSec(x, accuracy));
    }

    @Test
    @DisplayName("Sec: Parity")
    void testMethod_12() throws UnreachableResultException {
        double value = 2.543;
        assertEquals(Secant.compSec(value, accuracy), Secant.compSec(-value, accuracy), accuracy);
    }

    @Test
    @DisplayName("Csc: The accuracy below zero")
    void testMethod_13(){
        double value = 2.543;
        assertThrows(UnreachableResultException.class, () -> Cosecant.compCsc(value, -1));
    }

    @Test
    @DisplayName("Csc: The accuracy zero")
    void testMethod_14(){
        double value = 2.543;
        assertDoesNotThrow(() -> Cosecant.compCsc(value, 0));
    }

    @DisplayName("Csc: params")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {30, 45, 60, 90, 270, 23})
    void testMethod_15(double value) throws UnreachableResultException {
        double x = value/180*Math.PI;
        assertEquals(1/Math.sin(x), Cosecant.compCsc(x, accuracy), accuracy);
    }

    @DisplayName("Csc: params ")
    @ParameterizedTest(name = "{index}: {0} degrees")
    @ValueSource(doubles = {-180, 0, 180, 360})
    void testMethod_16(double value) {
        double x = value/180*Math.PI;
        assertThrows(UnreachableResultException.class, () -> Cosecant.compCsc(x, accuracy));
    }

    @Test
    @DisplayName("Csc: Parity")
    void testMethod_17() throws UnreachableResultException {
        double value = 2.543;
        assertEquals(Cosecant.compCsc(value, accuracy), -Cosecant.compCsc(-value, accuracy), accuracy);
    }
}