package qtgame;

import com.trolltech.qt.gui.*;
import com.trolltech.qt.core.*;

import java.util.LinkedList;

import com.trolltech.qt.QUiForm;

public class MyGame extends QWidget {
	
	private Ui_Form myform;
	private LinkedList<QPushButton> buttons;
	private int current;
	private Statistics s;
	public MyGame(){
		s= new Statistics(15);
		myform= new Ui_Form();
		myform.setupUi(this);
		current =0;
		buttons = new LinkedList<>();
		addButtons();

	}
	public static void main(String[] args) {
		QApplication.initialize(args);
		MyGame c=new MyGame();
		c.show();
        QApplication.execStatic();
        QApplication.shutdown();
    }
	private void connectButtons(){
		for (QPushButton b: buttons){
			b.clicked.connect(this, "buttonClicked(QPushButton)");
		}
	}
	
    public void buttonClicked(QPushButton b){
            int value = Integer.parseInt(b.text());
 
        if (this.current == value){
            b.setEnabled(false);
            this.s.correctClick();
            this.current += 1;
        }
        else{
            this.s.wrongClick();
        }
        this.printScores();
    }
    
    public void printScores(){
 
        myform.lCorrect.setText(s.correctStr());
        myform.lOPen.setText(s.openStr());
        myform.lWrong.setText(s.wrongStr());
        myform.lSum.setText(s.sumStr());
        myform.lGames.setText(s.gamesStr());
    }

    public void setButtonsEnabled(){
    	for(QPushButton b: buttons)
    		b.setEnabled(true);
    }
    
	private void addButtons(){
		buttons.add(myform.pButton0);
		buttons.add(myform.pButton1);
		buttons.add(myform.pButton2);
		buttons.add(myform.pButton3);
		buttons.add(myform.pButton4);
		buttons.add(myform.pButton5);
		buttons.add(myform.pButton6);
		buttons.add(myform.pButton7);
		buttons.add(myform.pButton8);
		buttons.add(myform.pButton9);
		buttons.add(myform.pButton10);
		buttons.add(myform.pButton11);
		buttons.add(myform.pButton12);
		buttons.add(myform.pButton13);
		buttons.add(myform.pButton14);
		
	}
}
