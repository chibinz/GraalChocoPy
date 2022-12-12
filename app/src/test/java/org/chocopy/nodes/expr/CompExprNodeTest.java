package org.chocopy.nodes.expr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompExprNodeTest {
    @Test
    public void compEqual() {
        var prog = CompExprNodeGen.create(
            new IntLitNode(1),
            new IntLitNode(1),
            "=="
        );

        assertEquals(true, prog.executeGeneric(null));
    }

    @Test void compLessThan() {
        var prog = CompExprNodeGen.create(
            new IntLitNode(1),
            new IntLitNode(2),
            "<"
        );

        assertEquals(true, prog.executeGeneric(null));
    }
}
