# Chapter 11: Swarm Intelligence

```
WIA2005: Advance 
Algorithms
Lecture 11: Swarm Intelligence 
Asmiza Abdul Sani
Semester 2, Session 2025/26
```

## Lecture Outline

- Introduction to Swarm Intelligence
- Types of Swarm Intelligence Algorithms
- Ant Colony Optimization (ACO)
- Particle Swarm Optimization (PSO)
- Artificial Bee Colony Algorithm (ABC)
- Advantages and Limitations of Swarm Intelligence
- Applications of Swarm Intelligence Algorithms

## Swarm Intelligence

- 
Swarm Intelligence (SI) refers to the collective behaviour of decentralized, self-
organized systems composed of numerous entities (agents or individuals)
interacting locally with each other and their environment.
- SI systems are typically made up of many simple agents that interact with
each other and their environment using very simple local rules.
- These systems are inspired by the collective behaviour observed in natural
swarms or groups, such as ant colonies, bird flocks, fish schools, and bee
hives.

## Principle of SI

- Awareness: Each member must be aware of their surroundings and abilities
- Autonomy: To self-coordinate, each member must operate as an autonomous
master (not as a slave)
- Solidarity: When a task is completed, members should autonomously look for
a new task
- Expandability: The system must permit dynamic expansion where members
are seamlessly aggregated
- Resiliency: When members are removed, the system must be self-healing

## Key characteristics of SI

- Decentralization
- Self-Organization
- Adaptability
- Emergence

## How SI works

- SI systems are typically composed of many simple agents that interact with
each other and their environment to achieve a common goal.
- Decentralization allows SI systems to be highly scalable and efficient
- agents can be added or removed without affecting the overall performance of the system.
- Agents are usually simple and homogeneous, and they interact with each
other and their environment using local communication.
- typically leads to emergent behaviour.

## SI components

1. Population of agents/particles
2. Interactions and feedback – Agents interact with each other and their
environment, receiving feedback based on these interactions to evaluate the
fitness value/function of each agent.
- This feedback guides their future actions, allowing for adaptation and learning within the
swarm.
3. Communication - Agents exchange information with neighbouring agents,
either directly or indirectly, to share knowledge, coordinate actions, and
influence each other's behaviours.
- Communication can be through direct interaction, signalling, or other means, depending
on the algorithm or system.

## Common SI Algorithm

- Ant Colony Optimization (ACO)
- Particle Swarm Optimization (PSO)
- Artificial Bee Colony Algorithm (ABC)

## Ant Colony Optimization (ACO)

- Ant colony optimization (ACO), is inspired by the foraging behaviour of ants to
find food.
- It is a technique used to find the shortest path between their nest and food
resources.
- Each ant leaves a trail of pheromones when they search for food. If an ant
finds food, it will return to the nest and leave a stronger trail of pheromones.
Other ants will then be more likely to follow the same path.
- Over time, the most efficient paths will be having strong pheromones, and the
less efficient paths (less pheromones) will be abandoned.
https://youtu.be/qfeymoF8pb4?si=QBS9XZVGo6oEzv3N

## Ant Colony Optimization (ACO)

https://www.geeksforgeeks.org/introduction-to-ant-colony-optimization/

## Particle swarm optimization (PSO)

- Particle swarm optimization (PSO) in an optimization technique inspired by
the swarm behaviour of birds flocking.
- Each particle has a fitness value and a velocity, and it learns the experiences
of the swarm to search for the global optima.
https://youtu.be/JnhJQe2sAno?si=0LiXDy_sK_DORLxS

## Particle Swarm Optimization (PSO)

## Artificial Bee Colony Algorithm (ABC)

- The Artificial Bee Colony (ABC) Algorithms is based on how honeybees find new
sources of food
- They fly out in all directions and return with their findings, then they share this
information with other bees who will then fly out in different directions to look
for food as well.
- ABC algorithm models consist of three groups of bees:
- scout bees discover all food source positions randomly based on the dances,
- employed bee exploiting a source of food which come from scouts bees,
- onlooker bees to evaluate food quality
https://www.youtube.com/watch?v=12Q8FfyLLso

## Artificial Bee

Colony
Algorithm
(ABC)

## Ant Colony Optimization (ACO)

Particle Swarm Optimization (PSO)
Artificial Bee Colony Algorithm
(ABC)
Inspiration
Foraging behaviour of ants
Social behavior of bird flocks or fish
schools
Foraging behaviour of honeybee
colonies
Basic
Mechanism
Pheromone trails, heuristic
information
Particle movement in multi-
dimensional space, velocity
adjustments
Employed bees, onlookers, scout
bees
Exploration vs.
Exploitation
Balances via pheromone levels:
Explores less pheromone trails,
exploits higher pheromone trails
Balances via exploration (random
movement) and exploitation (best-
known positions)
Balances via scout bees
(exploration) and employed/onlooker
bees (exploitation)
Handling
Constraints
Can handle constraints by
incorporating them into problem
formulation
Adaptable but might require specific
handling techniques for constraints
May require adaptations to handle
constraints effectively
Performance &
Applications
Combinatorial optimization
problems: TSP, vehicle routing,
network routing
Continuous optimization problems:
function optimization, parameter
tuning
Various optimization problems:
numerical optimization, scheduling,
feature selection
Key Features
Pheromone trail updates,
pheromone evaporation, heuristic
information utilization
Velocity updates, individual/global
best positions, neighbourhood
search
Employed/onlooker/scout bees,
employed bee food source
exploitation, scout bee exploration
Suitability
Effective for discrete problems with
solution paths, network routing
Efficient for continuous optimization,
function optimization
Applicable across various
optimization problems, limited by
specific constraints

## Applications of SI

- Optimization Problems
- Robotics and Automation
- Network Routing and Traffic Management
- Engineering Design and Optimization
- Healthcare and Medicine
- Energy Management Systems
- Natural Resource Management
- Telecommunication and IoT Networks
- Supply Chain and Logistics

## Advantages of SI

- Adaptability: Swarm systems can adapt to changes in their environment or
task requirements without explicit programming or control.
- Robustness: Decentralized control and the redundancy of multiple agents
make swarm systems resilient to individual failures.
- Efficiency in Exploration: Swarm algorithms often explore search spaces
efficiently, particularly in complex and large solution spaces, finding near-
optimal solutions.
- Parallelism: Swarm systems can perform parallel computations as agents
operate independently, enabling faster problem-solving.
- Simplicity: Many swarm intelligence algorithms are relatively simple and easy
to implement, yet they can produce effective solutions.

## Limitations of SI

- Local Optima: Swarm algorithms might get stuck in local optima, failing to
reach the global optimum due to the nature of decentralized decision-making.
- Convergence Speed: Some swarm algorithms might converge slowly, especially
in high-dimensional or complex search spaces.
- Sensitivity to Parameters: Performance might be highly sensitive to the
selection of parameters, requiring careful tuning for optimal results.
- Limited Problem Scope: While effective for certain problems, swarm
algorithms might not be suitable for all types of optimization or decision-
making tasks.
- Lack of Explanation: Swarm systems often produce solutions without providing
clear explanations or insights into how the solutions were reached, limiting
their interpretability.

## Class Group Activities

1. Bacterial Foraging Optimization Algorithm (BFOA):
2. Firefly Algorithm (FA)
3. Cuckoo Search Algorithm (CS)
4. Bat Algorithm (BA)
5. Fish School Search (FSS)
6. Wolf Search Algorithm (WSA)
7. Grasshopper Optimization Algorithm (GOA)
8. Social Spider Optimization (SSO)
9. Butterfly Optimization Algorithm (BOA)
