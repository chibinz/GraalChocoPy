package org.chocopy.nodes.stmt;

import org.chocopy.nodes.expr.*;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.frame.FrameSlotKind;

@NodeChild(value = "valueNode", type = BaseExprNode.class)
@NodeField(name = "slot", type = int.class)
public abstract class AssignNode extends BaseStmtNode {
    public abstract BaseExprNode getValueNode();
    public abstract int getSlot();

    @Specialization
    public void assignBool(VirtualFrame frame, boolean value) {
        frame.getFrameDescriptor().setSlotKind(getSlot(), FrameSlotKind.Boolean);
        frame.setBoolean(getSlot(), value);
    }

    @Specialization
    public void assignInt(VirtualFrame frame, int value) {
        frame.getFrameDescriptor().setSlotKind(getSlot(), FrameSlotKind.Int);
        frame.setInt(getSlot(), value);
    }

    @Specialization
    public void assignStr(VirtualFrame frame, String value) {
        frame.getFrameDescriptor().setSlotKind(getSlot(), FrameSlotKind.Object);
        frame.setObject(getSlot(), value);
    }
}
