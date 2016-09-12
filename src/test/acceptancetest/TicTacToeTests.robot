*** Settings ***
Library           keywords.TicTacToeKeywords

*** Keywords ***
Check Location  [arguments]  ${row}  ${col}  ${mark}
    ${m}=   Get Mark    ${row}  ${col}
    Should Be Equal     ${m}    ${mark}
    
Winner Should Be    [arguments]     ${mark}
    ${w}=   Get Winner  
    Should Be Equal     ${w}    ${mark}
	
 
*** Test Cases ***
Win Diagonally As X
	Start New Game
	Mark Location	1	1
	Check Location	1	1	X
	Mark Location	0	1
	Check Location	0	1	O
	Mark Location	0	0
	Check Location	0	0	X
	Mark Location	0	2
	Check Location	0	2	O
	Mark Location	2	2
	Check Location	2	2	X
	Winner Should Be	X
	
Win Horizontally as O
    Start New Game
    Mark Location       1   1
    Check Location  1   1   X
    Mark Location       2   0
    Check Location  2   0   O
    Mark Location       0   0
    Check Location  0   0   X
    Mark Location       2   2
    Check Location  2   2   O
    Mark Location       0   2
    Check Location  0   2   X
    Mark Location       2   1
    Check Location  2   1   O
    Winner Should Be    O

Force a Tie
    Start New Game
    Mark Location       1   1
    Check Location  1   1   X
    Mark Location       0   0
    Check Location  0   0   O
    Mark Location       2   0
    Check Location  2   0   X
    Mark Location       0   2
    Check Location  0   2   O
    Mark Location       0   1
    Check Location  0   1   X
    Mark Location       2   1
    Check Location  2   1   O
    Mark Location       1   2
    Check Location  1   2   X
    Mark Location       1   0
    Check Location  1   0   O
    Mark Location       2   2
    Check Location  2   2   X
    Winner Should Be    TIE
	
	