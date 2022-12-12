package org.chocopy.nodes.expr;

import org.chocopy.nodes.ChocoPyTypeSystem;
import org.chocopy.nodes.ChocoPyBaseNode;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;

@TypeSystemReference(ChocoPyTypeSystem.class)
public abstract class BaseExprNode extends ChocoPyBaseNode {
    public abstract Object executeGeneric(VirtualFrame frame);

    public int executeInt(VirtualFrame frame) {
        return (int) executeGeneric(frame);
    }

}
