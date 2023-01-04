package org.chocopy.nodes.stmt;

import org.chocopy.nodes.expr.BaseExprNode;

import com.oracle.truffle.api.frame.VirtualFrame;

public class WhileNode extends BaseStmtNode {
    @Child private BaseExprNode cond;
    @Child private BlockNode block;

    public WhileNode(BaseExprNode cond, BlockNode block) {
        this.cond = cond;
        this.block = block;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        while ((boolean) cond.executeGeneric(frame)) {
            block.executeVoid(frame);
        }
    }
}
