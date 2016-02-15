# Concurrency Java example with OO design patterns

This example shows how to use the Java executor framework along with design patters:

- Singleton
- Factory method
- Bridge


## Description
There are two entity types:
- Chef: makes foods
- Eater: eats foods

Instances of both can be created.

The bridge patter allows different classes of both types
(DessertChef, OmnivorousEater...) to be implemented elsewhere.
Therefore we have a core logic and the implementation may
belong to another package.

Factories are used to create objects of these classes al around.