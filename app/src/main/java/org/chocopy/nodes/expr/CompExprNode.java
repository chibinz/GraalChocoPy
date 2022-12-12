package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;

@NodeChild("leftNode")
@NodeChild("rightNode")
@NodeField(name = "op", type = String.class)
public abstract class CompExprNode extends BaseExprNode {
    public abstract String getOp();

    @Specialization
    public boolean comp(int left, int right) {
        return switch (getOp()) {
            case "<" -> left < right;
            case "<=" -> left <= right;
            case ">" -> left > right;
            case ">=" -> left >= right;
            case "==" -> left == right;
            case "!=" -> left != right;
            default -> throw new RuntimeException("Invalid operator: " + getOp());
        };
    }
}
