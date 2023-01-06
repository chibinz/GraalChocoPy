package org.chocopy.nodes.func;

import org.chocopy.nodes.*;
import org.chocopy.nodes.stmt.*;
import org.chocopy.nodes.expr.*;
import org.chocopy.nodes.literal.*;
import org.chocopy.nodes.builtin.*;
import org.junit.jupiter.api.Test;

import org.graalvm.polyglot.Context;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;

public class FuncNodeTest {
    @Test
    void testPrint() {
        var builder = FrameDescriptor.newBuilder();
        builder.addSlot(FrameSlotKind.Illegal, null, null);

        var frameDescriptor = builder.build();

        var prog = new BlockNode(
                new FuncDefNode("myprint", new BlockNode(
                        new PrintFrameNode(),
                        new PrintNode()), frameDescriptor),
                new FuncCallNode("myprint", new BaseExprNode[] { new IntNode(1) }));

        var context = Context.create("chocopy");
        context.initialize("chocopy");
        context.enter();

        prog.executeVoid(null);

    }
}
