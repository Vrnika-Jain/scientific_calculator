import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.lang.ArithmeticException;


public class LCM{
    public static void main(String[] args) {
        JFrame frame = new LcmFrame();
        frame.setVisible(true);
     }
}
class LcmFrame extends JFrame {
    public LcmFrame() {
        setTitle("Least Common Multiple Finder");
        centerWindow(this);
        setSize(300, 200);
        //  setResizable(false);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new LcmPanel();
        this.add(panel);
    }

    private void centerWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width - w.getWidth()) / 2,
        (d.height - w.getHeight()) / 2);
    }
 }
class LcmPanel extends JPanel implements ActionListener {
    private JTextField xTextField, yTextField,lcmTextField;
    private JLabel xLabel, yLabel, gcdLabel;    
    private JButton calculateButton, exitButton;
    int gcd=1;

    public LcmPanel() {
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
        gcdLabel = new JLabel("LCM:");
        displayPanel.add(gcdLabel);

        // future value text field
        lcmTextField = new JTextField(10);
        lcmTextField.setEditable(true);
        lcmTextField.setFocusable(true);
        displayPanel.add(lcmTextField);

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
            int lcm = leastCommonMultiple(x, y);
            lcmTextField.getText();
            lcmTextField.setText(lcmTextField.getText() + lcm);
        }
    }
    //calculate gcd to use in lcm
    private int greatestCommonDivisor(int x,int y){
        if(x==0) return y;
        return greatestCommonDivisor(y%x,x);
    }
    //recursively calling greatestCommonDivisor method
    private int leastCommonMultiple(int x, int y) {
        // TODO Auto-generated method stub
        return (x/greatestCommonDivisor(x,y))*y;
    }
}
