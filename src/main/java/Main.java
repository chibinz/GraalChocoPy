import java.io.IOException;
import java.nio.file.Path;
import org.antlr.v4.runtime.*;

// import com.oracle.truffle.api.TruffleLanguage;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args ) throws IOException {
        runFile(args[0]);
    }

    private static void runFile(String arg) throws IOException {
        var lexer = new ChocoPyLexer(CharStreams.fromPath(Path.of(arg)));
        var parser = new ChocoPyParser(
                new CommonTokenStream(lexer)
        );

        parser.setBuildParseTree(true);
        System.out.println(parser.program().toStringTree(parser));
    }
}

// class ChocoPyContext {
//     public ChocoPyContext(TruffleLanguage.Env env) {
//     }
// }

// class ChocoPyLanguage extends TruffleLanguage<ChocoPyContext> {
//     public ChocoPyLanguage() {
//         System.out.println("Hello World!");
//     }

//     @Override
//     public ChocoPyContext createContext(TruffleLanguage.Env env) {
//         return new ChocoPyContext(env);
//     }
// }
