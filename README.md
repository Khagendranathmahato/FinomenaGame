# FinomenaGame
How to install the game:
STEP1: Import the project to "Android Studio".
STEP2: Run the project.
STEP3: In your workspace, inside your project, the apk can be located at app/build/outputs
STEP3: Install the apk. play and enjoy.


How to play the game:
1. The first page has three fields. The upper two are for the name of the players playing the game.
2. The third field requires an integer value 'n' e.g 3.
    This value will divide you screen into n*n blocks.
    The default value is 3 i.e. 3*3 blocks.
3. First turn, player1 will put the finger on the screen where highlighted and will continue to put his/her finger there.
4. Then second player will do the same.
5. This continue until one of the player fails to puts his/her finger at the correct position.
6. A player loses if:
    1. failing to put finger at the highlighted block.
    2. uplifts a finger while placing another finger.
7. At the end a dialog box appears aksing you to continue playing or exiting the application.


Source file description:
Here I will briefly explain what I have used in making this application.
  Page1:
  This is the simple one.
  Added a background image.
  placed three EditText ,Three TextView and one button.
  On pressing the button an Intent starts which transfers our activity to the second page.
  Note: The intent transfers the values of name of player1,player2 and n to the next activity.
  
  Page2:
  The tough one.
  The first big task is to divide the screen into n parts.
  For this, I have imported the SurfaceView class.
  Created a canvas there and then dividing the canvas into n parts.
  The next task is to create the highlighted block.
  For this, I have created a rectangle in the canvas of size:
               size = canvas.getWidth()/n;
  The next part is to handle the TouchEvents.
  For this I have imported the method onTouchEvent.
  And Every time a user places/uplifts/moves his/her finger. The game proceeds accordingly.
   Note:  Any changes/modification in this project will be highly appreciated.
   
   I have learnt a lot of things while doing this project.
  
  Thank you.
  
 
