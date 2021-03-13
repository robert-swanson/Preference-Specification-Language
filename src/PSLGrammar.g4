grammar PSLGrammar;

start: block+ EOF;

block: NAME body;
body: '{' statement+ '}';
statement: require
    | priority
    | prefer
    | if_
    | when;

priority: PRIORITY NAME NUM PERIOD;
require: REQUIRE constraint PERIOD;
prefer: PREFER NAME constraint PERIOD;

if_: IF condition THEN body elif* else_?;
elif: OTHERWISE IF condition THEN body;
else_: OTHERWISE body;

when: WHEN condition body;

condition: TAKING STRING // course
    | NOT condition // not
    | OPENPAREND condition AND condition CLOSEPAREND
    | OPENPAREND condition OR condition CLOSEPAREND
    | OPENPAREND condition CLOSEPAREND
    ;

constraint:
     TAKING? courseNameList // courses
    | NUM credit_hours // creditHours
    | NUM OF courseNameList // X of courses
    | NUM UPPER DIVISION credit_hours // upper division hours
    | TAKING courseNameList BEFORE courseName // prereqs

    | LATER course_classes
    | EARLIER course_classes

    | MORE_ course_classes
    | LESS course_classes
    | MORE_ credit_hours
    | LESS credit_hours

    | NOT constraint // not
    ;


courseNameList: (STRING ',')* STRING;
courseName: STRING;
credit_hours: CREDITS | HOURS;
course_classes: COURSES | CLASSES;

// Statement Types
PRIORITY: 'priority';
REQUIRE: 'require';
PREFER: 'prefer';

IF: 'if';
THEN: 'then';
OTHERWISE: 'otherwise';
WHEN: 'when';
AND: 'and';
OR: 'or';

// Constraints

TAKING: 'taking';
BEFORE: 'before';

CREDITS: 'credits';
HOURS: 'hours';

UPPER: 'upper';
DIVISION: 'division';
OF: 'of';

LATER: 'later';
EARLIER: 'earlier';

LESS: 'less';
MORE_: 'more';


CLASSES: 'classes';
COURSES: 'courses';
NOT: 'not';

// Atoms
STRING: '"' .*? '"';
PERIOD: '.';
OPENPAREND: '(';
CLOSEPAREND: ')';
NUM: [0-9]+;
NAME: [a-zA-Z]('-'|'_'|[a-zA-Z0-9])*;

WS      : [ \t\n]+ -> skip ;  // tells ANTLR to ignore these
