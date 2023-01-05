package org.chocopy;

import java.util.HashMap;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.nodes.Node;

public class ChocoPyContext {
    private static final ContextReference<ChocoPyContext> REF = ContextReference.create(ChocoPyLanguage.class);
    private final TruffleLanguage.Env env;
    public final HashMap<String, Object> globalScope = new HashMap<>();

    public ChocoPyContext(TruffleLanguage.Env env) {
        this.env = env;
    }

    public static ChocoPyContext get(Node node) {
        return REF.get(node);
    }
}
