package it.unibo.exceptions.fakenetwork.impl;

import it.unibo.exceptions.arithmetic.ArithmeticService;
import it.unibo.exceptions.fakenetwork.api.NetworkComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

import static it.unibo.exceptions.arithmetic.ArithmeticService.KEYWORDS;
import static it.unibo.exceptions.arithmetic.ArithmeticUtil.nullIfNumberOrException;

/**
 * A NetworkComponent mimicking an unstable network.
 */
public final class ServiceBehindUnstableNetwork implements NetworkComponent {
    private final double failProbability;
    private final RandomGenerator randomGenerator;
    private final List<String> commandQueue = new ArrayList<>();

    
    public ServiceBehindUnstableNetwork(final double failProbability, final int randomSeed) {
        if (failProbability < 0 || failProbability >= 1) {
            throw new IllegalArgumentException("failProbability = " + failProbability + ": outside of range [0, 1[");
        }
        this.failProbability = failProbability;
        randomGenerator = new Random(randomSeed);
    }
    
    public ServiceBehindUnstableNetwork(final double failProbability) {
        this(failProbability, 0);
    }
    
    public ServiceBehindUnstableNetwork() {
        this(0.5);
    }

    public void sendData(final String data) throws IOException {
        accessTheNework(data);
        final var exceptionWhenParsedAsNumber = nullIfNumberOrException(data);
        if (KEYWORDS.contains(data) || exceptionWhenParsedAsNumber == null) {
            commandQueue.add(data);
        } else {
            final var message = data + " is not a valid keyword (allowed: " + KEYWORDS + "), nor is a number";
            commandQueue.clear();
            throw new IllegalArgumentException(message, exceptionWhenParsedAsNumber);
        }
    }

    public String receiveResponse() throws IOException {
        accessTheNework(null);
        try {
            return new ArithmeticService(Collections.unmodifiableList(commandQueue)).process();
        } finally {
            commandQueue.clear();
        }
    }

    private void accessTheNework(final String message) throws IOException {
        if (randomGenerator.nextDouble() < failProbability) {
            throw new NetworkException(message);
        }
    }

}
