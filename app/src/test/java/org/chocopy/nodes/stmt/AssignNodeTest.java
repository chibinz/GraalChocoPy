package org.chocopy.nodes.stmt;

import org.junit.jupiter.api.Test;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;

public class AssignNodeTest {
    @Test
    public void test() {
        var builder = FrameDescriptor.newBuilder();
        var slot1 = builder.addSlot(FrameSlotKind.Illegal, null, null);
        var slot2 = builder.addSlot(FrameSlotKind.Illegal, null, null);

        var builder2 = FrameDescriptor.newBuilder();
        var slot3 = builder2.addSlot(FrameSlotKind.Illegal, null, null);
        System.out.println(slot1);
        System.out.println(slot2);
        System.out.println(slot3);

        var node = new AssignNode(0, null, null);
    }
}
