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
constraint: NAME+
    | NUM NAME+
    | NUM OF (NAME ',')* NAME;


PRIORITY: 'priority';
REQUIRE: 'require';
PREFER: 'prefer';
IF: 'if';
THEN: 'then';
ELIF: 'elif';
ELSE: 'else';
TAKING: 'taking';
WHEN: 'when';
OF: 'of';
PERIOD: '.';
NUM: [0-9]+;
NAME: [a-zA-Z](-|_|[a-zA-Z0-9])*;
