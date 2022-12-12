package org.chocopy.nodes.expr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddExprNodeTest {
    @Test
    public void addInt() {
        var prog = AddExprNodeGen.create(
            new IntLitNode(1),
            new IntLitNode(2)
        );


        assertEquals(3, prog.executeGeneric(null));
    }

    @Test
    public void addBool() {
        assertThrows(Exception.class, () -> {
            var prog = AddExprNodeGen.create(
                new BoolLitNode(true),
                new BoolLitNode(false)
            );

            prog.executeGeneric(null);
        });
    }

    @Test
    public void concatStr() {
        var prog = AddExprNodeGen.create(
            new StrLitNode("Hello"),
            new StrLitNode("World")
        );

        assertEquals("HelloWorld", prog.executeGeneric(null));
    }
}
