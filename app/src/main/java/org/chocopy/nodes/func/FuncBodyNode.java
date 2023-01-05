package org.chocopy.nodes.func;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.frame.VirtualFrame;

public class FuncBodyNode extends RootNode {
    public FuncBodyNode(FrameDescriptor frameDescriptor) {
        super(null, frameDescriptor);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return null;
    }
}
