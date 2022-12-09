{ nixpkgs ? import <nixpkgs> {} }:

let
  graalvm = ./graalvm;
in
nixpkgs.mkShell {
  buildInputs = with nixpkgs; [
    maven
    gradle
    graalvm
  ];
  shellHook = ''
    if test $(uname) = "Darwin"; then
      export JAVA_HOME=${graalvm}/Contents/Home
    elif test $(uname) = "Linux"; then
      export JAVA_HOME=${graalvm}
    fi
  '';
}
