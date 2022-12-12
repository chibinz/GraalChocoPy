package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;

@NodeChild("child")
public abstract class NegNode extends BaseExprNode {
    @Specialization
    public int neg(int child) {
        return -child;
    }
}
