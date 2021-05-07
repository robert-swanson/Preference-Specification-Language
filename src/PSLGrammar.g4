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
require: REQUIRE NOT? rConstraint PERIOD;
prefer: PREFER NAME NOT? pConstraint PERIOD;

if_: IF condition THEN body otherwiseIf* otherwise?;
otherwiseIf: OTHERWISE IF condition THEN body;
otherwise: OTHERWISE body;

when: WHEN condition body;

condition: TAKING STRING // course
    | OPENPAREND condition AND condition CLOSEPAREND
    | OPENPAREND condition OR condition CLOSEPAREND
    | OPENPAREND condition CLOSEPAREND
    | OPENPAREND NOT condition CLOSEPAREND
    ;

rConstraint: courseNameList // courses
    | NUM credit_hours IN semester_plan// creditHours
    | NUM OF courseNameList // X of courses
    | NUM UPPER DIVISION credit_hours // upper division hours
    | TAKING courseNameList BEFORE courseName // prereqs
    ;

pConstraint: rConstraint
    | LATER course_classes
    | EARLIER course_classes

    | MORE_ course_classes IN semester_plan
    | LESS course_classes IN semester_plan
    | MORE_ credit_hours IN semester_plan
    | LESS credit_hours IN semester_plan
    ;


courseNameList: (STRING ',')* STRING;
courseName: STRING;
credit_hours: CREDITS | HOURS;
course_classes: COURSES | CLASSES;
semester_plan: SEMESTER | PLAN;

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
IN: 'in';

UPPER: 'upper';
DIVISION: 'division';
OF: 'of';

LATER: 'later';
EARLIER: 'earlier';

LESS: 'less';
MORE_: 'more';

SEMESTER: 'semester';
PLAN: 'plan';
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
