package frame;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.text.Element;

public class ContadorLinha extends JComponent {
    private final JTextArea textArea;

    public ContadorLinha(JTextArea textArea) {
        this.textArea = textArea;

        textArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { repaint(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { repaint(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { repaint(); }
        });

        textArea.addCaretListener(e -> repaint());
        textArea.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent e) {
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        FontMetrics fm = g.getFontMetrics();
        int fontHeight = fm.getHeight();
        int start = textArea.viewToModel2D(new Point(0, 0));
        int end = textArea.viewToModel2D(new Point(0, textArea.getHeight()));

        Element root = textArea.getDocument().getDefaultRootElement();
        int startLine = root.getElementIndex(start);
        int endLine = root.getElementIndex(end);

        for (int i = startLine; i <= endLine; i++) {
            try {
                Rectangle2D r = textArea.modelToView2D(root.getElement(i).getStartOffset());
                int lineY = (int) r.getY() + fm.getAscent();

                String lineNumber = String.valueOf(i + 1);
                g.drawString(lineNumber, 5, lineY);
            } catch (Exception e) {
                // Pode ignorar silenciosamente qualquer erro de visualização
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(40, textArea.getHeight());
    }
}
