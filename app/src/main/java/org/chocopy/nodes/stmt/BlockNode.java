package org.chocopy.nodes.stmt;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;

public class BlockNode extends BaseStmtNode {
    @Children
    private final BaseStmtNode[] stmts;

    public BlockNode(BaseStmtNode[] stmts) {
        this.stmts = stmts;
    }

    @Override
    @ExplodeLoop
    public void executeVoid(VirtualFrame frame) {
        for (var stmt : this.stmts) {
            stmt.executeVoid(frame);
        }
    }
}
