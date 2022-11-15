import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class GCD{
    public static void main(String[] args) {
        JFrame frame = new GcdFrame();
        frame.setVisible(true);
     }
}
class GcdFrame extends JFrame {
    public GcdFrame() {
        setTitle("Greatest Common Divisor Finder");
        centerWindow(this);
        setSize(300, 200);
        //  setResizable(false);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new GcdPanel();
        this.add(panel);
    }

    private void centerWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width - w.getWidth()) / 2,
        (d.height - w.getHeight()) / 2);
    }
 }
class GcdPanel extends JPanel implements ActionListener {
    private JTextField xTextField, yTextField,gcdTextField;
    private JLabel xLabel, yLabel, gcdLabel;    
    private JButton calculateButton, exitButton;

    public GcdPanel() {
        // display panel
        JPanel displayPanel = new JPanel();
        //   displayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        displayPanel.setLayout(new GridLayout(4, 2));
        // payment label
        xLabel = new JLabel("Enter first number: ");
        displayPanel.add(xLabel);

        // payment text field
        xTextField = new JTextField(10);
        displayPanel.add(xTextField);

        // rate label
        yLabel = new JLabel("Enter second number:");
        displayPanel.add(yLabel);

        // rate text field
        yTextField = new JTextField(10);
        displayPanel.add(yTextField);

        // future value label
        gcdLabel = new JLabel("GCD:");
        displayPanel.add(gcdLabel);

        // future value text field
        gcdTextField = new JTextField(10);
        gcdTextField.setEditable(false);
        gcdTextField.setFocusable(false);
        displayPanel.add(gcdTextField);

        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // calculate button
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        buttonPanel.add(calculateButton);

        // exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);

        // add panels to main panel
        this.setLayout(new BorderLayout());
        this.add(displayPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == exitButton)
            System.exit(0);
        else if (source == calculateButton) {
            int x =  Integer.parseInt(xTextField.getText());
            int y = Integer.parseInt(xTextField.getText());
            int gcd = greatestCommonDivisor(x, y);
            gcdTextField.getText();
            gcdTextField.setText(gcdTextField.getText()+gcd);
        }
    }
    private int greatestCommonDivisor(int x, int y) {
        // TODO Auto-generated method stub

        while (x != y) {
            if (x > y) {
                x = x - y;
            } 
            else {
                y = y - x;
            }
        }
        return y;
     }
}
