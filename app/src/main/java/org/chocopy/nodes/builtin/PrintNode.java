package org.chocopy.nodes.builtin;

import org.chocopy.nodes.expr.BaseExprNode;
import org.chocopy.nodes.stmt.BaseStmtNode;

import com.oracle.truffle.api.frame.VirtualFrame;

public class PrintNode extends BaseStmtNode {
    private final BaseExprNode expr;

    public PrintNode(BaseExprNode expr) {
        this.expr = expr;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        System.out.println(expr.executeGeneric(frame));
    }
}
