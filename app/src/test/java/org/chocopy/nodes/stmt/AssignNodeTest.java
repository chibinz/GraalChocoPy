package org.chocopy.nodes.stmt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;

import org.chocopy.nodes.ChocoPyRootNode;
import org.chocopy.nodes.expr.IntNode;

public class AssignNodeTest {
    @Test
    public void testValidFrame() {
        var builder = FrameDescriptor.newBuilder();
        var s1 = builder.addSlot(FrameSlotKind.Illegal, null, null);
        var s2 = builder.addSlot(FrameSlotKind.Illegal, null, null);

        var root = new ChocoPyRootNode(
                new BlockNode(new BaseStmtNode[] {
                        AssignNodeGen.create(new IntNode(0), s1),
                        AssignNodeGen.create(new IntNode(1), s2),
                        AssignNodeGen.create(new IntNode(2), s1),
                }),
                builder.build());

        root.getCallTarget().call();
    }

    @Test
    public void testEmptyFrame() {
        var root = new ChocoPyRootNode(
                new BlockNode(new BaseStmtNode[] {
                        AssignNodeGen.create(new IntNode(0), 0),
                }),
                null);

        assertThrows(Exception.class, () -> {
            root.getCallTarget().call();
        });
    }
}
