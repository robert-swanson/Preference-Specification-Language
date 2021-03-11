grammar PSLGrammar;

start: block+ EOF;

block: NAME body;
body: '{' statement+ '}';
statement: require
    | priority
    | prefer
    | if
    | when;

priority: PRIORITY NAME NUM PERIOD;
require: REQUIRE constraint PERIOD;
prefer: PREFER NAME constraint PERIOD;

if: IF condition THEN body elif* else?;
elif: ELIF condition THEN body;
else: ELSE body;

when: WHEN condition body;

condition: TAKING NAME;
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


courseNameList: (NAME ',')* NAME;
courseName: NAME;
credit_hours: CREDITS | HOURS;
course_classes: COURSES | CLASSES;

// Statement Types
PRIORITY: 'priority';
REQUIRE: 'require';
PREFER: 'prefer';

IF: 'if';
THEN: 'then';
ELIF: 'elif';
ELSE: 'else';
WHEN: 'when';

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
PERIOD: '.';
NUM: [0-9]+;
NAME: [a-zA-Z]('-'|'_'|[a-zA-Z0-9])*;

WS      : [ \t\n]+ -> skip ;  // tells ANTLR to ignore these
