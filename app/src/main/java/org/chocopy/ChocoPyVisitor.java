package org.chocopy;

public class ChocoPyVisitor extends ChocoPyParserBaseVisitor<Object> {
    @Override
    public Object visitVar_def(ChocoPyParser.Var_defContext ctx) {
        System.out.println(ctx.children);

        return 0;
    }
}
