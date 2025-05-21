package com.example.mockbean.DemoMockBeanIntegrationTest;

import com.example.mockbean.DemoMockBeanIntegrationTest.mockedbean.ADependent;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Test configuration that provides mock beans for the integration test
 */
@TestConfiguration
@Profile("dev-sql")
class TestConfig {

    @Value("${test.str}")
    String testString;

    /**
     * Create a mock of ADependent that will replace the real bean in the application context
     * @Primary ensures this bean is chosen over any other bean of the same type
     */
    @Bean
    @Primary
    public ADependent aDependentMock() {
        ADependent mockDependency = Mockito.mock(ADependent.class);
        // Configure default behavior for the mock
        when(mockDependency.performOperation(anyString())).thenReturn(testString);
        return mockDependency;
    }
}