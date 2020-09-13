package proyecto;

import java_cup.runtime.Symbol;
import java.io.Reader;

%%

%unicode
%class Lexer
%line
%column
%standalone
%ignorecase
%char
%public
%cup

identifier = [a-zA-Z][A-Za-z_0-9]*
character = [a-zA-Z]
int = [0-9]+
salto = \r|\n|\r\n
space = {salto}|[ \t\f]
assignation = [=]
comment = "#"


%{
    public static int errores = 0;
}%


%%

<YYINITIAL>{

    // States
    "if"    { return symbol(sym.IF,yycolumn,yyline,yytext()); }
    "else"  { return symbol(sym.ELSE,yycolumn,yyline,yytext()); }
    "for"   { return symbol(sym.FOR,yycolumn,yyline,yytext()); }
    "while" { return symbol(sym.WHILE,yycolumn,yyline,yytext()); }
    "switch"    { return symbol(sym.SWITCH,yycolumn,yyline,yytext()); }

    // Variables
    "boolean"   { return symbol(sym.BOOLEAN,yycolumn,yyline,yytext());  }
    "number"    { return symbol(sym.NUMBER,yycolumn,yyline,yytext()); }
    "character"    { return symbol(sym.CHARACTER,yycolumn,yyline,yytext()); }
    "array" { return symbol(sym.ARRAY,yycolumn,yyline,yytext()); }

    // Values
    {identifier}    { return symbol(sym.ID,yycolumn,yyline,yytext()); }
    {int}    { return symbol(sym.ID,yycolumn,yyline,yytext()); }   
    
    // Booleans
    "false" { return symbol(sym.FALSE,yycolumn,yyline,yytext()); }
    "true"  { return symbol(sym.TRUE,yycolumn,yyline,yytext()); }
    "empty" { return symbol(sym.EMPTY,yycolumn,yyline,yytext()); }
    
    // Keyboards
    "output"   { return symbol(sym.OUTPUT,yycolumn,yyline,yytext()); }
    "input" { return symbol(sym.INPUT,yycolumn,yyline,yytext()); }

    // Special characters
    "(" { return symbol(sym.PARENTHESISIZQ,yycolumn,yyline,yytext()); }
    ")" { return symbol(sym.PARENTHESISDER,yycolumn,yyline,yytext()); }
    "{" { return symbol(sym.CORCHETEIZQ,yycolumn,yyline,yytext()); }
    "}" { return symbol(sym.CORCHETEDER,yycolumn,yyline,yytext()); }
    "," { return symbol(sym.COMMA,yycolumn,yyline,yytext()); }
    ";" { return symbol(sym.SEMI,yycolumn,yyline,yytext()); }

    // Aritmetic Operators
    "+" { return symbol(sym.ADD,yycolumn,yyline,yytext()); }
    "-" { return symbol(sym.SUB,yycolumn,yyline,yytext()); }
    "/" { return symbol(sym.DIV,yycolumn,yyline,yytext()); }
    "*" { return symbol(sym.MULT,yycolumn,yyline,yytext()); }
    "&"    { return symbol(sym.AND,yycolumn,yyline,yytext()); }
    "<>"    { return symbol(sym.OR,yycolumn,yyline,yytext()); }
    "=="    { return symbol(sym.EQUAL,yycolumn,yyline,yytext()); }
    "=/="   { return symbol(sym.NEQUAL,yycolumn,yyline,yytext()); }
    "<"    { return symbol(sym.ME,yycolumn,yyline,yytext()); }
    "<="    { return symbol(sym.MEE,yycolumn,yyline,yytext()); }
    ">" { return symbol(sym.MA,yycolumn,yyline,yytext()); }
    ">="    { return symbol(sym.MAE,yycolumn,yyline,yytext()); }
    "=" { return symbol(sym.ASSIGN,yycolumn,yyline,yytext()); }

    // Comentarios
    {comment}   { yybegin(BLOCK_COMMENT); }

    {space} {/*Se ignora*/}

    .   { System.out.println("ERROR, caracter desconocido <" + yytext() + "> | linea: " + (yyline + 1) + " | Columna: " + (yycolumn + 1));
            errores++;}
}

<BLOCK_COMMENT>{
    {comment}   {yybegin(YYINITIAL);}
    .   {}
}