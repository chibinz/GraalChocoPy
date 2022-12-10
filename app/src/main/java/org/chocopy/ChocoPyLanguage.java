package org.chocopy;

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

    public ChocoPyLanguage() {
        System.out.println("Hello World!");
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
