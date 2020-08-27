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
coma = [,]

asignacion = [=]
delimitador = [;]



// ====> Asignación generalizada (Quien sabe que la utilicemos)
// assignation = {letras}+{espacio}+({letras}|{numeros})+{espacio}+{asignacion}{espacio}+{numeros}+{delimitador} 

numassignation = (number){espacio}+({letras}|{numeros})+{espacio}+{asignacion}{espacio}+{numeros}+{delimitador}


// =====> Array
// arrayassignation = (array<){letras}+(>){espacio}+({letras}|{numeros})+{espacio}+{asignacion}{espacio}+
numlist = {espacio}*{numeros}+{espacio}*(,)
numarrayassignation = (array<number>){espacio}+({letras}|{numeros})+{espacio}+{asignacion}{espacio}+{corcheteizq}({numlist}+{espacio}*{numeros}+{espacio}*)*{corcheteder}


ifstate = (if){saltos}*{parentesisizq}{saltos}*{letras}*{saltos}*{parentesisder}{saltos}*{corcheteizq}

%%

<YYINITIAL>{
    {numassignation}    {System.out.println("An number assignation detected");}
    {numarrayassignation}   {System.out.println("An array number detected");}
    {ifstate}   {System.out.println("State if detected");}
}
