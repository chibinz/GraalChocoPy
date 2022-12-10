package org.chocopy.nodes;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecuteNodeTest {
    @Test
    public void simpleAdd() {
        var prog = new ChocoPyRootNode(new AddNode(
            new IntNode(1),
            new IntNode(2)
        ));

        var callTarget = prog.getCallTarget();
        var result = callTarget.call();

        assertEquals(3, result);
    }
}
