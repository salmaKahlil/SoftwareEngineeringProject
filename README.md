# Digit Analysis Engine: Real-time Integer Stream Analysis for Digit Occurrences

## System Description:
### The engine receives an arbitrarily large stream of integers and a digit as inputs. For each integer, the engine analyzes the range from 0 to the provided integer (inclusive) while counting the occurrences of the specified digit throughout the provided range of numbers. Only POSITIVE integers (between zero and integer.MAX_VALUE) are accepted by the engine.

### Example:
 Inputs: 

Stream on integers: 10,25,30

Digit: 1

Output:

10:2; 25:13; 30:13




## System Diagram:

![System Diagram](<System Diagram.png>)

## Threading
The engine accepts input from multiUsers running on exactly foro threads. 



