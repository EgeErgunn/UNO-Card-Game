package mainGame; 
/************** Pledge of Honor *****************************************
I hereby certify that I have completed this programming project on my own
without any help from anyone else. The effort in the project thus belongs
completely to me. I did not search for a solution, or I did not consult any
program written by others or did not copy any program from other sources. I
read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Ege Ergün, 87569>
*************************************************************************/

import java.io.IOException;

import GUI.LoginScreen;

public class Main {

	public static void main(String[] args) {
		
		java.awt.EventQueue.invokeLater(new Runnable() { //Starts the application by opening Login page
            public void run() {
                try {
					new LoginScreen().setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
	}
}
