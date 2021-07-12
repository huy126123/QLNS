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
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nhật Quyên
 */
public class HoSoNhanVien extends JPanel  {
    private int DWIDTH;
    private JButton btThem, btXoa, btSua;
    private JTable tbDSNV;
    private DefaultTableModel mDSNV ;
    private JPanel bangDSNV;
    private JScrollBar thanhngang;
    
    HoSoNhanVien(int WIDTH){
        DWIDTH = WIDTH;
        init();
    }
    public void init(){
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, DWIDTH - 200, 1000));
        
        Font font0 = new Font("Segoe UI",Font.PLAIN,18);
        Font font1 = new Font("Segoe UI",Font.BOLD,20);
        
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
        
        
        
        
        
        
        //Bảng DSNV
        
        bangDSNV = new JPanel();
        bangDSNV.setLayout(new BorderLayout());
        bangDSNV.setSize(898,330);
        bangDSNV.setLocation(0, 90);
        
        /************** TẠO MODEL VÀ HEADER *********************/
        Vector header = new Vector();
        header.add("Phòng ban");
        header.add("Mă NV");
        header.add("Họ NV");
        header.add("Tên NV");
        header.add("Chức vụ");
        header.add("Giới tính");
        header.add("SĐT");
        header.add("Trạng Thái");
        header.add("Ngày Sinh");
        header.add("Nơi Sinh");
        header.add("CMND");
        header.add("Trình Độ Học Vấn");
        header.add("Chuyên Ngành");
        header.add("Địa Chỉ");
        header.add("Dân Tộc");
        header.add("Tôn Giáo");
        header.add("Thời Gian Làm Việc");
        header.add("Email");
        header.add("User");
        header.add("Pass");
        
        
        
        mDSNV = new DefaultTableModel(header,10);
        tbDSNV = new JTable();
        tbDSNV.setModel(mDSNV);
//        listSP(); //Đọc từ database lên table 
        
/*********************************************************/
        
/**************** TẠO TABLE ************************************************************/

        // Chỉnh width các cột 
        tbDSNV.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbDSNV.getColumnModel().getColumn(1).setPreferredWidth(90);
        tbDSNV.getColumnModel().getColumn(2).setPreferredWidth(150);
        tbDSNV.getColumnModel().getColumn(3).setPreferredWidth(80);
        tbDSNV.getColumnModel().getColumn(4).setPreferredWidth(95);
        tbDSNV.getColumnModel().getColumn(5).setPreferredWidth(80);
        tbDSNV.getColumnModel().getColumn(6).setPreferredWidth(80);
        tbDSNV.getColumnModel().getColumn(7).setPreferredWidth(120);
        tbDSNV.getColumnModel().getColumn(8).setPreferredWidth(0);
        tbDSNV.getColumnModel().getColumn(9).setPreferredWidth(0);
        tbDSNV.getColumnModel().getColumn(10).setPreferredWidth(0);
        tbDSNV.getColumnModel().getColumn(11).setPreferredWidth(0);
        tbDSNV.getColumnModel().getColumn(12).setPreferredWidth(0);
        tbDSNV.getColumnModel().getColumn(13).setPreferredWidth(0);
        tbDSNV.getColumnModel().getColumn(14).setPreferredWidth(0);
        tbDSNV.getColumnModel().getColumn(15).setPreferredWidth(0);
        tbDSNV.getColumnModel().getColumn(16).setPreferredWidth(0);
        tbDSNV.getColumnModel().getColumn(17).setPreferredWidth(0);
        tbDSNV.getColumnModel().getColumn(18).setPreferredWidth(0);
        tbDSNV.getColumnModel().getColumn(19).setPreferredWidth(0);
        


        // Custom table
        tbDSNV.setFocusable(false);
        tbDSNV.setIntercellSpacing(new Dimension(0,0));     
        tbDSNV.getTableHeader().setFont(font0);
        tbDSNV.setRowHeight(30);
        tbDSNV.setShowVerticalLines(true);              
        tbDSNV.getTableHeader().setOpaque(false);
        tbDSNV.setFillsViewportHeight(true);
        tbDSNV.getTableHeader().setBackground(new Color(1,153,253));
        tbDSNV.getTableHeader().setForeground(Color.WHITE);
        tbDSNV.setSelectionBackground(Color.ORANGE);
        tbDSNV.setShowGrid(true);
        tbDSNV.setShowHorizontalLines(true);
        
        
        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbDSNV,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(new Rectangle(0,0, this.DWIDTH  , 330));
        scroll.setBackground(null);
//        scroll.setLayout(new BorderLayout());
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(20,10));
        scroll.getHorizontalScrollBar().setPreferredSize(new Dimension(20,10));
        thanhngang = new JScrollBar();
        
        bangDSNV.add(scroll);
        
        //scroll.remove(sroll);
        //sp.remove(sb_width);
        //bangDSNV.setLayout(new BorderLayout());
        bangDSNV.add(scroll, BorderLayout.CENTER);
        bangDSNV.add(thanhngang, BorderLayout.SOUTH);
      //  jp.add(sb_width,BorderLayout.SOUTH);
/*****************************************************************************************/
        
        



        tbDSNV.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbDSNV.getSelectedRow();
                     
             }
        });
        
        
        
        
        
        add(btThem);
        add(btSua);
        add(btXoa);
        add(searchBox);
        add(bangDSNV);
       
        btThem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                ThongTinCaNhan thongtin = new ThongTinCaNhan();
                
            }
        });
        
        
    }
    
}
