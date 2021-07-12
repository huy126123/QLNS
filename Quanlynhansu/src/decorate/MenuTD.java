/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorate;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nhật Quyên
 */
public class MenuTD extends JPanel implements MouseListener{
    private JLabel td,icon;
    private boolean active ;
    private String name,Iplus,Iminus;
    private Color hover = new Color(1,153,253);
    private Color normal = new Color(10,114,185);
    private Rectangle khung = new Rectangle();
    public MenuTD(String s,Rectangle kh,String Iplus,String Iminus)
    {
        name = s;
        td = new JLabel(name);
        this.Iplus = Iplus;
        this.Iminus = Iminus;
        this.icon = new JLabel();
        khung = kh;
        init();
    }
    public MenuTD(String s,Rectangle kh,String Iplus,String Iminus, Color hover)
    {
        name = s;
        td = new JLabel(name);
        this.Iplus = Iplus;
        this.Iminus = Iminus;
        this.icon = new JLabel();
        khung = kh;
        this.hover = hover;
        init();
    }
    public MenuTD(String s,Rectangle kh)
    {
        td = new JLabel(s);
        icon = new JLabel();
        khung = kh ;
        init();
    }
    public void init()
    {

        addMouseListener(this);
        Font font = new Font("Segoe UI",Font.BOLD,12);
        setLayout(null);
        setBounds(khung);
        setBackground(null);
        
        icon.setIcon(new ImageIcon(getClass().getResource("/image/icon/plus_28.png")));
        icon.setBackground(Color.ORANGE);
        icon.setBounds(new Rectangle(khung.width/7 , khung.height/4, 50, 30));
        
        td.setFont(font);
        td.setForeground(Color.white);
        td.setBounds(new Rectangle(khung.width/4+10, khung.height/4, 250, 30));
           
        if(active)
        {
            setBackground(Color.ORANGE);
        }
        else
        {
            setBackground(null);
        } 
        add(icon);
        add(td);
        
    }
    public void setActive(boolean a)
    {
        active = a;
        
    }

    public String getName() {
        return name;
    }
    
    public void doActive()
    {
        active = true;
        icon.setIcon(new ImageIcon(getClass().getResource("/image/icon/minus_28.png")));
        //td.setForeground(Color.WHITE);
        setBackground(Color.ORANGE);
    }
    public void noActive()
    {
        active = false;
        icon.setIcon(new ImageIcon(getClass().getResource("/image/icon/plus_28.png")));
        //td.setForeground(Color.WHITE);
        setBackground(null);
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
      if(!active)
        {
            setBackground(hover);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(!active)
        {
            setBackground(normal);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    
    
    
}
