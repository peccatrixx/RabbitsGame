# RabbitsGame
In this PART#1, you are NOT ALLOWED TO USE ARRAYS. You can
only use variables (including String) to store data, selection statements (if,
else-if, switch), while/for/do-while loops, and methods. You are not
allowed to use other complex data structures (including arrays and
ArrayLists), or classes to implement PART#1. You will implement this part
in a .java file called RabbitGamePart1.java.
In this project, you will design and implement a game in which we have
rabbits and carrots in a triangular game area. The user gives the size of the
game area - S -. Let’s assume that the user gives S as 6. You will have a
game area as follows:
The user determines the size of the game area. It can be bigger or smaller.
In the game area, you will have the following characters and rules;
- Place 3 rabbits at random locations,
- Place carrots at locations where i and j are both even numbers,
- Place 2 rats at random locations,
- Place 2 exit rooms at random locations (one goes to Heaven, the other
goes to Hell),
- Place one player in a random location.
- 
The player of the game can move in any direction (user inputs for moving
are 8: up, 2: down, 6: right, 4: left) depending on his current position.
For example, if the player is at location (4, 1), he can move to the right and
down, but not move to the left and up.
At the beginning of the game, the player has no carrots. When he visits a
location having a carrot, his carrot count increases if he can answer an
arithmetic question (addition, subtraction, division, multiplication)
correctly. A question will be randomly generated. When the player visits a
location having a rabbit, he feeds the rabbit with carrots. Each rabbit eats a
random number of carrots. If the player has enough carrots, he gains
some game points; otherwise, he loses some game points. When the
player visits a location having a rat, he loses some of his carrots. You can
determine the amount of points to lose/gain and the amount of carrots to
lose by yourself. The game finishes when the player enters one of the exit
rooms. If he enters the “Heaven Exit”, print his total game points. If he
enters the “Hell Exit”, he will lose all carrots and lose the game.
After each move as the output, print the current location of the player, the
current number of carrots, the number of rabbits visited since the
beginning of the game, total game points, etc. At the end of the game,
print the game area showing rabbits, rats, carrots, exits, etc.
Also, you MUST add any other game rules or special characters
into your game.
Your solution must be modular since you must define sub-tasks and
implement methods. You have to write the following basic methods in
your program and use them. You must also write other methods that you
design. - isThereARabit(int i1, int j1, int i2, int j2, int i3, int j3, int i_player, int
j_player) that gets the rabbit locations and the player’s location and returns
true if there is a rabbit at the player’s location.
- isThereARat(int i1, int j1, int i2, int j2, int i_player, int j_player) that gets the rat
locations and player’s location and returns true if there is a rat at the
player’s location.
- isThereACarrot(int i_player, int j_player) that gets the player’s location and
returns true if there are some carrots at the player’s location.
- exitToHeaven(int i1, int j1, int i_player, int j_player) that gets the location of
the Heaven Exit and the player’s location and returns true if the player is
at the Heaven Exit.
- exitToHell(int i1, int j1, int i_player, int j_player) that gets the location of the
Hell Exit and the player’s location and returns true if the player is at the
Hell Exit.
- canMove(int i_player, int j_player, int direction) that gets the location of the
player and the direction he wants to go and returns true if it is possible to
go in that direction (if there is a cell in that direction on the game area);
otherwise returns false.
- generateAQuestion(int type) that gets a number between 0 and 3 (0: addition,
1: subtraction, 2: division, 3: multiplication) and asks the player a question
of the given type, gets the answer, checks the answer and return true if the
answer is true; otherwise false.
- Other methods (at least 3 more) that you will design.
——————— o ————————
PART#2 - Advance Rabbits or Carrots Game
Let’s assume now in PART#2 we have more than one player in the
game area. There can be many players and each player will make his move
in the game during his turn. You can use the array structure to store/
process the players. For game functionalities, you can call/invoke the
methods that are implemented in the RabbitGamePart1.java class. You
can also change the number of rabbits, carrots, and rats in the game in this
PART#2. You will implement this part in a .java file called
RabbitGamePart2.java.
At the end of the game, announce the player who wins the game. You
must define a rule to determine the winner. You have to print some game
statistics for each player at the end of the game. You must implement the
following methods:
- findWinner(…) that will return the winner of the game.
- findCarrotCollector(….) that will return the user who collects the most
number of carrots.
- findRabbitFeeder(….) that will return the player who feeds the most
number of rabbits.
- findRatVisitor(…..) that will return the player who visits the most number
of rats.
- Other methods (at least 2 more) that you will design.
