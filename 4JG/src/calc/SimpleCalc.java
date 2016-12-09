package calc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Font;

public class SimpleCalc extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8898969492235330L;
	private JButton btn9;
	private JButton btn8;
	private JButton btn7;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn0;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMul;
	private JButton btnDiv;
	private JButton btnErg;
	private JTextField jtfErgebnis;
	private Eingabe ziffern;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalc frame = new SimpleCalc();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleCalc() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 250);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		getContentPane().add(panel, BorderLayout.CENTER);
		// 10 Pixel Abstand in alle Richtungen
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        SpringLayout sl_panel = new SpringLayout();
        panel.setLayout(sl_panel);
        
        jtfErgebnis = new JTextField();
        sl_panel.putConstraint(SpringLayout.EAST, jtfErgebnis, -10, SpringLayout.EAST, panel);
        jtfErgebnis.setFont(new Font("Tahoma", Font.BOLD, 15));
        jtfErgebnis.setHorizontalAlignment(SwingConstants.RIGHT);
        jtfErgebnis.setText("0");
        sl_panel.putConstraint(SpringLayout.NORTH, jtfErgebnis, 10, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, jtfErgebnis, 10, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, jtfErgebnis, 40, SpringLayout.NORTH, panel);
        panel.add(jtfErgebnis);
        jtfErgebnis.setColumns(10);
        //initialize
        init();
		ziffern=new Eingabe(jtfErgebnis);

        btn7 = new JButton("7");
        sl_panel.putConstraint(SpringLayout.WEST, btn7, 0, SpringLayout.WEST, jtfErgebnis);
        btn7.addActionListener(ziffern);
        panel.add(btn7);
        
        btn8 = new JButton("8");
        sl_panel.putConstraint(SpringLayout.NORTH, btn8, 0, SpringLayout.NORTH, btn7);
        sl_panel.putConstraint(SpringLayout.WEST, btn8, 6, SpringLayout.EAST, btn7);
        btn8.addActionListener(ziffern);
        panel.add(btn8);
        
        btn9 = new JButton("9");
        sl_panel.putConstraint(SpringLayout.NORTH, btn9, 0, SpringLayout.NORTH, btn7);
        sl_panel.putConstraint(SpringLayout.WEST, btn9, 6, SpringLayout.EAST, btn8);
        btn9.addActionListener(ziffern);
        panel.add(btn9);
        
        btn4 = new JButton("4");
        sl_panel.putConstraint(SpringLayout.WEST, btn4, 0, SpringLayout.WEST, btn7);
        btn4.addActionListener(ziffern);
        sl_panel.putConstraint(SpringLayout.NORTH, btn4, 93, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, btn7, -6, SpringLayout.NORTH, btn4);
        panel.add(btn4);
        
        btn5 = new JButton("5");
        sl_panel.putConstraint(SpringLayout.WEST, btn5, 0, SpringLayout.WEST, btn8);
        btn5.addActionListener(ziffern);
        sl_panel.putConstraint(SpringLayout.NORTH, btn5, 0, SpringLayout.NORTH, btn4);
        panel.add(btn5);
        
        btn6 = new JButton("6");
        sl_panel.putConstraint(SpringLayout.WEST, btn6, 0, SpringLayout.WEST, btn9);
        sl_panel.putConstraint(SpringLayout.EAST, btn6, 0, SpringLayout.EAST, btn9);
        btn6.addActionListener(ziffern);
        sl_panel.putConstraint(SpringLayout.NORTH, btn6, 0, SpringLayout.NORTH, btn4);
        panel.add(btn6);
        
        btn1 = new JButton("1");
        sl_panel.putConstraint(SpringLayout.WEST, btn1, 0, SpringLayout.WEST, btn4);
        btn1.addActionListener(ziffern);
        sl_panel.putConstraint(SpringLayout.NORTH, btn1, 7, SpringLayout.SOUTH, btn4);
        panel.add(btn1);
        
        btn2 = new JButton("2");
        sl_panel.putConstraint(SpringLayout.WEST, btn2, 0, SpringLayout.WEST, btn5);
        btn2.addActionListener(ziffern);
        sl_panel.putConstraint(SpringLayout.SOUTH, btn2, 0, SpringLayout.SOUTH, btn1);
        panel.add(btn2);
        
        btn3 = new JButton("3");
        sl_panel.putConstraint(SpringLayout.WEST, btn3, 0, SpringLayout.WEST, btn6);
        sl_panel.putConstraint(SpringLayout.EAST, btn3, 0, SpringLayout.EAST, btn9);
        sl_panel.putConstraint(SpringLayout.EAST, btn2, -6, SpringLayout.WEST, btn3);
        btn3.addActionListener(ziffern);
        sl_panel.putConstraint(SpringLayout.SOUTH, btn3, 0, SpringLayout.SOUTH, btn1);
        panel.add(btn3);
        
        btn0 = new JButton("0");
        sl_panel.putConstraint(SpringLayout.WEST, btn0, 10, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btn0, 0, SpringLayout.EAST, btn9);
        btn0.addActionListener(ziffern);
        sl_panel.putConstraint(SpringLayout.NORTH, btn0, 6, SpringLayout.SOUTH, btn1);
        sl_panel.putConstraint(SpringLayout.SOUTH, btn0, 31, SpringLayout.SOUTH, btn1);
        panel.add(btn0);
        
        btnPlus = new JButton("+");
        sl_panel.putConstraint(SpringLayout.NORTH, btnPlus, 0, SpringLayout.NORTH, btn7);
        panel.add(btnPlus);
        btnPlus.addActionListener(ziffern);
        
        btnMinus = new JButton("-");
        sl_panel.putConstraint(SpringLayout.EAST, btnPlus, -6, SpringLayout.WEST, btnMinus);
        sl_panel.putConstraint(SpringLayout.NORTH, btnMinus, 0, SpringLayout.NORTH, btn7);
        sl_panel.putConstraint(SpringLayout.EAST, btnMinus, 0, SpringLayout.EAST, jtfErgebnis);
        panel.add(btnMinus);
        btnMinus.addActionListener(ziffern);
        
        btnMul = new JButton("*");
        sl_panel.putConstraint(SpringLayout.NORTH, btnMul, 0, SpringLayout.NORTH, btn4);
        panel.add(btnMul);
        btnMul.addActionListener(ziffern);
        
        btnDiv = new JButton("/");
        sl_panel.putConstraint(SpringLayout.EAST, btnMul, -6, SpringLayout.WEST, btnDiv);
        sl_panel.putConstraint(SpringLayout.NORTH, btnDiv, 0, SpringLayout.NORTH, btn4);
        sl_panel.putConstraint(SpringLayout.EAST, btnDiv, 0, SpringLayout.EAST, jtfErgebnis);
        panel.add(btnDiv);
        btnDiv.addActionListener(ziffern);
        
        btnErg = new JButton("=");
        sl_panel.putConstraint(SpringLayout.WEST, btnPlus, 0, SpringLayout.WEST, btnErg);
        sl_panel.putConstraint(SpringLayout.WEST, btnMul, 0, SpringLayout.WEST, btnErg);
        sl_panel.putConstraint(SpringLayout.WEST, btnErg, 36, SpringLayout.EAST, btn3);
        sl_panel.putConstraint(SpringLayout.EAST, btnErg, -10, SpringLayout.EAST, panel);
        btnErg.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String erg=eval(jtfErgebnis.getText());
        		jtfErgebnis.setText(erg);
        	}
        });
        sl_panel.putConstraint(SpringLayout.NORTH, btnErg, 0, SpringLayout.NORTH, btn1);
        panel.add(btnErg);
        
        JButton btnClear = new JButton("clear");
        sl_panel.putConstraint(SpringLayout.WEST, btnClear, 0, SpringLayout.WEST, btnErg);
        sl_panel.putConstraint(SpringLayout.NORTH, btnClear, 0, SpringLayout.NORTH, btn0);
        sl_panel.putConstraint(SpringLayout.EAST, btnClear, 0, SpringLayout.EAST, jtfErgebnis);
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		init();
        	}
        });
        panel.add(btnClear);
	}
	private void init(){
		jtfErgebnis.setText("0");
	}

	/**
	 * Evaluierung des Eingabefeldes	
	 * @param txt
	 * @return 
	 */
	private String eval(String txt){
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    String result="Err";
	    try {
			result=""+ engine.eval(txt);
		} catch (ScriptException e) {
		}
	    return result;
	}
}
