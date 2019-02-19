package fr.tangv.jdv.main;

import java.awt.Color;
import java.awt.Graphics;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Screen extends JPanel {

	private static final long serialVersionUID = 2L;
	public JFormattedTextField nbtime;
	public JTextField panel = new JTextField();
    
	public Screen() {
		super();
		this.setLocation(0, 0);
		this.setLayout(null);
		this.setBorder(null);
		try {
			MaskFormatter mask = new MaskFormatter("######");
			nbtime = new JFormattedTextField(mask);
			nbtime.setText("000250");
			nbtime.setSize(50, 20);
			nbtime.setHorizontalAlignment(0);
			nbtime.setVisible(true);
			this.add(nbtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		panel.setVisible(true);
		panel.setBackground(Color.GRAY);
		panel.setBorder(null);
		panel.setEditable(false);
		panel.setHorizontalAlignment(4);
		this.add(panel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		Main.plateaux.render(g);
		g.setColor(Color.GRAY);
		g.fillRect(0, this.getHeight()-30, this.getWidth(), this.getHeight());
		//nbtime
		nbtime.setLocation(57, this.getHeight()-25);
		panel.setLocation(112, this.getHeight()-25);
		panel.setSize(this.getWidth()-10-ImgList.apres.getWidth()-112,20);
		panel.setText("Sequence: "+Main.sequence);
		//line noir
		g.setColor(Color.black);
		g.drawLine(0, this.getHeight()-30, this.getWidth(), this.getHeight()-30);
		g.fillRect(this.getWidth()-1, 0,this.getWidth(), this.getHeight()-30);
		//pause , play
		g.setColor(Color.white);
		g.drawOval(5,this.getHeight()-25,20,20);
		if(!Main.ac) {
			for(int i = 0; i < 5; i++) {
				g.fillRect(11+(i*2), this.getHeight()-19+i, 2, 9-(i*2));
			}
		}else {
			g.fillRect(11, this.getHeight()-19, 4, 9);
			g.fillRect(16, this.getHeight()-19, 4, 9);
		}
		//Reset
		g.drawImage(ImgList.reset,31, this.getHeight()-25,null);
		g.drawImage(ImgList.apres,this.getWidth()-5-ImgList.apres.getWidth(), this.getHeight()-25,null);
		if(!Main.ac) {
			g.drawImage(ImgList.arrd,0, 0,null);
		}
	}
	
}
