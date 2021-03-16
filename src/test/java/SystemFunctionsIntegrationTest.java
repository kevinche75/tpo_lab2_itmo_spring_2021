import exceptions.UnreachableResultException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.params.provider.MethodSource;
import system.FirstFunction;
import system.SecondFunction;
import system.SystemFunctions;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class SystemFunctionsIntegrationTest {

    private static final double accuracy = 10e-5;
    static FirstFunction firstFunctionMock;
    static SecondFunction secondFunctionMock;
    static SystemFunctions system;

    @BeforeAll
    static void setUp() throws UnreachableResultException {
        firstFunctionMock = mock(FirstFunction.class);
        secondFunctionMock = mock(SecondFunction.class);
        when(firstFunctionMock.comp(-6.283185307179586)).thenThrow(new UnreachableResultException(""));
        when(firstFunctionMock.comp(-4.71238898038469)).thenThrow(new UnreachableResultException(""));
        when(firstFunctionMock.comp(-3.141592653589793)).thenThrow(new UnreachableResultException(""));
        when(firstFunctionMock.comp(-1.5707963267948966)).thenThrow(new UnreachableResultException(""));
        when(firstFunctionMock.comp(0.0)).thenThrow(new UnreachableResultException(""));
        when(secondFunctionMock.comp(1)).thenThrow(new UnreachableResultException(""));
        when(firstFunctionMock.comp(-6.160185307179586)).thenReturn(75.52160624166662);
        when(firstFunctionMock.comp(-5.485185307179586)).thenReturn(3.925945632261567);
        when(firstFunctionMock.comp(-4.1351853071795865)).thenReturn(1.7728551213754031);
        when(secondFunctionMock.comp(1.5707963267948966)).thenReturn(1.43713);
        when(secondFunctionMock.comp(3.141592653589793)).thenReturn(3.64301);
        when(secondFunctionMock.comp(4.71238898038469)).thenReturn(4.93338);
        system = new SystemFunctions(accuracy);
        system.firstFunction = firstFunctionMock;
        system.secondFunction = secondFunctionMock;
    }

    static Stream<Arguments> withExceptionsProvider(){
        return Stream.of(
                arguments(-6.283185307179586),
                arguments(-4.71238898038469),
                arguments(-3.141592653589793),
                arguments(-1.5707963267948966),
                arguments(0.0),
                arguments(1.0)
        );
    }

    static Stream<Arguments> valuesRangeProvider(){
        return Stream.of(
                arguments(-6.160185307179586, 75.52160620692274),
                arguments(-5.485185307179586, 3.9259456338239573),
                arguments(-4.1351853071795865, 1.7728551230150995),
                arguments(1.5707963267948966, 1.43713),
                arguments(3.141592653589793, 3.64301),
                arguments(4.71238898038469, 4.93337)
                );
    }

    @DisplayName("Integration Test with Mocks - exceptions")
    @ParameterizedTest(name = "{index}: With PI/2 x = {0}")
    @MethodSource("withExceptionsProvider")
    void test_0(Double value)  {
        assertThrows(UnreachableResultException.class,() -> system.comp(value));
    }

    @DisplayName("Integration Test with Mocks")
    @ParameterizedTest(name = "{index}: Check range of values, x = {0}")
    @MethodSource("valuesRangeProvider")
    void test_1(Double value, Double expected) throws UnreachableResultException {
        assertEquals(expected, system.comp(value), accuracy);
    }

    
}
