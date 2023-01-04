package org.chocopy.nodes.stmt;

import org.chocopy.nodes.expr.*;
import org.chocopy.nodes.builtin.PrintNode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IfNodeTest {
    @Test
    public void testSingleIf() {
        var prog = new IfNode(
                new BaseExprNode[] { new BoolNode(true) },
                new BlockNode[] { new BlockNode(new BaseStmtNode[] {
                        new PrintNode(new StrNode("Hello"))
                }) });

        prog.executeVoid(null);
    }

    @Test
    public void testInvalidCond() {
        var prog = new IfNode(
                new BaseExprNode[] { new IntNode(0) },
                new BlockNode[] { new BlockNode(new BaseStmtNode[] {
                        new PrintNode(new StrNode("Hello"))
                }) });

        assertThrows(Exception.class, () -> {
            prog.executeVoid(null);
        });
    }

    @Test
    void testIfElifElse() {
        var prog = new IfNode(
                new BaseExprNode[] {
                        new BoolNode(false),
                        new BoolNode(false),
                },
                new BlockNode[] {
                        new BlockNode(new BaseStmtNode[] {
                                new PrintNode(new StrNode("Hello"))
                        }),
                        new BlockNode(new BaseStmtNode[] {
                                new PrintNode(new StrNode("World"))
                        }),
                        new BlockNode(new BaseStmtNode[] {
                                new PrintNode(new StrNode("!!!"))
                        }),
                });

        prog.executeVoid(null);
    }
}
