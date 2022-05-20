package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.border.TitledBorder;

import Logico.DireccionIP;
import Logico.SistemaEnrutamiento;

import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Image imagenRouter = new ImageIcon(FrmPrincipal.class.getResource("Imagenes/Router.png")).getImage().getScaledInstance(70, 37, Image.SCALE_SMOOTH);
	private JButton btnNuevo;
	private JButton btnRedes;
	public static JButton btnEnrutamientos;
	private JButton btnSalir;
	private int opcionAux=0;

	public static void main(String[] args) {
		try {
			FrmPrincipal dialog = new FrmPrincipal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FrmPrincipal() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Saliendo del sistema!", "Confirmar", JOptionPane.INFORMATION_MESSAGE);
			}
		});	
		DireccionIP ip = new DireccionIP(10, 0, 0, 1, 30);
		System.out.println(ip.obtenerIPBinario());
		Dimension dimension=getToolkit().getScreenSize();
		setResizable(false);
		setTitle("Sistema de Enrutamiento");
		setIconImage((imagenRouter));
		setBounds(100, 100, dimension.width-300, dimension.height-200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 245, 245));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnMenuOpciones = new JPanel();
		pnMenuOpciones.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu Opciones", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnMenuOpciones.setBounds(15, 16, 227, 440);
		contentPanel.add(pnMenuOpciones);
		pnMenuOpciones.setLayout(null);
			
		btnRedes = new JButton("Redes");
		btnRedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTopologiaRed topologia = new FrmTopologiaRed();
				topologia.setVisible(true);
			}
		});
		btnRedes.setEnabled(false);
		btnRedes.setBounds(52, 133, 122, 50);
		pnMenuOpciones.add(btnRedes);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opcionAux==0) {
					btnRedes.setEnabled(true);
					opcionAux++;
				}else {
					int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro?", "Confirmar", JOptionPane.YES_NO_OPTION);
					if(opcion==0) {
						btnRedes.setEnabled(true);
						SistemaEnrutamiento.getInstance().getMisDireccionesIP().clear();
						SistemaEnrutamiento.getInstance().getMisRedes().clear();
						SistemaEnrutamiento.getInstance().getMisInterfaces().clear();
						SistemaEnrutamiento.getInstance().getMisRouters().clear();
						SistemaEnrutamiento.getInstance().getMisEnrutamientos().clear();
					}
				}

			}
		});
		btnNuevo.setBounds(52, 38, 122, 50);
		pnMenuOpciones.add(btnNuevo);
		
		btnEnrutamientos = new JButton("Enrutamientos");
		btnEnrutamientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRouter frmAux = new FrmRouter();
				frmAux.setVisible(true);
			}
		});
		btnEnrutamientos.setEnabled(false);
		btnEnrutamientos.setBounds(52, 245, 122, 50);
		pnMenuOpciones.add(btnEnrutamientos);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(52, 354, 122, 50);
		pnMenuOpciones.add(btnSalir);
		
		JPanel pnBody = new JPanel();
		pnBody.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnBody.setBounds(257, 16, 664, 440);
		contentPanel.add(pnBody);
		pnBody.setLayout(null);
		
		JLabel lblTituloDescripcion = new JLabel("Sistema de Enrutamiento de Redes");
		lblTituloDescripcion.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTituloDescripcion.setBounds(44, 16, 309, 31);
		pnBody.add(lblTituloDescripcion);
		
		JTextArea lblSistemaParaCalcular = new JTextArea();
		lblSistemaParaCalcular.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSistemaParaCalcular.setForeground(Color.BLACK);
		lblSistemaParaCalcular.setEditable(false);
		lblSistemaParaCalcular.setText(" Sistema para calcular la ruta mas optima hacia una red segun los siguientes criterios:"
				+ "\n\n 1) LPM (Longest Prefix Match).\n El primer criterio es este y nos indica que el trafico se va a ir preferiblemente"
				+ "por la ruta que vaya a la red\n mas especifica. La red mas especifica siempre sera la que tenga una mascara mayor."
				+ "\n\n 2) Distancia Administrativa.\n Este es el segundo criterio tomado en cuenta para el envio de la informacion."
				+ " En caso de que LPM no sea\n suficiente, la informacion se ira por la ruta que tenga una distancia administrativa menor."
				+ "\nAlgunas distancia administrativas por defecto (aunque pueden ser cambiadas) son las siguientes:\n +Estatico (0)\n +EIGRP (90)\n +OSPF(110)\n +RIP(120)"
				+ "\n\n 3) Metrica.\n Es el tercer criterio tomado en cuenta para elegir la mejor ruta y se usa en caso de que no sea"
				+ "suficiente con los\n criterios LPM o con la distancia administrativa."
				+ "\n\n 4) Balanceo de trafico.\n Si con los criterios anteriores no se logro obtener la mejor ruta, entonces el"
				+ " trafico se balanceara por las\n mejores rutas.");
		lblSistemaParaCalcular.setBounds(15, 63, 634, 361);
		pnBody.add(lblSistemaParaCalcular);
		
		

	}
}
