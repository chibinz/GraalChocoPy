package org.chocopy.nodes;

import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.frame.VirtualFrame;

public class ChocoPyRootNode extends RootNode {
    @Child
    private BaseNode body;

    public ChocoPyRootNode(BaseNode body) {
        super(null);
        this.body = body;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return body.execute(frame);
    }
}
