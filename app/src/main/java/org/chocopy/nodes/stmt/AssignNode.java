package org.chocopy.nodes.stmt;

import org.chocopy.nodes.expr.*;

import com.oracle.truffle.api.frame.VirtualFrame;

public class AssignNode extends BaseStmtNode {
    @Children private BaseExprNode[] targets;
    @Child private BaseExprNode valueNode;

    private final int slot;

    public AssignNode(int slot, BaseExprNode[] targets, BaseExprNode valueNode) {
        this.slot = slot;
        this.targets = targets;
        this.valueNode = valueNode;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        var value = valueNode.executeGeneric(frame);

        for (var target : targets) {
            frame.setObject(slot, value);
        }
    }
}
