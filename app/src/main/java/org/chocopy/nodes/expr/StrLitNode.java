package org.chocopy.nodes.expr;

import com.oracle.truffle.api.frame.VirtualFrame;

public class StrLitNode extends BaseExprNode {
    private final String value;

    public StrLitNode(String value) {
        this.value = value;
    }

    @Override
    public String executeStr(VirtualFrame frame) {
        return value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }
}
