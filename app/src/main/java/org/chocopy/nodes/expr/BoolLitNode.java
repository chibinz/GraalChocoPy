package org.chocopy.nodes.expr;

import com.oracle.truffle.api.frame.VirtualFrame;

public class BoolLitNode extends BaseExprNode {
    private final boolean value;

    public BoolLitNode(boolean value) {
        this.value = value;
    }

    @Override
    public boolean executeBool(VirtualFrame frame) {
        return value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }
}
