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
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
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
public class UsuarioMenu extends JFrame {

    Conexao con_cliente;
    JLabel titulo, product1name, product2name, product3name, productname4,
            product1image, productimage2, productimage3, productimage4;

    JButton product1button, product2button, product3button, product4button;

    public UsuarioMenu(int Id_user, String nomeuser) {
        con_cliente = new Conexao();

        con_cliente.conecta();

        Container tela = getContentPane();
        tela.setBackground(new Color(237, 241, 243));
        ImageIcon icone = new ImageIcon("src/imagens/icone.png"); // Substitua pelo caminho correto do ícone
        setIconImage(icone.getImage());

        int IDuser = Id_user;
        String clientename = nomeuser;

        //Logo
        ImageIcon pi1 = createResizedImageIcon("src/imagens/dorflex.png", 140 ,120);
        product1image = new JLabel(pi1);
        product1image.setBounds(80, 130, 140, 120);
        tela.add(product1image);

        ImageIcon pi2 = createResizedImageIcon("src/imagens/cetoprofeno.png", 150, 150);
        productimage2 = new JLabel(pi2);
        productimage2.setBounds(260, 110, 150, 150);
        tela.add(productimage2);

        ImageIcon  pi3= createResizedImageIcon("src/imagens/Desloratadina.png", 80, 130);
        productimage3 = new JLabel(pi3);
        productimage3.setBounds(450, 110, 80, 130);
        tela.add(productimage3);

        ImageIcon  pi4 = createResizedImageIcon("src/imagens/Methiolate.png", 70, 130);
        productimage4 = new JLabel(pi4);
        productimage4.setBounds(620, 110, 70, 130);
        tela.add(productimage4);

        product1button = new JButton("Comprar");
        product2button = new JButton("Comprar");
        product3button = new JButton("Comprar");
        product4button = new JButton("Comprar");

        product1button.setBackground(new Color(239, 35, 60)); // Define a cor de fundo do botão como azul
        product1button.setForeground(new Color(237, 242, 244));

        product2button.setBackground(new Color(239, 35, 60)); // Define a cor de fundo do botão como azul
        product2button.setForeground(new Color(237, 242, 244));

        product3button.setBackground(new Color(239, 35, 60)); // Define a cor de fundo do botão como azul
        product3button.setForeground(new Color(237, 242, 244));

        product4button.setBackground(new Color(239, 35, 60)); // Define a cor de fundo do botão como azul
        product4button.setForeground(new Color(237, 242, 244));

        product1button.setBounds(80, 240, 150, 30);
        product2button.setBounds(260, 240, 150, 30);
        product3button.setBounds(420, 240, 150, 30);
        product4button.setBounds(580, 240, 150, 30);

        //Titulo
        titulo = new JLabel("Produtos");
        titulo.setBounds(310, 5, 200, 100);
        titulo.setForeground(new Color(43, 45, 66));
        titulo.setFont(new Font("Tahoma", Font.BOLD, 30));

        product1name = new JLabel("Dorflex");
        product1name.setBounds(120, 55, 200, 100);
        product1name.setForeground(new Color(43, 45, 66));
        product1name.setFont(new Font("Tahoma", Font.BOLD, 15));

        product2name = new JLabel("Cetoprofeno");
        product2name.setBounds(290, 55, 200, 100);
        product2name.setForeground(new Color(43, 45, 66));
        product2name.setFont(new Font("Tahoma", Font.BOLD, 15));

        product3name = new JLabel("Desloratadina");
        product3name.setBounds(450, 45, 200, 100);
        product3name.setForeground(new Color(43, 45, 66));
        product3name.setFont(new Font("Tahoma", Font.BOLD, 15));

        productname4 = new JLabel("Merthiolate");
        productname4.setBounds(610, 45, 200, 100);
        productname4.setForeground(new Color(43, 45, 66));
        productname4.setFont(new Font("Tahoma", Font.BOLD, 15));

        product1button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = 1;
                int qtd = 1;
                String produtonome = "Dorflex";
                LocalDate datevar = LocalDate.now();

                try {
                    String insert_sql = "INSERT INTO registro_compra(Id_Remedio, Id_Cliente, Data_compra, Quantidade) VALUES ('" + id + "','" + IDuser + "','" + datevar + "','" + qtd + "')";
                    con_cliente.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Compra Realizada com Sucesso");
                    
                    NTFiscal notinha = new NTFiscal(nomeuser,produtonome);
                    notinha.setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioMenu.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
         product2button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = 2;
                int qtd = 1;
                String produtonome = "Cetoprofeno";
                LocalDate datevar = LocalDate.now();

                try {
                    String insert_sql = "INSERT INTO registro_compra(Id_Remedio, Id_Cliente, Data_compra, Quantidade) VALUES ('" + id + "','" + IDuser + "','" + datevar + "','" + qtd + "')";
                    con_cliente.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Compra Realizada com Sucesso");
                    
                    NTFiscal notinha = new NTFiscal(nomeuser,produtonome);
                    notinha.setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioMenu.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
         
         product3button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = 2;
                int qtd = 1;
                String produtonome = "Desloratadina";
                LocalDate datevar = LocalDate.now();

                try {
                    String insert_sql = "INSERT INTO registro_compra(Id_Remedio, Id_Cliente, Data_compra, Quantidade) VALUES ('" + id + "','" + IDuser + "','" + datevar + "','" + qtd + "')";
                    con_cliente.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Compra Realizada com Sucesso");
                    NTFiscal notinha = new NTFiscal(nomeuser,produtonome);
                    notinha.setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioMenu.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
         
         product4button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = 2;
                int qtd = 1;
                String produtonome = "Merthiolate";
                LocalDate datevar = LocalDate.now();

                try {
                    String insert_sql = "INSERT INTO registro_compra(Id_Remedio, Id_Cliente, Data_compra, Quantidade) VALUES ('" + id + "','" + IDuser + "','" + datevar + "','" + qtd + "')";
                    con_cliente.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Compra Realizada com Sucesso");
                    NTFiscal notinha = new NTFiscal(nomeuser,produtonome);
                    notinha.setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioMenu.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        tela.add(product1name);
        tela.add(product2name);
        tela.add(product3name);
        tela.add(productname4);

        tela.add(product1button);
        tela.add(product2button);
        tela.add(product3button);
        tela.add(product4button);

        setTitle("Menu-Usuario");
        setResizable(false);
        tela.setLayout(null);

        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);

        JMenu Menusair = new JMenu("Sair");
        JMenuItem MenusairItem = new JMenuItem("Sair");

        JMenu MenuSobre = new JMenu("Sobre");
        JMenuItem MenuSobreItem = new JMenuItem("Sobre");

        JMenu Menuvoltar = new JMenu("Voltar");
        JMenuItem MenuvoltarItem = new JMenuItem("Voltar");

        Menusair.add(MenusairItem);
        MenuSobre.add(MenuSobreItem);
        Menuvoltar.add(MenuvoltarItem);

        barra.add(MenuSobre);
        barra.add(Menuvoltar);
        barra.add(Menusair);

        MenuvoltarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login adm;
                adm = new Login();
                adm.setVisible(true);
                dispose();

            }
        });
        MenusairItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcao;
                Object[] botoes = {"Sim", "Não"};
                opcao = JOptionPane.showOptionDialog(null, "Deseja mesmo fechar a janela?", "Fechar",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoes, botoes[0]);
                if (opcao == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
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

        tela.add(titulo);

        ImagePanel backgroundPanel = new ImagePanel("src/imagens/backgroundlogin.png");
        tela.add(backgroundPanel);
        backgroundPanel.setBounds(0, -20, backgroundPanel.getPreferredSize().width, backgroundPanel.getPreferredSize().height);

        setSize(800, 450);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args, int Id_user, String nomeuser) {
        try {
            UsuarioMenu menu = new UsuarioMenu(Id_user, nomeuser);
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {

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

    }

    ;

    
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
