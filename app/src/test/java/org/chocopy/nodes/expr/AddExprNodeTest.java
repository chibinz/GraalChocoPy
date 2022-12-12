package org.chocopy.nodes.expr;

import org.chocopy.nodes.ChocoPyRootNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddExprNodeTest {
    @Test
    public void addInt() {
        var prog = new ChocoPyRootNode(AddExprNodeGen.create(
            new IntLitNode(1),
            new IntLitNode(2)
        ));

        var callTarget = prog.getCallTarget();
        var result = callTarget.call();

        assertEquals(3, result);
    }

    @Test
    public void addBool() {
        assertThrows(Exception.class, () -> {
            var prog = new ChocoPyRootNode(AddExprNodeGen.create(
                new BoolLitNode(true),
                new BoolLitNode(false)
            ));

            prog.getCallTarget().call();
        });
    }

    @Test
    public void concatStr() {
        var prog = new ChocoPyRootNode(AddExprNodeGen.create(
            new StrLitNode("Hello"),
            new StrLitNode("World")
        ));

        var callTarget = prog.getCallTarget();
        var result = callTarget.call();

        assertEquals("HelloWorld", result);
    }
}
