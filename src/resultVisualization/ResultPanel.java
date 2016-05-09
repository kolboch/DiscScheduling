package resultVisualization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import diskTasks.Request;

public class ResultPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int RADIUS = 5;
	private final Dimension PREFERRED = new Dimension(400,200);
	private Request[]requests;
	
	public ResultPanel(){
		this.setPreferredSize(PREFERRED);
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		
		int x = 0;
		Point2D previous = new Point2D.Double(0,0);
		
		if(requests != null){
			for(Request r : requests){
				Point2D currentPoint = new Point2D.Double(x, r.getCylinderToRead());
				Ellipse2D.Double ell = new Ellipse2D.Double(x, r.getCylinderToRead(), RADIUS, RADIUS);
				
				g2.setColor(Color.RED);
				g2.draw(new Line2D.Double(previous, currentPoint));
				previous = currentPoint;
				
				g2.setColor(Color.BLACK);
				g2.fill(ell);
				g2.draw(ell);
				
				x += 7;
			}
		}
	}
	
	public void setRequestToPrint(ArrayList<Request>requests){
		this.requests = new Request[requests.size()];
		requests.toArray(this.requests); 
		repaint();
	}
	
}
