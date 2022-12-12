package org.chocopy.nodes.expr;

import org.chocopy.nodes.ChocoPyRootNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogicalExprNodeTest {
    @Test
    public void logicalAnd() {
        var prog = new ChocoPyRootNode(LogicalExprNodeGen.create(
            new BoolLitNode(true),
            new BoolLitNode(false),
            "and"
        ));

        var callTarget = prog.getCallTarget();
        var result = callTarget.call();

        assertEquals(false, result);
    }
}
