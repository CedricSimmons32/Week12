package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	
	@ParameterizedTest
	@MethodSource("TestDemoUnitTest#argumentsForAddPositive")
	private void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean exceptException) {
		if(!exceptException) {
		   assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			    assertThatThrownBy(() ->  testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);

			}
		}

	
       static Stream <Arguments> argumentsForAddPositive() {
    	  
    	  return Stream.of(
    			  Arguments.of(1, 2, 3, false),
    			  Arguments.of(2, 4, 6, false),
    			  Arguments.of(-1, 2, 9, false), 
    			  Arguments.of(-3, 6, 7, true),
    			  Arguments.of(5, -5, 8, true),
    			  Arguments.of(4, 8, 10, false),
    			  Arguments.of(3, -2, 3, true),
    			  Arguments.of(-2, 0, 2, true) 
      );
     }


	@Test
    void assertThatNumberSquaredIsCorrect () {
    	TestDemo mockDemo = spy(testDemo);
    	
    	doReturn(5).when(mockDemo).getRandomInt();
    	
    	int fiveSquared = mockDemo.randomNumberSquared();
    	
    	assertThat(fiveSquared).isEqualTo(25);
    }
}   