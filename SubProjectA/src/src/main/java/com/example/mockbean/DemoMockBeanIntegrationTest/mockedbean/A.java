package com.example.mockbean.DemoMockBeanIntegrationTest.mockedbean;

/**
 * Main class that depends on ADependent
 */
public class A {

    private ADependent aDependent;
    private String description;

    public A() {
    }

    public A(ADependent aDependent) {
        this.aDependent = aDependent;
    }

    public ADependent getADependent() {
        return aDependent;
    }

    public void setADependent(ADependent aDependent) {
        this.aDependent = aDependent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method that uses the dependency
     */
    public String processData(String input) {
        if (aDependent == null) {
            throw new IllegalStateException("ADependent is not set");
        }
        return "A result: " + aDependent.performOperation(input) + ", desc: " + description;
    }
}

