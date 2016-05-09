package resultVisualization;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import disk.DiscResource;
import diskTasks.Request;
import diskTasks.RequestGenerator;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final Dimension PREFERRED = new Dimension(900,500);
	private JPanel panel;
	private ResultPanel alg1;
	private ResultPanel alg2;
	private ResultPanel alg3;
	private ResultPanel alg4;
	
	public MainFrame(){
		
		this.setPreferredSize(PREFERRED);
		panel = new JPanel();
		add(panel);
		DiscResource disk = new DiscResource(200);
		Request[]requestArray = RequestGenerator.generateRequest(200, 100, 60);
		disk.enqueueRequests(requestArray);
		disk.FCFS_algorithm();
		
		alg1 = new ResultPanel();
		alg1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		alg1.setRequestToPrint(disk.getRequestsServed());
		panel.add(alg1, BorderLayout.WEST);
		
		disk.enqueueRequests(requestArray);
		disk.SSTF_algorithm();
		
		alg2 = new ResultPanel();
		alg2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		alg2.setRequestToPrint(disk.getRequestsServed());
		panel.add(alg2, BorderLayout.EAST);
		
		disk.enqueueRequests(requestArray);
		disk.SCAN_Algorithm();
		
		alg3 = new ResultPanel();
		alg3.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
		alg3.setRequestToPrint(disk.getRequestsServed());
		panel.add(alg3, BorderLayout.CENTER);
		
		disk.enqueueRequests(requestArray);
		disk.CSCAN_Algorithm();
		
		alg4 = new ResultPanel();
		alg4.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		alg4.setRequestToPrint(disk.getRequestsServed());
		panel.add(alg4, BorderLayout.CENTER);
		
		
	}
	
}
