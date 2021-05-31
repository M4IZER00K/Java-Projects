package boxes;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class main extends JFrame {
	private Random rand = new Random();	
	main(){
		super("canvas");		 
        // create a empty canvas
        Canvas c = new Canvas() { 
            // paint the canvas
            public void paint(Graphics g)
            {
                // set color to red
                g.setColor(Color.cyan);
 
                // set Font
                g.setFont(new Font("Bold", 1, 10));
                		
                // draw a string
                for (int i = 20; i < 2500	; i+=10) {
                	for (int a = 20; a < 2500; a+=20) {
                		int temp = rand.nextInt(2);
                		System.out.println(temp);
                		switch (temp) {
                		case 0:
                			g.setColor(Color.cyan);
                			break;
                		case 1:
                			g.setColor(Color.pink);
                			break;
                		}
                        g.drawString("[]",i,a);
                	}
                }
            }
        };
        // set background
        c.setBackground(Color.black);
        add(c);
        setSize(400, 300);
        show();
    }
	
	public static void main(String[] args) {
        main c = new main();

	}
	
	
}
