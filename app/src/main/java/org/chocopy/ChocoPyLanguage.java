package org.chocopy;

import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.TruffleLanguage;

@TruffleLanguage.Registration(
    id = ChocoPyLanguage.ID,
    name = ChocoPyLanguage.NAME,
    defaultMimeType = ChocoPyLanguage.MIME_TYPE,
    characterMimeTypes = ChocoPyLanguage.MIME_TYPE
)
public class ChocoPyLanguage extends TruffleLanguage<ChocoPyContext> {
    public static final String ID = "chocopy";
    public static final String NAME = "ChocoPy";
    public static final String MIME_TYPE = "application/x-chocopy";

    private static final LanguageReference<ChocoPyLanguage> REF =
        LanguageReference.create(ChocoPyLanguage.class);

    public ChocoPyLanguage() {
        System.out.println("Hello World!");
    }

    public static ChocoPyLanguage get(Node node) {
        return REF.get(node);
    }

    @Override
    protected ChocoPyContext createContext(TruffleLanguage.Env env) {
        return new ChocoPyContext(env);
    }

    @Override
    protected CallTarget parse(TruffleLanguage.ParsingRequest request) throws Exception {
        return null;
    }
}
