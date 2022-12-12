package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class AddNode extends BinaryExprNode {
    @Specialization
    public int add(int left, int right) {
        return left + right;
    }

    @Specialization
    public String add(String left, String right) {
        return left + right;
    }
}
