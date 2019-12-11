this project is a solution  of new tendeuse problem.
it is based on 2 design pattern:
1) state pattern to manage tendeuse positions
2) command pattern to decouple objects that produce the commands from the consumer (new tendeuse).

to create an executable run **maven clean package**.

you can run the application by running the main class **NewMowerApplication** using your **IDE** or the **java** cmd.

obviously you can run the application by launching  **java -jar #target of your executable#**.


the application expect as input a file containing configs(pelouse, tendeuses).

you can provide the absolute file path (sorry!! you can provide relative path in a next release) using one of the solutions below.
 NB : this order allows you to override the value.
 
 1) the first argument of the program main class
 2) provide VM argument named MOWER_CONFIG_FILE
 3) provide ENV variable named MOWER_CONFIG_FILE
 4) provide the property mower.config.file in the application.properties
