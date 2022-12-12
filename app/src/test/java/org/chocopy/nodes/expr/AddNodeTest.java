package org.chocopy.nodes.expr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddNodeTest {
    @Test
    public void addInt() {
        var prog = AddNodeGen.create(
            new IntNode(1),
            new IntNode(2)
        );


        assertEquals(3, prog.executeGeneric(null));
    }

    @Test
    public void addBool() {
        assertThrows(Exception.class, () -> {
            var prog = AddNodeGen.create(
                new BoolNode(true),
                new BoolNode(false)
            );

            prog.executeGeneric(null);
        });
    }

    @Test
    public void concatStr() {
        var prog = AddNodeGen.create(
            new StrNode("Hello"),
            new StrNode("World")
        );

        assertEquals("HelloWorld", prog.executeGeneric(null));
    }
}
