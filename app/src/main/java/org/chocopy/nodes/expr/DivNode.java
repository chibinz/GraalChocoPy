package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class DivNode extends BinaryExprNode {
    @Specialization
    public int div(int left, int right) {
        return left / right;
    }
}
