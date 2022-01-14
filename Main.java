import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		
		JFrame  frame = new JFrame("Timer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TimerClass panel = new TimerClass();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
