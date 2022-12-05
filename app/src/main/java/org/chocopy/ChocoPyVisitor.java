package org.chocopy;

import java.util.HashMap;

public class ChocoPyVisitor extends ChocoPyParserBaseVisitor<Object> {
    private HashMap<String, Object> memory = new HashMap<String, Object>();
    private final static Object NONE = new Object();

    @Override
    public Object visitVar_def(ChocoPyParser.Var_defContext ctx) {
        System.out.println(ctx.children);

        var key = String[].class.cast(visit(ctx.typed_var()));
        var id = key[0];
        var type = key[1];
        var val = visit(ctx.literal());

        memory.put(id, val);

        System.out.println(memory);

        return 0;
    }

    @Override
    public String[] visitTyped_var(ChocoPyParser.Typed_varContext ctx) {
        return new String[] {ctx.IDENTIFIER().getText(), ctx.type().getText()};
    }

    @Override
    public Object visitLitNone(ChocoPyParser.LitNoneContext ctx) {
        return NONE;
    }

    @Override
    public Object visitLitTrue(ChocoPyParser.LitTrueContext ctx) {
        return true;
    }

    @Override
    public Object visitLitFalse(ChocoPyParser.LitFalseContext ctx) {
        return false;
    }

    @Override
    public Object visitLitInt(ChocoPyParser.LitIntContext ctx) {
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Object visitLitIdStr(ChocoPyParser.LitIdStrContext ctx) {
        return ctx.getText();
    }

    @Override
    public Object visitLitStr(ChocoPyParser.LitStrContext ctx) {
        return ctx.getText();
    }



}
