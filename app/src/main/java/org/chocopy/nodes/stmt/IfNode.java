package org.chocopy.nodes.stmt;

import org.chocopy.nodes.expr.BaseExprNode;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;

public class IfNode extends BaseStmtNode {
    @Children private final BaseExprNode[] conds;
    @Children private final BlockNode[] blocks;

    public IfNode(BaseExprNode[] conds, BlockNode[] blocks) {
        this.conds = conds;
        this.blocks = blocks;
        assert (conds.length == blocks.length || conds.length == blocks.length - 1);
    }

    @Override
    @ExplodeLoop
    public void executeVoid(VirtualFrame frame) {
        // Execute the first block whose condition is true.
        for (var i = 0; i < conds.length; i++) {
            var cond = (boolean) conds[i].executeGeneric(frame);

            if (cond) {
                this.blocks[i].executeVoid(frame);
                return;
            }
        }

        // If no condition was true, execute the last block.
        if (blocks.length > conds.length) {
            blocks[blocks.length - 1].executeVoid(frame);
        }
    }
}
