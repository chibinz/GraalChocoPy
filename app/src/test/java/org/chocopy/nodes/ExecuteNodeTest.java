package org.chocopy.nodes;

import org.chocopy.nodes.expr.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecuteNodeTest {
    @Test
    public void simpleAdd() {
        var prog = new ChocoPyRootNode(AddExprNodeGen.create(
            new IntLitNode(1),
            new IntLitNode(2)
        ));

        var callTarget = prog.getCallTarget();
        var result = callTarget.call();

        assertEquals(3, result);
    }
}
