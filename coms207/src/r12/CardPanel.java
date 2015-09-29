package r12;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class CardPanel extends javax.swing.JPanel {

	private BufferedImage[] cardImage = createAllImage();

	public static CardPanel getInstance() {
		CardPanel panel = new CardPanel();
		panel.setBackground(Color.BLUE);
		panel.setPreferredSize(new java.awt.Dimension(660, 180));
		return panel;
	}

	public BufferedImage[] createAllImage() {
		
		Deck example = new Deck();
		
		example.shuffleDeck();
		
		Card[] hand = example.getHand();
		BufferedImage[] imageArray = new BufferedImage[hand.length];
		
		for (int i = 0; i < imageArray.length; i++) {
			imageArray[i] = createImage(hand[i].toString());
		}
		
		return imageArray;
	}

	public BufferedImage createImage(String card) {
		int cardWidth = 120, cardHeight = 160;
		BufferedImage image = new BufferedImage(cardWidth, cardHeight,
				BufferedImage.TYPE_INT_ARGB);
		java.awt.Graphics2D gr = (java.awt.Graphics2D) image.getGraphics();
		gr.setColor(java.awt.Color.WHITE);
		gr.fillRect(0, 0, cardWidth, cardHeight);
		gr.setColor(java.awt.Color.BLACK);
		gr.drawRect(0, 0, cardWidth - 1, cardHeight - 1);
		Font font = new Font("Dialog", Font.PLAIN, 50);
		gr.setFont(font);
		String prefix = card.substring(0, 1);
		String postfix = card.substring(1, 2);
		String suit = "";
		java.awt.Color color = java.awt.Color.BLACK;
		if (prefix.equals("S")) {
			suit = "\u2660"; 
		} else if (prefix.equals("H")) {
			suit = "\u2665"; 
			color = java.awt.Color.RED;
		} else if (prefix.equals("C")) {
			suit = "\u2663";
		} else if (prefix.equals("D")) {
			suit = "\u2666";
			color = java.awt.Color.RED;
		}
		String point = postfix;
		int x = 20;
		if (postfix.equals("T")) {
			x = 10;
			point = "10";
		}
		gr.setColor(color);
		gr.drawString(suit + point, x, 100);
		return image;
	}

	public void paintComponent(java.awt.Graphics graphics) {
		super.paintComponent(graphics);
		int w = getWidth();
		int h = getHeight();
		java.awt.Graphics2D gr = (java.awt.Graphics2D) graphics;
		int y = 10;
		int x = 10;
		for (int i = 0; i < cardImage.length; i++) {
			gr.drawImage(cardImage[i], x, y, this);
			x += 130;
			if ((i + 1) % 13 == 0) {
				y += 170;
				x = 0;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setTitle("COMS207 Deck");
		CardPanel panel = CardPanel.getInstance();
		frame.add(panel);
		frame.pack(); 
		frame.setVisible(true);
	}
}
