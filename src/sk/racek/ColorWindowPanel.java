package sk.racek;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

public class ColorWindowPanel extends JPanel {

	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 600;
	private static final int RGB_MAX_VALUE = 255;

	private int mouseWheelRGBValueB = 0;
	private double a = 0;
	private double b = 0;

	public ColorWindowPanel() {
		this.addMouseMotionListener(new MouseMotionHandler());
		this.addMouseWheelListener(new MouseMotionHandler());
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	class MouseMotionHandler extends MouseAdapter implements MouseWheelListener {

		@Override
		public void mouseMoved(MouseEvent e) {
			Dimension d = getSize();
			a = fitPanelWidthForRGBvalueR(d.getWidth());
			b = fitPanelHeightForRGBValueG(d.getWidth());
			setBackground(new Color((int) (e.getPoint().x * a), (int) (e.getPoint().y * b), mouseWheelRGBValueB));
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			mouseWheelRGBValueB += e.getWheelRotation();
			if (mouseWheelRGBValueB < 0) {
				mouseWheelRGBValueB = 0;
			} else if (mouseWheelRGBValueB > 255) {
				mouseWheelRGBValueB = 255;
			}
			setBackground(new Color((int) (e.getPoint().x * a), (int) (e.getPoint().y * b), mouseWheelRGBValueB));
		}
	}

	public double fitPanelWidthForRGBvalueR(double width) {
		return RGB_MAX_VALUE / width;
	}

	public double fitPanelHeightForRGBValueG(double height) {
		return RGB_MAX_VALUE / height;
	}
}