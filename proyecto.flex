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


// =====> Arrays de una dimensión
// arrayassignation = (array<){letras}+(>){espacio}+({letras}|{numeros})+{espacio}+{asignacion}{espacio}+
numlist = ({espacio}*{numeros}+{espacio}*(,))+{espacio}*{numeros}+{espacio}*
numarrayassignation = (array<number>){espacio}+({letras}|{numeros})+{espacio}+{asignacion}{espacio}+{corcheteizq}{numlist}*{corcheteder}

boolist = ( {espacio}*((true)|(false)|(0)|(1)){espacio}*(,) )+{espacio}*((true)|(false)|(0)|(1))+{espacio}*
boolarrayassignation = (array<boolean>){espacio}+({letras}|{numeros})+{espacio}+{asignacion}{espacio}+{corcheteizq}{boolist}*{corcheteder}

charlist = ({espacio}*('){letras}('){espacio}*(,))+{espacio}*('){letras}('){espacio}*
chararrayassignation = (array<character>){espacio}+({letras}|{numeros})+{espacio}+{asignacion}{espacio}+{corcheteizq}{charlist}*{corcheteder}

ifstate = (if){saltos}*{parentesisizq}{saltos}*{letras}*{saltos}*{parentesisder}{saltos}*{corcheteizq}

%%

<YYINITIAL>{
    {numarrayassignation}   {System.out.println("A number array detected");}
    {boolarrayassignation}  {System.out.println("A boolean array detected ");}
    {chararrayassignation}  {System.out.println("A character array detected ");}
}
