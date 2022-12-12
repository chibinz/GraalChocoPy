package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class MulExprNode extends BinaryExprNode {
    @Specialization
    public int mul(int left, int right) {
        return left * right;
    }
}
