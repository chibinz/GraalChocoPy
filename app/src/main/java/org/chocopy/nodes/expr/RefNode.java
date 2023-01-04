package org.chocopy.nodes.expr;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;

@NodeField(name = "slot", type = int.class)
public abstract class RefNode extends BaseExprNode {
    public abstract int getSlot();

    @Specialization(guards = "frame.isBoolean(getSlot())")
    public boolean refBool(VirtualFrame frame) {
        return frame.getBoolean(getSlot());
    }

    @Specialization(guards = "frame.isInt(getSlot())")
    public int refInt(VirtualFrame frame) {
        return frame.getInt(getSlot());
    }

    @Specialization(guards = "frame.isObject(getSlot())")
    public String refStr(VirtualFrame frame) {
        return (String) frame.getObject(getSlot());
    }
}
