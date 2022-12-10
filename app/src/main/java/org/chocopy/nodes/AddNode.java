package org.chocopy.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class AddNode extends BaseNode {
    @Child
    private BaseNode left, right;

    public AddNode(BaseNode left, BaseNode right) {
        this.left = left;
        this.right = right;
    }

    public Object execute(VirtualFrame frame) {
        var l = (int) left.execute(frame);
        var r = (int) right.execute(frame);

        return l + r;
    }
}
