public class Maze {
    int rows;
    int cols;
    String[] map;
    int robotRow;
    int robotCol;
    int steps;

    public Maze() {
        // Note: in my real test, I will create much larger
        // and more complicated map
        rows = 1000;
        cols = 1000;

        map = new String[rows];

        /*
        map[0]  = "....................................................................................................";
        map[1]  = ".                                              ..                                                  .";
        map[2]  = ".      ..............            ..........    ..              ..                          ..      .";
        map[3]  = ".      ..............            ..........    ..              ..                          ..      .";
        map[4]  = ".      ..............            ..........    ..                  ...     ..                      .";
        map[5]  = ".      .............                     ..                  ...   ...          ....................";
        map[6]  = ".                                              ..                  ...     ..   ....................";
        map[7]  = ".       ....  .   .  .  .....                                                   ...     ..         .";
        map[8]  = ".       .  .  .. ..  .    .            ..........................  .........    ...     ..         .";
        map[9]  = ".       ....  . . .  .    .            ..........................  .........    ...     ..         .";
        map[10] = ".       ..    .   .  .    .            ........                                 ...     ..         .";
        map[11] = ".       . .   .   .  .    .        .   ........                        ..                       ....";
        map[12] = ".       .  .  .   .  .    .        .   ........                        ..                       ....";
        map[13] = ".                                  .                                   ..  ..           .......    .";
        map[14] = ".    ..       ..    ..       ..    .        ..      ..    ...          ..  ..           .......    .";
        map[15] = ".    ....     ..    ....     ..    .        ..      ..    .....        ..  ..                      .";
        map[16] = ".    .. ..    ..    .. ..    ..        .    ..      ..    ..  ...  ..      ..                      .";
        map[17] = ".    ..  ..   ..    ..  ..   ..   .......   ..........    ..   ..  ..      ..                      .";
        map[18] = ".    ..   ..  ..    ..   ..  ..   .......   ..........    ..   ..  ..      ..                      .";
        map[19] = ".    ..    .. ..    ..    .. ..        .    ..      ..    ..  ...          ..                      .";
        map[20] = ".    ..     ....    ..     ....             ..      ..    .....            ..    ..........        .";
        map[21] = ".    ..       ..    ..       ..             ..      ..    ...              ..    ..........        .";
        map[22] = ".                                                                          ..                      .";
        map[23] = ".      ....         ....        .   .            ..        ..                    ..                .";
        map[24] = ".      ....  .      ....        .   .         .  ..        ..                    ............      .";
        map[25] = ".      ....  .      ....        .   ...........  ..        ..                    ............      .";
        map[26] = ".      ....  .      ....        .   ...........  ..        ..                    ............      .";
        map[27] = ".      ....  .      ....        .   .         .  ..        ..                   ............      X.";
        map[28] = ".            .                  .   .            ..        ..................                      .";
        map[29] = "....................................................................................................";
        */
        // Upper bound = 2* accessible points + walls 2* 2600 + 400 = 5800 steps 3700 < 5800
        // 600 walls => upper = 2*2400 +600 = 5200 steps
        // 3700 -> 1204

        /*
        map[0]  = "....................................................................................................";
        map[1]  = ".                                              ..                                                  .";
        map[2]  = ".                                              ..                          ..                      .";
        map[3]  = ".                                              ..                          ..                      .";
        map[4]  = ".      ..............                          ..                  ...     ..                      .";
        map[5]  = ".            .............                     ..                  ...     ..   ....................";
        map[6]  = ".                                              ..                  ...     ..   ....................";
        map[7]  = ".       ....  .   .  .  .....                                                   ...     ..         .";
        map[8]  = ".       .  .  .. ..  .    .            ........                     .........   ...     ..         .";
        map[9]  = ".       ....  . . .  .    .            ........                    .........    ...     ..         .";
        map[10] = ".       ..    .   .  .    .            ........                                 ...     ..         .";
        map[11] = ".       . .   .   .  .    .        .   ........                        ..                       ....";
        map[12] = ".       .  .  .   .  .    .        .   ........                        ..                       ....";
        map[13] = ".                                  .                                   ..  ..           .......    .";
        map[14] = ".    ..       ..    ..       ..    .        ..      ..    ...          ..  ..           .......    .";
        map[15] = ".    ....     ..    ....     ..    .        ..      ..    .....        ..  ..                      .";
        map[16] = ".    .. ..    ..    .. ..    ..        .    ..      ..    ..  ...  ..      ..                      .";
        map[17] = ".    ..  ..   ..    ..  ..   ..   .......   ..........    ..   ..  ..      ..                      .";
        map[18] = ".    ..   ..  ..    ..   ..  ..   .......   ..........    ..   ..  ..      ..                      .";
        map[19] = ".    ..    .. ..    ..    .. ..        .    ..      ..    ..  ...          ..                      .";
        map[20] = ".    ..     ....    ..     ....             ..      ..    .....            ..    ..........        .";
        map[21] = ".    ..       ..    ..       ..             ..      ..    ...              ..    ..........        .";
        map[22] = ".                                                                          ..                      .";
        map[23] = ".      .            .           .            .                             ..                      .";
        map[24] = ".      .     .      .           .            .                             ..                      .";
        map[25] = ".      .     .      .                        .        .                    ..                      .";
        map[26] = ".      .     .      .                        .        .                    ..                      .";
        map[27] = ".      .     .      .           .            .        .                    ..                      .";
        map[28] = ".            .                  .                     .                    ..                      .";
        map[29] = "....................................................................................................";
        */
        // Upper bound = 2* accessible points + walls 2* 2600 + 400 = 5800 steps 3700 < 5800



        map[0]   = "............................................................................................................................................................................................................................................................................................................";
        map[1]   = ".             .                                                                                                                                                                                                                                                                                            .";
        map[2]   = ".             .                                                                                                                                                                                                                                                                                            .";
        map[3]   = ".             .                                                                                                                                                                                                                                                                                            .";
        map[4]   = ".             .                                                                                                                                                                                                                                                                                            .";
        map[5]   = ".             .        ........................................................................                                                                                                                                                                                                            .";
        map[6]   = ".             .                                                                                                                                                                                                                                                                                            .";
        map[7]   = ".             .                                                                                                                                                                                                                                                                                            .";
        map[8]   = ".             .                                                                                                                                                                                                                                                                                            .";
        map[9]   = ".                                                ........................................................................                                                                                                                                                                                  .";
        map[10]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[11]  = ".              .                                                                                                                                                                                                                                                                                           .";
        map[12]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[13]  = ".              .                                                                                                                                                                                                                                                                                           .";
        map[14]  = ".               .                                                                                                                                                                                                                                                                                          .";
        map[15]  = ".               .                                                                                                                                                                                                                                                                                          .";
        map[16]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[17]  = ".                                             ........................................................................                                                                                                                                                                                     .";
        map[18]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[19]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[20]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[21]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[22]  = ".                ..       ..    ..       ..    .        ..      ..    ...                                                                                                                                                                                                                                  .";
        map[23]  = ".                ....     ..    ....     ..    .        ..      ..    .....                                                                                                                                                                                                                                .";
        map[24]  = ".                .. ..    ..    .. ..    ..        .    ..      ..    ..  ...                                                                                                                                                                                                                              .";
        map[25]  = ".                ..  ..   ..    ..  ..   ..   .......   ..........    ..   ..  ..                                                                                                                                                                                                                          .";
        map[26]  = ".                ..   ..  ..    ..   ..  ..   .......   ..........    .......  ..                                                                                                                                                                                                                          .";
        map[27]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[28]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[29]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[30]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[31]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[32]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[33]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[34]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[35]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[36]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[37]  = ".                                          ........................................................................     .                                                                                                                                                                                  .";
        map[38]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[39]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[40]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[41]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[42]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[43]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[44]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[45]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[46]  = ".                                                                                                                        .                                                                                                                                                                                 .";
        map[47]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[48]  = ".                                                                                                                                                                                                                                                                                                          .";
        map[49]  = "............................................................................................................................................................................................................................................................................................................";


        robotRow = 1;
        robotCol = 1;
        steps = 0;
    }

    public String go(String direction) {
        if (!direction.equals("UP") &&
                !direction.equals("DOWN") &&
                !direction.equals("LEFT") &&
                !direction.equals("RIGHT")) {
            // invalid direction
            steps++;
            return "false";
        }
        int currentRow = robotRow;
        int currentCol = robotCol;
        if (direction.equals("UP")) {
            currentRow--;
        } else if (direction.equals("DOWN")) {
            currentRow++;
        } else if (direction.equals("LEFT")) {
            currentCol--;
        } else {
            currentCol++;
        }

        // check the next position
        if (map[currentRow].charAt(currentCol) == 'X') {
            // Exit gate
            steps++;
            System.out.println("Steps to reach the Exit gate " + steps);
            return "win";
        } else if (map[currentRow].charAt(currentCol) == '.') {
            // Wall
            steps++;
            return "false";
        } else {
            // Space => update robot location
            steps++;
            robotRow = currentRow;
            robotCol = currentCol;
            return "true";
        }
    }

    // Main program to run
    public static void main(String[] args) {
        (new Robot()).navigate();
    }
}

class Robot {
    // Set maximum maze size: maximum row and maximum col
    private static final int MAX_ROW = 1000;
    private static final int MAX_COL = 1000;

    private static final int MAX_SIZE = 1000;

    // Create navigate method
    public void navigate() {

        // Create a maze object
        Maze maze = new Maze();

        // Create an array of virtual maze for robot
        // Starting array with all 0(undiscovered), if discovered then assigned 1, if wall then assigned 2
        int[][] maze_check_array = new int[MAX_ROW][MAX_COL];

        // Reach exit gate flag
        boolean reachExit = false;

        // Set current location of robot in virtual maze
        int cur_row = 0;
        int cur_col = 0;

        // Starting Point in the virtual maze
        maze_check_array[cur_row][cur_col] = 1;

        // Direction array
        String[] directions = { "LEFT", "UP", "RIGHT", "DOWN" };
        int[] dX = { -1, 0, 1, 0 };
        int[] dY = { 0, -1, 0, 1 };

        // Printing out start the game when run the program
        System.out.println("Starting the game:");

        // A loop to move the Robot until it find the Exit Gate,
        // or it is impossible to reach the Exit Gate
        while (!reachExit) {
            // Initialize a path which contains the directions
            // that Robot follows to go to the nearest next location that is not visited
            // from its current location
            String path = move_nearest_point(cur_row, cur_col, maze_check_array);

            // In case that the Exit Gate is blocked around the walls
            // or the location of Robot is blocked by the walls
            // Print out message that cannot find the Exit Gate
            if (path.equals("")) {
                System.out.println("Cannot find the Exit Gate. It is blocked");
                break;
            }

            // Move the robot based on the directions
            for (int i = 0; i < path.length(); i++) {
                // Define the directions that Robot follows in each step
                int direction = path.charAt(i) - '0';

                // Print out the direction that Robot goes
                System.out.println("Go: " + directions[direction]);

                // result of each step Robot makes:
                // "win" when Robot go to the Exit Gate
                // "true" when the Robot can go to the next location
                // "false" when Robot meets the walls
                String result = maze.go(directions[direction]);

                switch (result)
                {
                    case "win":
                        reachExit = true;
                        System.out.println("\nFind the Exit Gate. Game complete");
                        break;
                    case "true":
                        cur_row = (cur_row + dY[direction] + MAX_ROW) % MAX_ROW;
                        cur_col = (cur_col + dX[direction] + MAX_COL) % MAX_COL;
                        // Set the value of position that Robot can go and visited equals 1
                        maze_check_array[cur_row][cur_col] = 1;
                        break;
                    case "false":
                        int nextRow = (cur_row + dY[direction] + MAX_ROW) % MAX_ROW;
                        int nextCol = (cur_col + dX[direction] + MAX_COL) % MAX_COL;
                        // Set the value of position that Robot encounter walls equals 2
                        maze_check_array[nextRow][nextCol] = 2;
                        break;
                }
            }
        }
    }

    public String move_nearest_point(int current_row, int current_col, int[][] arr) {
        // initial result
        String result = "";

        // LinkedListQueue to save the location in the virtual map that Robot visited
        LinkedListQueue<Coordinate> save_point = new LinkedListQueue<>();

        // current location
        Coordinate current_point = new Coordinate(current_row, current_col);

        // Add current location to the save_point LinkedListQueue
        save_point.enQueue(current_point);

        // Create a new 2-D array named visited array for Robot to use BFS
        int[][] visited = new int[MAX_ROW][MAX_COL];

        // Initialize the value for start location in visited array
        visited[current_row][current_col] = 1;

        // Initialize next visit row and col
        int next_visited_row = -1;
        int next_visited_col = -1;

        // while loop to find the nearest position to the current location that is not discovered
        while (!save_point.isEmpty()) {
            // Get the first element of the Queue
            Coordinate start = save_point.peekFront();
            save_point.deQueue();
            int cur_row = start.getRow();
            int cur_col = start.getCol();

            // when current location is not visited(== 0) => condition = true
            if(arr[cur_row][cur_col] == 0){
                next_visited_row = cur_row;
                next_visited_col = cur_col;
                break;
            } else{
                // Define direction array
                Coordinate[] four_directions = new Coordinate[4];

                // Four directions from current location after extending when Robot using BFS
                Coordinate right_cor = new Coordinate(cur_row, move_row_and_cols(cur_col, 1));
                Coordinate left_cor = new Coordinate(cur_row, move_row_and_cols(cur_col, -1));
                Coordinate up_cor = new Coordinate(move_row_and_cols(cur_row, -1), cur_col);
                Coordinate down_cor = new Coordinate(move_row_and_cols(cur_row, +1), cur_col);

                // Add four directions into array four_direction
                four_directions[0] = right_cor;
                four_directions[1] = left_cor;
                four_directions[2] = up_cor;
                four_directions[3] = down_cor;

                // Check condition and add element to Queue
                for(int i = 0; i < 4; i++){
                    if(arr[four_directions[i].getRow()][four_directions[i].getCol()] == 2){
                        // Set value if this point is a wall equals -1 => Robot cannot go to this position
                        visited[four_directions[i].getRow()][four_directions[i].getCol()] = -1;
                    } else if (visited[four_directions[i].getRow()][four_directions[i].getCol()] != 0) {
                        // If Robot already marked this position in the visited array, continue
                        continue;
                    } else {
                        // Add positions to the save_point LinkedListQueue and visited array
                        save_point.enQueue(four_directions[i]);
                        visited[four_directions[i].getRow()][four_directions[i].getCol()] = visited[cur_row][cur_col] + 1;
                    }
                }
            }
        }

        // If Robot cannot find the next position to go
        // => in the case that either the Robot or Exit Gate is blocked with walls, then returns nothing
        if (next_visited_col == -1 && next_visited_row == -1)
            return "";

        // Set directions
        int[] dX = {-1, 0, 1, 0};
        int[] dY = {0, -1, 0, 1};

        // Initialize a value variable to get the value of the next location that Robot must go to
        int value = visited[next_visited_row][next_visited_col];

        // Assign the instruction of direction to go to the nearest location that is not visited to Robot
        // Use loop to backtrack the direction from next location that Robot must go to its current location
        // with the shortest steps
        while (value != 1) {
            for (int i = 0; i < 4; i++) {
                // Create new variables to get the row and cols values of position
                // that is next to the next visited location
                int x = (next_visited_col + dX[i] + MAX_COL) % MAX_COL;
                int y = (next_visited_row + dY[i] + MAX_ROW) % MAX_ROW;

                // If the location if the visited[y][x] ( the previous location before reach the next visited location)
                // is satisfied, then add instruction to move to the Robot
                if (visited[y][x] == value - 1) {
                    result = ((i + 2) % 4) + result;
                    next_visited_col = x;
                    next_visited_row = y;
                    value -= 1;
                    break;
                }
            }
        }
        // Return the instructions to move to Robot
        return result;
    }

    // Create a move method for Robot in virtual maze
    public int move_row_and_cols(int x, int delta){
        return (x + delta + MAX_SIZE) % MAX_SIZE;
    }
}

// Class for coordinate
class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }
}

class LinkedListQueue<Coordinate> {
    // this class is used as a container of data
    static class Node<Coordinate> {
        Coordinate data;
        Node<Coordinate> next;

        public Node(Coordinate data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node<Coordinate> head;

    // Constructor
    public LinkedListQueue() {
        size = 0;
        head = null;
    }

    // check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // add a new node in queue
    public void enQueue(Coordinate item) {
        Node<Coordinate> n = new Node<>(item);
        n.next = head;
        head = n;
        size++;
    }

    // remove the node in queue
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            head = null;
            size = 0;
            return true;
        }
        Node<Coordinate> prev = head;
        Node<Coordinate> current = prev.next;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        size--;
        return true;
    }

    // get the current node without removing it
    public Coordinate peekFront() {
        if (isEmpty()) {
            return null;
        }
        Node<Coordinate> node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node.data;
    }
}