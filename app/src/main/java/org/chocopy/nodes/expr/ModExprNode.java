package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class ModExprNode extends BinaryExprNode {
    @Specialization
    public int mul(int left, int right) {
        return left % right;
    }
}
