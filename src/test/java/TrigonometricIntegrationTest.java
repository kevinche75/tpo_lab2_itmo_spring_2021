import exceptions.UnreachableResultException;
import functions.logarithms.Logarithm2;
import functions.logarithms.LogarithmNatural;
import functions.trigonometrics.Cosecant;
import functions.trigonometrics.Cosine;
import functions.trigonometrics.Secant;
import functions.trigonometrics.Sinus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;

import java.util.stream.Stream;
import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mockStatic;

public class TrigonometricIntegrationTest {

    private static final double accuracy = 10e-5;

    static Stream<Arguments> valuesRangeProvider() {
        return Stream.of(
                arguments(18.972555932820416),
                arguments(19.600874463820418),
                arguments(20.22919299482042),
                arguments(20.85751152582042),
                arguments(21.485830056820422),
                arguments(22.114148587820424),
                arguments(22.742467118820425),
                arguments(23.370785649820426),
                arguments(23.999104180820428),
                arguments(24.62742271182043),
                arguments(25.25574124282043),
                arguments(25.884059773820432),
                arguments(26.512378304820434),
                arguments(27.140696835820435),
                arguments(27.769015366820437),
                arguments(28.397333897820438),
                arguments(29.02565242882044),
                arguments(29.65397095982044),
                arguments(30.282289490820443),
                arguments(30.910608021820444)
        );
    }

    @DisplayName("Cosecant: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_0(Double value) throws UnreachableResultException {
        try (MockedStatic<Sinus> sin = mockStatic(Sinus.class)){
            sin.when(() -> Sinus.compSin(value, accuracy)).thenReturn(sin(value));
            assertEquals(1/sin(value), Cosecant.compCsc(value, accuracy), accuracy);
        }
    }

    @DisplayName("Sinus: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_1(Double value) throws UnreachableResultException {
        try (MockedStatic<Cosine> cos = mockStatic(Cosine.class)){
            cos.when(() -> Cosine.compCos(Math.PI/2 - value, accuracy)).thenReturn(cos(Math.PI/2 - value));
            assertEquals(sin(value), Sinus.compSin(value, accuracy), accuracy);
        }
    }

    @DisplayName("Secant: Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_2(Double value) throws UnreachableResultException {
        try (MockedStatic<Cosine> cos = mockStatic(Cosine.class)){
            cos.when(() -> Cosine.compCos(value, accuracy)).thenReturn(cos(value));
            assertEquals(1/cos(value), Secant.compSec(value, accuracy), accuracy);
        }
    }
}
