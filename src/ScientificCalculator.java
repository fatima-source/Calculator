import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ScientificCalculator {

    static JFrame frame;
    static ImageIcon image;
    static JTextField textField;
    static JButton [] numberButtons = new JButton[10];
    static JButton [] arithmeticButtons = new JButton[5];
    static JButton [] SpecialFunctionButtons = new JButton[3];
    static JButton [] TrignometricFunctionButtons = new JButton[3];
    static JButton [] InvTrignoFuncButtons = new JButton[3];
    static JButton [] LogFunctionButtons = new JButton[2];
    static JButton [] statFunctionButtons = new JButton[4];
    static JButton [] OtherFunctionButtons = new JButton[5];
    static JButton addBtn,subBtn,mulBtn,divBtn,eqBtn,sqrBtn,piBtn,expBtn,sinBtn,cosBtn,
                   tanBtn,invTanBtn,invCosBtn,invSinBtn,lnBtn,logBtn,decBtn,clrBtn,delBtn,
                   exponenBtn,facBtn,percenBtn,modeBtn,medBtn,meanBtn,stDevBtn;
    static JPanel panel;
    static double num1=0.0,num2=0.0,result=0.0;
    static char operator;
    static double mean,median,mode,sd;
    static double []num = new double [100];
    static int count = 0;


    public static void main(String[] args) {
        //create frame
        frame = new JFrame("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(495,50,690,750);
        frame.setLayout(null);
        frame.setResizable(false);

        image = new ImageIcon("calculator.png");
        frame.setIconImage(image.getImage());

        Font myfont = new Font("my font",Font.BOLD,30);
        Font decimalFont = new Font("Arial", Font.BOLD, 45);
        textField = new JTextField();
        textField.setBounds(35,20,600,75);
        textField.setFont(myfont);
        textField.setEditable(false);
        textField.setBackground(Color.white);

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        clrBtn = new JButton("Clr");
        delBtn = new JButton("Dlt");
        decBtn = new JButton(".");
        eqBtn = new JButton("=");
        sinBtn = new JButton("sin");
        cosBtn = new JButton("cos");
        tanBtn = new JButton("tan");
        invSinBtn = new JButton("sin⁻¹");
        invCosBtn = new JButton("cos⁻¹");
        invTanBtn = new JButton("tan⁻¹");
        expBtn = new JButton("e");
        exponenBtn = new JButton("^");
        piBtn = new JButton("π");
        sqrBtn = new JButton("√");
        logBtn = new JButton("log");
        lnBtn = new JButton("ln");
        facBtn = new JButton("!");
        percenBtn = new JButton("%");
        modeBtn = new JButton("M");
        meanBtn = new JButton("μ");
        medBtn = new JButton("Med");
        stDevBtn = new JButton("σ");


        arithmeticButtons[0] = addBtn;
        arithmeticButtons[1] = subBtn;
        arithmeticButtons[2] = mulBtn;
        arithmeticButtons[3] = divBtn;
        arithmeticButtons[4] = eqBtn;


        for (int i = 0; i < 5; i++) {
            arithmeticButtons[i].setFont(myfont);
            arithmeticButtons[i].setFocusable(false);
        }

        SpecialFunctionButtons[0] = piBtn;
        SpecialFunctionButtons[1] = sqrBtn;
        SpecialFunctionButtons[2] = expBtn;

        for (int i = 0; i < 3; i++) {
            SpecialFunctionButtons[i].setFont(myfont);
            SpecialFunctionButtons[i].setFocusable(false);
        }

        TrignometricFunctionButtons[0] = sinBtn;
        TrignometricFunctionButtons[1] = cosBtn;
        TrignometricFunctionButtons[2] = tanBtn;

        for (int i = 0; i < 3; i++) {
            TrignometricFunctionButtons[i].setFont(myfont);
            TrignometricFunctionButtons[i].setFocusable(false);
        }

        InvTrignoFuncButtons[0] = invSinBtn;
        InvTrignoFuncButtons[1] = invCosBtn;
        InvTrignoFuncButtons[2] = invTanBtn;

        for (int i = 0; i < 3; i++) {
            InvTrignoFuncButtons[i].setFont(myfont);
            InvTrignoFuncButtons[i].setFocusable(false);
        }

        LogFunctionButtons[0] = lnBtn;
        LogFunctionButtons[1] = logBtn;

        for (int i = 0; i < 2; i++) {
            LogFunctionButtons[i].setFont(myfont);
            LogFunctionButtons[i].setFocusable(false);
        }

        statFunctionButtons[0] = modeBtn;
        statFunctionButtons[1] = meanBtn;
        statFunctionButtons[2] = medBtn;
        statFunctionButtons[3] = stDevBtn;

        for (int i = 0; i < 4; i++) {
            statFunctionButtons[i].setFont(myfont);
            statFunctionButtons[i].setFocusable(false);
        }

        OtherFunctionButtons[0] = exponenBtn;
        OtherFunctionButtons[1] = facBtn;
        OtherFunctionButtons[2] = percenBtn;
        OtherFunctionButtons[3] = delBtn;
        OtherFunctionButtons[4] = clrBtn;

        for (int i = 0; i < 5; i++) {
            OtherFunctionButtons[i].setFont(myfont);
            OtherFunctionButtons[i].setFocusable(false);
        }


        for (int i = 0; i <10 ; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
            numberButtons[i].setForeground(Color.BLACK);
        }

        decBtn.setFont(decimalFont);


        for (JButton button : new JButton[]{addBtn, subBtn, mulBtn, divBtn, eqBtn, clrBtn, delBtn,
                sinBtn, cosBtn, tanBtn, invSinBtn, invCosBtn, invTanBtn, expBtn, exponenBtn, piBtn,
                sqrBtn, logBtn, lnBtn, facBtn, percenBtn, meanBtn, medBtn,
                modeBtn, stDevBtn}) {
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLACK);
        }


        clrBtn.setBackground(Color.RED);
        delBtn.setBackground(Color.YELLOW);
        eqBtn.setBackground(Color.green);
        decBtn.setBackground(Color.cyan);


        panel = new JPanel();
        panel.setBounds(35,115,600,565);
        panel.setLayout(new GridLayout(9,4,5,5));
        panel.setBackground(Color.GRAY);
        panel.setVisible(true);
        //add buttons into panel
        panel.add(delBtn);
        panel.add(clrBtn);
        panel.add(percenBtn);
        panel.add(divBtn);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulBtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subBtn);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addBtn);
        panel.add(decBtn);
        panel.add(numberButtons[0]);
        panel.add(sqrBtn);
        panel.add(eqBtn);
        panel.add(sinBtn);
        panel.add(cosBtn);
        panel.add(tanBtn);
        panel.add(piBtn);
        panel.add(invSinBtn);
        panel.add(invCosBtn);
        panel.add(invTanBtn);
        panel.add(expBtn);
        panel.add(lnBtn);
        panel.add(logBtn);
        panel.add(facBtn);
        panel.add(exponenBtn);
        panel.add(meanBtn);
        panel.add(modeBtn);
        panel.add(medBtn);
        panel.add(stDevBtn);

        //add components into frame
        frame.add(textField);
        frame.add(panel);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText()+numberButtons[finalI].getText());
                }
            });
        }
        decBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+".");
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
        });
        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
        });
        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
        });
        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
        });



        clrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                result = 0.0;
                num1=0.0;
                num2=0.0;
            }
        });


         delBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String txt = textField.getText();
                 textField.setText("");
                 for (int i = 0; i < txt.length()-1; i++) {
                     textField.setText(textField.getText()+txt.charAt(i));
                 }
             }
         });

        sinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Math.toRadians(Double.parseDouble(textField.getText()));
                operator = 's';
            }
        });

        cosBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Math.toRadians(Double.parseDouble(textField.getText()));
                operator = 'c';
            }
        });

        tanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Math.toRadians(Double.parseDouble(textField.getText()));
                operator = 't';
            }
        });

        invSinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = 'S';
            }
        });

        invCosBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = 'C';
            }
        });

        invTanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = 'T';
            }
        });

        lnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = 'l';
            }
        });

        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = 'L';
            }
        });

        expBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = 'e';
            }
        });

        exponenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '^';
                textField.setText("");
            }
        });

        sqrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '√';
            }
        });

        facBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '!';
            }
        });

        percenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '%';
            }
        });

        piBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.PI));
            }
        });

        meanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty() && textField.getText() != null){
                    num[count] = Double.parseDouble(textField.getText());
                    count++;
                    operator = 'μ';
                    textField.setText("");
                    double sum = 0.0;
                    for(int i = 0; i < count; i++){
                        sum += num[i];
                    }
                    mean = sum/count;
                }
                else {
                    System.err.println("Error");
                }
            }
        });

        medBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText() != null && !textField.getText().isEmpty()) {
                    num[count] = Double.parseDouble(textField.getText());
                    count++;
                    operator = 'M';
                    textField.setText("");

                    double []num_ = Arrays.stream(num).filter(value -> value != 0).toArray();
                    Arrays.sort(num_);
                    if(num_.length % 2 != 0){
                        median = num_[num_.length / 2];
                    }
                    else{
                        median = (num_[num_.length / 2] + (num_[num_.length / 2] - 1 )) / 2;
                    }
                }
                else {
                    System.err.println("Error");
                }
            }
        });

        modeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText() != null && !textField.getText().isEmpty()){
                    num[count] = Double.parseDouble(textField.getText());
                    count++;
                    operator = 'o';
                    textField.setText("");

                    int maxCount = 0;
                    double modeValue = num[0];

                    for (int i = 0; i < count; i++) {
                        int currentCount = 0;
                        for (int j = 0; j < count; j++) {
                            if (num[j] == num[i]) {
                                currentCount++;
                            }
                        }
                        if (currentCount > maxCount) {
                            maxCount = currentCount;
                            modeValue = num[i];
                        }
                    }

                    mode = modeValue;
                }
                else {
                    System.err.println("Error");
                }
            }
        });

        stDevBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty() && textField.getText() != null){
                    num[count] = Double.parseDouble(textField.getText());
                    count++;
                    operator = 'σ';
                    textField.setText("");
                    double sum = 0.0;
                    for(int i = 0; i < count; i++){
                        sum += num[i];
                    }
                    mean = sum/count;

                    double varianceSum = 0.0;
                    for (int i = 0; i < count; i++) {
                        varianceSum += Math.pow(num[i] - mean, 2);
                    }

                    double variance = varianceSum / (count - 1);
                    sd = Math.sqrt(variance);
                }
                else {
                    System.err.println("Error");
                }
            }
        });

        eqBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator){
                    case '+':{
                        result = num1+num2;
                        break;
                    }
                    case '-':{
                        result = num1-num2;
                        break;
                    }
                    case '*':{
                        result = num1*num2;
                        break;
                    }
                    case '/':{
                        if(num2 != 0) {
                            result = num1 / num2;
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Math's Error.");
                            result = 0.0;
                        }
                        break;
                    }
                    case '^': {
                        result = Math.pow(num1, Double.parseDouble(textField.getText()));
                        break;
                    }
                    case '√':{
                        result = Math.sqrt(num1);
                        break;
                    }
                    case '%':{
                        result = (num1 * num2) / 100;
                        break;
                    }
                    case '!':{
                        result = 1;
                        for (int i = 1; i <= num1; i++) {
                            result *= i;
                        }
                        break;
                    }
                    case 'e':{
                        result = Math.exp(num1);
                        break;
                    }
                    case 's':{
                        result = Math.sin(num1);
                        break;
                    }
                    case 'c':{
                        result = Math.cos(num1);
                        break;
                    }
                    case 't':{
                        result = Math.tan(num1);
                        break;
                    }
                    case 'S':{
                        result = Math.toDegrees(Math.asin(num1));
                        break;
                    }
                    case 'C':{
                        result = Math.toDegrees(Math.acos(num1));
                        break;
                    }
                    case 'T':{
                        result = Math.toDegrees(Math.atan(num1));
                        break;
                    }
                    case 'l':{
                        result = Math.log(Double.parseDouble(textField.getText()));
                        break;
                    }
                    case 'L':{
                        result = Math.log10(Double.parseDouble(textField.getText()));
                        break;
                    }
                    case 'μ':{
                        result = mean;
                        break;
                    }
                    case 'M':{
                        result = median;
                        break;
                    }
                    case 'o':{
                        result = mode;
                        break;
                    }
                    case 'σ':{
                        result = sd;
                        break;
                    }
                    default:
                        JOptionPane.showMessageDialog(null,"Invalid Operator...");
                }
                textField.setText(result+"");
                num1 = result;
            }
        });

        frame.setVisible(true);


    }
}

