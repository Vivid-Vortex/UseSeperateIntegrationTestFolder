package com.example.mockbean.DemoMockBeanIntegrationTest;

import com.example.mockbean.DemoMockBeanIntegrationTest.mockedbean.A;
import com.example.mockbean.DemoMockBeanIntegrationTest.mockedbean.ADependent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@Import(TestConfig.class)
@ActiveProfiles("dev-sql")
class AIntegrationTest {

	@Autowired
	private A a; // The real A bean from the application context

	@Autowired
	private ADependent aDependentMock; // This will be our mock from TestConfig

	@Test
	void testAWithMockedDependency() {
		// Additional mock configuration if needed for this specific test
		when(aDependentMock.performOperation("test input")).thenReturn("Special mocked result");

		// Set a test description
		a.setDescription("Test instance");

		// Execute the method that uses the mocked dependency
		String result = a.processData("test input");

		// Assert the result uses our mocked response
		assertEquals("A result: Special mocked result, desc: Test instance", result);

		// Verify the mock was called with the expected argument
		verify(aDependentMock).performOperation("test input");
	}

	@Test
	void testAWithDifferentInput() {
		// Configure mock for this test case
		when(aDependentMock.performOperation("another input")).thenReturn("Another mocked result");

		a.setDescription("Another test");

		// Execute and verify
		String result = a.processData("another input");
		assertEquals("A result: Another mocked result, desc: Another test", result);
		verify(aDependentMock).performOperation("another input");
	}
}