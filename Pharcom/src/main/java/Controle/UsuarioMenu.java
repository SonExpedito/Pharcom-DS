/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Conexão.Conexao;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author dti
 */
public class UsuarioMenu extends JFrame{
    Conexao con_cliente;
    JLabel ilogo,titulo,imedicamento,iinfantil;
    JButton medicamentolink, infantillink;
    
    public UsuarioMenu(){
        Container tela = getContentPane();
        tela.setBackground(new Color(237,241,243));
        ImageIcon icone = new ImageIcon("src/imagens/icone.png"); // Substitua pelo caminho correto do ícone
        setIconImage(icone.getImage());

        con_cliente = new Conexao();
        con_cliente.conecta();
        
        //Logo
         ImageIcon logo = createResizedImageIcon("src/imagens/admicone.png", 700, 500);
          ilogo = new JLabel(logo);
        ilogo.setBounds(200,-10,700,500);
        
        //Titulo
        titulo = new JLabel("Categorias");
        titulo.setBounds(190,5,200,100);
         titulo.setForeground(new Color(43,45,66));
         titulo.setFont(new Font("Tahoma",Font.BOLD,30));

         
         //Icones

        ImageIcon admins = new ImageIcon("src/imagens/medicamento.png");
        ImageIcon remedios = new ImageIcon("src/imagens/mamadeira.png");
        
        iinfantil= new JLabel(remedios);
        imedicamento= new JLabel(admins);
     
         
        setTitle("Menu-Usuario");
        setResizable(false);
        tela.setLayout(null);

        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);

        JMenu operacoesMenu = new JMenu("Produtos");
        JMenuItem medicamentioitem = new JMenuItem("Medicamento");
        JMenuItem infantilitem = new JMenuItem("Infantil");
       

        JMenu Menusair = new JMenu("Sair");
        JMenuItem MenusairItem = new JMenuItem("Sair");
         
        JMenu MenuSobre = new JMenu("Sobre");
        JMenuItem MenuSobreItem = new JMenuItem("Sobre");
         
        JMenu Menuvoltar = new JMenu("Voltar");
        JMenuItem MenuvoltarItem = new JMenuItem("Voltar"); 
       
        operacoesMenu.add(medicamentioitem);
        operacoesMenu.add(infantilitem);
       
        
        Menusair.add(MenusairItem);
        MenuSobre.add(MenuSobreItem);
        Menuvoltar.add(MenuvoltarItem);
        
       barra.add(operacoesMenu);
       barra.add(MenuSobre);
       barra.add(Menuvoltar);
       barra.add(Menusair); 
        
        medicamentioitem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Funcionarios fun = new Funcionarios();
                    fun.setVisible(true);
                    dispose();
                } catch (SQLException | ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });

        infantilitem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Remedio fun = new Remedio();
                    fun.setVisible(true);
                    dispose();
                } catch (SQLException | ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });


        
         MenuvoltarItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Login adm;
                adm = new Login();
                adm.setVisible(true);
                dispose();
               
            }
        });
         MenusairItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                           int opcao;
                            Object[] botoes = {"Sim","Não"};
                             opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo fechar a janela?","Fechar",
                          JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
                                    if(opcao==JOptionPane.YES_OPTION)System.exit(0);
              } 
                }
                  );
         
         MenuSobreItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    
                    Sobrenos fun = new Sobrenos();
                    fun.setVisible(true);
                    dispose();
           
            }
        });


        medicamentolink = new JButton("Medicamentos");
        infantillink = new JButton("Infantil");
       
        
        medicamentolink.setBackground(new Color(239,35,60)); // Define a cor de fundo do botão como azul
        medicamentolink.setForeground(new Color(237,242,244)); 
        
        infantillink.setBackground(new Color(239,35,60)); // Define a cor de fundo do botão como azul
        infantillink.setForeground(new Color(237,242,244)); 
        

         medicamentolink.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    Funcionarios fun = new Funcionarios();
                    fun.setVisible(true);
                    dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(MenuAdm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(MenuAdm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        infantillink.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    Remedio fun = new Remedio();
                    fun.setVisible(true);
                    dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(MenuAdm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(MenuAdm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        
               
                
        medicamentolink.setBounds(170, 95, 150, 30);
        imedicamento.setBounds(70, 95, 150, 30);
        
        infantillink.setBounds(170, 195, 150, 30);
        iinfantil.setBounds(70, 195, 150, 30);
        
  
 
        
        
        tela.add(imedicamento);
        tela.add(iinfantil);
        tela.add(titulo);
        tela.add(ilogo);
        tela.add(medicamentolink);
        tela.add(infantillink);
        

         ImagePanel backgroundPanel = new ImagePanel("src/imagens/backgroundlogin.png");
        tela.add(backgroundPanel);
        backgroundPanel.setBounds(0, -20, backgroundPanel.getPreferredSize().width, backgroundPanel.getPreferredSize().height);
        
        setSize(800, 450);
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
            public static void main(String [] args){
                                 try {
            UsuarioMenu menu = new UsuarioMenu();
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (UnsupportedLookAndFeelException e) {

            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();

        } catch (InstantiationException e) {

            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();

        } catch (IllegalAccessException e) {

            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    
            };
    
    private ImageIcon createResizedImageIcon(String imagePath, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(backgroundImage.getWidth(this), backgroundImage.getHeight(this));
    }
}
    
}

