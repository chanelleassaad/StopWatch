import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TimerClass extends JPanel{
	
	private JButton stop, start, clear, continueb;

	private JTextField time;
	private int  hours, min, sec;
	private Timer timer;

	public TimerClass() {
		Font font = new Font("Helvetica", Font.BOLD, 20);

		setLayout(new BorderLayout());

		start = new JButton("Start");
		start.setFont(font);

		stop = new JButton("Stop");
		stop.setFont(font);
		
		continueb = new JButton("Continue");
		continueb.setFont(font);
		
		clear = new JButton("Clear");
		clear.setFont(font);
		
		time = new JTextField("00:00:00");
		time.setFont(font);
		time.setHorizontalAlignment(JLabel.CENTER);

		//add timer here
		Timer timer = new Timer(1000,new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {

			if(sec!=59)
			{
				sec++;
			}
			else
			{
				sec=0;
				if(min!=59){
					min++;
				}
				else
				{
					min=0;
					if(hours!=99) {
						hours++;
					}
					else {
						min=0;
						sec=0;
						hours=0;
					}
				}
			}
			DecimalFormat fmt= new DecimalFormat("00");
			time.setText(fmt.format(hours)+":"+fmt.format(min)+":"+fmt.format(sec));
		}
				
		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			timer.stop();
			min=0;
			hours=0;
			sec=0;
			DecimalFormat fmt= new DecimalFormat("00");
			time.setText(fmt.format(hours)+":"+fmt.format(min)+":"+fmt.format(sec));
			}
		});

		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			timer.stop();

			}
		});

		continueb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			timer.start();

			}
		});

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				min=0;
				hours=0;
				sec=0;
				timer.start();

			}
		});

		
		Box buttonboxes = new Box(BoxLayout.X_AXIS);
		buttonboxes.add(start);
		buttonboxes.add(clear);
		buttonboxes.add(stop);
		buttonboxes.add(continueb);

		add(time, "North");
		add(buttonboxes, "Center");

		setPreferredSize(new Dimension(350, 200));
		setBackground(Color.BLUE);
	}

}
