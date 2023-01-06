package org.chocopy.nodes.func;

import java.util.stream.Stream;

import org.chocopy.ChocoPyContext;
import org.chocopy.nodes.expr.BaseExprNode;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.frame.VirtualFrame;

public class FuncCallNode extends BaseExprNode {
    private final String name;
    @Children
    private final BaseExprNode[] arguments;

    public FuncCallNode(String name, BaseExprNode[] arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        var context = ChocoPyContext.get(this);
        var callTarget = (CallTarget) context.globalScope.get(name);
        var args = Stream.of(arguments).map(arg -> arg.executeGeneric(frame)).toArray();

        return callTarget.call(args);
    }
}
