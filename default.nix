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
    export JAVA_HOME=${graalvm}
  '';
}
