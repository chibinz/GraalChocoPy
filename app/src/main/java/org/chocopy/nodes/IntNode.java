package org.chocopy.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class IntNode extends BaseNode {
    private final int value;

    public IntNode(int value) {
        this.value = value;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return value;
    }
}
