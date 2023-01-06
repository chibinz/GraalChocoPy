package org.chocopy.nodes.stmt;

import org.chocopy.nodes.expr.BaseExprNode;

import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.frame.VirtualFrame;

public class BlockNode extends BaseStmtNode {
    @Children
    private final Node[] stmts;

    public BlockNode(Node... stmts) {
        this.stmts = stmts;
    }

    @Override
    @ExplodeLoop
    public void executeVoid(VirtualFrame frame) {
        for (var stmt : this.stmts) {
            if (stmt instanceof BaseStmtNode) {
                ((BaseStmtNode) stmt).executeVoid(frame);
            } else if (stmt instanceof BaseExprNode) {
                ((BaseExprNode) stmt).executeGeneric(frame);
            } else {
                throw new RuntimeException("Unknown node type in block");
            }
        }
    }
}
