package fr.tangv.jdv.main;

import javax.swing.JFrame;

public class Main extends JFrame{

	private static final long serialVersionUID = 1L;
	public static Screen screen;
	public static boolean ac = false;
	public static int nbdate = 250;
	private static int ecran = 500;
	private int acecran = 0;
	public static long sequence = 0;
	public static Plateaux plateaux = new Plateaux(10);
	
	
	public static void settaile(int taile) {
		ecran = taile;
	}
	
	public static int gettaile() {
		return ecran;
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		super("Jeux De La Vie");
		this.setIconImage(ImgList.icone);
		this.setSize(ecran, ecran+30);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen = new Screen();
		screen.addMouseListener(new ListenerScreen());
		screen.addMouseMotionListener(new ListenerScreen());
		this.add(screen);
		this.setVisible(true);
		long time = System.currentTimeMillis();
		while(true) {
			if(acecran != ecran) {
				acecran = ecran;
				super.setSize(ecran-3, ecran+29);
			}
			if(time <= System.currentTimeMillis()) {
				time = System.currentTimeMillis()+nbdate;
				if(ac) {
					plateaux.update();
				}
			}
			screen.repaint();
		}
	}
}
