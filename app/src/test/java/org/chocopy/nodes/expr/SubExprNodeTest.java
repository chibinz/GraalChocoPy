package org.chocopy.nodes.expr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubExprNodeTest {
    @Test
    public void subInt() {
        var prog = SubExprNodeGen.create(
            new IntLitNode(2),
            new IntLitNode(1)
        );

        assertEquals(1, prog.executeGeneric(null));
    }

    @Test
    public void subBool() {
        assertThrows(Exception.class, () -> {
            var prog = SubExprNodeGen.create(
                new BoolLitNode(true),
                new BoolLitNode(false)
            );

            prog.executeGeneric(null);
        });
    }
}
