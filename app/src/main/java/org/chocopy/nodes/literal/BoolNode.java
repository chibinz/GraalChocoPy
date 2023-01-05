package org.chocopy.nodes.literal;

import org.chocopy.nodes.expr.BaseExprNode;

import com.oracle.truffle.api.frame.VirtualFrame;

public class BoolNode extends BaseExprNode {
    private final boolean value;

    public BoolNode(boolean value) {
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
