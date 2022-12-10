package org.chocopy;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class App {
    public static void main(String[] args) throws IOException {
        var parseTree = parseFile(args[0]);
        var visitor = new ChocoPySimpleVisitor();

        // printParseTree(parseTree);
        visitor.visit(parseTree);
    }

    public String getGreeting() {
        return "Hello World!";
    }

    private static ParseTree parseFile(String arg) throws IOException {
        var lexer = new ChocoPyLexer(CharStreams.fromPath(Path.of(arg)));
        var parser = new ChocoPyParser(
                new CommonTokenStream(lexer));

        parser.setBuildParseTree(true);
        return parser.program();
    }

    private static void printParseTree(ParseTree tree) {
        var parser = new ChocoPyParser(null);
        var buf = new StringBuilder();

        recursive(tree, buf, 0, Arrays.asList(parser.getRuleNames()));

        System.out.println(buf);
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
