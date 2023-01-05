package org.chocopy.nodes.expr;

import org.chocopy.nodes.literal.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompNodeTest {
    @Test
    public void compEqual() {
        var prog = CompNodeGen.create(
            new IntNode(1),
            new IntNode(1),
            "=="
        );

        assertEquals(true, prog.executeGeneric(null));
    }

    @Test void compLessThan() {
        var prog = CompNodeGen.create(
            new IntNode(1),
            new IntNode(2),
            "<"
        );

        assertEquals(true, prog.executeGeneric(null));
    }
}
