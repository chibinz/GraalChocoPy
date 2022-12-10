package org.chocopy.nodes;

import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.frame.VirtualFrame;

public abstract class BaseNode extends Node {
    public abstract Object execute(VirtualFrame frame);
}
