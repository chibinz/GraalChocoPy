package org.chocopy.nodes.expr;

import org.chocopy.nodes.ChocoPyRootNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompExprNodeTest {
    @Test
    public void compEqual() {
        var prog = new ChocoPyRootNode(CompExprNodeGen.create(
            new IntLitNode(1),
            new IntLitNode(1),
            "=="
        ));

        var callTarget = prog.getCallTarget();
        var result = callTarget.call();

        assertEquals(true, result);
    }

    @Test void compLessThan() {
        var prog = new ChocoPyRootNode(CompExprNodeGen.create(
            new IntLitNode(1),
            new IntLitNode(2),
            "<"
        ));

        var callTarget = prog.getCallTarget();
        var result = callTarget.call();

        assertEquals(true, result);
    }
}
