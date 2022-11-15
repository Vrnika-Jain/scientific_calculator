
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ScientificCalculator extends JFrame implements ActionListener {
    JTextField tfield;
    double temp, temp1, res, result, a,b;//variable to use in calculation part of function
    static double m1, m2;
    int k = 1, x = 0, y = 0, z = 0;
    char ch;
    String c;
    //different buttons names on the calculator
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, zero, clr, pow2, pow3, exp, //b=button, clr=clear the area, eq= answer, fac=factorial, dot=decimal
            fac, plus, min, div, log, rec, mul, eq, addSub, dot, mr, mp,
            sqrt, sin, cos, tan, hcf,lcm;
    Container cont;
    //panels for text area and buttons
    JPanel textPanel, buttonpanel;

    ScientificCalculator() {
        cont = getContentPane(); //introducing a container with input panel/area for the content
        cont.setLayout(new BorderLayout()); //filling up the container with borders
        JPanel textpanel = new JPanel(); //object for text area 
        tfield = new JTextField(25); //can fill upto 25 text digits
        tfield.setHorizontalAlignment(SwingConstants.RIGHT);//horizontally align text on right side of the area
        //after key's pressed, events should be performed
        tfield.addKeyListener(new KeyAdapter() { 
            public void keyTyped(KeyEvent keyevent) { 
                char c = keyevent.getKeyChar(); //input when the key's pressed
                if (c >= '0' && c <= '9') {
                } else {
                    keyevent.consume();
                }
            }
        });
        textpanel.add(tfield);
        buttonpanel = new JPanel();
        buttonpanel.setLayout(new GridLayout(8, 5, 3, 3)); //defining the dimensions for the app
        boolean t = true;
        
        //introducing keys layout for the calculator 
        //M keys ()
        mr = new JButton("MR"); //creating an object of the current button
        buttonpanel.add(mr); //adding the button on the calculator
        mr.addActionListener(this); // to command the variable to operate on the 'current --> this' clicked key

        mp = new JButton("M+"); 
        buttonpanel.add(mp);
        mp.addActionListener(this);

        //numbered keys
        b1 = new JButton("1");
        buttonpanel.add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("2");
        buttonpanel.add(b2);
        b2.addActionListener(this);
        
        b3 = new JButton("3");
        buttonpanel.add(b3);
        b3.addActionListener(this);

        b4 = new JButton("4");
        buttonpanel.add(b4);
        b4.addActionListener(this);
        
        b5 = new JButton("5");
        buttonpanel.add(b5);
        b5.addActionListener(this);
        
        b6 = new JButton("6");
        buttonpanel.add(b6);
        b6.addActionListener(this);

        b7 = new JButton("7");
        buttonpanel.add(b7);
        b7.addActionListener(this);
        
        b8 = new JButton("8");
        buttonpanel.add(b8);
        b8.addActionListener(this);
        
        b9 = new JButton("9");
        buttonpanel.add(b9);
        b9.addActionListener(this);

        zero = new JButton("0");
        buttonpanel.add(zero);
        zero.addActionListener(this);
        
        //arithmetic keys
        plus = new JButton("+");
        buttonpanel.add(plus);
        plus.addActionListener(this);

        min = new JButton("-");
        buttonpanel.add(min);
        min.addActionListener(this);

        mul = new JButton("*");
        buttonpanel.add(mul);
        mul.addActionListener(this);

        div = new JButton("/");
        div.addActionListener(this);
        buttonpanel.add(div);
        
        //embed +/- signs before value
        addSub = new JButton("+/-");
        buttonpanel.add(addSub);
        addSub.addActionListener(this);

        //decimal key
        dot = new JButton(".");
        buttonpanel.add(dot);
        dot.addActionListener(this);

        //scientific calculations keys
        rec = new JButton("1/x");
        buttonpanel.add(rec);
        rec.addActionListener(this);
        
        sqrt = new JButton("Sqrt");
        buttonpanel.add(sqrt);
        sqrt.addActionListener(this);
        
        log = new JButton("log");
        buttonpanel.add(log);
        log.addActionListener(this);

        sin = new JButton("SIN");
        buttonpanel.add(sin);
        sin.addActionListener(this);
        
        cos = new JButton("COS");
        buttonpanel.add(cos);
        cos.addActionListener(this);
        
        tan = new JButton("TAN");
        buttonpanel.add(tan);
        tan.addActionListener(this);
        
        pow2 = new JButton("x^2");
        buttonpanel.add(pow2);
        pow2.addActionListener(this);
        
        pow3 = new JButton("x^3");
        buttonpanel.add(pow3);
        pow3.addActionListener(this);
        
        exp = new JButton("Exp");
        exp.addActionListener(this);
        buttonpanel.add(exp);
        
        fac = new JButton("n!");
        fac.addActionListener(this);
        buttonpanel.add(fac);
        
        //keys to calculate hcf, lcm of input numbers
        hcf = new JButton("HCF");
        hcf.addActionListener(this);
        buttonpanel.add(hcf);
        
        lcm = new JButton("LCM");
        lcm.addActionListener(this);
        buttonpanel.add(lcm);
        
        //print the solution on click
        eq = new JButton("=");
        buttonpanel.add(eq);
        eq.addActionListener(this);

        //clearing the text feild
        clr = new JButton("AC");
        buttonpanel.add(clr);
        clr.addActionListener(this);
        
        //horizons to settle down buttons and text area
        cont.add("Center", buttonpanel);
        cont.add("North", textpanel);
        
        //closing the layout construction part
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //function to perform specific actions for different clicks
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand(); // input  the figures now using StringCharacterIterator 
        if (s.equals("1")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "1"); //add the current character into the text area when current key is pressed after the previous character (here 0)
            } else {
                tfield.setText(""); //keep empty when not in action 
                tfield.setText(tfield.getText() + "1"); 
                z = 0;
            }
        }
        if (s.equals("2")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "2");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "2");
                z = 0;
            }
        }
        if (s.equals("3")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "3");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "3");
                z = 0;
            }
        }
        if (s.equals("4")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "4");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "4");
                z = 0;
            }
        }
        if (s.equals("5")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "5");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "5");
                z = 0;
            }
        }
        if (s.equals("6")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "6");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "6");
                z = 0;
            }
        }
        if (s.equals("7")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "7");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "7");
                z = 0;
            }
        }
        if (s.equals("8")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "8");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "8");
                z = 0;
            }
        }
        if (s.equals("9")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "9");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "9");
                z = 0;
            }
        }
        if (s.equals("0")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "0");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "0");
                z = 0;
            }
        }
        if (s.equals("AC")) { //set the values as 0 for now
            tfield.setText("");
            x = 0;
            y = 0;
            z = 0;
        }
        if (s.equals("log")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.log(Double.parseDouble(tfield.getText())); //logging the value using Math library and typeCasting to Double for any bigger decimal values
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("1/x")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = 1 / Double.parseDouble(tfield.getText()); //inverse the value and typeCasting to Double for any chance
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("Exp")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.exp(Double.parseDouble(tfield.getText()));//exponating values i.e. (e^x where e is approx 2.71828)
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("x^2")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.pow(Double.parseDouble(tfield.getText()), 2); //measuring the values as power of 2
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("x^3")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.pow(Double.parseDouble(tfield.getText()), 3); //measuring the values as power of 3 
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("+/-")) {
            if (x == 0) {
                tfield.setText("-" + tfield.getText()); //drafting the +/- signs before the value
                x = 1;
            } else {
                tfield.setText(tfield.getText());
            }
        }
        if (s.equals(".")) {
            if (y == 0) {
                tfield.setText(tfield.getText() + "."); //setting decimal value when clicked
                y = 1;
            } else {
                tfield.setText(tfield.getText());
            }
        }
        //forming cases for arithmetic operations
        if (s.equals("+")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
                temp = 0;
                ch = '+';
            } else {
                temp = Double.parseDouble(tfield.getText());
                tfield.setText("");
                ch = '+';
                y = 0;
                x = 0;
            }
            tfield.requestFocus();//requesting the text area to get the input focus and window that contains this 'ch' component
        }
        if (s.equals("-")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
                temp = 0;
                ch = '-';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(tfield.getText());
                tfield.setText("");
                ch = '-';
            }
            tfield.requestFocus();
        }
        if (s.equals("/")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
                temp = 1;
                ch = '/';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(tfield.getText());
                ch = '/';
                tfield.setText("");
            }
            tfield.requestFocus();
        }
        if (s.equals("*")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
                temp = 1;
                ch = '*';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(tfield.getText());
                ch = '*';
                tfield.setText("");
            }
            tfield.requestFocus();
        }
        if (s.equals("MR")) {//memory recall, recalls the number in the temporary memory
            tfield.setText("");
            tfield.setText(tfield.getText() + m1);
        }
        if (s.equals("M+")) {//memory plus, adds calculus to memory i.e. store the first calculation into short term memory and add it to second calculation
            if (k == 1) {
                m1 = Double.parseDouble(tfield.getText());
                k++;
            } else {
                m1 += Double.parseDouble(tfield.getText());
                tfield.setText("" + m1);
            }
        }
        if (s.equals("Sqrt")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.sqrt(Double.parseDouble(tfield.getText())); // x^x
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("SIN")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.sin(Double.parseDouble(tfield.getText())); //doing sin(x)=side x of hypotenuse/side y of hypotenuse 
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("COS")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.cos(Double.parseDouble(tfield.getText())); //perform cos(x)=(adjacent side)/(hypotenuse) directly
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("TAN")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.tan(Double.parseDouble(tfield.getText())); //perform tan(x)=sin(x)/cos(x) directly
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }    
        //basic calculator of arithmetic operations (requestFocus request is fulfilled) 
        if (s.equals("=")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                temp1 = Double.parseDouble(tfield.getText());
                switch (ch) {
                case '+':
                    result = temp + temp1;
                    break;
                case '-':
                    result = temp - temp1;
                    break;
                case '/':
                    try {
                        if(temp1 == 0) 
                            throw new ArithmeticException();
                        result=temp / temp1; 
                        break;
                        } 
                    catch(ArithmeticException ae) {
                        JOptionPane.showMessageDialog(cont, "Divisor can not be ZERO");
                    }
                case '*':
                    result = temp * temp1;
                    break;   
                }
                tfield.setText("");
                tfield.setText(tfield.getText() + result);
                z = 1;
            }
        }
        if (s.equals("n!")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = fact(Double.parseDouble(tfield.getText())); //factorial ,n!=n*n-1*n-2*....*2*1
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("HCF")) { //greatest common divisor i.e. largest number that can divide both input numbers completely
                if (tfield.getText().equals("")) {
                    tfield.setText("");
                } 
                else {
                    JFrame frame = new GcdFrame();
                    frame.setVisible(true);
                }
        }
        if (s.equals("LCM")) {//least common multiple i.e. smallest number divisible by both input numbers
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } 
            else {
                JFrame frame = new LcmFrame();
                frame.setVisible(true);
            }
        }
    }
    //factorial for any decimal value is also applied 
    double fact(double x) {
        int er = 0;
        if (x < 0) {
            er = 20;
            return 0;
        }
        double i, s = 1;
        for (i = 2; i <= x; i += 1.0)
            s *= i;
        return s;
    }

    public static void main(String args[]) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //using UIManager try for any exception occurance and setting WindowsLookAndFeel to manage
        } catch (Exception e) { //throw exception e, if any 
        }
        ScientificCalculator f = new ScientificCalculator(); //creating object of the ScientificCalculator class
        f.setTitle("Scientific Calculator by team 4"); //title for the Calculator
        f.pack(); //finishing up all the UI part
        f.setVisible(true); //to make it visible to the user
    }
}
