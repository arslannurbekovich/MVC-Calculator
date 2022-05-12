
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.WindowConstants;

public class Viewer {

     private JTextArea textArea;
     private Controller controller;
     private Font font;
     private JButton[] buttonArray;
     private int number;

    public Viewer() {
        controller = new Controller(this);

        font = new Font("Century Gothic", Font.PLAIN, 36);
        textArea = new JTextArea();
        buttonArray = new JButton[24];
        Border border = BorderFactory.createLineBorder(Color.BLACK,2);
        textArea.setBorder(border);
        textArea.setBounds(2, 14, 486, 96);
        textArea.setFont(new Font("Agency FB", Font.BOLD, 56));
        textArea.setForeground(Color.BLACK);

        createButton("%", 2, 120, 120, 85, Color.WHITE, Color.GRAY, "Percent");
        createButton("\u221A", 124, 120, 120, 85, Color.WHITE, Color.GRAY, "Sqrt");
        createButton("x" + "\u00B2", 246, 120, 120, 85, Color.WHITE, Color.GRAY, "Sqr");
        createButton("\u00F7", 368, 120, 120, 85, Color.WHITE, Color.GRAY, "Divide");
        createButton("C", 2, 207, 120, 85, Color.WHITE, Color.RED, "C");
        createButton("\u2190", 124, 207, 120, 85, Color.GREEN, Color.GRAY, "X");
        createButton("1/x", 246, 207, 120, 85, Color.WHITE, Color.GRAY, "OneToX");
        createButton("\u00D7", 368, 207, 120, 85, Color.WHITE, Color.GRAY, "Multiple");
        createButton("7", 2, 294, 120, 85, Color.BLACK, Color.WHITE, "Seven");
        createButton("8", 124, 294, 120, 85, Color.BLACK, Color.WHITE, "Eight");
        createButton("9", 246, 294, 120, 85, Color.BLACK, Color.WHITE, "Nine");
        createButton("-", 368, 294, 120, 85, Color.WHITE, Color.GRAY, "Minus");
        createButton("4", 2, 381, 120, 85, Color.BLACK, Color.WHITE, "Four");
        createButton("5", 124, 381, 120, 85, Color.BLACK, Color.WHITE, "Five");
        createButton("6", 246, 381, 120, 85, Color.BLACK, Color.WHITE, "Six");
        createButton("+", 368, 381, 120, 85, Color.WHITE, Color.GRAY, "Plus");
        createButton("1", 2, 468, 120, 85, Color.BLACK, Color.WHITE, "One");
        createButton("2", 124, 468, 120, 85, Color.BLACK, Color.WHITE, "Two");
        createButton("3", 246, 468, 120, 85, Color.BLACK, Color.WHITE, "Three");
        createButton("=", 368, 468, 120, 172, Color.WHITE, Color.GREEN, "Equal");
        createButton("\u00B1", 2, 555, 120, 85, Color.WHITE, Color.GRAY, "Sign");
        createButton("0", 124, 555, 120, 85, Color.BLACK, Color.WHITE, "Zero");
        createButton(".", 246, 555, 120, 85, Color.WHITE, Color.GRAY, "Point");

        JFrame jframe = new JFrame("Calculator MVC");
        jframe.setSize(508, 700);
        jframe.setLayout(null);
        jframe.add(textArea);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        Image iconF = Toolkit.getDefaultToolkit().getImage("Icon/calculator.png");
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setIconImage(iconF);

        for (int i = 0; i <buttonArray.length-1; i++) {
            jframe.add(buttonArray[i]);
        }
        jframe.setVisible(true);

    }
    private JButton createButton(String nameButton, int x, int y , int width, int height,
                                 Color foreground, Color background, String actionCommand) {
        JButton button = new JButton(nameButton);
        button.setBounds(x, y, width, height);
        button.setFont(font);
        button.setForeground(foreground);
        button.setBackground(background);
        button.addActionListener(controller);
        button.setActionCommand(actionCommand);
        buttonArray[number++] = button;
        return button;
    }

    public void update(String text) {
        textArea.setText(text);
    }

}
