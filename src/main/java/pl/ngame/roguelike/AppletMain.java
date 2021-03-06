package pl.ngame.roguelike;

import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import asciiPanel.AsciiPanel;
import pl.ngame.roguelike.screens.Screen;
import pl.ngame.roguelike.screens.StartScreen;

public class AppletMain extends Applet implements KeyListener {
	private static final long serialVersionUID = 2560255315130084198L;
	
	private AsciiPanel terminal;
	private Screen screen;
	
	public AppletMain(){
		super();
		terminal = new AsciiPanel();
		add(terminal);
		screen = new StartScreen();
		addKeyListener(this);
		repaint();
	}
	
	@Override
	public void init(){
		super.init();
		this.setSize(terminal.getWidth() + 20, terminal.getHeight() + 20);
	}

	@Override
	public void repaint(){
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}

	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
	}

	public void keyReleased(KeyEvent e) { }

	public void keyTyped(KeyEvent e) { }
}
