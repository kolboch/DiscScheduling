package resultVisualization;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RunApp {
	
	public static void main(String[]args){
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
				
				MainFrame frame = new MainFrame();
				frame.pack();
				frame.setTitle("Disc scheduling algorithms visualization");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
			
		});
	}
	
}
