package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.DireccionIP;
import Logico.Enrutamiento;
import Logico.Interfaz;
import Logico.Router;
import Logico.SistemaEnrutamiento;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmEnrutamiento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrlTablaEnrutamiento;
	private JTable tblEnrutamiento;
	private static DefaultTableModel modeloTabla;
	private static Object[] row;//Arreglo de objeto.
	public Router routerElegido = null;
	private JPanel pnAgregarRuta;
	private JTextField txtDistanciaAdministrativa;
	private JTextField txtMetrica;
	private JButton btnAgregarRuta;
	private JComboBox cbxTipoEnrutamiento;
	private JComboBox cbxNextHop;
	private JTextField txtRutaMejorCamino;
	private JButton btnCalcularMejorRuta;
	private JButton btnSalir;
	private JButton btnMejorCamino;
	private JButton btnAgregarRutaMenu;
	private JButton btnAceptarMejorRuta;
	private JButton btnAceptarAgregarRuta;
	private JTextField txtRedDestinoCalculo;
	public ArrayList<Interfaz> interfacesSalida = new ArrayList<Interfaz>();
	public Interfaz interfazSeleccionada = null;
	private JTextField txtDireccionIPRedDestinoRuta;
	private JTextField txtMascaraRedDestinoRuta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Router router = new Router("Router 1", "Router 1");
			DireccionIP	ip = new DireccionIP(10, 0, 0, 1, 30);
			Interfaz inter = new Interfaz(router.getNombreRouter(), router.getNombreRouter(), ip);
			FrmEnrutamiento dialog = new FrmEnrutamiento(router);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmEnrutamiento(Router router) {
		routerElegido = router;
		setTitle("Enrutamientos - "+router.getNombreRouter());
		setResizable(false);
		setBounds(100, 100, 917, 654);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Redes Conectadas Tabla de Enrutamiento de "+router.getNombreRouter(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(15, 16, 881, 202);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				scrlTablaEnrutamiento = new JScrollPane();
				panel.add(scrlTablaEnrutamiento, BorderLayout.CENTER);
				
				tblEnrutamiento = new JTable();
				modeloTabla = new DefaultTableModel();
				String[] headers = { "Red destino", "C - R", "Int. (Conectadas)", "Protocolo", "Next Hop", "Interfaz Sal.", "Dist. Adm.", "Metrica"};
				modeloTabla.setColumnIdentifiers(headers);//Estos seran los encabezados de las columnas.
				tblEnrutamiento.setModel(modeloTabla);		

				scrlTablaEnrutamiento.setViewportView(tblEnrutamiento);
			}
		}
		{
			pnAgregarRuta = new JPanel();
			pnAgregarRuta.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnAgregarRuta.setBounds(15, 234, 881, 320);
			contentPanel.add(pnAgregarRuta);
			pnAgregarRuta.setLayout(null);
			
			JPanel pnRutas = new JPanel();
			pnRutas.setBorder(new TitledBorder(null, "Rutas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnRutas.setBounds(15, 16, 384, 288);
			pnAgregarRuta.add(pnRutas);
			pnRutas.setLayout(null);
			
			txtMascaraRedDestinoRuta = new JTextField();
			txtMascaraRedDestinoRuta.setColumns(10);
			txtMascaraRedDestinoRuta.setBounds(275, 22, 48, 23);
			pnRutas.add(txtMascaraRedDestinoRuta);
			
			txtDireccionIPRedDestinoRuta = new JTextField();
			txtDireccionIPRedDestinoRuta.setBounds(151, 22, 109, 23);
			pnRutas.add(txtDireccionIPRedDestinoRuta);
			txtDireccionIPRedDestinoRuta.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Red de destino:");
			lblNewLabel.setBounds(30, 25, 118, 20);
			pnRutas.add(lblNewLabel);
			
			JLabel label = new JLabel("Enrutamiento:");
			label.setBounds(30, 70, 101, 20);
			pnRutas.add(label);
			
			JLabel label_1 = new JLabel("Next Hop:");
			label_1.setBounds(30, 115, 101, 20);
			pnRutas.add(label_1);
			
			JLabel lblDistanciaAdmin = new JLabel("Distancia Admin.:");
			lblDistanciaAdmin.setBounds(15, 160, 133, 20);
			pnRutas.add(lblDistanciaAdmin);
			
			JLabel lblDistanciaAdministrativa = new JLabel("Metrica:");
			lblDistanciaAdministrativa.setBounds(30, 206, 133, 20);
			pnRutas.add(lblDistanciaAdministrativa);
			
			txtDistanciaAdministrativa = new JTextField();
			txtDistanciaAdministrativa.setBounds(151, 159, 172, 23);
			pnRutas.add(txtDistanciaAdministrativa);
			txtDistanciaAdministrativa.setColumns(10);
			
			
			for (int i = 0; i < routerElegido.getInterfaces().size(); i++) {
				interfacesSalida.add(router.getInterfaces().get(i));
			}
			String nextHopArray[] = new String[routerElegido.getInterfaces().size()];
			for (int i = 0; i < nextHopArray.length; i++) {
				if(routerElegido.getNombreRouter().equalsIgnoreCase("Router 1")) {
					switch (i) {
					case 0: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(0).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(0).getDireccionRed(), 2).obtenerIPMask();						
						break;
					case 1: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(1).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(1).getDireccionRed(), 2).obtenerIPMask();						
						break;
					}
				}
				
				if(routerElegido.getNombreRouter().equalsIgnoreCase("Router 2")) {
					switch (i) {
					case 0: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(0).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(0).getDireccionRed(), 1).obtenerIPMask();						
						break;
					case 1: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(2).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(2).getDireccionRed(), 2).obtenerIPMask();						
						break;
					case 2: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(3).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(3).getDireccionRed(), 2).obtenerIPMask();						
						break;
					case 3: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(6).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(6).getDireccionRed(), 2).obtenerIPMask();						
						break;
					}
				}
				
				if(routerElegido.getNombreRouter().equalsIgnoreCase("Router 3")) {
					switch (i) {
					case 0: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(1).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(1).getDireccionRed(), 1).obtenerIPMask();						
						break;
					case 1: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(2).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(2).getDireccionRed(), 1).obtenerIPMask();						
						break;
					case 2: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(5).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(5).getDireccionRed(), 2).obtenerIPMask();						
						break;
					}
				}
				
				if(routerElegido.getNombreRouter().equalsIgnoreCase("Router 4")) {
					switch (i) {
					case 0: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(3).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(3).getDireccionRed(), 1).obtenerIPMask();						
						break;
					case 1: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(4).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(4).getDireccionRed(), 2).obtenerIPMask();						
						break;
					}
				}
				
				if(routerElegido.getNombreRouter().equalsIgnoreCase("Router 5")) {
					switch (i) {
					case 0: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(4).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(4).getDireccionRed(), 1).obtenerIP();						
						break;
					case 1: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(5).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(5).getDireccionRed(), 1).obtenerIP();						
						break;
					case 2: 
						nextHopArray[i] = SistemaEnrutamiento.getInstance().getMisRedes().get(6).obtenerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(6).getDireccionRed(), 1).obtenerIP();						
						break;
					}
				}
				
			}
			cbxNextHop = new JComboBox(nextHopArray);
			interfazSeleccionada = interfacesSalida.get(cbxNextHop.getSelectedIndex());
			cbxNextHop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					interfazSeleccionada = interfacesSalida.get(cbxNextHop.getSelectedIndex());
				}
			});
			cbxNextHop.setBounds(151, 114, 172, 23);
			pnRutas.add(cbxNextHop);
			
			cbxTipoEnrutamiento = new JComboBox();
			cbxTipoEnrutamiento.setBounds(151, 69, 172, 23);
			cbxTipoEnrutamiento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indiceSeleccionado = cbxTipoEnrutamiento.getSelectedIndex();
					switch (indiceSeleccionado) {
						case 0: txtDistanciaAdministrativa.setText("1"); break;
						case 1: txtDistanciaAdministrativa.setText("120"); break;
						case 2: txtDistanciaAdministrativa.setText("90"); break;
						case 3: txtDistanciaAdministrativa.setText("110"); break;
						case 4: txtDistanciaAdministrativa.setText("100"); break;
					}
				}
			});
			cbxTipoEnrutamiento.setModel(new DefaultComboBoxModel(new String[] {"Estatico", "RIP", "EIGRP", "OSPF", "IGRP"}));

			pnRutas.add(cbxTipoEnrutamiento);
			
			txtMetrica = new JTextField();
			txtMetrica.setBounds(151, 204, 172, 23);
			pnRutas.add(txtMetrica);
			txtMetrica.setColumns(10);
			
			btnAgregarRuta = new JButton("Agregar");
			btnAgregarRuta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!txtDistanciaAdministrativa.getText().equalsIgnoreCase("") && !txtMetrica.getText().equalsIgnoreCase("")) {
						Enrutamiento enrutamiento = new Enrutamiento(routerElegido.getNombreRouter(), 
								SistemaEnrutamiento.getInstance().direccionIPbyIp(txtDireccionIPRedDestinoRuta.getText(), txtMascaraRedDestinoRuta.getText()),
								SistemaEnrutamiento.getInstance().buscarDireccionIP(cbxNextHop.getSelectedItem().toString()), 
								Integer.parseInt(txtDistanciaAdministrativa.getText()), Integer.parseInt(txtMetrica.getText()), 
								cbxTipoEnrutamiento.getSelectedItem().toString(), interfazSeleccionada);
						SistemaEnrutamiento.getInstance().ingresarEnrutamiento(enrutamiento);
						routerElegido.agregarEnrutamiento(enrutamiento);
						txtMetrica.setText("");
						txtDistanciaAdministrativa.setText("");
						cbxNextHop.setSelectedIndex(0);
						txtDireccionIPRedDestinoRuta.setText("");
						txtMascaraRedDestinoRuta.setText("");
						cbxTipoEnrutamiento.setSelectedIndex(0);
						cargarTabla(2);
					}else {
						JOptionPane.showMessageDialog(null, "Llene todos los campos");
					}
				}
			});
			btnAgregarRuta.setBounds(30, 242, 115, 29);
			pnRutas.add(btnAgregarRuta);
			
			ArrayList<String> redesRemotas = new ArrayList<String>();
			ArrayList<String> redesConectadas = new ArrayList<String>();
			for (int i = 0; i <routerElegido.getInterfaces().size(); i++) {
				redesConectadas.add(routerElegido.getInterfaces().get(i).getDireccionIP().direccionRed(routerElegido.getInterfaces().get(i).getDireccionIP()).obtenerIPMask());
			}
			for (int i = 0; i < SistemaEnrutamiento.getInstance().getMisRedes().size(); i++) {
				if(!redesConectadas.contains(SistemaEnrutamiento.getInstance().getMisRedes().get(i).getDireccionRed().obtenerIPMask())) {
					redesRemotas.add(SistemaEnrutamiento.getInstance().getMisRedes().get(i).getDireccionRed().obtenerIPMask());
				}
			}
			String remotas[] = new String[redesRemotas.size()];
			for (int i = 0; i < redesRemotas.size(); i++) {
				remotas[i] = redesRemotas.get(i);
			}
			
			btnAceptarAgregarRuta = new JButton("Aceptar");
			btnAceptarAgregarRuta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					habilitarAgregarRutas(false);
					btnAgregarRutaMenu.setEnabled(true);
					btnMejorCamino.setEnabled(true);
				}
			});
			btnAceptarAgregarRuta.setBounds(210, 243, 115, 29);
			pnRutas.add(btnAceptarAgregarRuta);
			
			JPanel pnMejorRuta = new JPanel();
			pnMejorRuta.setBorder(new TitledBorder(null, "Mejor Ruta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnMejorRuta.setBounds(455, 16, 384, 288);
			pnAgregarRuta.add(pnMejorRuta);
			pnMejorRuta.setLayout(null);
			
			JLabel label_2 = new JLabel("Red de destino:");
			label_2.setBounds(31, 40, 118, 20);
			pnMejorRuta.add(label_2);
			
			JLabel lblNewLabel_1 = new JLabel("Mejor Camino:");
			lblNewLabel_1.setBounds(139, 169, 105, 20);
			pnMejorRuta.add(lblNewLabel_1);
			
			txtRutaMejorCamino = new JTextField();
			txtRutaMejorCamino.setEnabled(false);
			txtRutaMejorCamino.setBounds(23, 211, 338, 23);
			pnMejorRuta.add(txtRutaMejorCamino);
			txtRutaMejorCamino.setColumns(10);
			
			btnCalcularMejorRuta = new JButton("Calcular");
			btnCalcularMejorRuta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calcularMejorRuta();
				}
			});
			btnCalcularMejorRuta.setBounds(44, 97, 115, 29);
			pnMejorRuta.add(btnCalcularMejorRuta);
			
			btnAceptarMejorRuta = new JButton("Aceptar");
			btnAceptarMejorRuta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					habilitarCalculoRutas(false);
					txtRutaMejorCamino.setText("");
					btnAgregarRutaMenu.setEnabled(true);
					btnMejorCamino.setEnabled(true);
				}
			});
			btnAceptarMejorRuta.setBounds(210, 97, 115, 29);
			pnMejorRuta.add(btnAceptarMejorRuta);
			
			txtRedDestinoCalculo = new JTextField();
			txtRedDestinoCalculo.setColumns(10);
			txtRedDestinoCalculo.setBounds(153, 37, 172, 23);
			pnMejorRuta.add(txtRedDestinoCalculo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnVisualizarTopologia = new JButton("Ver topologia");
			btnVisualizarTopologia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FrmVisualizarTopologia frm = new FrmVisualizarTopologia();
					frm.setVisible(true);
				}
			});
			buttonPane.add(btnVisualizarTopologia);
			
			btnMejorCamino = new JButton("Mejor Ruta");
			btnMejorCamino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					habilitarCalculoRutas(true);
					btnAgregarRutaMenu.setEnabled(false);
					btnMejorCamino.setEnabled(false);
				}
			});
			buttonPane.add(btnMejorCamino);
			
			btnAgregarRutaMenu = new JButton("Agregar Ruta");
			btnAgregarRutaMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					habilitarAgregarRutas(true);
					btnAgregarRutaMenu.setEnabled(false);
					btnMejorCamino.setEnabled(false);
				}
			});
			buttonPane.add(btnAgregarRutaMenu);
			{
				btnSalir = new JButton("Salir");
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
		
		cargarTabla(1);
		habilitarAgregarRutas(false);
		habilitarCalculoRutas(false);
	}

	public void habilitarAgregarRutas(boolean habilitar) {
		cbxTipoEnrutamiento.setEnabled(habilitar);
		cbxNextHop.setEnabled(habilitar);
		txtDireccionIPRedDestinoRuta.setEnabled(habilitar);
		txtMascaraRedDestinoRuta.setEnabled(habilitar);
		txtDistanciaAdministrativa.setEnabled(habilitar);
		txtMetrica.setEnabled(habilitar);
		btnAgregarRuta.setEnabled(habilitar);
		btnAceptarAgregarRuta.setEnabled(habilitar);
		
	}

	public void habilitarCalculoRutas(boolean habilitar) {
		txtRedDestinoCalculo.setEnabled(habilitar);
		btnCalcularMejorRuta.setEnabled(habilitar);
		btnAceptarMejorRuta.setEnabled(habilitar);
	}

	public void cargarTabla(int opcion) {
		modeloTabla.setRowCount(0);//Poner todo en la tabla en 0.
		row = new Object[modeloTabla.getColumnCount()];
		for (int i = 0; i <routerElegido.getInterfaces().size(); i++) {
				row[0] = routerElegido.getInterfaces().get(i).getDireccionIP().direccionRed(routerElegido.getInterfaces().get(i).getDireccionIP()).obtenerIPMask();
				row[1] = "Conectado";
				row[2] = routerElegido.getInterfaces().get(i).getNombreInterfaz();
				row[3] = "NA";
				row[4] = "NA";
				row[5] = "NA";
				row[6] = "NA";
				row[7] = "0";
				modeloTabla.addRow(row);

		}
		if(opcion==2){
			for (int i = 0; i <routerElegido.getEnrutamientos().size(); i++) {
				row[0] = routerElegido.getEnrutamientos().get(i).getRedDestino().getDireccionRed().obtenerIPMask();
				row[1] = "Remota";
				row[2] = "NA";
				row[3] = routerElegido.getEnrutamientos().get(i).getProtocoloEnrutamiento();
				row[4] = routerElegido.getEnrutamientos().get(i).getNextHop().obtenerIP();
				row[5] = routerElegido.getEnrutamientos().get(i).getInterfazSalida().getNombreInterfaz();
				row[6] = routerElegido.getEnrutamientos().get(i).getDistanciaAdministrativa();
				row[7] = routerElegido.getEnrutamientos().get(i).getMetrica();
				modeloTabla.addRow(row);

			}
		}

		
	}
	
	public void calcularMejorRuta() {
		ArrayList<Enrutamiento> enrutamientosDireccion = SistemaEnrutamiento.getInstance().rutasDireccion(txtRedDestinoCalculo.getText());
		String mejorRuta = "..";
		ArrayList<Enrutamiento> mejoresEnrutamientos = new ArrayList<Enrutamiento>();
		ArrayList<Enrutamiento> mejorLPM = new ArrayList<Enrutamiento>();
		ArrayList<Enrutamiento> mejorDistanciaAdministrativa = new ArrayList<Enrutamiento>();
		for (int i = 0; i < enrutamientosDireccion.size(); i++) {
		System.out.println("Enrutamientos: "+enrutamientosDireccion.get(i).getNextHop());
		}
		int mascaraMayor = SistemaEnrutamiento.getInstance().mascaraMayor(enrutamientosDireccion);
		System.out.println("Mascara mayor: "+mascaraMayor);
		JOptionPane.showMessageDialog(null, SistemaEnrutamiento.getInstance().rutasDireccion(txtRedDestinoCalculo.getText()).size());

		for (int i = 0; i < enrutamientosDireccion.size(); i++) {
			if(enrutamientosDireccion.get(i).getRedDestino().getDireccionRed().getMascara()==mascaraMayor) {
				mejorLPM.add(enrutamientosDireccion.get(i));
			}				
		}
		for (int i = 0; i < mejorLPM.size(); i++) {
		System.out.println("Mejores LMP: "+mejorLPM.get(i).getNextHop());
	}
//		
		if(mejorLPM.size()==1) {
			mejoresEnrutamientos.add(mejorLPM.get(0));
		}else {
			int menorAD=SistemaEnrutamiento.getInstance().distanciaADministrativaMenor(mejorLPM);
			for (int i = 0; i < mejorLPM.size(); i++) {
				if(mejorLPM.get(i).getDistanciaAdministrativa()==menorAD) {
					mejorDistanciaAdministrativa.add(mejorLPM.get(i));
				}				
			}				
		}
		for (int i = 0; i < mejorDistanciaAdministrativa.size(); i++) {
		System.out.println("Mejores Dis. admi.: "+mejorDistanciaAdministrativa.get(i).getNextHop().obtenerIP());
	}
		if(mejorDistanciaAdministrativa.size()==1) {
			mejoresEnrutamientos.add(mejorDistanciaAdministrativa.get(0));
		}else if(mejorDistanciaAdministrativa.size()>1){
			int menorMetrica=SistemaEnrutamiento.getInstance().metricaMenor(mejorDistanciaAdministrativa);
			System.out.println("Menor metrica: "+menorMetrica);
			for (int i = 0; i < mejorDistanciaAdministrativa.size(); i++) {
				if(mejorDistanciaAdministrativa.get(i).getMetrica()==menorMetrica) {
					mejoresEnrutamientos.add(mejorDistanciaAdministrativa.get(i));
				}				
			}				
		}
		for (int i = 0; i < mejoresEnrutamientos.size(); i++) {
		System.out.println("Mejores Enutamiento: "+mejoresEnrutamientos.get(i).getNextHop().obtenerIP());
	}
	
		
		mejorRuta = "Las mejores rutas son por las vias: ";
		for (int i = 0; i < mejoresEnrutamientos.size(); i++) {
			if(mejoresEnrutamientos.size()==1) {
				mejorRuta = "La mejor ruta es por la via: " + mejoresEnrutamientos.get(0).getNextHop().obtenerIP();
			}else {
				mejorRuta = mejorRuta+mejoresEnrutamientos.get(i).getNextHop().obtenerIP()+" ";
			}
		}
		for (int i = 0; i < mejoresEnrutamientos.size(); i++) {
		System.out.println(mejoresEnrutamientos.get(i).getNextHop().obtenerIP());
	}
		txtRutaMejorCamino.setText(mejorRuta);
		
}
	
	
}
