package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import source.pingulangCompiler;  
import source.SimpleNode;
import source.ParseException;
import source.TokenMgrError;
import source.Token;


public class TelaCompilador extends JPanel implements ActionListener{
	
	private pingulangCompiler parser = null; //parser
	private JTextArea codigoArea; //Area de texto para editar o codigo
	private JTextArea retornoArea; //Area de display do retorno do compilador
	
	private JTree arvoreSintatica;
	private DefaultMutableTreeNode raizArvore;
	private JButton compilaBotao; //Botao para compilar o codigo
	private JScrollPane codigoScroll;
	private ContadorLinha contadorLinhas;
	
	private JButton abrirArquivoBotao;
	
	//paleta de cores
	private final Color SOFT_PINK = new Color(0xFE, 0xC5, 0xF6); // FEC5F6
    private final Color BUTTON_PINK = new Color(0xDB, 0x8D, 0xD0); // DB8DD0
    private final Color DARK_PINK = new Color(0xB3, 0x37, 0x91); // B33791
    private final Color CONTRAST_PINK = new Color(0xC5, 0x62, 0xAF); // C562AF
    private final Color TEXT_COLOR = new Color(0x33, 0x00, 0x2B); // Dark purple for contrast
	
	public TelaCompilador() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        setLayout(new BorderLayout());
        setBackground(DARK_PINK); //COR DE FUNDO

        //definindo as areas
        codigoArea = new JTextArea();
        retornoArea = new JTextArea();
        
        // Iniciando a arvore com um no raiz gernerico
        raizArvore = new DefaultMutableTreeNode("Arvore Sintatica");
        arvoreSintatica = new JTree(raizArvore);
        arvoreSintatica.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 14));
        arvoreSintatica.setBackground(SOFT_PINK);
        arvoreSintatica.setForeground(TEXT_COLOR);

        //UTF-8
        Font font = new Font("DejaVu Sans Mono", Font.PLAIN, 14);
        codigoArea.setFont(font);
        retornoArea.setFont(font);
        
        // Cor das areas
        codigoArea.setBackground(SOFT_PINK);
        codigoArea.setForeground(TEXT_COLOR);
        codigoArea.setCaretColor(TEXT_COLOR);
        codigoArea.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(CONTRAST_PINK, 2),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        retornoArea.setBackground(SOFT_PINK);
        retornoArea.setForeground(TEXT_COLOR);
        retornoArea.setEditable(false);
        retornoArea.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(CONTRAST_PINK, 2),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        
        //botao
        compilaBotao = new JButton("▶ Compilar");
        compilaBotao.addActionListener(this);
        compilaBotao.setBackground(BUTTON_PINK);
        compilaBotao.setForeground(Color.BLACK);
        compilaBotao.setFocusPainted(false);
        compilaBotao.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(CONTRAST_PINK, 2),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        compilaBotao.setFont(font.deriveFont(Font.BOLD));
        
        //hover
        compilaBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                compilaBotao.setBackground(CONTRAST_PINK);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                compilaBotao.setBackground(BUTTON_PINK);
            }
        });
        
        // Botao para abrir o arquivo
        abrirArquivoBotao = new JButton("Abrir Arquivo");
        abrirArquivoBotao.setBackground(BUTTON_PINK);
        abrirArquivoBotao.setForeground(Color.BLACK);
        abrirArquivoBotao.setFocusPainted(false);
        abrirArquivoBotao.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(CONTRAST_PINK, 2),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        abrirArquivoBotao.setFont(compilaBotao.getFont());

        // Hover efeito igual ao compilaBotao
        abrirArquivoBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abrirArquivoBotao.setBackground(CONTRAST_PINK);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abrirArquivoBotao.setBackground(BUTTON_PINK);
            }
        });

        // Acaoo ao clicar para abrir o arquivo:
        abrirArquivoBotao.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int retorno = chooser.showOpenDialog(this);
            if (retorno == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String linha;
                    StringBuilder conteudo = new StringBuilder();
                    while ((linha = reader.readLine()) != null) {
                        conteudo.append(linha).append("\n");
                    }
                    codigoArea.setText(conteudo.toString());
                    retornoArea.setText(""); // limpa área de retorno ao abrir novo arquivo
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo: " + ex.getMessage());
                }
            }
        });


        //contador de linhas
        codigoScroll = new JScrollPane(codigoArea);
        contadorLinhas = new ContadorLinha(codigoArea);
        contadorLinhas.setBackground(Color.WHITE);
        contadorLinhas.setForeground(Color.BLACK);
        //scroll
        codigoScroll.setRowHeaderView(contadorLinhas);
        codigoScroll.setBorder(BorderFactory.createEmptyBorder());
        codigoScroll.getViewport().setBackground(SOFT_PINK);
        
        //painel do botao
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(DARK_PINK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        buttonPanel.add(abrirArquivoBotao);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.weightx = 1.0;
        buttonPanel.add(compilaBotao, gbc);
        
        //painel de componentes
        JPanel containerPanel = new JPanel(new GridBagLayout());
        containerPanel.setBackground(DARK_PINK);
        
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.weightx = 1.0;
        gbcMain.weighty = 1.0;
        gbcMain.fill = GridBagConstraints.BOTH;
        containerPanel.add(codigoScroll, gbcMain);

        gbcMain.gridy = 1;
        gbcMain.weighty = 0;
        gbcMain.fill = GridBagConstraints.HORIZONTAL;
        gbcMain.anchor = GridBagConstraints.WEST;
        containerPanel.add(buttonPanel, gbcMain);

        //dividir areas
        JScrollPane retornoScroll = new JScrollPane(retornoArea);
        JScrollPane arvoreScroll = new JScrollPane(arvoreSintatica);

        JSplitPane painelInferior = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, retornoScroll, arvoreScroll);
        painelInferior.setDividerLocation(0.5);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, containerPanel, painelInferior);

        
        splitPane.setDividerLocation(500);
        splitPane.setBorder(BorderFactory.createLineBorder(DARK_PINK, 5));
        splitPane.setBackground(DARK_PINK);

        add(splitPane, BorderLayout.CENTER);
    }

	//lidar com o retorno
	private static class CustomOutputStream extends OutputStream {
	    private JTextArea areaSaida;
	    private Charset charset = StandardCharsets.UTF_8;
	    
	    public CustomOutputStream(JTextArea textArea) {
	        this.areaSaida = textArea;
	    }
	    
	    /*@Override
	    public void write(int b) throws IOException {
	    	areaSaida.append(String.valueOf((char) b));
	    	areaSaida.setCaretPosition(areaSaida.getDocument().getLength());
	    }*/
	    
	    //ACENTOS ACENTOS
	    @Override
	    public void write(int b) throws IOException {
	        byte[] bytes = new byte[] {(byte)b};
	        String str = new String(bytes, charset);
	        areaSaida.append(str);
	        areaSaida.setCaretPosition(areaSaida.getDocument().getLength());
	    }
	    
	    @Override
	    public void write(byte[] b, int off, int len) throws IOException {
	        String str = new String(b, off, len, charset);
	        areaSaida.append(str);
	        areaSaida.setCaretPosition(areaSaida.getDocument().getLength());
	    }
	}
	
	
	public void iniciar(JFrame tela) {
		try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/frame/imgs/pingu.jpg"));
            
            int iconWidth = 164;
            int iconHeight = 164;
            
            Image originalImage = icon.getImage();

	         Image scaledImage = originalImage.getScaledInstance(
	             iconWidth, 
	             iconHeight, 
	             Image.SCALE_SMOOTH  // Note: This should be Image.SCALE_SMOOTH, not ImageIcon.SCALE_SMOOTH
	         );
            
            tela.setIconImage(icon.getImage());
        } catch (Exception e) {
            System.err.println("Could not load icon: " + e.getMessage());
        }
        
        tela.setContentPane(this);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)(screenSize.width * 0.8);
        int height = (int)(screenSize.height * 0.8);
        tela.setPreferredSize(new Dimension(width, height));
        
        // centralizar
        tela.setLocationRelativeTo(null);
        
        tela.pack();
        tela.setVisible(true);
	}
	
	private void criarArvoreSintatica(SimpleNode no, DefaultMutableTreeNode noPai) {
	    DefaultMutableTreeNode novoNo = new DefaultMutableTreeNode(no.toString());
	    noPai.add(novoNo);
	    
	    for (int i = 0; i < no.jjtGetNumChildren(); i++) {
	        SimpleNode filho = (SimpleNode) no.jjtGetChild(i);
	        criarArvoreSintatica(filho, novoNo);
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String codigo = codigoArea.getText();
        retornoArea.setText(""); // Clear 

        PrintStream ps;
        try {
            ps = new PrintStream(new CustomOutputStream(retornoArea), true, "UTF-8");
            System.setOut(ps);
            System.setErr(ps);
        } catch (UnsupportedEncodingException e1) {
        	retornoArea.append("Erro de codificação de caractere:\n" + e1.getMessage());
        }


        try {
            Reader input = new StringReader(codigo);
            
            if (parser == null) {
                parser = new pingulangCompiler(input);
            } else {
                parser.ReInit(input);
            }
            
            
            Token t;
            System.err.println("Tokens reconhecidos:");
            while (true) {
                t = parser.getNextToken();
                if (t.image.equals("") || t.kind == 0) break;

                System.err.printf("Classe: %-15s Lexema: %-15s Linha: %d Coluna: %d%n",
                    pingulangCompiler.tokenImage[t.kind],
                    t.image,
                    t.beginLine,
                    t.beginColumn
                );
            }
            System.err.println("----------------------");

            // Reinicializa parser para análise sintática após exibir tokens
            parser.ReInit(new StringReader(codigo));
            SimpleNode n = pingulangCompiler.Programa();
            System.err.println("Código compilado com sucesso");
            System.err.flush();

            
            raizArvore.removeAllChildren(); // limpa árvore anterior
            criarArvoreSintatica(n, raizArvore);
            ((DefaultTreeModel) arvoreSintatica.getModel()).reload();

            
        } catch (ParseException ex) {
            System.err.println("Erro de sintaxe:");
            System.err.println(ex.getMessage());
            System.err.flush();
        } catch (TokenMgrError ex) {
            System.err.println("Erro léxico:");
            System.err.println(ex.getMessage());
            System.err.flush();
        } catch (Exception ex) {
            System.err.println("Erro inesperado:");
            ex.printStackTrace();
            System.err.flush();
        }
	}
}
