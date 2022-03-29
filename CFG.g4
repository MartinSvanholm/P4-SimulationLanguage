grammar CFG;

program: environmentSection? behaviorSection? updateSection? outputSection? EOF;

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
    | MultiComment;

dcl: functionDcl
   | listDcl
   | classDcl
   | objDcl
   | primVarDcl;

endCondition: 'EndCondition' '{' codeBlock* 'return' expr SemiColon '}';

initCondition: 'InitCondition<' type '>' '{' codeBlock* '}';

/* FUNCTION CALL
    Void function: function TestFunction() { }
    With return type: function bool IsClearToDrive() { }
*/
functionDcl: 'function' identifier dclParams stmtBody
           | 'function' primType identifier dclParams funcReturnBody;

funcReturnBody: '{' codeBlock* 'return' expr SemiColon '}';

//  List<Road> roadList {Road1, Road2};
listDcl: 'List<' type '>' identifier ('{' params multipleParams '}')? SemiColon;

classDcl: type identifier classBody;

classBody: '{' classPropDcl* '}';

classPropDcl: contructorDcl
            | functionDcl
            | listDcl
            | primVarDcl
            | statement
            | assignment
            | expr SemiColon;

contructorDcl: 'constructor' 'Create<' type '>' dclParams '{' codeBlock* '}';

constructorCall: 'Create<' type '>' '(' (params multipleParams)? ')';

objDcl: type identifier Equals (constructorCall | expr) SemiColon;

primVarDcl: primType identifier (Equals expr)? SemiColon;

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
switchBody: '{' ('case' (numberLiteral | type) ':' codeBlock* )+ ('default:' expr*)? '}';

iterativeCtrl: whileLoop | forLoop;

// while(Sentinal) { }
whileLoop: 'while' '('expr')' stmtBody;

forLoop: 'for' identifier 'in range' '(' (numberLiteral | identifier) ')' stmtBody;

stmtBody: '{' codeBlock* '}';

assignment: identifier Equals (identifier | expr) SemiColon;

expr: functionCall
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

functionCall: identifier '(' (params (Comma params)* )? ')';

params: expr | constructorCall;

multipleParams: (Comma (constructorCall | expr))*;

dclParams: '(' (type identifier multipleDclParams)? ')';

multipleDclParams: (Comma type identifier)*;

type: primType | complexType | identifier;

primType: 'number ' | 'string ' | 'bool ';

// Node node = Nodes[RandomInt(0, IONode.length)];
complexType: 'Vehicle ' | 'Node ' | 'List<' type '>';

identifier: Letter (Letter | Number*) ('.' identifier)*;

literal: numberLiteral | stringLiteral | boolLiteral;

numberLiteral: (Number | Number '.' Number)+;

stringLiteral: '"' (Letter | Number)+ '"';

boolLiteral: bool;

bool: 'true' | 'false';

codeBlock: dcl | statement | assignment | expr SemiColon;

Number: ('0'..'9');

Letter: (('a'..'z') | ('A'..'Z') | ('_'))+;

Comma: ',';
Equals: '=';
SemiColon: ';';

Comment: '//' ~('\r' | '\n')* -> skip;

MultiComment: '/*' .*? '*/' -> skip;

WS: [ \t\r\n]+ -> skip;