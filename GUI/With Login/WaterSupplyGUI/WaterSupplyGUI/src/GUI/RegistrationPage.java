package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPage implements ActionListener {
    JFrame f;
    Font font1, font2, font3, font4, font5;
    JPanel p;
    ImageIcon image, icon;
    JButton Btn_SignUp, Login, Reset;
    JTextField UFName, ULName, UName, emailadd;
    JPasswordField password;
    JLabel message, message1;

    RegistrationPage() {
        //creating different fonts
        font1 = new Font("Cambria", Font.BOLD, 50);
        font2 = new Font("Cambria", Font.BOLD, 20);
        font3 = new Font("Cambria", Font.PLAIN, 20);
        font4 = new Font("Californian FB", Font.BOLD, 20);
        font5 = new Font("Cambria", Font.PLAIN, 15);

        //creating icon
        icon = new ImageIcon("resource/icon.png");

        //JFrame
        f = new JFrame("Register");

        //JPanel
        p = new JPanel();

        //Login Credential
        JLabel Heading = new JLabel("USER REGISTER");
        Heading.setBounds(150, 20, 600, 60);
        Heading.setFont(font1);
        Heading.setForeground(Color.WHITE);
        p.add(Heading);

        //user first name label
        JLabel UserFName = new JLabel("First Name");
        UserFName.setFont(font2);
        UserFName.setBounds(170, 150, 200, 30);
        UserFName.setForeground(Color.WHITE);
        p.add(UserFName);

        //User Last Name Label
        JLabel UserLName = new JLabel("Last Name");
        UserLName.setFont(font2);
        UserLName.setBounds(330, 150, 200, 30);
        UserLName.setForeground(Color.WHITE);
        p.add(UserLName);

        //user name label
        JLabel UserAddress = new JLabel("User Name");
        UserAddress.setFont(font2);
        UserAddress.setBounds(250, 250, 200, 30);
        UserAddress.setForeground(Color.WHITE);
        p.add(UserAddress);

        //user email address label
        JLabel Useremail = new JLabel("Email");
        Useremail.setFont(font2);
        Useremail.setBounds(270, 350, 200, 30);
        Useremail.setForeground(Color.WHITE);
        p.add(Useremail);

        //user password label
        JLabel Password = new JLabel("Password");
        Password.setFont(font2);
        Password.setBounds(250, 450, 200, 30);
        Password.setForeground(Color.WHITE);
        p.add(Password);

        //userFirstname text field
        UFName = new JTextField();
        UFName.setBounds(150, 180, 140, 30);
        UFName.setFont(font3);
        UFName.setBackground(Color.lightGray);
        UFName.setOpaque(false);
        p.add(UFName);

        //user last name text field
        ULName = new JTextField();
        ULName.setBounds(310, 180, 140, 30);
        ULName.setFont(font3);
        ULName.setBackground(Color.lightGray);
        ULName.setOpaque(false);
        p.add(ULName);

        //UserName text field
        UName = new JTextField();
        UName.setBounds(150, 280, 300, 30);
        UName.setFont(font3);
        UName.setBackground(Color.lightGray);
        UName.setOpaque(false);
        p.add(UName);

        //user email address text field
        emailadd = new JTextField();
        emailadd.setBounds(150, 380, 300, 30);
        emailadd.setFont(font3);
        emailadd.setBackground(Color.lightGray);
        emailadd.setOpaque(false);
        p.add(emailadd);

        //user password text field
        password = new JPasswordField();
        password.setBounds(150, 480, 300, 30);
        password.setFont(font3);
        password.setBackground(Color.lightGray);
        password.setOpaque(false);
        p.add(password);

        //Sign Up button
        Btn_SignUp = new JButton("Sign Up");
        Btn_SignUp.setBackground(Color.GREEN);
        Btn_SignUp.setForeground(Color.BLACK);
        Btn_SignUp.setBounds(500, 470, 110, 40);
        Btn_SignUp.addActionListener(this);
        Btn_SignUp.setFont(font2);
        p.add(Btn_SignUp);

        //Exit button
//        Exit = new JButton("Exit");
//        Exit.setBackground(Color.darkGray);
//        Exit.setForeground(new Color(255, 69, 0));
//        Exit.setBounds(10, 510, 100, 40);
//        Exit.addActionListener(this);
//        Exit.setFont(font4);
//        p.add(Exit);

        //Reset button
        Reset = new JButton("Reset");
        Reset.setBackground(Color.ORANGE);
        Reset.setForeground(Color.BLACK);
        Reset.setBounds(650, 470, 100, 40);
        Reset.addActionListener(this);
        Reset.setFont(font4);
        Reset.addActionListener(this);
        p.add(Reset);

        //signup label
        JLabel Account = new JLabel("Already Have Account:");
        Account.setFont(font3);
        Account.setBounds(520, 260, 200, 40);
        Account.setForeground(new Color(238, 209, 128));
        p.add(Account);

        //signIn button
        Login = new JButton("Login");
        Login.setBackground(Color.cyan);
        Login.setForeground(Color.BLACK);
        Login.setBounds(550, 300, 130, 40);
        Login.setFont(font3);
        Login.addActionListener(this);
        p.add(Login);

        //signup message label
        message = new JLabel();
        message.setFont(font3);
        message.setBounds(500, 430, 300, 30);
        message.setForeground(Color.RED);
        p.add(message);

        //signup second message label
        message1 = new JLabel();
        message1.setFont(font3);
        message1.setBounds(500, 430, 300, 30);
        message1.setForeground(Color.GREEN);
        p.add(message1);

        //background image
        JLabel background;
        image = new ImageIcon("src/GUI/background.jpg");
        background = new JLabel("", image, JLabel.CENTER);
        background.setBounds(0, 0, 800, 600);


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

    @Override
    public void actionPerformed(ActionEvent e) {
        String firstName = UFName.getText();
        String lastName = ULName.getText();
        String userName = UName.getText();
        String email = emailadd.getText();
        String pass = password.getText();

//        //button to exit application
//        if (e.getSource() == Exit) {
//            System.exit(0);
//        }

        //scene changer
        if (e.getSource() == Login) {
            new LoginPage();
            f.dispose();
        }
        //reset button clears all the text field
        if (e.getSource() == Reset) {
            message1.setText("SignUp Completed");
            message.setText("");
            UFName.setText("");
            ULName.setText("");
            UName.setText("");
            emailadd.setText("");
            password.setText("");
            message1.setText("");
            message.setText("");


        }
        //signup button functions
        if (e.getSource() == Btn_SignUp) {
            JDBC db = new JDBC();
            //display message if text field is/are blank
            if (firstName.isBlank() || lastName.isBlank() || userName.isBlank() || email.isBlank() || pass.isBlank()) {
                message.setText("Please Enter All the Credentials");
                message1.setText("");
            }
            if (!firstName.isBlank() && !lastName.isBlank() && !userName.isBlank() && !email.isBlank() && !pass.isBlank()) {
                String query = "Insert Into tbl_register(FirstName,LastName,UserName,Email,Password) values('" + firstName + "','" + lastName + "','" + userName + "','" + email + "','" + pass + "')";
                int ans = db.insert(query);
                if (ans > 0) {
                    message1.setText("SignUp Completed");
                    //clears text field once signup completed
                    message.setText("");
                    UFName.setText("");
                    ULName.setText("");
                    UName.setText("");
                    emailadd.setText("");
                    password.setText("");

                }
            }

        }
    }

}


