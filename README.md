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
The engine support multithreading with an upper bound of 4 threads running concurrently. 

## Performance Tuning of Computation Algorithm

In the pursuit of optimizing computational efficiency, 
significant enhancements were made to the computation algorithm implemented in the ComputeEngineImp class. Recognizing the necessity for refinement, the algorithm underwent a transformation resulting in the creation of the NewComputeEngineImp class. 
This new implementation leverages advanced mathematical
operations and data structures to achieve remarkable 
performance gains. Notably, by employing logarithmic 
computations and efficient data storage techniques, the 
algorithm now exhibits exponential improvements in speed
and resource utilization. Rigorous benchmark testing 
corroborated these advancements, demonstrating an 
astonishing enhancement percentage of 1629400% as seen in the following picture. 
This substantial upgrade underscores our commitment
to delivering high-performance software solutions and 
signifies a pivotal milestone in the evolution of the 
project. 

[LINK TO THE TEST](test/performancetuning/TestBench.java)


![Results](<Performance%20tuning.jpg.png>)




