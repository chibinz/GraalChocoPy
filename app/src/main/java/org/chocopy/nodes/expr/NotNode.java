package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;

@NodeChild("child")
public abstract class NotNode extends BaseExprNode {
    @Specialization
    public boolean not(boolean child) {
        return !child;
    }

}
