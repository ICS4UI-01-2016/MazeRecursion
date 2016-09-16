/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivemaze;

/**
 *
 * @author lamon
 */
public class RecursiveMaze {

    
    public void printMaze(char[][] maze){
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[row].length; col++){
                System.out.print(maze[row][col]);
            }
            System.out.println("");
        }
    }
    
    public boolean solveMaze(char[][] maze, int row, int col){
        // bad conditions
        // not even in the maze!
        if(row < 0 || row >= maze.length){
            return false;
        }
        if(col < 0 || col >= maze[0].length){
            return false;
        }
        // cant move to this spot
        if(maze[row][col] == 'X' || 
                maze[row][col] == '+'){
            return false;
        }
        
        // winning condition: found the exit
        if(maze[row][col] == 'E'){
            return true;
        }
        
        // mark spot as visited
        maze[row][col] = '+';
        
        //try north
        // try path. if successful - DONE!
        if(solveMaze(maze, row - 1, col)){
            return true;
        }
        // try east
        // if path successful - DONE!
        if(solveMaze(maze, row, col + 1)){
            return true;
        }
        // try south
        // if path successful - DONE!
        if(solveMaze(maze, row + 1, col)){
            return true;
        }
        // try west
        // if path successful - DONE!
        if(solveMaze(maze, row, col - 1)){
            return true;
        }
        
        // tried every direction - NO GOOD
        // "unvisit" the spot
        maze[row][col] = '.';
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RecursiveMaze test = new RecursiveMaze();
        
        // X - wall, . - space, S - start, 
        // E - end, + - path
        char[][] maze = {
            {'X', 'X', 'X', 'X', 'X','X', 'X', 'X', 'X', 'X'},
            {'S', '.', '.', '.', 'X','X', 'X', '.', '.', 'X'},
            {'X', '.', 'X', '.', '.','.', 'X', '.', 'X', 'X'},
            {'X', '.', 'X', '.', 'X','.', 'X', '.', '.', 'X'},
            {'X', '.', '.', '.', 'X','.', '.', '.', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X','.', 'X', '.', 'X', 'X'},
            {'X', 'X', 'X', '.', '.','.', 'X', '.', 'X', 'X'},
            {'X', '.', '.', '.', 'X','X', 'X', '.', '.', 'E'},
            {'X', 'X', 'X', '.', '.','.', '.', '.', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X','X', 'X', 'X', 'X', 'X'}
        };
        
        test.printMaze(maze);
        if(test.solveMaze(maze, 1, 0)){
            System.out.println("Solved the maze");
            test.printMaze(maze);
        }else{
            System.out.println("Failed to solve maze");
        }
    }
    
}
