# Data-Structures-Project
An Immutable Binary search tree with a Hash Chain implementation and also a Merkel tree to Return its Merkel Root
In this project, we will be discussing about functional programming in Java and its uses and how the Cons-Set is used in functional programming.
A brief introduction will be given about a cryptographic algorithm named Hash chains.
Further on, we will be discussing about Merkle Trees in brief and the characteristic features present in it.
On understanding the various parts of our project, we will then implement our question given which will be split into 3 basic steps:
•	Creating a Cons-Set of integer data.
•	Reading and printing the Data from a Cons-Set to perform Hash chaining.
•	Creating a Merkle tree from the retrieved data from the Cons-Set.
PSEUDO CODE:
Parent hash- hash(parent data)
Child hash-hash(stringof(parent hash + child data))
Parent hash=child hash

Roothash-merkel root
Hash(stringof(all hashes from nodes))
