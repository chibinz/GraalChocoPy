package org.chocopy.nodes.expr;

import org.chocopy.nodes.ChocoPyTypeSystem;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;

@TypeSystemReference(ChocoPyTypeSystem.class)
public abstract class BaseExprNode extends Node {
    public abstract Object executeGeneric(VirtualFrame frame);

    public int executeInt(VirtualFrame frame) {
        return (int) executeGeneric(frame);
    }
}
