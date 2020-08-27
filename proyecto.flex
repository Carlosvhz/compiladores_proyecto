%%

%unicode
%class proyecto
%int
%line
%standalone

numeros = [0-9]
letras = [a-zA-z]
espacio = [ \n\t\r]+

apar = [+|-|*|/]
opre = [>|<|>=|<=|=/=]

parentesisder = [)]
parentesisizq = [(]

corcheteder = [}]
corcheteizq = [{]

asignacion = [=]


ifstate = (if){espacio}*{parentesisizq}{espacio}*{letras}*{espacio}*{parentesisder}{espacio}*{corcheteizq}

%%

<YYINITIAL>{
    {ifstate}   {System.out.println("State if detected");}
}
