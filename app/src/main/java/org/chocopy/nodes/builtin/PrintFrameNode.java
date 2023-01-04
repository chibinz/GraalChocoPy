package org.chocopy.nodes.builtin;

import org.chocopy.nodes.stmt.BaseStmtNode;

import com.oracle.truffle.api.frame.VirtualFrame;

public class PrintFrameNode extends BaseStmtNode {
    public PrintFrameNode() {
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        var descriptor = frame.getFrameDescriptor();

        System.out.println("Name" + "\t" + "Info" + "\t" + "Kind" + "\t" + "Value");
        for (var i = 0; i < descriptor.getNumberOfSlots(); i++) {
            var name = descriptor.getSlotName(i);
            var info = descriptor.getSlotInfo(i);
            var kind = descriptor.getSlotKind(i);
            var value = frame.getValue(i);
            System.out.println(name + "\t" + info + "\t" + kind + "\t" + value);
        }
    }
}
