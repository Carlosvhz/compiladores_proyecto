%%

%unicode
%class Lexer
%int
%line
%standalone
%column
%ignorecase
%char
%public


identifier = [a-zA-Z][A-Za-z_0-9]*

character = [a-zA-Z]
number = [0-9]+
space = [" "]
breaks = [ \n\t\r]+

assignation = [=]
delimiter = [;]

//Arithmetic Operators
sum_sub = "+"|"-"
mult_div = "*"|"/"
mod = "%"

//Relational Operators
opre = [>|<|>=|<=|=/=|==]


%%

<YYINITIAL>{
    /* // States
    "if"    { return symbil(sym.IF, yytext()); }
    "else"  { return symbil(sym.ELSE, yytext()); }
    "for"   { return symbil(sym.FOR, yytext()); }
    "while" { return symbil(sym.WHILE, yytext()); }
    "switch"    { return symbil(sym.SWITCH, yytext()); }

    // Variables
    "boolean"   { return symbil(sym.BOOLEAN, yytext());  }
    "number"    { return symbil(sym.NUMBER, yytext()); }
    "character"    { return symbil(sym.CHARACTER, yytext()); }
    "array" { return symbil(sym.ARRAY, yytext()); }

    // Booleans
    "false" { return symbil(sym.FALSE, yytext()); }
    "true"  { return symbil(sym.TRUE, yytext()); }

    // Keyboards
    "output"   { return symbil(sym.SHOW, yytext()); }
    "input" { return symbil(sym.INPUT, yytext()); }

    // Special characters
    "(" { return symbil(sym.PARENTHESISIZQ, yytext()); }
    ")" { return symbil(sym.PARENTHESISDER, yytext()); }
    "{" { return symbil(sym.CORCHETEIZQ, yytext()); }
    "}" { return symbil(sym.CORCHETEDER, yytext()); }
    "," { return symbil(sym.COMMA, yytext()); }
    ";" { return symbil(sym.SEMI, yytext()); }

    // Aritmetic Operators
    "+" { return symbil(sym.ADD, yytext()); }
    "-" { return symbil(sym.SUB, yytext()); }
    "/" { return symbil(sym.DIV, yytext()); }
    "*" { return symbil(sym.MULT, yytext()); }
    "&&"    { return symbil(sym.AND, yytext()); }
    "||"    { return symbil(sym.OR, yytext()); }
    "=="    { return symbil(sym.EQUAL, yytext()); }
    "=/="   { return symbil(sym.NEQUAL, yytext()); }
    "<"    { return symbil(sym.ME, yytext()); }
    "<="    { return symbil(sym.MEE, yytext()); }
    ">" { return symbil(sym.MA, yytext()); }
    ">="    { return symbil(sym.MAE, yytext()); }
    "=" { return symbil(sym.ASSIGN, yytext()); } */

    "if"    { System.out.println("If"); }
    "else"  { System.out.println("Else"); }
    "for"   { System.out.println("For"); }
    "while" { System.out.println("While");  }
    "switch"    { System.out.println("Switch");  }

    // Variables
    "boolean"   { System.out.println("Boolean");   }
    "number"    { System.out.println("Number");  }
    "character"    { System.out.println("Character");  }
    "array" { System.out.println("Array");  }

    // Booleans
    "false" { System.out.println("False"); }
    "true"  { System.out.println("True");  }

    // Keyboards
    "output"   { System.out.println("Output"); }
    "input" { System.out.println("Input"); }

    // Special characters
    "(" { System.out.println(")");  }
    ")" { System.out.println("(");  }
    "{" { System.out.println("}"); }
    "}" { System.out.println("{"); }
    "," { System.out.println(",");  }
    ";" { System.out.println(";");  }

    // Arithmetic Operators
    "+" { System.out.println("+");  }
    "-" {  System.out.println("-"); }
    "/" {  System.out.println("/"); }
    "*" {  System.out.println("*"); }
    "&&"    {  System.out.println("&&"); } 
    "||"    {   System.out.println("||"); }
    "=="    {  System.out.println("==");  }
    "=/="   {  System.out.println("=/="); }
    "<"    {  System.out.println("<"); }
    "<="    {  System.out.println("<="); }
    ">" {  System.out.println(">"); }
    ">="    {  System.out.println(">="); }
    "'" { System.out.println(" ' ' "); }
    {assignation}    { System.out.println("Assignation"); }
    {delimiter} { System.out.println("Delimiter"); }
    
    // 
    {number}    { System.out.println("A number"); }
    {identifier}    { System.out.println("An identifier"); }
    {character} { System.out.println("A character"); }

    {space} {}
}