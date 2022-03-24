grammar CFG;

program: dcl* EOF;

dcl: primVarDcl ';'
   //| functionDcl
   //| objectDcl
   //| flowDcl
   //| listDcl;
   ;

primVarDcl: primType identifier ('=' expr)?;

primType: 'number' | 'string' | 'bool';

identifier: Letter (Letter | Number)*;

expr: (literal | multiplyExpr | additiveExpr)+;

multiplyExpr: numberLiteral  (('*' | '/' | '%') numberLiteral)+;

additiveExpr: numberLiteral (('+' | '-') numberLiteral)+;

literal: numberLiteral | stringLiteral | boolLiteral;

numberLiteral: (Number | Number '.' Number)+;

stringLiteral: '"' (Letter | Number)+ '"';

boolLiteral: Bool;

functionDcl: ;

objectDcl: ;

flowDcl: ;
listDcl: ;

Number: ('0'..'9');

Letter: ('a'..'z') | ('A'..'Z') | ('_');

Bool: 'true' | 'false';

WS: [ \t\r\n]+ -> skip;