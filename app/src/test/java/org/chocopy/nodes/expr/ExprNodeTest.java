package org.chocopy.nodes.expr;

import org.chocopy.nodes.literal.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExprNodeTest {
    @Test
    public void integratedTest() {
        // -1 + 2 == ((3 * 4) % 5) - 1
        var prog = LogicalNodeGen.create(
            CompNodeGen.create(
                AddNodeGen.create(
                    NegNodeGen.create(new IntNode(1)),
                    new IntNode(2)
                ),
                SubNodeGen.create(
                    ModNodeGen.create(
                        MulNodeGen.create(new IntNode(3), new IntNode(4)),
                        new IntNode(5)
                    ),
                    new IntNode(1)
                ),
                "=="
            ),
            new BoolNode(true),
            "and"
        );

        assertEquals(true, prog.executeGeneric(null));
    }
}
