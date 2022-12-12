package org.chocopy.nodes.expr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogicalExprNodeTest {
    @Test
    public void logicalAnd() {
        var prog = LogicalExprNodeGen.create(
            new BoolLitNode(true),
            new BoolLitNode(false),
            "and"
        );

        assertEquals(false, prog.executeGeneric(null));
    }
}
