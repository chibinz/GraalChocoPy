package org.chocopy.nodes.func;

public class ReturnException extends RuntimeException {
    public final Object value;

    public ReturnException(Object value) {
        this.value = value;
    }
}
