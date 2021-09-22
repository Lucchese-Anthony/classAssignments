/* Java application that "draws" a checkerboard whose size (i.e., # rows, 
** # columns, height and width of each square) is specified by inputs 
** entered by the user.
**
** To illustrate, here are two examples:
**
**       4 rows x 6 columns                  10 rows x 8 columns 
**        square height 3                      square height 1
**        square width 4                       square width 2
**
**   +------------------------+              +----------------+
**   |****    ****    ****    |              |**  **  **  **  |
**   |****    ****    ****    |              |  **  **  **  **|
**   |****    ****    ****    |              |**  **  **  **  |
**   |    ****    ****    ****|              |  **  **  **  **|
**   |    ****    ****    ****|              |**  **  **  **  |
**   |    ****    ****    ****|              |  **  **  **  **|
**   |****    ****    ****    |              |**  **  **  **  |
**   |****    ****    ****    |              |  **  **  **  **|
**   |****    ****    ****    |              |**  **  **  **  |
**   |    ****    ****    ****|              |  **  **  **  **|
**   |    ****    ****    ****|              +----------------+
**   |    ****    ****    ****|
**   +------------------------+
**
**
** Authors: R. McCloskey, P.M. Jackowitz, and ....
** Date: Sept. 2019
** CMPS 134  Fall 2019 Prog. Assg. #3
** Collaborated with: ...
** Known Defects: ...
*/

import java.util.Scanner;

public class DrawCheckerBoardV4 {

   public static void main(String[] args) {
     drawBoard();
   }
   
   /* Draws a checkerboard.
   */
   public static void drawBoard() {
   
      // Draw boundary at top of board.
      drawBoundary();
   
      // Draw the four pairs of rows
      for(int i=0; i<4; i++) {
         drawBWRow();
         drawWBRow();
      }
        
      // Draw boundary at bottom of board.
      drawBoundary();
   }

   /* Draws the boundary line that goes at the top and bottom of the board.
   */
   public static void drawBoundary() {
      drawBoundaryJunction();
      for(int i=0; i<8; i++) {
         drawBoundarySegment();
      }
      drawBoundaryJunction();
      System.out.println();
   }

   /* Draws a single BW-row (i.e., one whose leftmost square is black).
   */
   public static void drawBWRow() {
      for(int i=0; i<3; i++) {
         drawBWLine();
      }
   }

   /* Draws a single WB-row (i.e., one whose leftmost square is white).
   */
   public static void drawWBRow() {
      for(int i=0; i<3; i++) {
         drawWBLine();
      }
   }

   /* Draws a single BW-line (i.e., one line of a BW-row).
   */
   public static void drawBWLine() {
      drawBoundaryLR();
      for(int i=0; i<4; i++) {
         drawBWSegmentAlternation();
      }
      drawBoundaryLR();  System.out.println();
   }

   /* Draws a black segment followed by a white segment.
   */
   public static void drawBWSegmentAlternation() {
      drawBSegment();  drawWSegment();
   }

   /* Draws a single WB-line (i.e., one line of a WB-row).
   */
   public static void drawWBLine() {
      drawBoundaryLR();
      for(int i=0; i<4; i++) {
         drawWBSegmentAlternation();
      }
      drawBoundaryLR();  System.out.println();
   }
   
   /* Draws a white segment followed by a black segment.
   */
   public static void drawWBSegmentAlternation() {
      drawWSegment();  drawBSegment();
   }

   /* Draws the boundary marker that indicates a corner of the board
   ** (where horizontal and vertical boundaries meet).
   */
   public static void drawBoundaryJunction() {
      System.out.print("+");
   }

   /* Draws the boundary marker that goes at the left and right ends
   ** of each line.
   */
   public static void drawBoundaryLR() {
      System.out.print("|");
   }

   /* Draws one segment of the top/bottom boundary line.
   */
   public static void drawBoundarySegment() {
      System.out.print("----");
   }

   /* Draws one segment of a black square.
   */
   public static void drawBSegment() {
      System.out.print("****");
   }

   /* Draws one segment of a white square.
   */
   public static void drawWSegment() {
      System.out.print("    ");
   }

}
