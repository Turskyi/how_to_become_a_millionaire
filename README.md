# how_to_become_a_millionaire
Simple android application of the game "Who Wants to Be a Millionaire?" with attempt to use design.

               PROJECT SPECIFICATION
               
               The application displays a question and offers 4 possible answers.
After selecting the answer shows an alert - true or not. In the first case - game over, in the second - displays the next question.
At the bottom, there are buttons - 50/50 (hides 2 incorrect answers), a call to a friend and help of the audience. 
The realisation of adding an error in last two hints using Random () disabled for convenience for my younger brother-in-law so they always show true, but only once, but easily can be implemented - in most cases, they would show the correct result, but also may be wrong. In the "call, a friend" error is higher for example.

Only 15 questions.

Adding graphic design - fully customize the display of all elements (so that the appearance does not look like a classic material design), adding animations.

* Functionality to receive a list of questions as a JSONArray network request (for example, use pastebin.com) is failed.

** Adding the option to download questions from different sources - the ability to enter a link to another resource for downloading, as well as the ability to get data from a text file on the device also not implemented.
               
CRITERIA.        MEETS SPECIFICATIONS

Layout.

Overall Layout: The app contains one layout with a quastion, four options and three hints.

The code adheres to all of the following Layout best practices: Text sizes are defined in sp, Lengths are defined in dp, Padding and margin are used appropriately, such that the views are not crammed up against each other.

Functionality.

String Storage: All strings are stored in the strings.xml resource file.

Errors: The code runs without errors.

Button Function: Each button updates the question TextView in its layout. Hint buttons dissapear foraver after using.

After answering on all questions the layout displays the congratulations.


Code Readability

Readability: Code is easily readable such that a fellow programmer can understand the purpose of the app.

Naming Conventions: All variables, methods, and resource IDs are descriptively named such that another developer reading the code can easily understand their function.

Code style: "There are no unnecessary blank lines. One variable is declared per declaration line. The code within a method is indented with respect to the method declaration line."

The code is properly formatted: No unused variables or methods, No commented out code.
