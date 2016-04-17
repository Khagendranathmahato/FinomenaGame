# FinomenaGame
How to install the game: <br />
STEP1: Import the project to "Android Studio". <br />
STEP2: Run the project.<br />
STEP3: In your workspace, inside your project, the apk can be located at app/build/outputs<br />
STEP3: Install the apk. play and enjoy.<br />
<br />
<br />
How to play the game:<br />
1. The first page has three fields. The upper two are for the name of the players playing the game.<br />
2. The third field requires an integer value 'n' e.g 3.<br />
    This value will divide you screen into n*n blocks.<br />
    The default value is 3 i.e. 3*3 blocks.<br />
3. First turn, player1 will put the finger on the screen where highlighted and will continue to put his/her finger there.<br />
4. Then second player will do the same.<br />
5. This continue until one of the player fails to puts his/her finger at the correct position.<br />
6. A player loses if:<br />
    1. failing to put finger at the highlighted block.<br />
    2. uplifts a finger while placing another finger.<br />
7. At the end a dialog box appears aksing you to continue playing or exiting the application.<br />
<br />
<br />
Source file description:<br />
Here I will briefly explain what I have used in making this application.<br />
  Page1:<br />
  This is the simple one.<br />
  Added a background image.<br />
  placed three EditText ,Three TextView and one button.<br />
  On pressing the button an Intent starts which transfers our activity to the second page.<br />
  Note: The intent transfers the values of name of player1,player2 and n to the next activity.<br />
  <br />
  Page2:<br />
  The tough one.<br />
  The first big task is to divide the screen into n parts.<br />
  For this, I have imported the SurfaceView class.<br />
  Created a canvas there and then dividing the canvas into n parts.<br />
  The next task is to create the highlighted block.<br />
  For this, I have created a rectangle in the canvas of size:<br />
               size = canvas.getWidth()/n;<br />
  The next part is to handle the TouchEvents.<br />
  For this I have imported the method onTouchEvent.<br />
  And Every time a user places/uplifts/moves his/her finger. The game proceeds accordingly.<br />
   Note:  Any changes/modification in this project will be highly appreciated.<br />
   <br />
   I have learnt a lot of things while doing this project.<br />
  <br />
  Thank you.<br />
  
 
