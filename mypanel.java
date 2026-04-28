import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

// import java.awt.BorderLayout;
// import java.awt.Font;
// import java.awt.GridLayout;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.KeyEvent;
// import java.awt.event.KeyListener;

public class mypanel extends JPanel implements ActionListener , KeyListener{

    button b1 , b2 , b3 , b4 , b5 , b6 , b7 , b8 , b9 , b10 , b11 , b12 , b13 , b14 , b15 , b16;
    display text;

    JButton clicked;
    String btext;

    double firstnum = 0;
    String operator = "";
    boolean newno = false;

    mypanel() {

        this.setFocusable(true);
        this.addKeyListener(this);
        this.requestFocusInWindow();

        JPanel jbutton = new JPanel();

        text = new display();

        jbutton.setLayout(new GridLayout(4 , 4 ));

        b1 = new button("0");   b2 = new button("/");   b3 = new button("*");   b4 = new button("-"); 
        b5 = new button("7");   b6 = new button("8");   b7 = new button("9");   b8 = new button("+");
        b9  = new button("4");  b10 = new button("5"); b11 = new button("6"); b12 = new button("CE");
        b13 = new button("1"); b14 = new button("2"); b15 = new button("3"); b16 = new button("=");

        jbutton.add(b1); jbutton.add(b2); jbutton.add(b3); jbutton.add(b4);
        jbutton.add(b5); jbutton.add(b6); jbutton.add(b7); jbutton.add(b8);
        jbutton.add(b9); jbutton.add(b10); jbutton.add(b11); jbutton.add(b12);
        jbutton.add(b13); jbutton.add(b14); jbutton.add(b15); jbutton.add(b16);

        b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);b4.addActionListener(this);
        b5.addActionListener(this);b6.addActionListener(this);b7.addActionListener(this);b8.addActionListener(this);
        b9.addActionListener(this);b10.addActionListener(this);b11.addActionListener(this);b12.addActionListener(this);
        b13.addActionListener(this);b14.addActionListener(this);b15.addActionListener(this);b16.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(text,BorderLayout.NORTH);
        this.add(jbutton,BorderLayout.CENTER);
    }

            @Override
        public void keyTyped(KeyEvent arg0) {
        
        }

        @Override
        public void keyReleased(KeyEvent arg0) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {

            btext = "";

            switch (e.getKeyCode()) {

                case 96: btext = "0"; break;
                case 97: btext = "1"; break;
                case 98: btext = "2"; break;
                case 99: btext = "3"; break;
                case 100: btext = "4"; break;
                case 101: btext = "5"; break;
                case 102: btext = "6"; break;
                case 103: btext = "7"; break;
                case 104: btext = "8"; break;
                case 105: btext = "9"; break;

                case 111: btext = "/"; break;
                case 106: btext = "*"; break;
                case 107: btext = "+"; break;
                case 109: btext = "-"; break;

                case 10: btext = "="; break;
                case 144: btext = "CE"; break;
            }

            if (!btext.isEmpty()) {
                processInput(btext); // same logic as button
            }
        }

        @Override
    public void actionPerformed(ActionEvent e) {

        clicked = (JButton) e.getSource();
        btext = clicked.getText();
        processInput(btext);
    }
        void processInput(String btext) {

        if (btext.matches("[0-9]")) {

            if (newno) {
                text.setText("");
                newno = false;
            }

            text.setText(text.getText() + btext);
        }

        else if (btext.matches("[+\\-*/]")) {

            if (text.getText().isEmpty()) return;

            firstnum = Double.parseDouble(text.getText());
            operator = btext;
            text.setText(operator);
            newno = true;
        }

        else if (btext.equals("=")) {

            if (text.getText().isEmpty()) return;

            double secondnum = Double.parseDouble(text.getText());
            double result = 0;

            switch (operator) {
                case "+": result = firstnum + secondnum; break;
                case "-": result = firstnum - secondnum; break;
                case "*": result = firstnum * secondnum; break;
                case "/":
                    if (secondnum == 0) {
                        text.setText("Cannot divide by zero");
                        return;
                    }
                    result = firstnum / secondnum;
                    break;
                default : result = firstnum + secondnum; break;
            }

            text.setText("" + result);
            newno = true;
        }

        else if (btext.equals("CE")) {
            text.setText("");
            firstnum = 0;
            operator = "";
            newno = false;
        }
    }

}