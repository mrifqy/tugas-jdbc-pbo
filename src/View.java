import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame{
    JLabel title = new JLabel(" --- TUGAS JDBC --- ");
//    DEKLARASI KOMPONEN LOGIN
    JLabel lUserLogin = new JLabel("Username  : ");
    JTextField tfUserLogin = new JTextField (25);
    JLabel lPasswordLogin = new JLabel ("Password  : ");
    JPasswordField tfPasswordLogin = new JPasswordField(25);
    JButton btnLogin = new JButton("Login");

//    DEKLARASI KOMPONEN DAFTAR
    JLabel lUserDaftar = new JLabel ("Username : ");
    JTextField tfUserDaftar = new JTextField (25);
    JLabel lPasswordDaftar = new JLabel ("Password : ");
    JPasswordField tfPasswordDaftar = new JPasswordField (25);
    JButton btnDaftar = new JButton ("Daftar");

    public View(){
        setVisible(true);
        setTitle("");
        setSize(600,300);
        setLocationRelativeTo(null);
        setLayout(null);

//        ADD JUDUL
        add(title);

//        ADD KOMPONEN LOGIN
        add(lUserLogin);
        add(tfUserLogin);
        add(lPasswordLogin);
        add(tfPasswordLogin);
        add(btnLogin);

//        ADD KOMPONEN DAFTAR
        add(lUserDaftar);
        add(tfUserDaftar);
        add(lPasswordDaftar);
        add(tfPasswordDaftar);
        add(btnDaftar);

        title.setBounds(240,0,150,50);

//        SET POSISI TAMPILAN LOGIN
        lUserLogin.setBounds(30, 80,100,30);
        tfUserLogin.setBounds(100,80,150,30);
        lPasswordLogin.setBounds(30,120,100,30);
        tfPasswordLogin.setBounds(100,120,150,30);
        btnLogin.setBounds(100,180,100,20);

//        SET POSISI TAMPILAN DAFTAR
        lUserDaftar.setBounds(330,80,100,30);
        tfUserDaftar.setBounds(400,80,150,30);
        lPasswordDaftar.setBounds(330,120,100,30);
        tfPasswordDaftar.setBounds(400,120,150,30);
        btnDaftar.setBounds(400,180,90,20);

//        ACTION UNTUK TOMBOL LOGIN
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Connector koneksi = new Connector();
                String user = tfUserLogin.getText();
                System.out.println(user);

                if (koneksi.checkUsername(user) && user != "" && koneksi.checkLogin(user, String.valueOf(tfPasswordLogin.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login berhasil!");
                }
                else if (user.isEmpty() || String.valueOf(tfPasswordLogin.getPassword()).isEmpty()) { //error handling
                    JOptionPane.showMessageDialog(null, "Masukkan username atau password!");
                }
                else if (!koneksi.checkUsername(user)) {
                    JOptionPane.showMessageDialog(null, "Username tidak ada!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Password salah!");
                }

            }

        });

//        ACTION UNTUK TOMBOL DAFTAR
        btnDaftar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Connector koneksi = new Connector();
                String reguser = tfUserDaftar.getText();
                String regpass = String.valueOf(tfPasswordDaftar.getPassword());
                if (!reguser.isEmpty() && !regpass.isEmpty()) {
                    koneksi.inputData(reguser,regpass);
                }
                else if(reguser.isEmpty() || regpass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Masukkan username atau password!");
                }

            }

        });

    }


}
