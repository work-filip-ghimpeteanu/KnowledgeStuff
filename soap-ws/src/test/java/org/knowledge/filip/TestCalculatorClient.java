package org.knowledge.filip;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestCalculatorClient {

    private CalculatorClient client;

    @Test
    public void testCalculatorClient() {
        client = new CalculatorClient();

        assertThat("Sum doesn't match", 4, is(client.doAddition(2, 2)));
        assertThat("Sum doesn't match", 3, is(client.doSubstraction(4, 1)));
        assertThat("Sum doesn't match", -6, is(client.doMultiplication(-3, 2)));
        assertThat("Sum doesn't match", -2, is(client.doDivision(-4, 2)));
    }

}
