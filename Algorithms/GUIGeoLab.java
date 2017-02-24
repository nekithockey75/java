import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JFrame;

 public class GUIGeoLab extends JFrame {

 	private Figure[] f;

	public GUIGeoLab(Figure[] figures) {
		super("Labyrinth");
		setSize(1000, 1000);
		setVisible(true);
		f = figures;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D gr2d = (Graphics2D) g;

		int height = 0, width = 0;

		gr2d.setPaint(Color.MAGENTA);
		for (Figure figure : f) {
			Polygon j = new Polygon();
			for (Vertex v : figure.vert_array) {
				width = (v.x > width ? v.x : width);
				height = (v.y > height ? v.y : height);
				j.addPoint(100 * v.y, 100 * v.x);
			}
			g.drawPolygon(j);
		}

		setSize(100 * height, 100 * width + 100);

		//gr2d.clearRect(50, 40, 200, 200);
	}
}