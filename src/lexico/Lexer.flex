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

//Basic characters
characters = [a-zA-Z]
number = [0-9]+
breaks = \r|\n|\r\n
space = {breaks}|[ \t\f]

//Assignment and delimiter
assignation = "="
delimiter = ";"

//Comment character
comment = "#"

//Relational Operators
opre = ">"|"<"|">="|"<="|"=/="|"=="

//Special chars
lparenthesis = "("
rparenthesis = ")"
lbracket = "["
rbracket = "]"
lkey = "{"
rkey = "}"
colon = ":"
comma = ","
special_ones = @|#|&|"'"|"$"|"^"|"?"|"!"|"%"

//Decisions 
and = "&&"
or = "||"

%{
    public static int errores = 0;
    public static String texto = "";
  
    private Symbol symbol(String name, int sym) {
	//System.out.println("name: " + name + " sym: " + sym);
        return new Symbol(sym, yyline, yycolumn);
    }
    
    private Symbol symbol(String name, int sym, Object val) {
        //System.out.println("name: " + name + " sym: " + sym + " val: " + val);
        return new Symbol(sym, yyline, yycolumn, val);
    }
}%


%%

<YYINITIAL>{

    // States
    "if"    { return symbol("IF", sym.IF); }
    "else"  { return symbol("ELSE", sym.ELSE); }
    "for"   { return symbol("FOR", sym.FOR); }
    "while" { return symbol("WHILE", sym.WHILE); }
    "switch"    { return symbol("SWITCH", sym.SWITCH); }

    // Variables
    "boolean"   { return symbol("BOOLEAN", sym.BOOLEAN);  }
    "number"    { return symbol("NUMBER", sym.NUMBER); }
    "character"    { return symbol("CHARACTER", sym.CHARACTER); }
    "array" { return symbol("ARRAY", sym.ARRAY); }

    // Values
    {identifier}    { return symbol("ID", sym.ID); }
    {int}    { return symbol("INTEGER", sym.INT); }   
    
    // Booleans
    "false" { return symbol("FALSE", sym.FALSE); }
    "true"  { return symbol("TRUE", sym.TRUE); }
    "empty" { return symbol("EMPTY", sym.EMPTY); }
    
    // Keyboards
    "output"   { return symbol("OUTPUT", sym.OUTPUT); }
    "input" { return symbol("INPUT", sym.INPUT); }

    // Special characters
    "(" { return symbol("PARENTESISIZQUIERDO", sym.PARENTHESISIZQ) }
    ")" { return symbol("PARENTESISDERECHO", sym.PARENTHESISDER); }
    "{" { return symbol("CORCHETEIZQUIERDO", sym.CORCHETEIZQ); }
    "}" { return symbol("CORCHETEDERECHO", sym.CORCHETEDER); }
    "," { return symbol("COMA", sym.COMMA); }
    ";" { return symbol("PUNTOYCOMA", sym.SEMI); }

    // Aritmetic Operators
    "+" { return symbol("SUMA", sym.ADD); }
    "-" { return symbol("RESTA", sym.SUB); }
    "/" { return symbol("DIVISION", sym.DIV); }
    "*" { return symbol("MULTIPLICACION", sym.MULT); }
    "&"    { return symbol("AND"; sym.AND); }
    "<>"    { return symbol("OR", sym.OR); }
    "=="    { return symbol("IGUAL", sym.EQUAL); }
    "=/="   { return symbol("DISTINTO", sym.NEQUAL); }
    "<"    { return symbol("MENOR", sym.ME); }
    "<="    { return symbol("MENORIGUAL", sym.MEE); }
    ">" { return symbol("MAYOR", sym.MA); }
    ">="    { return symbol("MAYORIGUAL", sym.MAE); }
    "=" { return symbol("ASIGNACION", sym.ASSIGN); }

    // Comentarios
    {comment}   { yybegin(COMMENT); }

    {space} {/*Se ignora*/}

    .   { System.out.println("ERROR, simbolo desconocido <" + yytext() + "> | linea: " + (yyline + 1) + " | Columna: " + (yycolumn + 1));
            errores++;}
}

<COMMENT>{
    {comentario} {yybegin(YYINIYIAL);}
    .   {}
}
