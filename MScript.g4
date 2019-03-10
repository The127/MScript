/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
grammar MScript;

@header{
package com.github.The127.MScript.antlr;
}

script
	: alias* constant* function*
	;
	
// def d0 as SolarSensor;
alias
	: 'def' Device 'as' Identifier ';'
	;

// def $MyConst as 3.14;
constant
	: 'def' Const 'as' Number ';'
	;

// fn my_function (param1, param2, . . ., paramN) { ... }
function
	: 'fn' Identifier '(' params? ')' fnBody
	;

params
	: Identifier (',' Identifier)*
	;

fnBody
	: '{' varDeclaration* statement* '}'
	;

// var my_var;
// var my_var1, my_var2, ..., my_varN;
varDeclaration
	: 'var' Identifier (',' Identifier)* ';'
	;

statement
	: loopStatement
	| conditionalStatement
	| assignmentStatement
	| readStatement
	| writeStatement
	| yieldStatement
	| sleepStatement
	| returnStatement
	| fnCallStatement
	| thisIsFineStatement
	;

// forever loop (just loop keyword)
// loop {
//    // your awesome code here
// }
// conditional loop
// loop while(one_thing > another_thing) {
//    // your awesome code here
// }
loopStatement
	: 'loop' whileCondition?  block
	;

whileCondition
	: 'while' '(' expression ')' 
	;

// if (one_thing == another_thing) {
//   // do awesome things
// } elif (one_thing != something_else) {
//   // do another awesome thing instead
// } else {
//   // executed if none of the above hold true
//}
conditionalStatement
	: 'if' '(' expression ')' block
	  elifStatement*
	  elseStatement?
	;

elifStatement
	: 'elif' '(' expression ')' block
	;

elseStatement
	: 'else' block
	;

assignmentStatement
	: Identifier '=' expression';'
	;

readStatement
	: readBasic
	| readReagent
	| readSlot
	;
	
// read SolarSensor.SolarAngle into my_variable;
readBasic
	: 'read' dev=Identifier '.' target=Identifier 'into' id=Identifier ';'
	;

// read reagent Furnace.Contents.Copper into my_variable;
readReagent
	: 'read' 'reagent' dev=Identifier '.' reagentMode=Identifier '.' reagent=Identifier 'into' var=Identifier ';'
	;

// read slot dev.0.Mature into my_variable;
readSlot
	: 'read' 'slot' dev=Identifier '.' slotNumber=Integer '.' target=Identifier 'into' var=Identifier ';'
	;

// write my_variable into base.Setting;
writeStatement
	: 'write' id=Identifier 'into' dev=Identifier '.' target=Identifier ';'
	;

yieldStatement
	: 'yield' ';'
	;

sleepStatement
	: sleepHardcoded 
	| sleepVar
	;

// sleep 0.23;
sleepHardcoded
	: 'sleep' Number ';'
	;

// sleep my_var;
sleepVar
	: 'sleep' expression ';'
	;
	
// return my_var;
returnStatement
	: 'return' expression? ';'
	;

// totally will not break the game
// and/or set everything on fire
thisIsFineStatement
	: 'this' 'is' 'fine' ';'
	;

// foo(x);
fnCallStatement
	: functionCall ';'
	;

block
	: '{' statement* '}'
	;

expression
	: functionCall
	| evalExpression
	;

// my_fn(x, y, ..., z)
functionCall
	: Identifier '(' args? ')'
	;
	
args
	: expression (',' expression)*
	;

// precedence 1
evalExpression
	: precedence2 (precedence1Operators precedence2)*
	;

precedence1Operators
	: '&' | '|' | '^'
	;

precedence2
	: precedence3 (precedence2Operators precedence3)*
	;

precedence2Operators
	: '<'|'>'|'>='|'<='|'=='|'!='
	;

precedence3
	: precedence3Operators? precedence4
	;

precedence3Operators
	: '-' | '!'
	;

precedence4
	: precedence5 (precedence4Operators precedence5)*
	;

precedence4Operators
	: '+' | '-'
	;

precedence5
	: atom (precedence5Operators atom)*
	;

precedence5Operators
	: '*' | '/' | '%'
	;

atom
	: Number
	| variable
	| '(' expression ')'
	;
	
variable
	: Identifier
	| Const
	;

// valid numbers:
// 0123123 (no decimal point)
// 012312.134231 (decimal point and numbers after it)
// 12312312. (no numbers after decimal point)
// 0.1234123 (no numbers before decimal point)
// dont allow only decimal point without numbers
Number
	: ('0'..'9')+ ('.' ('0'..'9')*)?
	| '.' ('0'..'9')*
	;

// not a type but used internally
Integer
	: ('0'..'9')+
	;

// possible devices: d0, d1, d2, d3, d4, d5, db
Device
	: 'd' ('b' | '0' | '1' | '2' | '3' | '4' | '5')
	;

// like Identifier but start with $
Const
  :  '$'('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*
  ;	

// start with letters (upper or lower case) followed by any alphanumeric symbol
Identifier
  :  ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*
  ;

// comments and white space -> ignored
BLOCK_COMMENT
	: '/*' .*? '*/' -> channel(HIDDEN)
	;
LINE_COMMENT
	: '//' ~[\n]* -> channel(HIDDEN)
	;
WS 
	: [ \t\r\n\f]+ -> channel(HIDDEN) 
	;
