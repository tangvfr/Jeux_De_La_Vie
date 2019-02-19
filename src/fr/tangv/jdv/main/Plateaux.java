package fr.tangv.jdv.main;

import java.awt.Color;
import java.awt.Graphics;

public class Plateaux {

	private int ptx;
	private int pty;
	private boolean plateaux[][];
	public int cof;
	
	public void invcellule(int coordsx,int coordsy) {
		int x = Math.round(coordsx/cof);
		int y = Math.round(coordsy/cof);
		if(x >= 0 && x < ptx && y >= 0 && y < pty) {
			plateaux[x][y] = !plateaux[x][y];
		}
	}
	
	private boolean celluleetat(int x , int y) {
		if(x >= 0 && x < ptx && y >= 0 && y < pty) {
			return plateaux[x][y];
		}else {
			return false;
		}
	}
	
	private int nbcellueva(int x,int y) {
		if(x >= 0 && x < ptx && y >= 0 && y < pty) {
			int i = 0;
			if(celluleetat(x-1,y-1)) {
				i += 1;
			}
			if(celluleetat(x-1,y)) {
				i += 1;
			}
			if(celluleetat(x-1,y+1)) {
				i += 1;
			}
			
			if(celluleetat(x,y-1)) {
				i += 1;
			}
			if(celluleetat(x,y+1)) {
				i += 1;
			}
			
			if(celluleetat(x+1,y-1)) {
				i += 1;
			}
			if(celluleetat(x+1,y)) {
				i += 1;
			}
			if(celluleetat(x+1,y+1)) {
				i += 1;
			}
			return i;
		}else {
			return 0;
		}
	}
	
	public void update() {
		boolean[][] tab = new boolean[this.ptx][this.pty];
		for(int x = 0; x < ptx; x++) {
			for(int y = 0; y < pty; y++) {
				tab[x][y] = plateaux[x][y];
				int nbc = nbcellueva(x, y);
				if(plateaux[x][y]) {
					if(nbc < 2 || 3 < nbc) {
						tab[x][y] = false;
					}
				}else {
					if(nbc == 3) {
						tab[x][y] = true;
					}
				}
			}
		}
		plateaux = tab;
		Main.sequence++;
	}
	
	public Plateaux(int cof) {
		this.cof = cof;
		this.ptx = Main.gettaile()/cof;
		this.pty = Main.gettaile()/cof;
		this.plateaux = new boolean[this.ptx][this.pty];
		for(int x = 0; x < ptx; x++) {
			for(int y = 0; y < ptx; y++) {
				plateaux[x][y] = false;
			}
		}
	}
	
	public void render(Graphics g) {
		for(int x = 0; x < ptx; x++) {
			for(int y = 0; y < ptx; y++) {
				g.setColor(Color.BLACK);
				g.fillRect(x*cof, y*cof, 11, 11);
				if(plateaux[x][y] == false) {
					g.setColor(Color.WHITE);
					g.fillRect((x*cof)+1, (y*cof)+1, 9, 9);
				}
			}
		}
	}
	
	public int getwidth() {
		return ptx;
	}
	
	public int getheight() {
		return pty;
	}
	
}
