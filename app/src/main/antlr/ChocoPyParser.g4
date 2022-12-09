parser grammar ChocoPyParser;

options { tokenVocab=ChocoPyLexer; }

program
    : LINE_BREAK* (var_def | func_def /* | class_def */ )* stmt*
    ;

// class_def
//     : CLASS IDENTIFIER OPEN_PAREN IDENTIFIER CLOSE_PAREN COLON LINE_BREAK INDENT class_body DEDENT
//     ;

// class_body
//     : PASS LINE_BREAK
//     | (var_def | func_def)+
//     ;

func_def
    : DEF func_sig COLON LINE_BREAK INDENT func_body DEDENT
    ;

func_sig
    : IDENTIFIER OPEN_PAREN (typed_var (COMMA typed_var)*)? CLOSE_PAREN (ARROW type)?
    ;

func_body
    : ( /* global_decl | nonlocal_decl | */ var_def | func_def)* stmt+
    ;

typed_var
    : IDENTIFIER COLON type
    ;

type
    : IDENTIFIER | IDSTRING | type OPEN_BRACKET type CLOSE_BRACKET
    ;

// global_decl
//     : GLOBAL IDENTIFIER LINE_BREAK
//     ;

// nonlocal_decl
//     : NONLOCAL IDENTIFIER LINE_BREAK
//     ;

var_def
    : typed_var ASSIGN literal LINE_BREAK
    ;

stmt
    : simple_stmt LINE_BREAK                                           # simpleStmt
    | IF expr COLON block (ELIF expr COLON block)* (ELSE COLON block)? # ifStmt
    | WHILE expr COLON block                                           # whileStmt
    | FOR IDENTIFIER IN expr COLON block                               # forStmt
    ;

simple_stmt
    : PASS                                  # passStmt
    | expr                                  # exprStmt
    | RETURN (expr)? ?                      # returnStmt
    | (target ASSIGN)+ expr                 # assignStmt
    ;

block
    : LINE_BREAK INDENT stmt+ DEDENT
    ;

literal
    : lit = NONE
    | lit = TRUE
    | lit = FALSE
    | lit = INTEGER
    | lit = IDSTRING
    | lit = STRING
    ;

expr
    : cexpr
    | NOT expr
    | expr (AND | OR) expr
    | expr IF expr ELSE expr
    ;

cexpr
    : pexpr (comp_op pexpr)*
    ;

pexpr
    : literal                                           # litExpr
    | IDENTIFIER                                        # idExpr
    | OPEN_BRACKET (expr (COMMA expr)*) CLOSE_BRACKET   # listExpr
    | OPEN_PAREN expr CLOSE_PAREN                       # parenExpr
    | pexpr member_op                                   # memberExpr
    | pexpr index_op                                    # indexExpr
    | pexpr call_op                                     # callExpr
    | pexpr bin_op pexpr                                # binExpr
    | MINUS pexpr                                       # negExpr
    ;

target
    : IDENTIFIER
    | pexpr member_op
    | pexpr index_op
    ;

member_op
    : DOT IDENTIFIER
    ;

index_op
    : OPEN_BRACKET expr CLOSE_BRACKET
    ;

call_op
    : OPEN_PAREN (expr (COMMA expr)*)? CLOSE_PAREN
    ;

bin_op
    : PLUS | MINUS | STAR | IDIV | MOD
    ;

comp_op
    : op = EQUALS
    | op = BANG_EQUAL
    | op = LESS_THAN_EQUAL
    | op = GREATER_THAN_EQUAL
    | op = LESS_THAN
    | op = GREATER_THAN
//     | IS
    ;
