grammar CFG;

program: environmentSection behaviorSection updateSection outputSection EOF;

environmentSection: 'Simulation Environment' '{' line* '}';

behaviorSection: 'Simulation Behavior' '{' line* '}';

updateSection: 'Simulation Update' '{' line* '}';

outputSection: 'Simulation Output' '{' line* '}';

line: dcl | Comment | MultiComment;

dcl: functionDcl
   | listDcl
   | classDcl
   | statement;

/* FUNCTION CALL
    Void function: function TestFunction() { }
    With return type: function bool IsClearToDrive() { }
*/
functionDcl: 'function' identifier funcParams stmtBody
           | 'function' primType identifier funcParams funcReturnBody;

funcReturnBody: '{' (statement | listDcl)* 'return' expr';' '}';

funcParams: '(' (primType identifier (Comma primType identifier)*)? ')';

//  List<Road> roadList {Road1, Road2};
listDcl: 'List<' type '>' identifier ('{' params (Comma params)* '}')? ';';

classDcl: type identifier classBody;

classBody: '{' classPropDcl* '}';

classPropDcl: functionDcl
            | listDcl
            | statement;

primVarDcl: primType identifier (Equals expr)?;

type: primType | complexType | identifier;

primType: ' number ' | ' string ' | ' bool ';

// Node node = Nodes[RandomInt(0, IONode.length)];
complexType: ' Vehicle ' | ' Node ';

statement: primVarDcl ';'
         | selectiveCtrl
         | iterativeCtrl
         | assignment ';';

stmtBody: '{' (statement | listDcl)* '}';

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
switchStmt: 'switch' '(' expr ')' switchBody;

switchBody: '{' ('case' numberLiteral ':' expr* )+ ('default:' expr*)? '}';

iterativeCtrl: whileLoop | forLoop;

// while(Sentinal) { }
whileLoop: 'while' '('expr')' stmtBody;

forLoop: 'for' identifier 'in range' '(' (numberLiteral | identifier) ')' stmtBody;

assignment: identifier Equals expr;

identifier: Letter (Letter | Number)*;

params: literal | identifier;

literal: numberLiteral | stringLiteral | boolLiteral | Letter+;

numberLiteral: (Number | Number '.' Number)+;

stringLiteral: '"' (Letter | Number)+ '"';

boolLiteral: Bool;

expr: identifier '(' (params (Comma params)* )? ')'
    | '(' expr ')'
    | expr '^' expr
    | expr ('*' | '/' | '%') expr
    | expr ('+' | '-') expr
    | expr ('<=' | '>=' | '<' | '>')
    | expr ('==' | '!=') expr
    | expr ('&&' | ' and ') expr
    | expr ('||' | ' or ') expr
    | assignment
    | literal;

Number: ('0'..'9');

Letter: ('a'..'z') | ('A'..'Z') | ('_');

Bool: 'true' | 'false';

Comma: ',';
Equals: '=';

Comment: '//' ~('\r' | '\n')* -> skip;

MultiComment: '/*' .*? '*/' -> skip;

WS: [ \t\r\n]+ -> skip;