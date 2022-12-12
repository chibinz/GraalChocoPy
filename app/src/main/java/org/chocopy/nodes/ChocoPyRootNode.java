package org.chocopy.nodes;

import org.chocopy.nodes.expr.*;

import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.frame.VirtualFrame;

public class ChocoPyRootNode extends RootNode {
    @Child
    private AddExprNode body;

    public ChocoPyRootNode(AddExprNode body) {
        super(null);
        this.body = body;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return body.executeGeneric(frame);
    }
}
