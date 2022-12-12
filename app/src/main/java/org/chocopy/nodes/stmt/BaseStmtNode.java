package org.chocopy.nodes.stmt;

import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.frame.VirtualFrame;

public abstract class BaseStmtNode extends Node {
    public abstract void executeVoid(VirtualFrame frame);
}
