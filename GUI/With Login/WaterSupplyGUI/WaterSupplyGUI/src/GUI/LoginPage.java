package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LoginPage implements ActionListener {
    JFrame f;
    Font font1, font2, font3, font4, font5;
    JPanel p;
    ImageIcon image, icon;
    JButton SignUp, Login, Reset;
    JLabel Heading, Account, UserName, UserIcon, UserPass, background, message, message2;
    JTextField UName;
    JPasswordField password;

    LoginPage() {
        //creating different fonts
        font1 = new Font("Cambria", Font.BOLD, 50);
        font2 = new Font("Californian FB", Font.BOLD, 10);
        font3 = new Font("Cambria", Font.PLAIN, 20);
        font4 = new Font("Californian FB", Font.BOLD, 20);
        font5 = new Font("Californian FB", Font.BOLD, 15);

        //creating icon
        icon = new ImageIcon("resource/icon.png");

        //JFrame
        f = new JFrame("Login");

        //JPanel
        p = new JPanel();

        //Login Credential
        Heading = new JLabel("User Login");
        Heading.setBounds(270, 10, 300, 70);
        Heading.setFont(font1);
        Heading.setForeground(Color.WHITE);
        p.add(Heading);

        //User Icon
        UserIcon = new JLabel();
        ImageIcon user = new ImageIcon("src/GUI/user.png");
        UserIcon = new JLabel("", user, JLabel.CENTER);
        UserIcon.setBounds(190, 130, 80, 80);
        p.add(UserIcon);

        //username
        UserName = new JLabel("User Name");
        UserName.setFont(font2);
        UserName.setBounds(205, 205, 200, 30);
        UserName.setForeground(Color.WHITE);
        p.add(UserName);

        //username text field
        UName = new JTextField();
        UName.setBounds(290, 155, 250, 30);
        UName.setFont(font3);
        UName.setBackground(Color.lightGray);
        UName.setOpaque(false);
        p.add(UName);

        //user password icon
        UserPass = new JLabel();
        ImageIcon pass = new ImageIcon("src/GUI/password.png");
        UserPass = new JLabel("", pass, JLabel.CENTER);
        UserPass.setBounds(190, 240, 80, 80);
        p.add(UserPass);

        //user password label
        JLabel Password = new JLabel("Password");
        Password.setFont(font2);
        Password.setBounds(205, 315, 200, 30);
        Password.setForeground(Color.WHITE);
        p.add(Password);

        //user password text field
        password = new JPasswordField();
        password.setBounds(290, 260, 250, 30);
        password.setFont(font3);
        password.setBackground(Color.lightGray);
        password.setOpaque(false);
        p.add(password);

        //Login button
        Login = new JButton("Login");
        Login.setBackground(Color.GREEN);
        Login.setForeground(Color.BLACK);
        Login.setBounds(290, 380, 100, 40);
        Login.setFont(font4);
        Login.addActionListener(this);
        p.add(Login);

        //Reset button
        Reset = new JButton("Reset");
        Reset.setBackground(Color.ORANGE);
        Reset.setForeground(Color.BLACK);
        Reset.setBounds(440, 380, 100, 40);
        Reset.setFont(font4);
        Reset.addActionListener(this);
        p.add(Reset);

        //signup label
        Account = new JLabel("Register New Account:");
        Account.setFont(font3);
        Account.setBounds(430, 500, 200, 30);
        Account.setForeground(new Color(238, 209, 128));
        p.add(Account);

        //signup button
        SignUp = new JButton("Sign Up");
        SignUp.setBackground(Color.cyan);
        SignUp.setForeground(Color.BLACK);
        SignUp.setBounds(630, 500, 130, 30);
        SignUp.setFont(font3);
        SignUp.addActionListener(this);
        p.add(SignUp);

        //background image
        background = new JLabel();
        image = new ImageIcon("src/GUI/background.jpg");
        background = new JLabel("", image, JLabel.CENTER);
        background.setBounds(0, 0, 800, 600);

        //message label
        //message label
        message = new JLabel();
        message.setFont(font5);
        message.setBounds(300, 320, 300, 50);
        message.setForeground(new Color(255, 69, 0));
        p.add(message);

        //message2 label
        message2 = new JLabel();
        message2.setFont(font5);
        message2.setBounds(300, 320, 300, 50);
        message2.setForeground(new Color(0,255,127));
        p.add(message);

        //setting up JPanel
        p.setBounds(0, 0, 800, 600);
        p.setLayout(null);
        p.setVisible(true);
        p.add(background);
        f.add(p);

        //setting up JFrame
        f.setBounds(0, 0, 800, 600);
        f.setIconImage(icon.getImage());
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new LoginPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Reset Button Action
        if(e.getSource()==Reset){
            UName.setText("");
            password.setText("");
        }
        //Signup button Action
        if (e.getSource() == SignUp) {
            new RegistrationPage();
            f.dispose();
        }
        //Login Button Action
        if (e.getSource() == Login) {
            JDBC db = new JDBC();
            String user_Name = UName.getText();
            String user_password = password.getText();

            //Login Functions
            String verifyLogin ="Select count(1) FROM tbl_register WHERE UserName = '"+user_Name+"' AND Password = '"+user_password+"'";
            try{
                ResultSet queryResult = db.select(verifyLogin);
                while((queryResult.next())){
                    if (queryResult.getInt(1)==1){
                        // To select the Nimbus's Look and Feel
                        try {
                            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                    break;
                                }
                            }
                        } catch (ClassNotFoundException ex) {
                            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }

                        main cs = new main();
                        cs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        cs.setVisible(true);
                        cs.setLocation(0,0);
                        cs.setSize(1200,800);
                        cs.setResizable(false);
                        cs.setTitle("Water Supply GUI");

                        f.dispose();
                        message2.setText("Login Successful");// Login Success message display
                    }
                    else{
                        message.setText("User Name or Password do not match");//login unsuccessful message display
                    }
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
            //Informative messages
            if (UName.getText().isBlank()) {
                message.setText("Please Enter User Name");
            }
            if (password.getText().isBlank()) {
                message.setText("Please Enter Password");
            }
            if (UName.getText().isBlank() && password.getText().isBlank()) {
                message.setText("Please Enter User Name and Password");
            }
        }
    }
}
