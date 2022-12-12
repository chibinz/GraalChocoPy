package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;

@NodeChild("leftNode")
@NodeChild("rightNode")
public abstract class AddExprNode extends BaseExprNode {
    @Specialization
    public int add(int left, int right) {
        return left + right;
    }

    @Fallback
    public Object typeError(Object left, Object right) {
        throw new RuntimeException("Cannot add " + left + " and " + right);
    }
}
