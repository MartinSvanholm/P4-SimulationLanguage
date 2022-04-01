grammar CFG;

program: environmentSection behaviorSection updateSection outputSection EOF;

environmentSection: 'Simulation Environment' '{' line* endCondition? '}';

behaviorSection: 'Simulation Behavior' '{' line* '}';

updateSection: 'Simulation Update' '{' line* '}';

outputSection: 'Simulation Output' '{' line* '}';

line: initCondition
    | dcl
    | statement
    | assignment SemiColon
    | expr SemiColon
    | Comment
    | MultiComment;

dcl: functionDcl
   | listDcl
   | classDcl
   | objDcl SemiColon
   | primVarDcl SemiColon;

endCondition: 'EndCondition' '{' (statement | assignment | expr | primVarDcl)* 'return' expr SemiColon '}';

initCondition: 'InitCondition<' type '>' '{' (statement | assignment | expr | primVarDcl)* '}';

/* FUNCTION CALL
    Void function: function TestFunction() { }
    With return type: function bool IsClearToDrive() { }
*/
functionDcl: 'function' identifier funcParams stmtBody
           | 'function' primType identifier funcParams funcReturnBody;

funcReturnBody: '{' (statement | assignment SemiColon | functionCall SemiColon | primVarDcl SemiColon | objDcl SemiColon | listDcl )* 'return' expr SemiColon '}';

funcParams: '(' ( (type identifier) | listParam (Comma type identifier)* )? ')';

listParam: 'List<' type '>' identifier;

//  List<Road> roadList {Road1, Road2};
listDcl: 'List<' type '>' identifier ('{' params (Comma params)* '}')? SemiColon;

classDcl: type identifier classBody;

classBody: '{' classPropDcl* '}';

classPropDcl: contructorDcl
            | functionDcl
            | listDcl
            | primVarDcl ';'
            | statement
            | assignment SemiColon
            | expr SemiColon;

objDcl: type identifier Equals constructorCall;

contructorDcl: 'constructor' 'Create<' type '>' funcParams '{' (statement | assignment SemiColon | functionCall SemiColon | primVarDcl SemiColon | objDcl SemiColon | listDcl )* '}';

constructorCall: 'Create<' type '>' '(' (params (Comma params)* )? ')';

primVarDcl: primType identifier (Equals expr)?;

statement: selectiveCtrl
         | iterativeCtrl;

selectiveCtrl: ifElseStmt | switchStmt;

/* IF ELSE
    if (nodes.GetIndex(path[0]) < nodes.GetIndex(path[1])) {
        this.direction = true;
    } else {
        this.direction = false;
    }
*/
ifElseStmt: 'if' '(' expr ')' stmtBody elseIfStmt?;

elseIfStmt: 'else' stmtBody
          | 'else if' '(' expr ')' stmtBody elseIfStmt?;

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
switchBody: '{' ('case' (numberLiteral | type) ':' (assignment ';' | expr ';' | statement)* )+ ('default:' expr*)? '}';

iterativeCtrl: whileLoop | forLoop;

// while(Sentinal) { }
whileLoop: 'while' '('expr')' stmtBody;

forLoop: 'for' identifier 'in range' '(' (numberLiteral | identifier ('.' identifier)* ) ')' stmtBody;

stmtBody: '{' (statement | assignment SemiColon | primVarDcl SemiColon | objDcl SemiColon | listDcl SemiColon |functionCall SemiColon)* '}';

assignment: (identifier ('.' identifier)* ) Equals (identifier | expr);

expr: functionCall
    | expr '.' expr
    | expr '[' expr ']' expr?
    | '(' expr ')'
    | expr '^' expr
    | expr ('*' | '/' | '%') expr
    | expr ('+' | '-') expr
    | expr ('<=' | '>=' | '<' | '>') expr
    | expr ('==' | '!=') expr
    | expr ('&&' | ' and ') expr
    | expr ('||' | ' or ') expr
    | literal
    | identifier;

functionCall: identifier ('.' identifier)* '(' (params (Comma params)* )? ')';

params: literal | identifier  | constructorCall | expr;

type: primType | complexType | identifier;

primType: 'number ' | 'string ' | 'bool ';

// Node node = Nodes[RandomInt(0, IONode.length)];
complexType: ' Vehicle ' | ' Node ' | ' List<' type '>';

identifier: Letter (Letter | Number*);

literal: numberLiteral | stringLiteral | boolLiteral;

numberLiteral: (Number | Number '.' Number)+;

stringLiteral: '"' (Letter | Number)+ '"';

boolLiteral: bool;

bool: 'true' | 'false';

Number: ('0'..'9');

Letter: (('a'..'z') | ('A'..'Z') | ('_'))+;

Comma: ',';
Equals: '=';
SemiColon: ';';

Comment: '//' ~('\r' | '\n')* -> skip;

MultiComment: '/*' .*? '*/' -> skip;

WS: [ \t\r\n]+ -> skip;