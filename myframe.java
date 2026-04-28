import javax.swing.*;

public class myframe extends JFrame{
 
    mypanel panel;
    ImageIcon logo;

    myframe(){

        logo = new ImageIcon("logo.png");
        this.setIconImage(logo.getImage());

        this.setTitle("Calculator");
        panel = new mypanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        
        this.add(panel);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}
