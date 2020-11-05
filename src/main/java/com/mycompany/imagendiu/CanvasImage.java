/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imagendiu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

/**
 *
 * @author Sara
 */
public class CanvasImage extends JPanel{
    
    private BufferedImage imageno, imagen, logo;
    private int pos;
    
    public CanvasImage(){
        try{
            imageno = ImageIO.read(new URL("https://www.theartwolf.com/services/wallpapers/aivazovsky_wave-1024-768.jpg"));
            imagen = ImageIO.read(new URL("https://www.theartwolf.com/services/wallpapers/aivazovsky_wave-1024-768.jpg"));
            this.setPreferredSize(new Dimension(imagen.getWidth(),imagen.getHeight()));
            pos = 0;
            logo = ImageIO.read(new URL("https://images.vexels.com/media/users/3/128297/isolated/lists/381968e81c737e4ae2a10f46f062ed2b-icono-de-croissant-rosa-neon.png"));
        }catch(IOException e){}
    }
    
    public void setImage(BufferedImage imagen){
        this.imagen = imagen;
        repaint();
    }
    
    public BufferedImage getImage(){
        return imageno;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagen,0,0,null);
        switch(pos%4){
            case 0: g.drawImage(logo,0,0,null);
            break;
            case 1: g.drawImage(logo,this.getWidth()-logo.getWidth(),0,null);
            break;
            case 2: g.drawImage(logo,this.getWidth()-logo.getWidth(),this.getHeight()-logo.getHeight(),null);
            break;
            case 3: g.drawImage(logo,0,this.getHeight()-logo.getHeight(),null);
            break;
        }
    }
    
    public void setPos(int pos){
        this.pos = pos%4;
        repaint();
    }
}
