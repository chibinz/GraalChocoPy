package org.chocopy.nodes.func;

import org.chocopy.nodes.stmt.BlockNode;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.frame.VirtualFrame;

public class FuncBodyNode extends RootNode {
    @Child private BlockNode body;

    public FuncBodyNode(BlockNode body, FrameDescriptor frameDescriptor) {
        super(null, frameDescriptor);
        this.body = body;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        try {
            body.executeVoid(frame);
        } catch (ReturnException e) {
            return e.value;
        }

        return null;
    }
}
