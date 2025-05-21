package com.example.mockbean.DemoMockBeanIntegrationTest.mockedbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ADependent aDependent() {
        ADependent aDependent = new ADependent();
        aDependent.setName("RealDependency");
        aDependent.setValue(100);
        return aDependent;
    }

    @Bean
    public A a(ADependent aDependent) {
        A a = new A(aDependent);
        a.setDescription("Production instance");
        return a;
    }
}
