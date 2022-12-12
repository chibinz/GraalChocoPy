package org.chocopy.nodes.expr;

import org.chocopy.nodes.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubExprNodeTest {
    @Test
    public void subInt() {
        var prog = new ChocoPyRootNode(SubExprNodeGen.create(
            new IntLitNode(2),
            new IntLitNode(1)
        ));

        var callTarget = prog.getCallTarget();
        var result = callTarget.call();

        assertEquals(1, result);
    }

    @Test
    public void subBool() {
        assertThrows(Exception.class, () -> {
            var prog = new ChocoPyRootNode(SubExprNodeGen.create(
                new BoolLitNode(true),
                new BoolLitNode(false)
            ));

            prog.getCallTarget().call();
        });
    }
}
