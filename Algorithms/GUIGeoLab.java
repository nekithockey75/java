import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JFrame;

 public class GUIGeoLab extends JFrame {

 	private Figure[] f;
	private int height = 0, width = 0;
	private Vertex start, finish;

	public GUIGeoLab(Figure[] figures, Vertex start_arg, Vertex finish_arg) {
		super("Labyrinth");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setVisible(true);
		f = figures;
		for (Figure figure : f)
			for (Vertex vertex : figure.vert_array) {
				vertex.x *= 100; vertex.y *= 100;
			}
		height = 7 * 100;
		width = 7 * 100;
		start = start_arg; finish = finish_arg;
		start.x *= 100; start.y *= 100;
		finish.x *= 100; finish.y *= 100;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D gr2d = (Graphics2D) g;

		gr2d.setPaint(Color.MAGENTA);
		for (Figure figure : f) {
			Polygon j = new Polygon();
			for (Vertex v : figure.vert_array) {
				j.addPoint((int)v.y, (int)v.x);
				//if (v.g) g.drawOval(v.y, v.x, 5, 5);
			}
			g.drawPolygon(j);
		}

		g.fillOval((int)start.x, (int)start.y, 5, 5);
		g.fillOval((int)finish.y, (int)finish.x, 5, 5);

		setSize(height, width);

		//gr2d.clearRect(50, 40, 200, 200);
	}
}
