package org.chocopy.nodes.expr;


import com.oracle.truffle.api.frame.VirtualFrame;

public class IntNode extends BaseExprNode {
    private final int value;

    public IntNode(int value) {
        this.value = value;
    }

    @Override
    public int executeInt(VirtualFrame frame) {
        return value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }
}
