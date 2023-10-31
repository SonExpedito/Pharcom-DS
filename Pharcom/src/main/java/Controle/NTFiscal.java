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
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author alexe
 */
public class NTFiscal extends JFrame {

    Conexao con_cliente;
    JLabel data,horario, nome, produto, quantidade;

    public NTFiscal(String nomeuser, String produtonome) {
        Container tela = getContentPane();

        ImageIcon icone = new ImageIcon("src/imagens/icone.png"); // Substitua pelo caminho correto do ícone
        setIconImage(icone.getImage());

        con_cliente = new Conexao();
        con_cliente.conecta();
        
        LocalDate datazina = LocalDate.now();
        LocalTime timezinho = LocalTime.now();
        String horaFormatada = timezinho.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        nome = new JLabel("Cliente: " + nomeuser);
        produto = new JLabel("Produto: " +produtonome);
        quantidade = new JLabel("Quantidade: 1");
        data = new JLabel ("Data: " +datazina);
        horario = new JLabel ("Hora: " +horaFormatada);
        
        nome.setForeground(new Color(43, 45, 66));
        nome.setFont(new Font("Tahoma", Font.BOLD, 12));
        nome.setBounds(50,220,200,100);
        
        produto.setForeground(new Color(43, 45, 66));
        produto.setFont(new Font("Tahoma", Font.BOLD, 12));
        produto.setBounds(50,250,200,100);
        
        quantidade.setForeground(new Color(43, 45, 66));
        quantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
        quantidade.setBounds(50,280,200,100);
        
        data.setForeground(new Color(43, 45, 66));
        data.setFont(new Font("Tahoma", Font.BOLD, 12));
        data.setBounds(50,310,200,100);
        
        horario.setForeground(new Color(43, 45, 66));
        horario.setFont(new Font("Tahoma", Font.BOLD, 12));
        horario.setBounds(50,340,200,100);
        
    

        
        tela.add(nome);
        tela.add(produto);
        tela.add(quantidade);
        tela.add(data);
        tela.add(horario);

        setTitle("Nota Fiscal");
        setResizable(false);
        tela.setLayout(null);

        ImagePanel backgroundPanel = new ImagePanel("src/imagens/NTFiscal.png");
        tela.add(backgroundPanel);
        backgroundPanel.setBounds(0, -20, backgroundPanel.getPreferredSize().width, backgroundPanel.getPreferredSize().height);

        setSize(300, 620);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args, String nomeuser, String produtonome) {
        NTFiscal menu = new NTFiscal(nomeuser, produtonome);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
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
