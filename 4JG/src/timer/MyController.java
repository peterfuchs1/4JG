/**
 * 
 */
package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author uhs374h
 * 
 */
public class MyController implements ActionListener, IObserver {
	private MyPanel mPanel;
	private DigitalUhr model;
	private IObservable ob;
	private long myStatus;

	/**
	 * @param gui
	 */
	public MyController(IObservable ob) {
		this.ob=ob;
		model = new DigitalUhr();
		mPanel = new MyPanel(this);
		new MyFrame("DigitalUhr", mPanel);
		mPanel.setStatusbar(model.getZustand().name());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Buttons gedrückt
		String s = e.getActionCommand();
		switch (s) {
		case "set":
			model.set();
			break;
		case "inc":
			model.inc();
			doState();
			break;
		case "dec":
			model.dec();
			doState();
			break;
		case "start":
			myStatus=java.time.LocalTime.now().toSecondOfDay()+model.value();
			mPanel.startTimer();
			ob.addObserver(this);
			break;
		case "stopp":
			ob.removeObserver(this);
			mPanel.stoppTimer();
			break;
		default:
		}
		mPanel.setStatusbar(model.getZustand().name());

	}

	public void doState() {
		mPanel.setStunden(model.getStunden());
		mPanel.setMinuten(model.getMinuten());
		mPanel.setSekunden(model.getSekunden());
		mPanel.refresh();
	}
	@Override
	public void update(IObservable o, Object arg) {
		int newTime=(int)(myStatus-(Long) arg);
		int h=newTime/3600;
		newTime=newTime-h*3600;
		int m=newTime/60;
		int s=newTime-m*60;
		model.setStunden(h);
		model.setMinuten(m);
		model.setSekunden(s);
		doState();
		if(newTime==0){
			ob.removeObserver(this);
			mPanel.stoppTimer();
		}
	}

	public static void main(String[] a) {
		IObservable ob=new MyTimer();
		new MyController(ob);
		new MyController(ob);
	}

}
