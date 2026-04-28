import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class display extends JTextField{
    
    display(){

        this.setPreferredSize(new Dimension(250,100));
        this.setFont(new Font("Comic Sans",Font.BOLD,50));
        this.setEditable(false);
        this.setHorizontalAlignment(JTextField.RIGHT);
        this.setBackground(Color.black);
        this.setForeground(Color.ORANGE);
    }
}
