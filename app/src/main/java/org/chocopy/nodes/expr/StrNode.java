package org.chocopy.nodes.expr;

import com.oracle.truffle.api.frame.VirtualFrame;

public class StrNode extends BaseExprNode {
    private final String value;

    public StrNode(String value) {
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
