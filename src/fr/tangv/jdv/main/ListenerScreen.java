package fr.tangv.jdv.main;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ListenerScreen implements MouseListener,MouseMotionListener {

	private boolean click = false;
	
	public boolean colide(int x,int y,int w,int h,int xm,int ym,int wm ,int hm) {
		if(x >= xm+wm) return false;
		if(y >= ym+hm) return false;
		if(x+w <= xm) return false;
		if(y+h <= ym) return false;
		return true;
	}
	
	//mouse

	private void acpause(boolean bool) {
		Main.screen.nbtime.setText(Main.screen.nbtime.getText().replace(' ', '0'));
		Main.nbdate = Integer.parseInt(Main.screen.nbtime.getText());
		Main.screen.nbtime.setEnabled(!bool);
		Main.ac = bool;
	}
	
	private void reset(int cof) {
		acpause(false);
		Main.plateaux = new Plateaux(cof);
		Main.sequence = 0;
	}
	
	private void click(int x,int y) {
		int h = Main.screen.getHeight()-25;
		int w = Main.screen.getWidth();
		if(colide(5,h,21,21,x,y,1,1)) {
			acpause(!Main.ac);
		}else
		if(colide(31, h,21,21,x,y,1,1)) {
			reset(Main.plateaux.cof);
		}else
		if(colide(w-5-ImgList.apres.getWidth(), h,21,21,x,y,1,1)) {
			Main.plateaux.update();
		}else
		if(colide(0,0,20,20,x,y,1,1) && !Main.ac) {
			reset(Main.plateaux.cof);
			Main.settaile(Main.gettaile()+10);
		}else
		if(colide(21,0,19,20,x,y,1,1) && !Main.ac) {
			reset(Main.plateaux.cof);
			if(Main.gettaile() > 300) {
				Main.settaile(Main.gettaile()-10);
			}
		}else
		if(colide(41,0,20,20,x,y,1,1) && !Main.ac){
			if(Main.plateaux.cof == 10) {
				reset(5);
			}else {
				reset(10);
			}
		}else
		if(!Main.ac && y < Main.screen.getHeight()-30) {
			Main.plateaux.invcellule(x, y);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		click(e.getX(),e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(!click) {
			click(e.getX(),e.getY());
			click = true;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		click = false;
	}

}
