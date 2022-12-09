package org.chocopy;

import java.util.HashMap;

public class ChocoPyVisitor extends ChocoPyParserBaseVisitor<Object> {
    private HashMap<String, Object> memory = new HashMap<String, Object>();
    private final static Object NONE = new Object();

    @Override
    public Object visitProgram(ChocoPyParser.ProgramContext ctx) {
        visitChildren(ctx);

        System.out.println(memory);

        return NONE;
    }

    @Override
    public Object visitFunc_def(ChocoPyParser.Func_defContext ctx) {
        var id = ctx.func_sig().IDENTIFIER().getText();

        memory.put(id, ctx);

        return NONE;
    }

    @Override
    public String visitTyped_var(ChocoPyParser.Typed_varContext ctx) {
        return ctx.IDENTIFIER().getText();
    }

    @Override
    public Object visitVar_def(ChocoPyParser.Var_defContext ctx) {
        var id = visitTyped_var(ctx.typed_var());
        var val = visit(ctx.literal());

        memory.put(id, val);
        System.out.println(memory);

        return NONE;
    }

    @Override
    public Object visitIfStmt(ChocoPyParser.IfStmtContext ctx) {
        for (var i = 0; i < ctx.expr().size(); i++) {
            var cond = Boolean.class.cast(visit(ctx.expr(i)));

            if (cond) {
                return visit(ctx.block(i));
            }
        }

        if (ctx.ELSE() != null) {
            var len = ctx.block().size();
            return visit(ctx.block(len - 1));
        }

        return NONE;
    }

    @Override
    public Object visitWhileStmt(ChocoPyParser.WhileStmtContext ctx) {
        var cond = Boolean.class.cast(visit(ctx.expr()));
        while (cond) {
            visit(ctx.block());
            cond = Boolean.class.cast(visit(ctx.expr()));
        }

        return NONE;
    }

    @Override
    public Object visitForStmt(ChocoPyParser.ForStmtContext ctx) {
        var arr = Object[].class.cast(visit(ctx.expr()));
        if (arr == null) {
            throw new RuntimeException("Cannot iterate over non-list");
        }
        var id = ctx.IDENTIFIER().getText();

        for (var val : arr) {
            memory.put(id, val);
            visit(ctx.block());
        }

        return NONE;
    }

    @Override
    public Object visitAssignStmt(ChocoPyParser.AssignStmtContext ctx) {
        var val = visit(ctx.expr());

        for (var id : ctx.target()) {
            memory.put(id.getText(), val);
        }

        System.out.println(memory);

        return NONE;
    }

    @Override
    public Object visitLiteral(ChocoPyParser.LiteralContext ctx) {
        var rule = ctx.lit.getType();

        return switch (rule) {
            case ChocoPyParser.NONE -> NONE;
            case ChocoPyParser.TRUE -> true;
            case ChocoPyParser.FALSE -> false;
            case ChocoPyParser.INTEGER -> Integer.parseInt(ctx.getText());
            case ChocoPyParser.IDSTRING -> ctx.getText().replace("\"", "");
            case ChocoPyParser.STRING -> ctx.getText().replace("\"", "");
            default -> throw new RuntimeException("Unknown literal type");
        };
    }

    @Override
    public Object visitIdExpr(ChocoPyParser.IdExprContext ctx) {
        var id = ctx.IDENTIFIER().getText();
        var val = memory.get(id);

        if (id.equals("print")) {
            return NONE;
        }

        if (val == null) {
            throw new RuntimeException("Undefined variable: " + id);
        }

        return val;
    }

    @Override
    public Object visitListExpr(ChocoPyParser.ListExprContext ctx) {
        var len = ctx.expr().size();
        var list = new Object[len];

        for (int i = 0; i < len; i++) {
            list[i] = visit(ctx.expr(i));
        }

        return list;
    }

    @Override
    public Object visitIndexExpr(ChocoPyParser.IndexExprContext ctx) {
        var list = Object[].class.cast(visit(ctx.pexpr()));
        var index = Integer.class.cast(visit(ctx.index_op().expr()));

        assert list != null;
        assert index != null;

        return list[index];
    }

    @Override
    public Object visitCallExpr(ChocoPyParser.CallExprContext ctx) {
        if (ctx.pexpr().getText().equals("print")) {
            var args = ctx.call_op().expr();
            for (var arg : args) {
                System.out.print(visit(arg));
                System.out.print(" ");
            }
            System.out.println();
            return NONE;
        }

        var func = ChocoPyParser.Func_defContext.class.cast(visit(ctx.pexpr()));
        var args = ctx.call_op().expr();
        var params = func.func_sig().typed_var();

        System.out.println(func.func_sig().getText());

        if (args.size() != params.size()) {
            throw new RuntimeException("Wrong number of arguments");
        }

        for (var i = 0; i < args.size(); i++) {
            var arg = visit(args.get(i));
            var param = visitTyped_var(params.get(i));

            memory.put(param, arg);
        }

        return visit(func.func_body());
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
    public Object visitNegExpr(ChocoPyParser.NegExprContext ctx) {
        var val = Integer.class.cast(visit(ctx.pexpr()));
        return -val;
    }
}
