package Tela;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Editor extends JFrame {

	
	private JPanel contentPane;
	private static JTextArea lines;
	
	public static void main(String[] args) {
		
	}

	public Editor() {
		setTitle("Titulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 644);
		contentPane = new JPanel();
		setMinimumSize(new Dimension(912, 630));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBounds(0, 0, 900, 70);
		panelBotoes.setMinimumSize(new Dimension(900,70));
		panelBotoes.setMaximumSize(new Dimension());
		panelBotoes.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(null);
		
		JButton btnNewButton = new JButton("novo [ctrl-n]");
		btnNewButton.setBounds(0, 0, 112, 70);
		btnNewButton.setIcon(new ImageIcon("novoPapel.png"));
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		panelBotoes.add(btnNewButton);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.setBounds(112, 0, 112, 70);
		panelBotoes.add(btnAbrir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(224, 0, 112, 70);
		panelBotoes.add(btnSalvar);
		
		JButton btnCopiar = new JButton("Copiar");
		btnCopiar.setBounds(336, 0, 112, 70);
		panelBotoes.add(btnCopiar);
		
		JButton btnColar = new JButton("Colar");
		btnColar.setBounds(448, 0, 112, 70);
		panelBotoes.add(btnColar);
		
		JButton btnRecortar = new JButton("Recortar");
		btnRecortar.setBounds(560, 0, 112, 70);
		panelBotoes.add(btnRecortar);
		
		JButton btnCompilar = new JButton("Compilar");
		btnCompilar.setBounds(672, 0, 112, 70);
		panelBotoes.add(btnCompilar);
		
		JButton btnEquipe = new JButton("Equipe");
		btnEquipe.setBounds(784, 0, 112, 70);
		panelBotoes.add(btnEquipe);
		
		JPanel panelEditor = new JPanel();
		panelEditor.setBounds(0, 70, 900, 400);
		panelEditor.setBackground(Color.LIGHT_GRAY);
		panelEditor.setMinimumSize(new Dimension(900, 400));
		contentPane.add(panelEditor);
		panelEditor.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 900, 400);
		panelEditor.add(scrollPane);
		
		JTextArea txtrGhhbmj = new JTextArea();
		txtrGhhbmj.setText("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
		lines = new JTextArea("1");
	    lines.setBackground(Color.LIGHT_GRAY);
	    lines.setEditable(false);
		txtrGhhbmj.getDocument().addDocumentListener(new DocumentListener() {
			public String getText() {
	            int caretPosition = txtrGhhbmj.getDocument().getLength();
	            Element root = txtrGhhbmj.getDocument().getDefaultRootElement();
	            String text = "1" + System.getProperty("line.separator");
	               for(int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
	                  text += i + System.getProperty("line.separator");
	               }
	            return text;
	         }
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				lines.setText(getText());
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				 lines.setText(getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				 lines.setText(getText());
			}
		});
		scrollPane.setViewportView(txtrGhhbmj);
		scrollPane.setRowHeaderView(lines);
		
		JPanel panelMensagens = new JPanel();
		panelMensagens.setBounds(0, 470, 900, 100);
		contentPane.add(panelMensagens);
		panelMensagens.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(0, 0, 900, 100);
		panelMensagens.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
			
		JPanel panelStatus = new JPanel();
		panelStatus.setBounds(0, 570, 900, 30);
		contentPane.add(panelStatus);
		panelStatus.setLayout(null);
		btnCompilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
                panelEditor.setSize(getSize().width - 16, getSize().height - 200);
                scrollPane.setSize(panelEditor.getSize().width, panelEditor.getSize().height);
			}
		});
	}
}
