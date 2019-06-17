# ZombieDriver

The ZombieApocalypse is a programme written in Java that allows a user by altering the input.txt file to create a single zombie at the start of the game and many creatures. The user may also alter the board size and the movements that a zombie can make.  
When a zombie reaches a square that a creature is on, the creature is converted and the zombie's gain 1 point. The newly converted zombie will follow the movements commands when the zombie before it has completed its movement.

## Installation

The programme was constructed using JDK.

## Usage

To run this project use the following commands:

javac ZombieDriver.java   
java ZombieDriver

Additional tests can be added by altering the input textfile.

## Input Text File

The input.txt file is in the following format:  
X                        - Where X is an integer and represents the size of the board.  
(X,Y)                    - Where X is the x-coordinate of the zombie, and y is the y-coordinate of the zombie. Only one zombie may be present to begin with.  
(X,Y), (X,Y), ..., (X,Y) - Where X is the x-coordinate of a creature, and y is the y-coordinate of a creature.  
URLD                     - Where U is up, R is right, L is left and D is down. There is no limit to the number of commands.  