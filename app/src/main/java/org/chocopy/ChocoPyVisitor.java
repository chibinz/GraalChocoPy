package org.chocopy;

import java.util.HashMap;

public class ChocoPyVisitor extends ChocoPyParserBaseVisitor<Object> {
    private HashMap<String, Object> memory = new HashMap<String, Object>();
    private final static Object NONE = new Object();

    @Override
    public Object visitVar_def(ChocoPyParser.Var_defContext ctx) {
        var id = visitTyped_var(ctx.typed_var());
        var val = visit(ctx.literal());

        memory.put(id, val);

        System.out.println(memory);

        return 0;
    }

    @Override
    public String visitTyped_var(ChocoPyParser.Typed_varContext ctx) {
        return ctx.IDENTIFIER().getText();
    }

    @Override
    public Object visitLiteral(ChocoPyParser.LiteralContext ctx) {
        var rule = ctx.lit.getType();

        return switch (rule) {
            case ChocoPyParser.NONE -> NONE;
            case ChocoPyParser.TRUE -> true;
            case ChocoPyParser.FALSE -> false;
            case ChocoPyParser.INTEGER -> Integer.parseInt(ctx.getText());
            case ChocoPyParser.IDSTRING -> ctx.getText();
            case ChocoPyParser.STRING -> ctx.getText();
            default -> throw new RuntimeException("Unknown literal type");
        };
    }



}
