/******************************************************************************************
* Weekly Coding Challenge: Bishop Challenge:
*
*Your chess teacher wants to know if a bishop can reach a certain spot on the board in the 
*given amount of moves.
*Given a starting square start, ending square end and the maximum number of moves allowed n.
*Return true if the ending square can be reached from the starting square within the given 
*amount of moves. Keep in mind the chessboard goes from a1 to h8 (8x8).
*Examples
*<code>bishop("a1", "b4", 2) ➞ truebishop("a1", "b5", 5) ➞ falsebishop("f1", "f1", 0) ➞ true</code>Notes
*
*    Chessboard is always empty (only the bishop is there).
*    Bishop can move in any direction diagonally.
*    If the starting and ending square are the same, return true (even if the move is 0).
*    Square names will always be lowercase and valid.
******************************************************************************************/
public class BishopProblem {

    private int xCord;
    private int yCord;
    private int targetXCord;
    private int targetYCord;
    private int steps;
    private int maxSteps;

    public BishopProblem(String start, String end, int maxSteps) {
        this.maxSteps = maxSteps;
        parseCoords(start, end);
        this.steps = 0;
    }

    // To convert from char-int coords to int-int coords
    private void parseCoords(String start, String end){
        switch (start.charAt(0)){
            case 'a':
                this.xCord = 0;
                break;
            case 'b':
                this.xCord = 1;
                break;
            case 'c':
                this.xCord = 2;
                break;
            case 'd':
                this.xCord = 3;
                break;
            case 'e':
                this.xCord = 4;
                break;
            case 'f':
                this.xCord = 5;
                break;
            case 'g':
                this.xCord = 6;
                break;
            case 'h':
                this.xCord = 7;
                break;
        }
        this.yCord = Character.getNumericValue(start.charAt(1)) - 1;

        switch (end.charAt(0)){
            case 'a':
                this.targetXCord = 0;
                break;
            case 'b':
                this.targetXCord = 1;
                break;
            case 'c':
                this.targetXCord = 2;
                break;
            case 'd':
                this.targetXCord = 3;
                break;
            case 'e':
                this.targetXCord = 4;
                break;
            case 'f':
                this.targetXCord = 5;
                break;
            case 'g':
                this.targetXCord = 6;
                break;
            case 'h':
                this.targetXCord = 7;
                break;
        }
        this.targetYCord = Character.getNumericValue(end.charAt(1)) - 1;
    }

    // Does the actual calculations for the class
    public boolean checkPossible(){
        // Pre-req: If start and end positions are the same return true
        if (xCord == targetXCord && yCord == targetYCord)
            return true;
        else {
            // If the start and end positions aren't the same and maxSteps is 0 return false
            if (maxSteps == 0)
                return false;
            // If the start and end positions are one different colors return false 
            if (!sameColor())
                return false;
            // If the maxSteps given is 1, the end position has to be dirrectly diagonal to the start position
            if (maxSteps == 1){
                if (checkDiagonals())
                    return true;
                else
                    return false;
            }
        }
        // If there hasn't been a return yet, that means:
        //      * The coords don't match
        //      * They are on the same color
        //      * The maxSteps given is 2+
        // Because the bishop can get to any square of its color in 2 moves or less we return true
        return true;
    }

    // Checks to see if the bishop's start and end position colors are on the same 
    private boolean sameColor(){
        // True -> black, False -> white
        boolean startColor = true, endColor = true;

        // Start coord color assignment
        if (xCord % 2 == 0)
        {
            // Assign black if both are even
            if (yCord % 2 == 0)
                startColor = true;
            // Otherwise assign white
            else
                startColor = false;
        }
        else{
            // Assign white if x is odd and y is even
            if (yCord % 2 == 0)
                startColor = false;
            // Otherwise assign black
            else
                startColor = true;
        }

        // End coord color assignment
        if (targetXCord % 2 == 0)
        {
            // Assign black if both are even
            if (targetYCord % 2 == 0)
                endColor = true;
            // Otherwise assign white
            else
                endColor = false;
        }
        else{
            // Assign white if x is odd and y is even
            if (targetYCord % 2 == 0)
                endColor = false;
            // Otherwise assign black
            else
                endColor = true;
        }

        // Return the results of comparing the two
        return startColor == endColor;
    }

    // Method checks the diagonals from the starting coord to see if the end coord is on them
    private boolean checkDiagonals(){
        int currX = xCord, currY = yCord;
        // Top-Right Loop
        while(currX != 7 && currY != 7){
            currX++;
            currY++;
            if (currX == targetXCord && currY == targetYCord)
                return true;
        }
        // Bottom-Right Loop
        currX = xCord;
        currY = yCord;
        while(currX != 7 && currY != 0){
            currX++;
            currY--;
            if (currX == targetXCord && currY == targetYCord)
                return true;
        }
        // Top-Left Loop
        currX = xCord;
        currY = yCord;
        while(currX != 0 && currY != 7){
            currX--;
            currY++;
            if (currX == targetXCord && currY == targetYCord)
                return true;
        }
        // Bottom-Left Loop
        currX = xCord;
        currY = yCord;
        while(currX != 0 && currY != 0){
            currX--;
            currY--;
            if (currX == targetXCord && currY == targetYCord)
                return true;
        }
        // If the target coord isn't found, return false
        return false;
    }

    // Settis and Spagettis
    public int getxCord() {
        return xCord;
    }

    public void setxCord(int xCord) {
        this.xCord = xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void setyCord(int yCord) {
        this.yCord = yCord;
    }

    public int getTargetXCord() {
        return targetXCord;
    }

    public void setTargetXCord(int targetXCord) {
        this.targetXCord = targetXCord;
    }

    public int getTargetYCord() {
        return targetYCord;
    }

    public void setTargetYCord(int targetYCord) {
        this.targetYCord = targetYCord;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getMaxSteps() {
        return maxSteps;
    }

    public void setMaxSteps(int maxSteps) {
        this.maxSteps = maxSteps;
    }
 
}
