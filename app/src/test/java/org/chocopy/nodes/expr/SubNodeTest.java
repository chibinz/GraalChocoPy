package org.chocopy.nodes.expr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubNodeTest {
    @Test
    public void subInt() {
        var prog = SubNodeGen.create(
            new IntNode(2),
            new IntNode(1)
        );

        assertEquals(1, prog.executeGeneric(null));
    }

    @Test
    public void subBool() {
        assertThrows(Exception.class, () -> {
            var prog = SubNodeGen.create(
                new BoolNode(true),
                new BoolNode(false)
            );

            prog.executeGeneric(null);
        });
    }
}
