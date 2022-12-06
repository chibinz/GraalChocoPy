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

        // System.out.println(memory);

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

    @Override
    public Object visitBinExpr(ChocoPyParser.BinExprContext ctx) {
        var left = Integer.class.cast(visit(ctx.pexpr(0)));
        var right = Integer.class.cast(visit(ctx.pexpr(1)));
        var op = ctx.bin_op().getText();

        return switch (op) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "//" -> left / right;
            case "%" -> left % right;
            default -> throw new RuntimeException("Unknown binary operator");
        };
    }

    @Override
    public Object visitListExpr(ChocoPyParser.ListExprContext ctx) {
        var len = ctx.expr().size();
        var list = new Object[len];

        for (int i = 0; i < len; i++) {
            System.out.println(ctx.expr(i).getText());
            list[i] = visit(ctx.expr(i));
        }

        return list;
    }
}
