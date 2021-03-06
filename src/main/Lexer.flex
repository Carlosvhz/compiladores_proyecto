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
/*
%eofval{
        System.out.println(" ==> FIN DEL ARCHIVO <== ");
%eofval}
*/

%{
	public static int errores = 0;
%}


special_characters = "^"|@|"$"|#|&|"%"|"'"|"?"|"!"|"_"

// Values
digit = [0-9] | -[0-9]
integer = {digit}+
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
        "Main"			{ return new Symbol(sym.MAIN, yycolumn, yyline, yytext());}
        "if"			{ return new Symbol(sym.IF, yycolumn, yyline, yytext());}
        "then"                  { return new Symbol(sym.THEN, yycolumn, yyline, yytext());}
        "else"			{ return new Symbol(sym.ELSE, yycolumn, yyline, yytext());}
        "for"			{ return new Symbol(sym.FOR, yycolumn, yyline, yytext());}
        "to"                    { return new Symbol(sym.TO, yycolumn, yyline, yytext());}
        "while"		        { return new Symbol(sym.WHILE, yycolumn, yyline, yytext());}
        "switch"		{ return new Symbol(sym.SWITCH, yycolumn, yyline, yytext());}
        // Palabras reservadas
        "call"                  { return new Symbol(sym.CALL, yycolumn, yyline, yytext());}  
        "case"			{ return new Symbol(sym.CASE, yycolumn, yyline, yytext());}  
        "default"		{ return new Symbol(sym.DEFAULT, yycolumn, yyline, yytext());}
        "function"		{ return new Symbol(sym.FUNCTION, yycolumn, yyline, yytext());}
        "comeBack"		{ return new Symbol(sym.COMEBACK, yycolumn, yyline, yytext());}
        // Tipo de variable
        "number"		{ return new Symbol(sym.NUMBER, yycolumn, yyline, yytext());}
        "boolean"		{ return new Symbol(sym.BOOLEAN, yycolumn, yyline, yytext());}
        "character"		{ return new Symbol(sym.CHARACTER, yycolumn, yyline, yytext());}
        "array"			{ return new Symbol(sym.ARRAY, yycolumn, yyline, yytext());}
        // Input y output
        "input"			{ return new Symbol(sym.INPUT, yycolumn, yyline, yytext());}
        "output"		{ return new Symbol(sym.OUTPUT, yycolumn, yyline, yytext());}

        "empty"		        { return new Symbol(sym.EMPTY,yycolumn,yyline,yytext()); }   
        {integer}	        { return new Symbol(sym.INT,yycolumn,yyline,yytext()); }
        {character}		{ return new Symbol(sym.CHAR,yycolumn,yyline,yytext()); }
	{bool}			{ return new Symbol(sym.BOOL,yycolumn,yyline,yytext()); }
        
        {oprel}	                { return new Symbol(sym.OPREL,yycolumn,yyline,yytext()); }
	{opsum}	                { return new Symbol(sym.SUM,yycolumn,yyline,yytext()); }
        {opres}	                { return new Symbol(sym.RES,yycolumn,yyline,yytext()); }
	{opmult}	        { return new Symbol(sym.MULT,yycolumn,yyline,yytext()); }
        {opdiv}	                { return new Symbol(sym.DIV,yycolumn,yyline,yytext()); }
        {opmod}	                { return new Symbol(sym.MOD,yycolumn,yyline,yytext()); }

	{colon}		        { return new Symbol(sym.COLON,yycolumn,yyline,yytext()); }
	{comma}			{ return new Symbol(sym.COMMA,yycolumn,yyline,yytext()); }
	
        {parder}		{ return new Symbol(sym.PARDER,yycolumn,yyline,yytext()); }
        {parizq}		{ return new Symbol(sym.PARIZQ,yycolumn,yyline,yytext()); }
        {bracketder}		{ return new Symbol(sym.BRACKETDER,yycolumn,yyline,yytext()); }
        {bracketizq}		{ return new Symbol(sym.BRACKETIZQ,yycolumn,yyline,yytext()); }
        {sbracketder}		{ return new Symbol(sym.SBRACKETDER,yycolumn,yyline,yytext()); }
        {sbracketizq}		{ return new Symbol(sym.SBRACKETIZQ,yycolumn,yyline,yytext()); }
	{assignment}		{ return new Symbol(sym.ASSIGNMENT,yycolumn,yyline,yytext()); }

	{identifier}	        { return new Symbol(sym.ID,yycolumn,yyline,yytext()); }
        {delimeter}             { return new Symbol(sym.DELIMETER,yycolumn,yyline,yytext()); }
	/* Comments */
	{comment}		{ yybegin(BLOCK_COMMENT); }

	{space}			{/*Ignora*/}

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