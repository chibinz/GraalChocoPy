package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class DivExprNode extends BinaryExprNode {
    @Specialization
    public int div(int left, int right) {
        return left / right;
    }
}
