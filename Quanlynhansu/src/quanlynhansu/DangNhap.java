/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhansu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import keeptoo.KButton;
import keeptoo.KGradientPanel;

/**
 *
 * @author Nhật Quyên
 */
public class DangNhap extends JFrame{
        
        private JLabel lbUser, lbPass, lbText,lbLogo;
        private JTextField txtUser = new JTextField();
        private JPasswordField txtPass = new JPasswordField();
        private int DWIDTH = 380, DHEIGHT = 500;
        
        
        DangNhap(){
            init();
        }
        
        
        public void init(){
            setTitle ("Quản Lý Nhân Sự");
            ImageIcon logo = new ImageIcon(getClass().getResource("/image/icon/logo.png"));
            setIconImage(logo.getImage());
            setSize(DWIDTH, DHEIGHT);
            setLayout(null);
            setLocationRelativeTo(null);
            
            
            KGradientPanel background = new KGradientPanel();
            background.setLayout(null);
            background.setkStartColor(new Color(10,114,185));
            background.setkGradientFocus(1200);
            background.setkBorderRadius(25); 
            background.setBounds(0,0,DWIDTH,DHEIGHT);
            
            
            //phần đầu
            lbLogo = new JLabel(logo);
            lbLogo.setSize(55,45);
            lbLogo.setLocation(30,50);
            lbText = new JLabel("QUẢN LÝ NHÂN SỰ");
            lbText.setForeground(Color.WHITE);
            lbText.setSize(200,50);
            lbText.setLocation(90,50);
            lbText.setFont (new Font("Segoe UI Black", Font.PLAIN,20));
            JLabel exit = new JLabel(new ImageIcon(getClass().getResource("/image/icon/exit_25.png")),JLabel.CENTER);
            exit.setBounds(DWIDTH - 40, 10, 30, 30);
            exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
            
            
            
            //phần body
            JPanel pnbody = new JPanel();
            pnbody.setLayout(null);
            pnbody.setSize(DWIDTH,300);
            pnbody.setLocation(0, 120);
            pnbody.setBorder(BorderFactory.createLineBorder(new Color(10,114,185)));
            pnbody.setBackground(Color.WHITE);
            ImageIcon user = new ImageIcon(getClass().getResource("/image/icon/user_25.png"));
            ImageIcon pass = new ImageIcon(getClass().getResource("/image/icon/pass_25.png"));
            Font font = new Font("Segoe UI", Font.PLAIN,12);
            lbUser = new JLabel(user);
            lbUser.setSize(50,50);
            lbUser.setLocation(50, 50);
            txtUser = new JTextField("Tên Truy Cập");
            txtUser.setFont(font);
            txtUser.setForeground(new Color(10,114,185));
            txtUser.setCaretColor(new Color(10,114,185));
            txtUser.setBorder(null);
            txtUser.setOpaque(false);
            txtUser.setBounds(100, 50, 200, 50);
            JSeparator spUser = new JSeparator();
            spUser.setBounds(70,90,230,5);
            
            
            lbPass = new JLabel(pass);
            lbPass.setSize(50,50);
            lbPass.setLocation(50, 100);
            txtPass = new JPasswordField("Password");
            txtPass.setFont(font);
            txtPass.setForeground(new Color(10,114,185));
            txtPass.setCaretColor(new Color(10,114,185));
            txtPass.setBorder(null);
            txtPass.setOpaque(false);
            txtPass.setBounds(100, 100, 200, 50);
            JSeparator spPass = new JSeparator();
            spPass.setBounds(70,140,230,5);
            
            KButton btnLogin = new KButton();
            btnLogin.setText("Đăng nhập");
            btnLogin.setFont(new Font("Segoe UI", Font.PLAIN,15));
            btnLogin.setkStartColor(new Color(10,114,185));
            btnLogin.setkEndColor(new Color(10,114,185));
            btnLogin.setkBorderRadius(20); 
            btnLogin.setkHoverStartColor(Color.orange);
            btnLogin.setkHoverEndColor(Color.orange);
            btnLogin.setBorder(null);
            btnLogin.setOpaque(false);
            btnLogin.setBounds(80, 200, 200, 40);
            btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            
            
            
            //phần add
           
            pnbody.add(lbUser);
            pnbody.add(lbPass);
            pnbody.add(txtUser);
            pnbody.add(spUser);
            pnbody.add(txtPass);
            pnbody.add(spPass);
            pnbody.add(btnLogin);
            
            
            setUndecorated(true);
            background.add(exit);
            background.add(lbLogo);
            background.add(lbText);
            background.add(pnbody);
            add(background);
          
        exit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                System.exit(0);
            }
        });
            
        txtUser.addMouseListener((new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {
                txtUser.setText("");
            }
        }));
        txtPass.addMouseListener((new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {
                txtPass.setText("");
            }
        }));
        btnLogin.addMouseListener((new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
               System.out.println("Click");
               setVisible(false);
               
               QuanLyNhanSu ql = new QuanLyNhanSu(txtUser.getText());
               ql.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               ql.setVisible(true);
               
            }
        }));
        
        }            
            
            
}

        

   