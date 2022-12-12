package org.chocopy.nodes.expr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogicalNodeTest {
    @Test
    public void logicalAnd() {
        var prog = LogicalNodeGen.create(
            new BoolNode(true),
            new BoolNode(false),
            "and"
        );

        assertEquals(false, prog.executeGeneric(null));
    }
}
