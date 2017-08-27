package sk.racek;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ColorWindowDemo {
	public static void main(String[] args) {
		EventQueue.invokeLater(() ->{
			JFrame frame = new ColorWindowFrame("Colored Widow");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
