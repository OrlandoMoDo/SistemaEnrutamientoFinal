package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Router;
import Logico.SistemaEnrutamiento;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRouter extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private Image imagenTopologia = new ImageIcon(FrmPrincipal.class.getResource("Imagenes/Topologia.png")).getImage().getScaledInstance(300, 285, Image.SCALE_SMOOTH);
	private Image imagenRouter1 = new ImageIcon(FrmPrincipal.class.getResource("Imagenes/Router1.png")).getImage().getScaledInstance(90, 65, Image.SCALE_SMOOTH);
	private Image imagenRouter2 = new ImageIcon(FrmPrincipal.class.getResource("Imagenes/Router2.png")).getImage().getScaledInstance(90, 65, Image.SCALE_SMOOTH);
	private Image imagenRouter3 = new ImageIcon(FrmPrincipal.class.getResource("Imagenes/Router3.png")).getImage().getScaledInstance(90, 65, Image.SCALE_SMOOTH);
	private Image imagenRouter4 = new ImageIcon(FrmPrincipal.class.getResource("Imagenes/Router4.png")).getImage().getScaledInstance(90, 65, Image.SCALE_SMOOTH);
	private Image imagenRouter5 = new ImageIcon(FrmPrincipal.class.getResource("Imagenes/Router5.png")).getImage().getScaledInstance(90, 65, Image.SCALE_SMOOTH);
	private JButton btnRouter1;
	private JLabel lblRouterSeleccionado;
	private JButton btnRouter2;
	private JButton btnRouter3;
	private JButton btnRouter4;
	private JButton btnRouter5;
	
	public Router routerSeleccionado = null;
	private JButton btnAceptar;
	private JPanel panel;
	private JLabel lblTopologia;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmRouter dialog = new FrmRouter();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmRouter() {

		setTitle("Seleccion del Router");
		setBounds(100, 100, 838, 505);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnSeleccion = new JPanel();
		pnSeleccion.setBorder(new TitledBorder(null, "Selecciona el Router con el que trabajaras:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnSeleccion.setBounds(15, 16, 405, 389);
		contentPanel.add(pnSeleccion);
		pnSeleccion.setLayout(null);
		
		btnRouter1 = new JButton("");
		btnRouter1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRouterSeleccionado.setText("Router Seleccionado: Router 1");
				btnAceptar.setEnabled(true);
				routerSeleccionado = SistemaEnrutamiento.getInstance().buscarRouterNombre("Router 1");
			}
		});
		btnRouter1.setIcon(new ImageIcon(imagenRouter1));
		btnRouter1.setBounds(15, 73, 115, 65);
		pnSeleccion.add(btnRouter1);

		btnRouter2 = new JButton("");
		btnRouter2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRouterSeleccionado.setText("Router Seleccionado: Router 2");
				btnAceptar.setEnabled(true);
				routerSeleccionado = SistemaEnrutamiento.getInstance().buscarRouterNombre("Router 2");
			}
		});
		btnRouter2.setIcon(new ImageIcon(imagenRouter2));
		btnRouter2.setBounds(145, 73, 115, 65);
		pnSeleccion.add(btnRouter2);
		
		{
			btnRouter3 = new JButton("");
			btnRouter3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblRouterSeleccionado.setText("Router Seleccionado: Router 3");
					btnAceptar.setEnabled(true);
					routerSeleccionado = SistemaEnrutamiento.getInstance().buscarRouterNombre("Router 3");

				}
			});
			btnRouter3.setBounds(275, 73, 115, 65);
			btnRouter3.setIcon(new ImageIcon(imagenRouter3));
			pnSeleccion.add(btnRouter3);
		}
		{
			btnRouter4 = new JButton("");
			btnRouter4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblRouterSeleccionado.setText("Router Seleccionado: Router 4");
					btnAceptar.setEnabled(true);
					routerSeleccionado = SistemaEnrutamiento.getInstance().buscarRouterNombre("Router 4");
				}
			});
			btnRouter4.setIcon(new ImageIcon(imagenRouter4));
			btnRouter4.setBounds(37, 200, 115, 65);
			pnSeleccion.add(btnRouter4);
		}
		{
			btnRouter5 = new JButton("");
			btnRouter5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblRouterSeleccionado.setText("Router Seleccionado: Router 5");
					btnAceptar.setEnabled(true);
					routerSeleccionado = SistemaEnrutamiento.getInstance().buscarRouterNombre("Router 5");
				}
			});
			btnRouter5.setIcon(new ImageIcon(imagenRouter5));
			btnRouter5.setBounds(200, 200, 115, 65);
			pnSeleccion.add(btnRouter5);
		}
		
		lblRouterSeleccionado = new JLabel("Router Seleccionado:");
		lblRouterSeleccionado.setBounds(77, 330, 276, 20);
		pnSeleccion.add(lblRouterSeleccionado);
		{
			panel = new JPanel();
			panel.setBounds(435, 16, 382, 389);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblTopologia = new JLabel("");
				lblTopologia.setIcon(new ImageIcon(imagenTopologia));
				lblTopologia.setBounds(35, 16, 311, 357);
				panel.add(lblTopologia);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FrmEnrutamiento frmAux = new FrmEnrutamiento(routerSeleccionado);
						frmAux.setVisible(true);
						dispose();
					}
				});
				btnAceptar.setEnabled(false);
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			
			JButton btnNewButton = new JButton("Visualizar Topologia");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FrmVisualizarTopologia frm = new FrmVisualizarTopologia();
					frm.setVisible(true);
				}
			});
			buttonPane.add(btnNewButton);
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
