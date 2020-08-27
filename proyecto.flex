%%

%unicode
%class proyecto
%int
%line
%standalone

numeros = [0-9]
letras = [a-zA-z]
saltos = [ \n\t\r]+
espacio = [" "]

opar = [+|-|*|/]
opre = [>|<|>=|<=|=/=]

parentesisder = [)]
parentesisizq = [(]

corcheteder = [}]
corcheteizq = [{]

asignacion = [=]

delimitador = [;]



// ====> Asignación generalizada (Quien sabe que la utilicemos)
// assignation = {letras}+{espacio}+({letras}|{numeros})+{espacio}+{asignacion}{espacio}+{numeros}+{delimitador} 

numassignation = (number){espacio}+({letras}|{numeros})+{espacio}+{asignacion}{espacio}+{numeros}+{delimitador}


ifstate = (if){saltos}*{parentesisizq}{saltos}*{letras}*{saltos}*{parentesisder}{saltos}*{corcheteizq}

%%

<YYINITIAL>{
    // {assignation}    {System.out.println("An assignation detected");}
    {numassignation}    {System.out.println("An number assignation detected");}
    {ifstate}   {System.out.println("State if detected");}
}
