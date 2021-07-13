package frontend.tabs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class BarGraphTab extends JPanel {

	private static final long serialVersionUID = -5924687061567665299L;
	private String title;
	private ArrayList<String> names;
	private ArrayList<Double> values;

	private Dimension dimension;

	public BarGraphTab(String title, ArrayList<String> names, ArrayList<Double> values) {
		super();
		this.title = title;
		this.names = names;
		this.values = values;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		double min = Collections.min(this.values);
		double max = Collections.max(this.values);


		if (dimension == null) {
			dimension = getSize();
		}
		this.setBounds(dimension.width*5/100, 40, dimension.width*9/10, 150);
		Rectangle rect = this.getBounds();
	    int clientWidth = rect.width;
	    int clientHeight = rect.height;
	    int barWidth = 30;

	    Font titleFont = new Font("SansSerif", Font.BOLD, 20);
	    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
	    Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
	    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

	    int titleWidth = titleFontMetrics.stringWidth(title);
	    int y = titleFontMetrics.getAscent();
	    int x = (clientWidth - titleWidth) / 2;
	    g.setFont(titleFont);
	    g.drawString(title, x, y);

	    int top = titleFontMetrics.getHeight();
	    int bottom = labelFontMetrics.getHeight();
	    if (max == min)
	    	return;
	    double scale = (clientHeight - top - bottom) / (max - min);
	    y = clientHeight - labelFontMetrics.getDescent();
	    g.setFont(labelFont);

	    for (int i = 0; i < this.values.size(); i++) {
			int valueX = 2 * i * barWidth + 1;
			int valueY = top;
			int height = (int) (this.values.get(i) * scale * 2);
			if (this.values.get(i) >= 0)
				valueY += (int) ((max - this.values.get(i)) * scale);
			else {
				valueY += (int) (max * scale);
				height = -height;
			}


			if (this.values.get(i) <= 10)
				g.setColor(Color.red);
			else
				g.setColor(Color.green);

			g.fillRect(valueX, valueY, barWidth - 2, height-10);
			g.setColor(Color.black);
			g.drawRect(valueX, valueY, barWidth - 2, height-10);
			int labelWidth = labelFontMetrics.stringWidth(this.names.get(i));
			x = 2 * i * barWidth + (barWidth - labelWidth) / 2;
			g.drawString(this.names.get(i), x, y);
	    }

//	    ArrayList<String> names = new ArrayList<String>();
//		for (String name : new String[]{"INDIA", "JAPAN"}) {
//			names.add(name);
//		}
//
//		ArrayList<Double> values = new ArrayList<Double>();
//		for (Double value : new Double[]{10.0, 20.0}) {
//			values.add(value);
//		}
//
//		JPanel graph = new BarGraphTab("TEST GRAPH", names, values);
//
//		getContentPane().add(graph, BorderLayout.CENTER);
//		graph.setLayout(null);
	}
}
