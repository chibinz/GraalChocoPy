package org.chocopy;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class App {
    public static void main(String[] args) {
        runSimpleVisitor(args[0]);
    }

    public String getGreeting() {
        return "Hello World!";
    }

    public static void runSimpleVisitor(String path) {
        var parseTree = parseFile(path);
        var visitor = new ChocoPySimpleVisitor();

        visitor.visit(parseTree);
    }

    public static void printParseTree(ParseTree tree) {
        var parser = new ChocoPyParser(null);
        var buf = new StringBuilder();

        recursive(tree, buf, 0, Arrays.asList(parser.getRuleNames()));

        System.out.println(buf);
    }

    private static ParseTree parseFile(String path) {
        try {
            var lexer = new ChocoPyLexer(CharStreams.fromPath(Path.of(path)));
            var parser = new ChocoPyParser(
                    new CommonTokenStream(lexer));

            parser.setBuildParseTree(true);
            return parser.program();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
            return null;
        }
    }

    private static void recursive(ParseTree aRoot, StringBuilder buf, int offset, List<String> ruleNames) {
        for (int i = 0; i < offset; i++) {
            buf.append("  ");
        }
        buf.append(Trees.getNodeText(aRoot, ruleNames)).append("\n");
        if (aRoot instanceof ParserRuleContext) {
            ParserRuleContext prc = (ParserRuleContext) aRoot;
            if (prc.children != null) {
                for (ParseTree child : prc.children) {
                    recursive(child, buf, offset + 1, ruleNames);
                }
            }
        }
    }
}
