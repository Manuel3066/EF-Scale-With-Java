package SourceClasses;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EFSCALE {
	//Manuel Corral
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel panel =  new EFSPANEL();
		
		frame.add(panel);
		frame.setSize(370, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
