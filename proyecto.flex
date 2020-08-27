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

apar = [+|-|*|/]
opre = [>|<|>=|<=|=/=]

parentesisder = [)]
parentesisizq = [(]

corcheteder = [}]
corcheteizq = [{]

asignacion = [=]


delimitador = [;]

assignation = {letras}+{espacio}+({letras}|{numeros})+{espacio}+{asignacion}{espacio}+{numeros}+{delimitador} 
ifstate = (if){saltos}*{parentesisizq}{saltos}*{letras}*{saltos}*{parentesisder}{saltos}*{corcheteizq}

%%

<YYINITIAL>{
    {ifstate}   {System.out.println("State if detected");}
    {assignation}    {System.out.println("An assignation detected");}
}
