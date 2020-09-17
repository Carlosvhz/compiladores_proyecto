package main;
import java_cup.runtime.*;

%%

%unicode
%class Lexer
%int
%ignorecase
%line
%column
%standalone
%cup
%eofval{
        System.out.println("FIN DEL ARCHIVO");
        System.exit(0);
%eofval}

%{
	public static int errores = 0;
%}


special_characters = "^"|@|"$"|#|&|"%"|"'"|"?"|"!"|"_"

// Values
digit = [0-9]
int = {digit}+
characters = [a-z]|[A-Z]|"_"
character = '({characters}|{digit}|{special_characters}|" ")'
bool = true|false

// Identifier 
identifier = {characters}({digit}|{characters})*

comma = ","
colon = ":"

parder = ")"
parizq = "("
bracketizq = "{"
bracketder = "}"
sbracketizq = "["
sbracketder = "]"

delimeter = "|"

// Operadores 
oprel = "=="|"=/="|">="|"<="|"&&"|"||"|"<>"|"<"|">"
opsum = "+"
opres = "-"
opmult = "*"
opdiv = "/"
opmod = "%"
assignment = "="

space = [ \n\r\t]+
comment = "#"
%state BLOCK_COMMENT

%%

<YYINITIAL>
{
        // States
        "Main"			{ System.out.println("MAIN"); return new Symbol(sym.MAIN, yycolumn, yyline, yytext());}
        "if"			{ System.out.println("IF"); return new Symbol(sym.IF, yycolumn, yyline, yytext());}
        "then"                  { System.out.println("THEN"); return new Symbol(sym.THEN, yycolumn, yyline, yytext());}
        "else"			{ System.out.println("ELSE"); return new Symbol(sym.ELSE, yycolumn, yyline, yytext());}
        "for"			{ System.out.println("FOR"); return new Symbol(sym.FOR, yycolumn, yyline, yytext());}
        "to"                    { System.out.println("TO"); return new Symbol(sym.TO, yycolumn, yyline, yytext());}
        "while"		        { System.out.println("WHILE"); return new Symbol(sym.WHILE, yycolumn, yyline, yytext());}
        "switch"		{ System.out.println("SWITCH"); return new Symbol(sym.SWITCH, yycolumn, yyline, yytext());}
        // Palabras reservadas
        "case"			{ System.out.println("CASE"); return new Symbol(sym.CASE, yycolumn, yyline, yytext());}  
        "default"		{ System.out.println("DEFAULT"); return new Symbol(sym.DEFAULT, yycolumn, yyline, yytext());}
        "function"		{ System.out.println("FUNCTION"); return new Symbol(sym.FUNCTION, yycolumn, yyline, yytext());}
        "comeBack"		{ System.out.println("COMEBACK"); return new Symbol(sym.COMEBACK, yycolumn, yyline, yytext());}
        // Tipo de variable
        "number"		{ System.out.println("NUMBER"); return new Symbol(sym.NUMBER, yycolumn, yyline, yytext());}
        "boolean"		{ System.out.println("BOOLEAN"); return new Symbol(sym.BOOLEAN, yycolumn, yyline, yytext());}
        "character"		{ System.out.println("CHARACTER"); return new Symbol(sym.CHARACTER, yycolumn, yyline, yytext());}
        "array"			{ System.out.println("ARRAY"); return new Symbol(sym.ARRAY, yycolumn, yyline, yytext());}
        // Input y output
        "input"			{ System.out.println("INPUT"); return new Symbol(sym.INPUT, yycolumn, yyline, yytext());}
        "output"		{ System.out.println("OUTPUT"); return new Symbol(sym.OUTPUT, yycolumn, yyline, yytext());}

        "empty"		        { System.out.println("EMPTY"); return new Symbol(sym.EMPTY,yycolumn,yyline,yytext()); }   
        {int}		        { System.out.println("INT"); return new Symbol(sym.INT,yycolumn,yyline,yytext()); }
        {character}		{ System.out.println("CHAR"); return new Symbol(sym.CHAR,yycolumn,yyline,yytext()); }
	{bool}			{ System.out.println("BOOL"); return new Symbol(sym.BOOL,yycolumn,yyline,yytext()); }
        
        {oprel}	                { System.out.println("OPREL"); return new Symbol(sym.OPREL,yycolumn,yyline,yytext()); }
	{opsum}	                { System.out.println("SUM"); return new Symbol(sym.SUM,yycolumn,yyline,yytext()); }
        {opres}	                { System.out.println("RES"); return new Symbol(sym.RES,yycolumn,yyline,yytext()); }
	{opmult}	        { System.out.println("MULT"); return new Symbol(sym.MULT,yycolumn,yyline,yytext()); }
        {opdiv}	                { System.out.println("DIV"); return new Symbol(sym.DIV,yycolumn,yyline,yytext()); }
        {opmod}	                { System.out.println("MOD"); return new Symbol(sym.MOD,yycolumn,yyline,yytext()); }

	{colon}		        { System.out.println("COLON"); return new Symbol(sym.COLON,yycolumn,yyline,yytext()); }
	{comma}			{ System.out.println("COMMA"); return new Symbol(sym.COMMA,yycolumn,yyline,yytext()); }
	
        {parder}		{ System.out.println("PARDER"); return new Symbol(sym.PARDER,yycolumn,yyline,yytext()); }
        {parizq}		{ System.out.println("PARIZQ"); return new Symbol(sym.PARIZQ,yycolumn,yyline,yytext()); }
        {bracketder}		{ System.out.println("BRACKETDER"); return new Symbol(sym.BRACKETDER,yycolumn,yyline,yytext()); }
        {bracketizq}		{ System.out.println("BRACKETIZQ"); return new Symbol(sym.BRACKETIZQ,yycolumn,yyline,yytext()); }
        {sbracketder}		{ System.out.println("SBRACKETDER"); return new Symbol(sym.SBRACKETDER,yycolumn,yyline,yytext()); }
        {sbracketizq}		{ System.out.println("SBRACKETIZQ"); return new Symbol(sym.SBRACKETIZQ,yycolumn,yyline,yytext()); }
	{assignment}		{ System.out.println("ASSIGNMENT"); return new Symbol(sym.ASSIGNMENT,yycolumn,yyline,yytext()); }

	{identifier}	        { System.out.println("ID"); return new Symbol(sym.ID,yycolumn,yyline,yytext()); }
        {delimeter}             { System.out.println("DELIMETER"); return new Symbol(sym.DELIMETER,yycolumn,yyline,yytext()); }
	/* Comments */
	{comment}		{ yybegin(BLOCK_COMMENT); }

	{space}			{/*Ignora uwu*/}

	.			{
				    System.out.println("Error léxico, caracter illegal: " + yytext() + "en Línea: " + (yyline + 1) + ", Columna: " + (yycolumn + 1));
                                    errores++;
				}
}

<BLOCK_COMMENT>
{
	{comment}		{ yybegin(YYINITIAL); }
	.		        {}
}