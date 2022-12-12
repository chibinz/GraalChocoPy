package org.chocopy.nodes;

import org.chocopy.nodes.expr.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExecuteNodeTest {
    @Test
    public void add2Int() {
        var prog = new ChocoPyRootNode(AddExprNodeGen.create(
            new IntLitNode(1),
            new IntLitNode(2)
        ));

        var callTarget = prog.getCallTarget();
        var result = callTarget.call();

        assertEquals(3, result);
    }

    @Test
    public void add2Bool() {
        assertThrows(Exception.class, () -> {
            var prog = new ChocoPyRootNode(AddExprNodeGen.create(
                new BoolLitNode(true),
                new BoolLitNode(false)
            ));

            prog.getCallTarget().call();
        });
    }

    @Test
    public void concat2Str() {
        var prog = new ChocoPyRootNode(AddExprNodeGen.create(
            new StrLitNode("Hello"),
            new StrLitNode("World")
        ));

        var callTarget = prog.getCallTarget();
        var result = callTarget.call();

        assertEquals("HelloWorld", result);
    }
}
