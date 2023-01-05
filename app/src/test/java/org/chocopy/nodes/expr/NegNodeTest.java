package org.chocopy.nodes.expr;

import org.chocopy.nodes.literal.IntNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegNodeTest {
    @Test
    public void negInt() {
        var prog = NegNodeGen.create(new IntNode(1));

        assertEquals(-1, prog.executeGeneric(null));
    }
}
