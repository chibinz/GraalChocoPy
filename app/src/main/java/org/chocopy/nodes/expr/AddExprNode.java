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

    @Specialization
    public String add(String left, String right) {
        return left + right;
    }

}
