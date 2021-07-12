/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhansu;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Nhật Quyên
 */

public class ThongTinCaNhan extends JFrame implements MouseListener{

    private JPanel header, image, info, remark,footer;
    private JLabel lbLogo, lbText,lbTTChung,lbTTCongViec,lbMaNV, lbPhongBan ,
            lbHoTen, lbNgaySinh, lbGioiTinh, lbNoiSinh, lbCMND, lbTrinhDoHocVan, 
            lbChuyenNganh, lbDiaChi, lbDanToc,lbTonGiao,lbChucVu,lbTGLamViec,
            lbTinhTrang,lbUser,lbPass, lbSDT, lbEmail;
    private JTextField txtMaNV, txtPhongBan ,txtHo,txtTen, 
            txtNoiSinh, txtCMND, txtTrinhDoHocVan, txtChuyenNganh, 
            txtDiaChi, txtDanToc,txtTonGiao,txtChucVu,txtTGLamViec,
            txtUser, txtPass, txtSDT, txtEmail, txtGioiTinh;
    private JButton Iface, btSaveAs;
    private Choice cNgay, cThang, cNam, cTinhTrang;
    private JComboBox cbGioiTinh;
    private int DWIDTH = 1200, DHEIGHT = 700;
    
    
    
    
    public ThongTinCaNhan ()
    {
         init();
    }
    public void init(){
        setTitle ("Thông Tin Cá Nhân");
        ImageIcon logo = new ImageIcon(getClass().getResource("/image/icon/logo_64.png"));
        setIconImage(logo.getImage());
        setSize(DWIDTH, DHEIGHT);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        
        //phần đầu
        header = new JPanel();
        header.setBackground(new Color(10,114,185));
        header.setLayout(null);
        header.setPreferredSize(new Dimension(DWIDTH,80));
        lbLogo = new JLabel(logo);
        lbLogo.setSize(55,45);
        lbLogo.setLocation(20,20);
        lbText = new JLabel("THÔNG TIN CÁ NHÂN");
        lbText.setForeground(Color.WHITE);
        lbText.setSize(300,50);
        lbText.setLocation(80,20);
        lbText.setFont (new Font("Segoe UI Black", Font.PLAIN,20));
  
        
        
        
        //phần body
        image = new JPanel();
        image.setLayout(null);
        image.setBackground(Color.WHITE);
        image.setPreferredSize(new Dimension(200,500));
        ImageIcon face = new ImageIcon(getClass().getResource("/image/icon/face_128.png"));
        Iface = new JButton(face);
        Iface.setBounds(50,30,128,128);
        //phần info
        Font fonttext = new Font("Segoe UI",Font.PLAIN,15);
        Color xanhduong = new Color(10,114,185);
        info = new JPanel();
        info.setLayout(null);
        info.setPreferredSize(new Dimension(500,200));
        
        lbTTChung = new JLabel("THÔNG TIN CHUNG");
        lbTTChung.setForeground(xanhduong);
        lbTTChung.setSize(300,50);
        lbTTChung.setLocation(80,5);
        lbTTChung.setFont (new Font("Segoe UI Black", Font.BOLD,20));
        
        lbHoTen = new JLabel("Họ và Tên:");
        lbHoTen.setBounds(new Rectangle(20,60,160,30));
        lbHoTen.setFont(fonttext);
        lbHoTen.setForeground(xanhduong);
        txtHo = new JTextField();
        txtTen = new JTextField();
        txtHo.setFont(fonttext);
        txtTen.setFont(fonttext);
        txtHo.setBorder(createLineBorder(xanhduong));
        txtHo.setBounds(new Rectangle(190,60,200,30));
        txtTen.setBorder(createLineBorder(xanhduong));
        txtTen.setBounds(new Rectangle(400,60,80,30));
        
        lbGioiTinh = new JLabel("Giới tính:");
        lbGioiTinh.setBounds(new Rectangle(20,100,160,30));
        lbGioiTinh.setFont(fonttext);
        lbGioiTinh.setForeground(xanhduong);
        txtGioiTinh = new JTextField();
        txtGioiTinh.setBorder(createLineBorder(xanhduong));
        txtGioiTinh.setBounds(new Rectangle(190,100,100,30));
        txtGioiTinh.setFont(fonttext);
        
        lbNgaySinh = new JLabel("Ngày Sinh:");
        lbNgaySinh.setBounds(new Rectangle(20,140,160,30));
        lbNgaySinh.setFont(fonttext);
        lbNgaySinh.setForeground(xanhduong);
        int Nam = Calendar.getInstance().get(Calendar.YEAR); 
        int Thang = Calendar.getInstance().get(Calendar.MONTH);
        int Ngay = Calendar.getInstance().get(Calendar.DATE);
        cNam = new Choice();
        cNam.setFont(fonttext);
        for (int i = (Nam-18); i>=(Nam-40);i-- ){
            cNam.add(String.valueOf(i));
        }
        cNam.select("1999");
        cNam.setBounds(new Rectangle(310,140,100,30));
        
        cThang= new Choice();
        cThang.setFont(fonttext);
        for (int i = 1; i<=12; i++)
        {
            cThang.add(String.valueOf(i));
        }
        cThang.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                chonNgay();
            }
        });
        cThang.select("1");
        cThang.setBounds(new Rectangle(250,140,50,30));
        
        cNgay = new Choice();
        cNgay.setFont(fonttext);
        chonNgay();
        cNgay.setBounds(new Rectangle(190,140,50,30));
        
        
        
        lbNoiSinh = new JLabel("Nơi Sinh:");
        lbNoiSinh.setBounds(new Rectangle(20,180,160,30));
        lbNoiSinh.setFont(fonttext);
        lbNoiSinh.setForeground(xanhduong);
        txtNoiSinh = new JTextField();
        txtNoiSinh.setBorder(createLineBorder(xanhduong));
        txtNoiSinh.setBounds(new Rectangle(190,180,200,30));
        txtNoiSinh.setFont(fonttext);
        
        lbDiaChi = new JLabel("Địa Chỉ Thường Trú:");
        lbDiaChi.setBounds(new Rectangle(20,220,160,30));
        lbDiaChi.setFont(fonttext);
        lbDiaChi.setForeground(xanhduong);
        txtDiaChi = new JTextField();
        txtDiaChi.setBorder(createLineBorder(xanhduong));
        txtDiaChi.setBounds(new Rectangle(190,220,200,30));
        txtDiaChi.setFont(fonttext);
        
        lbDanToc = new JLabel("Dân Tộc:");
        lbDanToc.setBounds(new Rectangle(20,260,160,30));
        lbDanToc.setFont(fonttext);
        lbDanToc.setForeground(xanhduong);
        txtDanToc = new JTextField();
        txtDanToc.setBorder(createLineBorder(xanhduong));
        txtDanToc.setBounds(new Rectangle(190,260,200,30));
        txtDanToc.setFont(fonttext);
        
        lbTonGiao = new JLabel("Tôn Giáo:");
        lbTonGiao.setBounds(new Rectangle(20,300,160,30));
        lbTonGiao.setFont(fonttext);
        lbTonGiao.setForeground(xanhduong);
        txtTonGiao = new JTextField();
        txtTonGiao.setBorder(createLineBorder(xanhduong));
        txtTonGiao.setBounds(new Rectangle(190,300,200,30));
        txtTonGiao.setFont(fonttext);
        
        lbCMND = new JLabel("Chứng Minh Nhân Dân:");
        lbCMND.setBounds(new Rectangle(20,340,160,30));
        lbCMND.setFont(fonttext);
        lbCMND.setForeground(xanhduong);
        txtCMND = new JTextField();
        txtCMND.setBorder(createLineBorder(xanhduong));
        txtCMND.setBounds(new Rectangle(190,340,200,30));
        txtCMND.setFont(fonttext);
        
        lbTrinhDoHocVan= new JLabel("Trình Độ Học Vấn:");
        lbTrinhDoHocVan.setBounds(new Rectangle(20,380,160,30));
        lbTrinhDoHocVan.setFont(fonttext);
        lbTrinhDoHocVan.setForeground(xanhduong);
        txtTrinhDoHocVan = new JTextField();
        txtTrinhDoHocVan.setBorder(createLineBorder(xanhduong));
        txtTrinhDoHocVan.setBounds(new Rectangle(190,380,200,30));
        txtTrinhDoHocVan.setFont(fonttext);
        
        lbChuyenNganh = new JLabel("Chuyên Ngành");
        lbChuyenNganh.setBounds(new Rectangle(20,420,160,30));
        lbChuyenNganh.setFont(fonttext);
        lbChuyenNganh.setForeground(xanhduong);
        txtChuyenNganh = new JTextField();
        txtChuyenNganh.setBorder(createLineBorder(xanhduong));
        txtChuyenNganh.setBounds(new Rectangle(190,420,200,30));
        txtChuyenNganh.setFont(fonttext);
        
        
        //phần remark
        remark = new JPanel();
        remark.setLayout(null);
        remark.setPreferredSize(new Dimension(500,00));
        remark.setBackground(new Color(216,234,246));
        
        lbTTCongViec = new JLabel("THÔNG TIN CÔNG VIỆC");
        lbTTCongViec.setForeground(xanhduong);
        lbTTCongViec.setSize(300,50);
        lbTTCongViec.setLocation(80,5);
        lbTTCongViec.setFont (new Font("Segoe UI Black", Font.BOLD,20));
        
        lbMaNV = new JLabel("Mã Nhân Viên:");
        lbMaNV.setBounds(new Rectangle(20,60,160,30));
        lbMaNV.setFont(fonttext);
        lbMaNV.setForeground(xanhduong);
        txtMaNV = new JTextField();
        txtMaNV.setBorder(createLineBorder(xanhduong));
        txtMaNV.setBounds(new Rectangle(190,60,200,30));
        txtMaNV.setFont(fonttext);
        
        lbPhongBan = new JLabel("Phòng Ban:");
        lbPhongBan.setBounds(new Rectangle(20,100,160,30));
        lbPhongBan.setFont(fonttext);
        lbPhongBan.setForeground(xanhduong);
        txtPhongBan = new JTextField();
        txtPhongBan.setBorder(createLineBorder(xanhduong));
        txtPhongBan.setBounds(new Rectangle(190,100,100,30));
        txtPhongBan.setFont(fonttext);
        
        lbChucVu = new JLabel("Chức Vụ:");
        lbChucVu.setBounds(new Rectangle(20,140,160,30));
        lbChucVu.setFont(fonttext);
        lbChucVu.setForeground(xanhduong);
        txtChucVu = new JTextField();
        txtChucVu.setBorder(createLineBorder(xanhduong));
        txtChucVu.setBounds(new Rectangle(190,140,150,30));
        txtChucVu.setFont(fonttext);
        
        lbTGLamViec = new JLabel("Thời Gian Làm Việc:");
        lbTGLamViec.setBounds(new Rectangle(20,180,160,30));
        lbTGLamViec.setFont(fonttext);
        lbTGLamViec.setForeground(xanhduong);
        txtTGLamViec = new JTextField();
        txtTGLamViec.setBorder(createLineBorder(xanhduong));
        txtTGLamViec.setBounds(new Rectangle(190,180,200,30));
        txtTGLamViec.setFont(fonttext);
        
        lbTinhTrang = new JLabel("Trạng Thái Làm Việc:");
        lbTinhTrang.setBounds(new Rectangle(20,220,160,30));
        lbTinhTrang.setFont(fonttext);
        lbTinhTrang.setForeground(xanhduong);
        cTinhTrang = new Choice();
        cTinhTrang.setFont(fonttext);
        cTinhTrang.add("Chính thức");
        cTinhTrang.add("Nghỉ việc");
        cTinhTrang.select("Chính thức");
        cTinhTrang.setBounds(new Rectangle(190,220,200,30));
        
        lbSDT = new JLabel("Số điện thoại:");
        lbSDT.setBounds(new Rectangle(20,260,160,30));
        lbSDT.setFont(fonttext);
        lbSDT.setForeground(xanhduong);
        txtSDT = new JTextField();
        txtSDT.setBorder(createLineBorder(xanhduong));
        txtSDT.setBounds(new Rectangle(190,260,200,30));
        txtSDT.setFont(fonttext);
        
        lbEmail = new JLabel("Email :");
        lbEmail.setBounds(new Rectangle(20,300,160,30));
        lbEmail.setFont(fonttext);
        lbEmail.setForeground(xanhduong);
        txtEmail = new JTextField();
        txtEmail.setBorder(createLineBorder(xanhduong));
        txtEmail.setBounds(new Rectangle(190,300,200,30));
        txtEmail.setFont(fonttext);
        
        lbUser = new JLabel("Tên truy cập:");
        lbUser.setBounds(new Rectangle(20,340,160,30));
        lbUser.setFont(fonttext);
        lbUser.setForeground(xanhduong);
        txtUser = new JTextField();
        txtUser.setBorder(createLineBorder(xanhduong));
        txtUser.setBounds(new Rectangle(190,340,200,30));
        txtUser.setFont(fonttext);
        
        lbPass = new JLabel("Mật khẩu :");
        lbPass.setBounds(new Rectangle(20,380,160,30));
        lbPass.setFont(fonttext);
        lbPass.setForeground(xanhduong);
        txtPass = new JTextField();
        txtPass.setBorder(createLineBorder(xanhduong));
        txtPass.setBounds(new Rectangle(190,380,200,30));
        txtPass.setFont(fonttext);
        
        
        

        //phần footer
        footer = new JPanel();
        footer.setLayout(null);
        footer.setBackground(Color.ORANGE);
        footer.setPreferredSize(new Dimension(DWIDTH,100));
        btSaveAs = new JButton("Lưu Lại");
        ImageIcon save = new ImageIcon (getClass().getResource("/image/icon/saveas_30.png"));
        btSaveAs.setIcon(save);
        btSaveAs.setBounds(DWIDTH-250,15,150,50);
        btSaveAs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        
        
        //add các phần vào
        header.add(lbLogo);
        header.add(lbText);
        image.add(Iface);
        info.add(lbTTChung);
        info.add(lbHoTen);
        info.add(txtHo);
        info.add(txtTen);
        info.add(lbGioiTinh);
        info.add(txtGioiTinh);
        info.add(lbNgaySinh);
        info.add(cNgay);
        info.add(cThang);
        info.add(cNam);
        info.add(lbNoiSinh);
        info.add(txtNoiSinh);
        info.add(lbDiaChi);
        info.add(txtDiaChi);
        info.add(lbCMND);
        info.add(txtCMND);
        info.add(lbDanToc);
        info.add(txtDanToc);
        info.add(lbTonGiao);
        info.add(txtTonGiao);
        info.add(lbTrinhDoHocVan);
        info.add(txtTrinhDoHocVan);
        info.add(lbChuyenNganh);
        info.add(txtChuyenNganh);
        
        remark.add(lbTTCongViec);
        remark.add(lbMaNV);
        remark.add(txtMaNV);
        remark.add(lbPhongBan);
        remark.add(txtPhongBan);
        remark.add(lbChucVu);
        remark.add(txtChucVu);
        remark.add(lbTGLamViec);
        remark.add(txtTGLamViec);
        remark.add(lbTinhTrang);
        remark.add(cTinhTrang);
        remark.add(lbSDT);
        remark.add(txtSDT);
        remark.add(lbEmail);
        remark.add(txtEmail);
        remark.add(lbUser);
        remark.add(txtUser);
        remark.add(lbPass);
        remark.add(txtPass);
        
        footer.add(btSaveAs);
        
        
        
        add(header,BorderLayout.NORTH);
        add(image,BorderLayout.WEST);
        add(info,BorderLayout.CENTER);
        add(remark,BorderLayout.EAST);
        add(footer,BorderLayout.SOUTH);
        
        
        
    }
    
    public void chonNgay()
    {
        cNgay.removeAll();
        int Thangsl = Integer.parseInt(cThang.getSelectedItem());
        int Namsl = Integer.parseInt(cNam.getSelectedItem());
        if (Thangsl==1||Thangsl==3||
            Thangsl==5||Thangsl==7||
            Thangsl==8||Thangsl==10||
            Thangsl==12){
        for (int i = 1; i<=31; i++)
        {
            cNgay.add(String.valueOf(i));
        }}
        else {if (Thangsl==4||Thangsl==6||
                 Thangsl==9||Thangsl==11){
            for (int i = 1; i<=30; i++)
            {
            cNgay.add(String.valueOf(i));
            }
        }
            else{
             if (((Namsl% 4 == 0) && (Namsl % 100!= 0)) 
                   || (Namsl%400 == 0)){
                    for (int i = 1; i<=29; i++)
                    {
                        cNgay.add(String.valueOf(i));
                    }
             }
             else {
                    for (int i = 1; i<=28; i++)
                    {
                        cNgay.add(String.valueOf(i));
                    }
                    
        }
        }
        }
        cNgay.repaint();
        cNgay.select("1");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        ThongTinCaNhan thongtin = new ThongTinCaNhan();
        thongtin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thongtin.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
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
