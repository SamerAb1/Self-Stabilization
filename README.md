Dijkstra's Self-Stabilization Algorithms Simulator

Overview
  The Self-Stabilizing Algorithms Simulator is a Java application developed to simulate and visualize two of Dijkstra’s self-stabilizing algorithms in distributed computing: the K-State Machines and Three-State Machines algorithms. This simulator enables users to observe and experiment with how these algorithms stabilize on networks of processors arranged in various configurations, assisting in both educational and research contexts.
The simulator provides step-by-step execution, automatic runs, and a complexity analysis tool to examine time-step requirements for stabilization. Key features include customizable networks, interactive visualization, and detailed processor state indicators.

Features
  •	K-State Machines Algorithm Simulation:
    o	Customizable network sizes (2-20 processors) and processor states (up to 999).
    o	Interactive visualization on a ring network with options for random or manual value assignment.
    o	Step-by-step execution or automatic runs with a 2-second interval.
    o	Processor states and privileges displayed via color-coding and shape differentiation.
  •	Three-State Machines Algorithm Simulation:
    o	Supports networks of 3-10 processors, displayed in ring or string configurations.
    o	Allows manual or random assignment of processor states.
    o	Toggle button for display mode switching (Ring/String) for deeper insight into algorithm stability.
    o	Similar execution modes and color indicators as K-State Machines.
  •	Complexity Analysis:
    o	Visual comparison of algorithm performance on networks of various sizes.
    o	Generates complexity graphs to illustrate average and worst-case time steps needed for stabilization.
    o	Supports up to five network sizes (up to 10,000 processors) for comprehensive time complexity analysis.

Getting Started
  Prerequisites
    •	Java SE 1.8
    •	JavaFX SDK 19 (for UI components)
    •	SceneBuilder 19.0.0 (for UI development)
    •	Eclipse IDE (2022-12 or newer recommended)
  Installation
    1.	Download the simulator source code from GitHub.
    2.	Extract the downloaded ZIP file.
    3.	Import the project into your Java IDE (e.g., Eclipse).
    4.	Ensure JavaFX and other necessary libraries are properly configured.
    
Usage
  Upon running the simulator, you’ll reach the Main Page where you can select from:
    •	Algorithm Simulation (K-State or Three-State)
    •	Complexity Graph
    •	Exit
  K-State Machines Algorithm
    1.	Choose the K-State Machines Algorithm option from the main menu.
    2.	Algorithm Values Page:
    o	Select the number of processors (2-20) and K value (up to 999).
    o	Assign processor values manually or generate random values.
  3.	Processors Values Page:
    o	Enter specific values for each processor if using manual assignment.
  4.	Simulator Page:
    o	Visualizes the network in real-time, with options for step-by-step or automatic execution.
    o	Special processor indicators: squares represent privileged processors; circles for standard.
    o	Use the Next-Step or Automatic button to control the simulation flow.
  Three-State Machines Algorithm
    1.	Choose the Three-State Machines Algorithm from the main menu.
    2.	Algorithm Values Page:
    o	Select the processor count (3-10) and display configuration (Ring or String).
    o	Assign values manually or randomly.
  3.	Simulator Page:
    o	Similar controls as K-State, with the option to toggle display form.
    o	Privileged processors are marked by specific color and ring indicators for easy tracking.
    
Complexity Analysis
    1.	From the main menu, select Complexity Graph.
    2.	Complexity Main Page:
      o	Define the size of each network and additional parameters (e.g., number of runs).
      o	Choose either K-State Machines or Three-State Machines for the complexity graph.
    3.	Graph Display:
      o	Shows the average and worst-case stabilization steps across different network sizes, aiding in understanding algorithm complexity.

