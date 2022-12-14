package org.chocopy.nodes.func;

import org.chocopy.ChocoPyContext;
import org.chocopy.ChocoPyLanguage;
import org.chocopy.nodes.stmt.BaseStmtNode;
import org.chocopy.nodes.stmt.BlockNode;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;

public class FuncDefNode extends BaseStmtNode {
    private final String name;
    private final FrameDescriptor frameDescriptor;

    @Child private BlockNode body;

    public FuncDefNode(String name, BlockNode body, FrameDescriptor frameDescriptor) {
        this.name = name;
        this.body = body;
        this.frameDescriptor = frameDescriptor;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        var language = ChocoPyLanguage.get(this);
        var context = ChocoPyContext.get(this);

        var funcBodyNode = new FuncBodyNode(language, body, frameDescriptor);

        context.globalScope.put(name, funcBodyNode.getCallTarget());
    }
}
