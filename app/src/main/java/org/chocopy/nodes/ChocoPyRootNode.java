package org.chocopy.nodes;

import org.chocopy.ChocoPyLanguage;
import org.chocopy.nodes.stmt.BaseStmtNode;

import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;

public class ChocoPyRootNode extends RootNode {
    @Child
    private BaseStmtNode body;

    public ChocoPyRootNode(ChocoPyLanguage language, BaseStmtNode body, FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
        this.body = body;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        body.executeVoid(frame);

        return null;
    }
}
