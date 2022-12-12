package org.chocopy.nodes.expr;

import org.chocopy.nodes.ChocoPyTypeSystem;
import org.chocopy.nodes.ChocoPyTypeSystemGen;

import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.dsl.TypeSystemReference;

@TypeSystemReference(ChocoPyTypeSystem.class)
public abstract class BaseExprNode extends Node {
    public abstract Object executeGeneric(VirtualFrame frame);

    public boolean executeBool(VirtualFrame frame) throws UnexpectedResultException {
        return ChocoPyTypeSystemGen.expectBoolean(executeGeneric(frame));
    }

    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        return ChocoPyTypeSystemGen.expectInteger(executeGeneric(frame));
    }

    public String executeStr(VirtualFrame frame) throws UnexpectedResultException {
        return ChocoPyTypeSystemGen.expectString(executeGeneric(frame));
    }
}
