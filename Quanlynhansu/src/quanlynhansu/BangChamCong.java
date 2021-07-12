/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhansu;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nhật Quyên
 */
public class BangChamCong extends JPanel {
    
    private int DWIDTH;
    private JButton btThem, btXoa, btSua, btChiTietNgayLam;
    private JTable tbTheoNgay, tbTheoThang, tbTheoNam;
    private DefaultTableModel mTheoNgay, mTheoThang, mTheoNam;
    private Choice chamCong, cNgay, cThang, cNam;
    private JScrollPane scCNgay, scCThang, scCNam;
    private Font font0 = new Font("Segoe UI",Font.PLAIN,18);
    private Font font1 = new Font("Segoe UI",Font.BOLD,20);
    
    BangChamCong(int WIDTH){
        DWIDTH = WIDTH;
        init();
    }
    public void init(){
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, DWIDTH - 200, 1000));
        
        
        
        
        // Các nút Thêm , Sửa, Xóa
        
        btThem = new JButton("Thêm");
        ImageIcon add = new ImageIcon(getClass().getResource("/image/icon/addfile_25.png"));
        btThem.setIcon(add);
        btThem.setBounds(20,20,120,30);
        btThem.setBackground(Color.ORANGE);
        btThem.setFont(font0);
        btThem.setForeground(Color.WHITE);
        btThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btSua = new JButton("Sửa");
        ImageIcon edit = new ImageIcon(getClass().getResource("/image/icon/editfile_25.png"));
        btSua.setIcon(edit);
        btSua.setBounds(220,20,120,30);
        btSua.setBackground(Color.ORANGE);
        btSua.setFont(font0);
        btSua.setForeground(Color.WHITE);
        btSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btXoa = new JButton("Xóa");
        ImageIcon delete = new ImageIcon(getClass().getResource("/image/icon/deletefile_25.png"));
        btXoa.setIcon(delete);
        btXoa.setBounds(420,20,120,30);
        btXoa.setBackground(Color.ORANGE);
        btXoa.setFont(font0);
        btXoa.setForeground(Color.WHITE);
        btXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //---thanh search--
        JPanel searchBox = new JPanel(null);
        searchBox.setBackground(null);
        searchBox.setBounds(new Rectangle(600, 20,250, 30)); 
        searchBox.setBorder(BorderFactory.createLineBorder(new Color(10,114,185))); //Chỉnh viền 
        
        //Phần TextField 
        JTextField txtSearch = new JTextField();
        txtSearch.setBounds(new Rectangle(5,0,300,30));
        txtSearch.setBorder(null);
        txtSearch.setOpaque(false);
        txtSearch.setFont(new Font("Segoe UI",Font.PLAIN,15));
        txtSearch.setForeground(new Color(10,114,185));
        txtSearch.setCaretColor(new Color(10,114,185));
        
        // Custem Icon search
        JLabel searchIcon = new JLabel(new ImageIcon("./src/image/icon/search_25.png"));
        searchIcon.setBounds(new Rectangle(200,-9,50,50));
        searchIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Add tất cả vào search box
        searchBox.add(searchIcon);
        searchBox.add(txtSearch);

        //bắt sự kiện Focus vào search box
        txtSearch.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) 
            {
                searchIcon.setIcon(new ImageIcon("./src/image/icon/searchactive_25.png")); //Đổi màu icon
                searchBox.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Đổi màu viền 
            }
            public void focusLost(FocusEvent e) //Trờ về như cũ
            {
                searchIcon.setIcon(new ImageIcon("./src/image/icon/search_25.png"));
                searchBox.setBorder(BorderFactory.createLineBorder(new Color(10,114,185))); 
            }
        });
        txtSearch.addKeyListener(new KeyAdapter (){
            public void keyPressed(KeyEvent e) 
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) //Khi nhất Enter
                {
//                    txtSearchKeyPressed();
                }
            }
        } ); 
        
        // Bảng Ngày , Tháng, Năm
        
        chamCong = new Choice();
        chamCong.add("Chọn");
        chamCong.add("Theo Ngày");
        chamCong.add("Theo Tháng");
        chamCong.setBounds(new Rectangle(50,80,150,30));
        chamCong.setFont(font0);
        int Nam = Calendar.getInstance().get(Calendar.YEAR); 
        int Thang = Calendar.getInstance().get(Calendar.MONTH);
        int Ngay = Calendar.getInstance().get(Calendar.DATE);
        cNam = new Choice();
        cNam.setFont(font0);
        for (int i = (Nam); i>=(Nam-3);i-- ){
            cNam.add(String.valueOf(i));
        }
        cNam.select("2019");
        cNam.setBounds(new Rectangle(310,140,100,30));
        
        cThang= new Choice();
        cThang.setFont(font0);
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
        cNgay.setFont(font0);
        chonNgay();
        cNgay.setBounds(new Rectangle(190,140,50,30));
        
        
        
        
        //Bảng Chọn Theo Ngày
        
        /************** TẠO MODEL VÀ HEADER *********************/
        Vector headerCN = new Vector();
        headerCN.add("STT");
        headerCN.add("Mă NV");
        headerCN.add("Họ NV");
        headerCN.add("Tên NV");
        headerCN.add("Chức vụ");
        headerCN.add("Phòng Ban");
        headerCN.add("Ca");
        headerCN.add("Vào 1");
        headerCN.add("Ra 1");
        headerCN.add("Vào 2");
        headerCN.add("Ra 2");
        
        mTheoNgay = new DefaultTableModel(headerCN,10);
        tbTheoNgay = new JTable();
        tbTheoNgay.setModel(mTheoNgay);
//        listSP(); //Đọc từ database lên table 
        
/*********************************************************/
        
/**************** TẠO TABLE ************************************************************/

        // Chỉnh width các cột 
        tbTheoNgay.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbTheoNgay.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbTheoNgay.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbTheoNgay.getColumnModel().getColumn(3).setPreferredWidth(130);
        tbTheoNgay.getColumnModel().getColumn(4).setPreferredWidth(120);
        tbTheoNgay.getColumnModel().getColumn(5).setPreferredWidth(120);
        tbTheoNgay.getColumnModel().getColumn(6).setPreferredWidth(80);
        tbTheoNgay.getColumnModel().getColumn(7).setPreferredWidth(80);
        tbTheoNgay.getColumnModel().getColumn(8).setPreferredWidth(80);
        tbTheoNgay.getColumnModel().getColumn(9).setPreferredWidth(80);
        tbTheoNgay.getColumnModel().getColumn(10).setPreferredWidth(80);


        // Custom table
        tbTheoNgay.setFocusable(false);
        tbTheoNgay.setIntercellSpacing(new Dimension(0,0));     
        tbTheoNgay.getTableHeader().setFont(font0);
        tbTheoNgay.setRowHeight(30);
        tbTheoNgay.setShowVerticalLines(true);              
        tbTheoNgay.getTableHeader().setOpaque(false);
        tbTheoNgay.setFillsViewportHeight(true);
        tbTheoNgay.getTableHeader().setBackground(new Color(1,153,253));
        tbTheoNgay.getTableHeader().setForeground(Color.WHITE);
        tbTheoNgay.setSelectionBackground(Color.ORANGE);          
        
        // Add table vào ScrollPane
        scCNgay = new JScrollPane(tbTheoNgay);
        scCNgay.setBounds(new Rectangle(0, 200, this.DWIDTH - 300 , 330));
        scCNgay.setBackground(null);
        scCNgay.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        
        add(scCNgay);
/*****************************************************************************************/
        
        



        tbTheoNgay.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbTheoNgay.getSelectedRow();
                     
             }
        });
        
        //Bảng Chọn Theo Tháng
        
        /************** TẠO MODEL VÀ HEADER *********************/
        Vector headerCT = new Vector();
        headerCT.add("STT");
        headerCT.add("Mă NV");
        headerCT.add("Họ NV");
        headerCT.add("Tên NV");
        headerCT.add("Chức vụ");
        headerCT.add("Phòng Ban");
        headerCT.add("Ngày Làm");
        headerCT.add("Vắng");
        headerCT.add("Đi Trễ");
        headerCT.add("Tăng Ca");
        headerCT.add("Tổng");
        
        
        
        mTheoNgay = new DefaultTableModel(headerCT,10);
        tbTheoNgay = new JTable();
        tbTheoNgay.setModel(mTheoNgay);
//        listSP(); //Đọc từ database lên table 
        
/*********************************************************/
        
/**************** TẠO TABLE ************************************************************/

        // Chỉnh width các cột 
        tbTheoNgay.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbTheoNgay.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbTheoNgay.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbTheoNgay.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbTheoNgay.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbTheoNgay.getColumnModel().getColumn(5).setPreferredWidth(100);
        tbTheoNgay.getColumnModel().getColumn(6).setPreferredWidth(100);
        tbTheoNgay.getColumnModel().getColumn(7).setPreferredWidth(80);
        tbTheoNgay.getColumnModel().getColumn(8).setPreferredWidth(100);
        tbTheoNgay.getColumnModel().getColumn(8).setPreferredWidth(80);
        tbTheoNgay.getColumnModel().getColumn(9).setPreferredWidth(80);


        // Custom table
        tbTheoNgay.setFocusable(false);
        tbTheoNgay.setIntercellSpacing(new Dimension(0,0));     
        tbTheoNgay.getTableHeader().setFont(font0);
        tbTheoNgay.setRowHeight(30);
        tbTheoNgay.setShowVerticalLines(true);              
        tbTheoNgay.getTableHeader().setOpaque(false);
        tbTheoNgay.setFillsViewportHeight(true);
        tbTheoNgay.getTableHeader().setBackground(new Color(1,153,253));
        tbTheoNgay.getTableHeader().setForeground(Color.WHITE);
        tbTheoNgay.setSelectionBackground(Color.ORANGE);          
        
        // Add table vào ScrollPane
        scCThang = new JScrollPane(tbTheoNgay);
        scCThang.setBounds(new Rectangle(0, 200, this.DWIDTH-300 , 330));
        scCThang.setBackground(null);
        scCThang.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        
        add(scCThang);
/*****************************************************************************************/
        
        



        tbTheoNgay.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbTheoNgay.getSelectedRow();
                     
             }
        });
        
        
        // add tất cả vào panel
        add(btThem);
        add(btSua);
        add(btXoa);
        add(searchBox);
        add(chamCong);
        add(cNgay);
        add(cThang);
        add(cNam);
        cNgay.setVisible(false);
        cThang.setVisible(false);
        cNam.setVisible(false);
        scCNgay.setVisible(false);
        scCThang.setVisible(false);
        
        
       
        btThem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                ThongTinCaNhan themtt = new ThongTinCaNhan();
            }
        });
        
        chamCong.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                    bangChamCong();
            }
        });
    }
    public void bangChamCong (){
        if("Theo Ngày".equals(chamCong.getSelectedItem()))
        {
        cNgay.setVisible(true);
        cThang.setVisible(true);
        cNam.setVisible(true);
        scCNgay.setVisible(true);
        scCThang.setVisible(false);
        }
        else if("Theo Tháng".equals(chamCong.getSelectedItem()))
        {
        cNgay.setVisible(false);
        cThang.setVisible(true);
        cNam.setVisible(true);
        scCNgay.setVisible(false);
        scCThang.setVisible(true);
        }
        else {
        cNgay.setVisible(false);
        cThang.setVisible(false);
        cNam.setVisible(false);
        scCNgay.setVisible(false);
        scCThang.setVisible(false);
        }
        
        
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
    
}
