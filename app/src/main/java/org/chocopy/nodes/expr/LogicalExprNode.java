package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;

@NodeChild("leftNode")
@NodeChild("rightNode")
@NodeField(name = "op", type = String.class)
public abstract class LogicalExprNode extends BaseExprNode {
    public abstract String getOp();

    @Specialization
    public boolean logical(boolean left, boolean right) {
        return switch (getOp()) {
            case "and" -> left && right;
            case "or" -> left || right;
            default -> throw new RuntimeException("Invalid operator: " + getOp());
        };
    }
}
