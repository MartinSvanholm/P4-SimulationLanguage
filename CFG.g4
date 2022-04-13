grammar CFG;

program: environmentSection behaviorSection? updateSection? outputSection? EOF;

environmentSection: 'Simulation Environment' '{' line* endCondition? '}';

behaviorSection: 'Simulation Behavior' '{' line* '}';

updateSection: 'Simulation Update' '{' line* '}';

outputSection: 'Simulation Output' '{' line* '}';

line: initCondition
    | dcl
    | statement
    | assignment
    | expr SemiColon
    | Comment
    | MultiComment
    ;

dcl: functionDcl
   | procedureDcl
   | listDcl
   | classDcl
   | objDcl;
   //| primVarDcl;

endCondition: 'EndCondition' codeBlock;

initCondition: 'InitCondition<' type '>' codeBlock;

/* FUNCTION CALL
    Void function: function TestFunction() { }
    With return type: function bool IsClearToDrive() { }
*/
functionDcl: 'function' type identifier '(' (dclParams (Comma dclParams)*)? ')' codeBlock;

procedureDcl: 'function' identifier '(' (dclParams (Comma dclParams)*)? ')' codeBlock;

//  List<Road> roadList {Road1, Road2};
listDcl: 'List<' type '>' identifier ('{' params (Comma params)* '}')? SemiColon;

classDcl: type identifier codeBlock;

contructorDcl: 'constructor' 'Create<' type '>' '(' (dclParams (Comma dclParams)*)? ')' codeBlock;

constructorCall: 'Create<' type '>' '(' (params (Comma params)*)? ')';

//primVarDcl: primType identifier (Equals expr)? SemiColon;

objDcl: type identifier (Equals (constructorCall | expr))? SemiColon;

statement: selectiveCtrl
         | iterativeCtrl
         | 'return' expr SemiColon;

selectiveCtrl: ifElseStmt | switchStmt;

/* IF ELSE
    if (nodes.GetIndex(path[0]) < nodes.GetIndex(path[1])) {
        this.direction = true;
    } else {
        this.direction = false;
    }
*/
ifElseStmt: 'if' '(' left=expr ')' index=codeBlock right=elseIfStmt?;

elseIfStmt: left=elseStmt
          | 'else if' '(' index=expr ')' body=codeBlock right=elseIfStmt?;

elseStmt: 'else' codeBlock;

switchStmt: 'switch' '(' expr ')' switchBody;

/* SWITCH STATEMENT
    switch(identifier) {
        case 1:
            x = 4;
        case 2:
            x = 10;
        default:
            x = 0;
    }
*/
switchBody: '{' ('case' switchcase codeBlock )+ ('default' codeBlock)? '}';

switchcase: numberLiteral | type;

iterativeCtrl: whileLoop | forLoop;

// while(Sentinal) { }
whileLoop: 'while' '('left=expr')' codeBlock;

forLoop: 'for' loopNumber=identifier  'in range' '(' (numberLiteral | rangeNumber=identifier) ')' codeBlock;

assignment: identifier Equals (value=identifier | expr) SemiColon;

expr: functionCall                                         # funcExpr
    | left=expr '[' index=expr ']' right=expr?             # arrExpr
    | '(' middel=expr ')'                                         # parensExpr
    | left=expr op='^' right=expr                          # infixExpr
    | left=expr op=('*' | '/' | '%') right=expr            # infixExpr
    | left=expr op=('+' | '-') right=expr                  # infixExpr
    | left=expr op=('<=' | '>=' | '<' | '>') right=expr    #compareExpr
    | left=expr op=('==' | '!=') right=expr                #compareExpr
    | left=expr op=('&&' | ' and ') right=expr             #logicalExpr
    | left=expr op=('||' | ' or ') right=expr              #logicalExpr
    | literal                                              #literalExpr
    | identifier                                           #identifierExpr
    ;

functionCall: identifier '(' (params (Comma params)*)? ')';

params: (expr | constructorCall);

dclParams: (type identifier);

type: primType | complexType | identifier;

primType: 'number ' | 'string ' | 'bool ';

// Node node = Nodes[RandomInt(0, IONode.length)];
complexType: 'Vehicle' | 'Node' | listType='List<' type '>';

identifier: Letter (Letter | Number*) ('.' identifier)*;

literal: numberLiteral
       | stringLiteral
       | boolLiteral
       ;

numberLiteral: (Number | Number '.' Number)+;

stringLiteral: '"' (Letter | Number)+ '"';

boolLiteral: bool;

bool: 'true' | 'false';

codeBlock: '{' (dcl | statement | assignment | expr SemiColon | contructorDcl)* '}';

OP_POW: '^';
OP_MUL: '*';
OP_DIV: '/';
OP_MOD: '%';
OP_ADD: '+';
OP_SUB: '-';

OP_LTOE: '<=';
OP_GTOE: '>=';
OP_LT: '<';
OP_GT: '>';
OP_EQUALS: '==';
OP_NEQUALS: '!=';

OP_AND: ' and ';
OP_AND2: '&&';
OP_OR: ' or ';
OP_OR2: '||';

Number: ('0'..'9');

Letter: (('a'..'z') | ('A'..'Z') | ('_'))+;

Comma: ',';
Equals: '=';
SemiColon: ';';

Comment: '//' ~('\r' | '\n')* -> skip;

MultiComment: '/*' .*? '*/' -> skip;

WS: [ \t\r\n]+ -> skip;