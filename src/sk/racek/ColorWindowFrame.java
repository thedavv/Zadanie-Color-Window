package sk.racek;

import javax.swing.JFrame;

public class ColorWindowFrame extends JFrame{
	public ColorWindowFrame(String str) {
		super(str);
		add(new ColorWindowPanel());
		pack();
	}
}
