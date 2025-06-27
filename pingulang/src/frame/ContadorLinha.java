package frame;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.text.Element;

public class ContadorLinha extends JComponent {
	private final JTextArea textArea;
	
	public ContadorLinha(JTextArea textArea) {
		this.textArea = textArea;
		
		//atualizar numero de linhas
		textArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { repaint(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { repaint(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { repaint(); }
        });
		
		textArea.addCaretListener(e -> repaint());
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		FontMetrics fm = g.getFontMetrics();
        int lineHeight = fm.getHeight();
        int start = textArea.viewToModel2D(new Point(0, 0));
        int end = textArea.viewToModel2D(new Point(0, textArea.getHeight()));
        Element root = textArea.getDocument().getDefaultRootElement();
        int startLine = root.getElementIndex(start);
        int endLine = root.getElementIndex(end);

        for (int i = startLine; i <= endLine; i++) {
            int y = (i + 1) * lineHeight;
            String lineNumber = String.valueOf(i + 1);
            g.drawString(lineNumber, 5, y);
        }
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(40, textArea.getHeight());
    }
}
