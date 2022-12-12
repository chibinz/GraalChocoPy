package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class SubExprNode extends BinaryExprNode {
    @Specialization
    public int sub(int left, int right) {
        return left - right;
    }
}
