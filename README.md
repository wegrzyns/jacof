Java Ant Colony Optimization Framework
=========
**jacof** is an object-oriented Java-based framework for ant colony optimization (ACO). It implements the most used ACO's implementations.

What is the ACO?
-----

Ant Colony Optimization (ACO) studies artificial systems that take inspiration from the behavior of real ant colonies and which are used to solve discrete optimization problems. In 1999, the Ant Colony Optimization metaheuristic was defined by Dorigo, Di Caro and Gambardella.

The ACOs Developed
-------

This framework implements the following ACO's variations:

| Algorithm                  | Authors | Year |
|---------------------------|----------------------|----------------------|
Ant System | Dorigo, Maniezzo and Colomi | 1992 |
Elitist Ant System | Dorigo | 1992 |
Ant Colony System | Dorigo and Gambardella | 1997 |
Rank-based Ant System | Bullnheimer, Hartl and Strauss | 1997 |
MaxMin Ant System | Stützle and Hoos | 2000 |

The Problems Developed
-------

This framework addresses the following problems:

* Next Release Problem (NRP)
* Traveling Salesperson Problem (TSP)

How To Use
-------
This is a example for the Next Release Problem

```java
int numberOfAnts = 10;
int numberOfInterations = 100;

Problem p = new NextReleaseProblem("in/delsagrado20.nrp");
ACO aco = new AntSystem(p, ants, interations);
```

### Ant System

```java
Problem problem = new NextReleaseProblem("in/delsagrado20.nrp");

AntSystem aco = new AntSystem(problem);

aco.setNumberOfAnts(10);
aco.setNumberOfIterations(50);
aco.setAlpha(1.0);
aco.setBeta(2.0);
aco.setRho(0.1);

int[] bestSolution = aco.solve();

double value = problem.evaluate(bestSolution);

System.out.println(Arrays.toString(bestSolution) + " : " + value)
```

### Ant Colony System

```java
Problem problem = new NextReleaseProblem("in/delsagrado20.nrp");

AntColonySystem aco = new AntColonySystem(problem);

aco.setNumberOfAnts(10);
aco.setNumberOfIterations(50);
aco.setAlpha(1.0);
aco.setBeta(2.0);
aco.setRho(0.1);
aco.setOmega(0.1);
aco.setQ0(0.9);
	
int[] bestSolution = aco.solve();

double value = problem.evaluate(bestSolution);

System.out.println(Arrays.toString(bestSolution) + " : " + value);
```

### Elitist Ant System


```java
Problem problem = new NextReleaseProblem("in/delsagrado20.nrp");

ElitistAntSystem aco = new ElitistAntSystem(problem);

aco.setNumberOfAnts(10);
aco.setNumberOfIterations(50);
aco.setAlpha(1.0);
aco.setBeta(2.0);
aco.setRho(0.1);
aco.setWeight(6);

int[] bestSolution = aco.solve();

double value = problem.evaluate(bestSolution);

System.out.println(Arrays.toString(bestSolution) + " : " + value);

```

### Rank-based Ant System

```java
Problem problem = new NextReleaseProblem("in/delsagrado20.nrp");

RankBasedAntSystem aco = new RankBasedAntSystem(problem);

aco.setNumberOfAnts(10);
aco.setNumberOfIterations(50);
aco.setAlpha(1.0);
aco.setBeta(2.0);
aco.setRho(0.1);
aco.setWeight(6);

int[] bestSolution = aco.solve();

double value = problem.evaluate(bestSolution);

System.out.println(Arrays.toString(bestSolution) + " : " + value);

```

### Max-Min Ant System

```java
Problem problem = new NextReleaseProblem("in/delsagrado20.nrp");

MaxMinAntSystem aco = new MaxMinAntSystem(problem);

aco.setNumberOfAnts(10);
aco.setNumberOfIterations(50);
aco.setAlpha(1.0);
aco.setBeta(2.0);
aco.setRho(0.1);
aco.setStagnation(10);

int[] bestSolution = aco.solve();

double value = problem.evaluate(bestSolution);

System.out.println(Arrays.toString(bestSolution) + " : " + value);

```

Version
----
1.0

