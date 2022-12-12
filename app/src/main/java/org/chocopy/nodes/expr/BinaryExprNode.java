package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.NodeChild;

@NodeChild("leftNode")
@NodeChild("rightNode")
public abstract class BinaryExprNode extends BaseExprNode {
}
