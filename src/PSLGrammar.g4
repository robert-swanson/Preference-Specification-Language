grammar PSLGrammar;

start: block+ EOF;

block: NAME body;
body: '{' statement+ '}';
statement: require
    | priority
    | prefer
    | if
    | when;

priority: 'priority' NAME NUM '.';
require: 'require' constraint '.';
prefer: 'prefer' NAME constraint '.';

if: 'if' condition 'then' body elif* else?;
elif: 'elif' condition 'then' body;
else: 'else' body;

when: 'when' condition body;

condition: 'taking' NAME;
constraint: NAME+
    | NUM NAME+
    | NUM 'of' (NAME ',')* NAME;

NUM: [0-9]+;
NAME: [a-zA-Z](-|_|[a-zA-Z0-9])*;
