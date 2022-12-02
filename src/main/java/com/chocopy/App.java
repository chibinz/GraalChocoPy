package com.chocopy;

import com.oracle.truffle.api.TruffleLanguage;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        var l = new ChocoPyLanguage();
    }
}

class ChocoPyContext {
    public ChocoPyContext(TruffleLanguage.Env env) {
    }
}

class ChocoPyLanguage extends TruffleLanguage<ChocoPyContext> {
    public ChocoPyLanguage() {
        System.out.println("Hello World!");
    }

    @Override
    public ChocoPyContext createContext(TruffleLanguage.Env env) {
        return new ChocoPyContext(env);
    }
}
