import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Imagine {

	
	static Janelas jan;
	public static void main(String[] args) throws IOException {
		jan = new Janelas();
		jan.setVisible(true);
	}

	public BufferedImage abrirImagem() throws IOException {
		BufferedImage imagem = ImageIO.read(new File("imagem.jpg"));
		int w = imagem.getWidth();
		int h = imagem.getHeight();
		int[] pixels = imagem.getRGB(0, 0, w, h, null, 0, w);
		System.out.println("Abriu");

		return imagem;
	}

	public BufferedImage salvarImagem(BufferedImage imagem) throws IOException {
		// ImageIO.write(imagem, "PNG", new File("b.png"));
		BufferedImage b = imagem;
		System.out.println("Salvou");

		return b;
	}

	public void subirContraste(BufferedImage imagem, int h, int w) throws IOException {
		abrirImagem();
		float scaleFactor = 2.0f;
		float offset = -50;
		RescaleOp rescale = new RescaleOp(scaleFactor, offset, null);
		rescale.filter(imagem, imagem);
		jan.mostraImagem(salvarImagem(imagem));
	}

	public void inverso(BufferedImage imagem, int h, int w) throws IOException {
		abrirImagem();

		for (int col = 0; col < w; col++) {
			for (int lin = 0; lin < h; lin++) {
				Color pixel = new Color(imagem.getRGB(lin, col));

				Color inverso = new Color(255 - pixel.getRed(), 255 - pixel.getGreen(), 255 - pixel.getBlue());

				imagem.setRGB(lin, col, inverso.getRGB());
			}
		}

		jan.mostraImagem(salvarImagem(imagem));
	}

	public void amarelo(BufferedImage imagem, int h, int w) throws IOException {
		abrirImagem();

		for (int y = 0; y < w; y++) {
			for (int x = 0; x < h; x++) {

				Color color = new Color(imagem.getRGB(x, y));

				Color blue1 = new Color(color.getBlue(), color.getRed(), 0 * color.getGreen());

				imagem.setRGB(x, y, blue1.getRGB());

			}
		}

		jan.mostraImagem(salvarImagem(imagem));
	}
	public void dimContraste(BufferedImage imagem, int h, int w) throws IOException {
		abrirImagem();
		float scaleFactor = 1.0f;
		float offset = +50;
		RescaleOp rescale = new RescaleOp(scaleFactor, offset, null);
		rescale.filter(imagem, imagem);
		jan.mostraImagem(salvarImagem(imagem));
	}

	public void PretoeBranco(BufferedImage imagem, int h, int w) throws IOException {

		BufferedImageOp op = new ColorConvertOp(
			       ColorSpace.getInstance(ColorSpace.CS_GRAY), null); 
			     imagem = op.filter(imagem, null);
		
	jan.mostraImagem(salvarImagem(imagem));
		

	}

	
}
