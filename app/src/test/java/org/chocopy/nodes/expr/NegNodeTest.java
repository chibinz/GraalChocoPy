package org.chocopy.nodes.expr;

import org.chocopy.nodes.ChocoPyRootNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegNodeTest {
    @Test
    public void negInt() {
        var prog = new ChocoPyRootNode(NegNodeGen.create(new IntLitNode(1)));

        var callTarget = prog.getCallTarget();
        var result = callTarget.call();

        assertEquals(-1, result);
    }
}
