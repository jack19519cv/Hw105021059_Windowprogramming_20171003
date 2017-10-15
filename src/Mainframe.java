import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Mainframe extends JFrame {
    private JButton BtnEx= new JButton("範例文");
    private JButton Btn2= new JButton("加密");
    private JLabel  lb  = new JLabel( "key");
    private JButton Btn3= new JButton("清除");
    private JButton Btn4= new JButton("解密");
    private JButton Btn5= new JButton("Exit");
    private Container cp;
    private JTextArea  Jtal= new JTextArea();
    private JTextArea  Jtar= new JTextArea();
    private JScrollPane Jspl = new JScrollPane(Jtal);
    private JScrollPane Jspr = new JScrollPane(Jtar);
    private JTextField Tfkey = new JTextField("csie");
    private JPanel cp1 = new JPanel(new GridLayout(7,1,3,3));

    private int c=0;
    Mainframe(){
        init();
    }
    private void init(){
        this.setBounds(100,100,600,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        lb.setHorizontalAlignment(JLabel.CENTER);


        cp1.add(BtnEx);
        cp1.add(Btn2);
        cp1.add(lb);
        cp1.add(Tfkey);
        cp1.add(Btn3);
        cp1.add(Btn4);
        cp1.add(Btn5);
        cp.add(cp1,BorderLayout.CENTER);
        cp.add(Jspl,BorderLayout.WEST);
        cp.add( Jspr,BorderLayout.EAST);
        Jspl.setPreferredSize(new Dimension(250,400));
        Jspr.setPreferredSize(new Dimension(250,400));
        Jtal.setLineWrap(true);
        Jtar.setLineWrap(true);
      BtnEx.addActionListener(new AbstractAction() {
          @Override
          public void actionPerformed(ActionEvent e) {
              Jtal.setText("The Department of Computer Science and Information Engineering," +
                      " formerly the Department of Information Technology, was established in 2001" +
                      ". The department first offered a Master program only. In 2002, the undergraduate program was established." +
                      " The Doctoral program was established in 2006." +
                      " Each year the department admits about 80 undergraduates, 15 graduate students and 3 Ph.D. students.");

          }
      });
        Btn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[ ]= Jtal.getText().toCharArray();
                char data1[ ]= Tfkey.getText().toCharArray();
                int len = data.length,elen= data1.length;

                for(int i = 0;i<len;i++){

                        data[i]^=data1[i%elen];



                }
                Jtar.setText(new String( data));
                Btn4.setEnabled(true);

            }
        });
        Btn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jtar.setText("");
                Jtal.setText("");
            }
        });
        Btn4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[ ]= Jtar.getText().toCharArray();
                char data1[ ]= Tfkey.getText().toCharArray();
                int len = data.length,elen= data1.length;

                for(int i = 0;i<len;i++){

                    data[i]^=data1[i%elen];



                }
                Jtar.setText(new String( data));
                Btn4.setEnabled(false);
            }
        });

        Btn5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }

}
