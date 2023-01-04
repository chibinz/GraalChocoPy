package org.chocopy.nodes.stmt;

import org.chocopy.nodes.expr.*;
import org.chocopy.nodes.ChocoPyRootNode;
import org.chocopy.nodes.builtin.PrintNode;

import org.junit.jupiter.api.Test;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;

public class WhileNodeTest {
    @Test
    public void testFalse() {
        var prog = new WhileNode(
                new BoolNode(false),
                new BlockNode(new BaseStmtNode[] {
                        new PrintNode(new StrNode("Hello"))
                }));

        prog.executeVoid(null);
    }

    @Test
    public void testLoop10() {
        var builder = FrameDescriptor.newBuilder();
        var s1 = builder.addSlot(FrameSlotKind.Illegal, null, null);

        var root = new ChocoPyRootNode(new BlockNode(
                new BaseStmtNode[] {
                        AssignNodeGen.create(new IntNode(0), s1),
                        new WhileNode(
                                CompNodeGen.create(RefNodeGen.create(s1), new IntNode(10), "<"),
                                new BlockNode(new BaseStmtNode[] {
                                        AssignNodeGen.create(
                                                AddNodeGen.create(
                                                        RefNodeGen.create(s1),
                                                        new IntNode(1)),
                                                s1),
                                        new PrintNode(RefNodeGen.create(s1))
                                })),

                }), builder.build());

        root.getCallTarget().call();
    }

}
