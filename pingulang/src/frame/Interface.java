package frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Interface {

    public static void main(String[] args) {
        // Create JFrame
        JFrame tela = new JFrame("Compilador PinguLang");
        TelaCompilador ide = new TelaCompilador();
        
        tela.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
	);

	ide.iniciar(tela);

    }
}
