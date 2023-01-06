package org.chocopy.nodes.func;

import org.chocopy.nodes.expr.BaseExprNode;
import org.chocopy.nodes.stmt.BaseStmtNode;

import com.oracle.truffle.api.frame.VirtualFrame;

public class FuncReturnNode extends BaseStmtNode {
    @Child private BaseExprNode value;

    public FuncReturnNode(BaseExprNode value) {
        this.value = value;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        throw new ReturnException(value.executeGeneric(frame));
    }
}
