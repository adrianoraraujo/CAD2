import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Janelas extends JFrame {

	private JLabel titulo;
	private JRadioButton subirContraste = new JRadioButton("+ contraste");
	private JRadioButton amarelo = new JRadioButton("Amarelo");
	private JRadioButton pretoeBranco = new JRadioButton("P&B");
	private JRadioButton dimContraste = new JRadioButton("- contraste");
	private JRadioButton inverso = new JRadioButton("Inveter Cores");
	private ImageIcon img = new ImageIcon();
	private JLabel imgL = new JLabel();

	private ButtonGroup tratamento;
	private JLabel tratamentoLabel;
	private JButton tratarimg;
	private JButton sobre;
	JFrame content;
	Imagine ima = new Imagine();
	
	public Image redimensionarImagem(BufferedImage imagem)
	{
		Image novaImagem;
		Dimension tamanhoImagem = new Dimension();
		double proporcao = imagem.getWidth()/imagem.getHeight();
		tamanhoImagem.setSize(proporcao*520, 520);
		novaImagem=imagem.getScaledInstance(tamanhoImagem.width, tamanhoImagem.height, Image.SCALE_DEFAULT);
		return novaImagem;
	}
	
	public void mostraImagem(BufferedImage imagem) {

		img.setImage(redimensionarImagem(imagem));
		imgL.repaint();
	}

	public void JanelaPrincipal() throws IOException {

		content = this;
		System.out.println(content);
		titulo = new JLabel("CAD");
		tratamento = new ButtonGroup();
		tratamentoLabel = new JLabel();
		tratarimg = new JButton("Tratar Imagem");
		tratarimg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (subirContraste.isSelected()) {

					try {
						ima.subirContraste(ima.abrirImagem(), ima.abrirImagem().getHeight(),
								ima.abrirImagem().getWidth());

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (amarelo.isSelected()) {
					try {
						ima.amarelo(ima.abrirImagem(), ima.abrirImagem().getHeight(), ima.abrirImagem().getWidth());

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (pretoeBranco.isSelected()) {
					try {
						ima.PretoeBranco(ima.abrirImagem(), ima.abrirImagem().getHeight(),
								ima.abrirImagem().getWidth());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (dimContraste.isSelected()) {
					try {
						ima.dimContraste(ima.abrirImagem(), ima.abrirImagem().getHeight(),
								ima.abrirImagem().getWidth());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (inverso.isSelected()) {
					try {
						ima.inverso(ima.abrirImagem(), ima.abrirImagem().getHeight(), ima.abrirImagem().getWidth());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(content, "Selecione alguma opção", "CAD", JOptionPane.ERROR_MESSAGE);

				}
			}
		});

		sobre = new JButton("Sobre");
		sobre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String msg = "            "
						+ "Desenvolvido por\n                      "
						+ "Adriano Araújo\n                        "
						+ "Jorge Oliveira                        ";
				JOptionPane.showMessageDialog(content, msg, "Sobre", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		try {
			img.setImage(redimensionarImagem(ImageIO.read(new File("imagem.jpg"))));

		} catch (Exception e) {
			// TODO: handle exception
		}

		titulo.setBounds(15, 5, 200, 30);
		subirContraste.setBounds(5, 50, 100, 20);
		dimContraste.setBounds(5, 75, 100, 20);
		inverso.setBounds(5, 100, 100, 20);
		amarelo.setBounds(5, 125, 100, 20);
		pretoeBranco.setBounds(5, 150, 100,20);
		tratarimg.setBounds(5, 180, 120, 20);
		sobre.setBounds(680, 530, 100, 20);
		tratamentoLabel.setBounds(100, 35, 250, 100);
		imgL.setBounds(200, 5, 570, 520);
		imgL.setIcon(img);

		
		tratamento.add(amarelo);
		tratamento.add(dimContraste);
		tratamento.add(inverso);
		tratamento.add(pretoeBranco);
		tratamento.add(subirContraste);
		
		super.add(imgL);
		super.add(titulo);
		super.add(subirContraste);
		super.add(dimContraste);
		super.add(amarelo);
		super.add(pretoeBranco);
		super.add(inverso);
		super.add(tratarimg);
		super.add(sobre);
		super.add(tratamentoLabel);
		// TODO Auto-generated method stub

	}

	public Janelas() throws IOException {
		super("CAD");
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		super.setLocation((screen.width-800)/2, (screen.height-600)/2);
		super.setSize(800, 600);
		super.setResizable(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setLayout(null);
		JanelaPrincipal();

	}

}
