    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhansu;

import decorate.MenuTD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Nhật Quyên
 */

public class QuanLyNhanSu extends JFrame  implements MouseListener{

    private JPanel header, menu, body;
    private JLabel lbLogo, lbText;
    String user = "";
    private JButton btLogin, btplus, btminus, btinfinity;
    private ArrayList<MenuTD> menuItem = new ArrayList<>();
    private int DWIDTH = 1250, DHEIGHT = 700;
    
    
    public QuanLyNhanSu (String user){
        this.user = user;
         init();
    }
    public QuanLyNhanSu (){
         init();
    }
    public void init(){
        setTitle ("Quản Lý Nhân Sự");
        ImageIcon logo = new ImageIcon(getClass().getResource("/image/icon/logo.png"));
        setIconImage(logo.getImage());
        setSize(DWIDTH, DHEIGHT);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        
        //phần đầu
        header = new JPanel();
        header.setBackground(new Color(10,114,185));
        header.setLayout(null);
        header.setPreferredSize(new Dimension(DWIDTH,80));
        lbLogo = new JLabel(logo);
        lbLogo.setSize(55,45);
        lbLogo.setLocation(20,20);
        lbText = new JLabel("QUẢN LÝ NHÂN SỰ");
        lbText.setForeground(Color.WHITE);
        lbText.setSize(200,50);
        lbText.setLocation(80,20);
        lbText.setFont (new Font("Segoe UI Black", Font.PLAIN,20));
        ImageIcon ILogin = new ImageIcon(getClass().getResource("/image/icon/admin_40.png"));
        btLogin = new JButton(user);
        btLogin.setBounds(900,20,250,50);
        btLogin.setIcon(ILogin);
        btLogin.setBackground(Color.ORANGE);
        btLogin.setForeground(Color.WHITE);
        btLogin.setFont (new Font("Segoe UI", Font.PLAIN,20));
        
        
        
        //phần menu
        
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(new Color(10,114,185));
        menu.setPreferredSize(new Dimension(200,DHEIGHT));
        ImageIcon Iplus = new ImageIcon (getClass().getResource("/image/icon/plus_28.png"));
        btplus = new JButton(Iplus);
        btplus.setBounds(150,50,28,28);
        ImageIcon Iminus = new ImageIcon (getClass().getResource("/image/icon/minus_28.png"));
        btminus = new JButton(Iminus);
        btminus.setBounds(150,50,28,28);
        ImageIcon Iinfinity = new ImageIcon (getClass().getResource("/image/icon/infinity_28.png"));
        btinfinity = new JButton(Iinfinity);
        btinfinity.setBounds(150,50,28,28);
        //mảng
        ArrayList<String> MenuTD = new ArrayList<>();
        MenuTD.add("Hồ Sơ Nhân Viên:btplus:btminus");
        MenuTD.add("Chấm Công:btplus:btminus");
        MenuTD.add("Bảo hiểm & Thuế:btplus:btminus");
        MenuTD.add("Tính Lương:btplus:btminus");
        MenuTD.add("Ban Quản Lý:btplus:btminus");
        MenuTD.add("Tuyển dụng:btplus:btminus");
        MenuTD.add("Thiết lập:btplus:btminus");
        
        for (int i = 0; i < MenuTD.size(); i++) {
            String s = MenuTD.get(i).split(":")[0];
            String plus = MenuTD.get(i).split(":")[1];
            String minus = MenuTD.get(i).split(":")[2];
            menuItem.add(new MenuTD(s, new Rectangle(0, 50 * i, 200, 50), plus, minus));
            menuItem.get(i).addMouseListener(this);
            menu.add(menuItem.get(i));
        }
        
        // phần body
        body = new JPanel();
        body.setLayout(null);
        body.setBackground(Color.WHITE);

        
        
        
        
        
        //add các phần vào
        header.add(lbLogo);
        header.add(lbText);
        header.add(btLogin);
        menu.add(btplus);
        add(header,BorderLayout.NORTH);
        add(menu,BorderLayout.WEST);
        add(body,BorderLayout.CENTER);
        
        
        
        
    }
    
   
    
    
   public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        QuanLyNhanSu ql = new QuanLyNhanSu();
        ql.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ql.setVisible(true);
    }
    
    
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        for (int i = 0; i < menuItem.size(); i++) {
            MenuTD item = menuItem.get(i);
            if (e.getSource() == item) {
                item.doActive();
                changeMainInfo(i);
            } else {
                item.noActive();
            }
        }
    }
    public void changeMainInfo(int i) {
        switch (i) {
            case 0: // Hồ Sơ Nhân Viên
                body.removeAll();
                body.add(new HoSoNhanVien(DWIDTH));
                body.repaint();
                break;

            case 1: // Chấm Công
                body.removeAll();
                body.add(new BangChamCong(DWIDTH));
                body.repaint();
                break;
            case 2: // Bảo hiểm và Thuế
                body.removeAll();
              //  body.add(new Page404(DEFALUT_WIDTH));
                body.repaint();
                break;
            case 3: //Tính Lương
                body.removeAll();
              //  body.add(new Page404(DEFALUT_WIDTH));
                body.repaint();
                break;
            case 4: //Ban Quản Lý
                body.removeAll();
              //  body.add(new Page404(DEFALUT_WIDTH));
                body.repaint();
                break;
            case 5: //Tuyển Dụng
                body.removeAll();
              //  body.add(new Page404(DEFALUT_WIDTH));
                body.repaint();
                break;
            case 6: //Thiết Lập
                body.removeAll();
              //  body.add(new Page404(DEFALUT_WIDTH));
                body.repaint();
                break;    
            default:
        }
    }
    

    @Override
    public void mousePressed(MouseEvent me) {
   }

    @Override
    public void mouseReleased(MouseEvent me) {
     }

    @Override
    public void mouseEntered(MouseEvent me) {
      }

    @Override
    public void mouseExited(MouseEvent me) {
       }

   
}
