package org.chocopy;

import com.oracle.truffle.api.TruffleLanguage;

public class ChocoPyLanguage extends TruffleLanguage<ChocoPyContext> {
    public ChocoPyLanguage() {
        System.out.println("Hello World!");
    }

    @Override
    public ChocoPyContext createContext(TruffleLanguage.Env env) {
        return new ChocoPyContext(env);
    }
}
