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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Vector;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nhật Quyên
 */
public class ChiTietNgayLam extends JFrame implements MouseListener{
    
    private JPanel header, info, bangchamcong ,footer;
    private JLabel lbLogo, lbText,lbTTNhanVien,lbMaNV, lbPhongBan ,
            lbHoTen,lbChucVu, lbNgayLam, lbTangCa;
    private JTextField txtMaNV, txtPhongBan ,txtHo,txtTen, 
            txtChucVu;
    private JButton  btSaveAs;
    private int DWIDTH = 1150, DHEIGHT = 650;
    private JTable tbBCC;
    private DefaultTableModel mBCC ;
    
    
    
    public ChiTietNgayLam()
    {
         init();
    }
    public void init(){
        setTitle ("Bảng Chấm Công Tháng");
        ImageIcon logo = new ImageIcon(getClass().getResource("/image/icon/logo_64.png"));
        setIconImage(logo.getImage());
        setSize(DWIDTH, DHEIGHT);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        Font fonttext = new Font("Segoe UI",Font.PLAIN,15);
        Color xanhduong = new Color(10,114,185);
        
        //phần đầu
        header = new JPanel();
        header.setBackground(new Color(10,114,185));
        header.setLayout(null);
        header.setPreferredSize(new Dimension(DWIDTH,80));
        lbLogo = new JLabel(logo);
        lbLogo.setSize(55,45);
        lbLogo.setLocation(20,20);
        lbText = new JLabel("BẢNG CHẤM CÔNG THEO THÁNG");
        lbText.setForeground(Color.WHITE);
        lbText.setSize(500,50);
        lbText.setLocation(100,20);
        lbText.setFont (new Font("Segoe UI Black", Font.PLAIN,20));
  
        
        
        
        //phần info
        info = new JPanel();
        info.setLayout(null);
        info.setBackground(Color.WHITE);
        info.setPreferredSize(new Dimension(400,200));
        lbTTNhanVien = new JLabel("THÔNG TIN NHÂN VIÊN");
        lbTTNhanVien.setForeground(xanhduong);
        lbTTNhanVien.setSize(300,50);
        lbTTNhanVien.setLocation(50,5);
        lbTTNhanVien.setFont (new Font("Segoe UI Black", Font.BOLD,20));
        
        lbMaNV = new JLabel("Mã Nhân Viên:");
        lbMaNV.setBounds(new Rectangle(10,60,160,30));
        lbMaNV.setFont(fonttext);
        lbMaNV.setForeground(xanhduong);
        txtMaNV = new JTextField();
        txtMaNV.setBorder(createLineBorder(xanhduong));
        txtMaNV.setBounds(new Rectangle(120,60,200,30));
        txtMaNV.setFont(fonttext);
        
        lbHoTen = new JLabel("Họ và Tên:");
        lbHoTen.setBounds(new Rectangle(10,100,160,30));
        lbHoTen.setFont(fonttext);
        lbHoTen.setForeground(xanhduong);
        txtHo = new JTextField();
        txtTen = new JTextField();
        txtHo.setFont(fonttext);
        txtTen.setFont(fonttext);
        txtHo.setBorder(createLineBorder(xanhduong));
        txtHo.setBounds(new Rectangle(90,100,160,30));
        txtTen.setBorder(createLineBorder(xanhduong));
        txtTen.setBounds(new Rectangle(260,100,80,30));
        
        lbPhongBan = new JLabel("Phòng Ban:");
        lbPhongBan.setBounds(new Rectangle(10,140,160,30));
        lbPhongBan.setFont(fonttext);
        lbPhongBan.setForeground(xanhduong);
        txtPhongBan = new JTextField();
        txtPhongBan.setBorder(createLineBorder(xanhduong));
        txtPhongBan.setBounds(new Rectangle(90,140,100,30));
        txtPhongBan.setFont(fonttext);
        
        lbChucVu = new JLabel("Chức Vụ:");
        lbChucVu.setBounds(new Rectangle(10,180,160,30));
        lbChucVu.setFont(fonttext);
        lbChucVu.setForeground(xanhduong);
        txtChucVu = new JTextField();
        txtChucVu.setBorder(createLineBorder(xanhduong));
        txtChucVu.setBounds(new Rectangle(90,180,150,30));
        txtChucVu.setFont(fonttext);
        
        
        
        
        

        //phần bảng chấm công
        
        bangchamcong = new JPanel();
        bangchamcong.setLayout(null);
        bangchamcong.setPreferredSize(new Dimension(500,300));
        bangchamcong.setBackground(Color.WHITE);
        
       
        
        //phần footer
        footer = new JPanel();
        footer.setLayout(null);
        footer.setBackground(Color.WHITE);
        footer.setPreferredSize(new Dimension(DWIDTH,250));
        btSaveAs = new JButton("Lưu Lại");
        ImageIcon save = new ImageIcon (getClass().getResource("/image/icon/saveas_30.png"));
        btSaveAs.setIcon(save);
        btSaveAs.setBounds(DWIDTH-250,15,150,50);
        btSaveAs.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbNgayLam = new JLabel("Ngày Làm:");
        lbNgayLam.setBounds(new Rectangle(20,30,160,30));
        lbNgayLam.setFont(fonttext);
        lbNgayLam.setForeground(xanhduong);
        lbTangCa = new JLabel("Tăng Ca:");
        lbTangCa.setBounds(new Rectangle(20,60,160,30));
        lbTangCa.setFont(fonttext);
        lbTangCa.setForeground(xanhduong);
         /************** TẠO MODEL VÀ HEADER *********************/
        Vector hdbang = new Vector();
        for (int i=1;i<=31;i++){
            hdbang.add(Integer.valueOf(i));
        }
        mBCC = new DefaultTableModel(hdbang,2);
        tbBCC = new JTable();
        tbBCC.setModel(mBCC);
//        listSP(); //Đọc từ database lên table 
        
/*********************************************************/
        
/**************** TẠO TABLE ************************************************************/

        // Chỉnh width các cột 
        for (int i=0; i<=30;i++)
        {
            tbBCC.getColumnModel().getColumn(i).setPreferredWidth(10);
        }


        // Custom table
        tbBCC.setFocusable(false);
        tbBCC.setIntercellSpacing(new Dimension(0,0));     
        tbBCC.getTableHeader().setFont(new Font("Segoe UI",Font.PLAIN,15));
        tbBCC.setRowHeight(30);
        tbBCC.setShowVerticalLines(true);              
        tbBCC.getTableHeader().setOpaque(false);
        tbBCC.setFillsViewportHeight(true);
        tbBCC.getTableHeader().setBackground(new Color(1,153,253));
        tbBCC.getTableHeader().setForeground(Color.WHITE);
        tbBCC.setSelectionBackground(Color.ORANGE);          
        
        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbBCC);
        scroll.setBounds(new Rectangle(120, 0, this.DWIDTH - 200 ,88));
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        
       // add(scroll);
/*****************************************************************************************/
        
        



        tbBCC.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbBCC.getSelectedRow();
                     
             }
        });
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        header.add(lbLogo);
        header.add(lbText);
        info.add(lbTTNhanVien);
        info.add(lbHoTen);
        info.add(txtHo);
        info.add(txtTen);
        info.add(lbMaNV);
        info.add(txtMaNV);
        info.add(lbPhongBan);
        info.add(txtPhongBan);
        info.add(lbChucVu);
        info.add(txtChucVu);
        footer.add(scroll);
        footer.add(lbNgayLam);
        footer.add(lbTangCa);
        
        
        
        add(header,BorderLayout.NORTH);
        add(info,BorderLayout.WEST);
        add(bangchamcong,BorderLayout.CENTER);
        add(footer,BorderLayout.SOUTH);
        
        
    }
        
        
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        ChiTietNgayLam chitiet = new ChiTietNgayLam();
        chitiet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chitiet.setVisible(true);
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

