import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class button extends JButton{
    
     button(String text){
        super(text);

        this.setFocusable(false);
        this.setFont(new Font("Comic Sans",Font.BOLD,30));
        this.setBackground(Color.black);
        this.setForeground(Color.RED);
    }
}
