package com.example.mockbean.DemoMockBeanIntegrationTest.mockedbean;

/**
 * Dependency class that will be mocked in tests
 */
public class ADependent {

    private String name;
    private int value;

    public ADependent() {
    }

    public ADependent(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * A method that we'll mock in our tests
     */
    public String performOperation(String input) {
        // In a real scenario, this might interact with native code or other complex dependencies
        return "Processed: " + input + " with value " + value;
    }
}
