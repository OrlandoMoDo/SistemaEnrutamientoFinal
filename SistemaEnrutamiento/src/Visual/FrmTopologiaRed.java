package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Logico.DireccionIP;
import Logico.Interfaz;
import Logico.Red;
import Logico.Router;
import Logico.SistemaEnrutamiento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class FrmTopologiaRed extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Image imagenTopologia = new ImageIcon(FrmTopologiaRed.class.getResource("Imagenes/TopologiaRedes.png")).getImage().getScaledInstance(452, 368, Image.SCALE_SMOOTH);
	private JTextField txtRedG;
	private JTextField txtMascaraG;
	private JTextField txtRedF;
	private JTextField txtMascaraE;
	private JTextField txtRedE;
	private JTextField txtMascaraD;
	private JTextField txtRedD;
	private JTextField txtRedC;
	private JTextField txtMascaraC;
	private JTextField txtRedB;
	private JLabel label_1;
	private JTextField txtMascaraB;
	private JTextField txtMascaraA;
	private JTextField txtRedA;
	private int red;
	private JTextField txtMascaraF;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnConfirmar;

	
	public static void main(String[] args) {
		try {
			FrmTopologiaRed dialog = new FrmTopologiaRed();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmTopologiaRed() {
		red = 1;
		setTitle(".:. Topologia de la Red .:.");
		setBounds(100, 100, 814, 601);
		setLocationRelativeTo(null);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel pnTopologia = new JPanel();
			pnTopologia.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Topologia de la Red", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnTopologia.setBounds(15, 16, 502, 469);
			contentPanel.add(pnTopologia);
			pnTopologia.setLayout(null);
			{
				JLabel lblTopologiaRed = new JLabel("");
				lblTopologiaRed.setIcon(new ImageIcon(imagenTopologia));

				lblTopologiaRed.setBounds(11, 36, 480, 396);
				pnTopologia.add(lblTopologiaRed);
			}
		}
		{
			JPanel pnAsignacionRedes = new JPanel();
			pnAsignacionRedes.setBorder(new TitledBorder(null, "Asignacion de Redes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnAsignacionRedes.setBounds(532, 16, 245, 469);
			contentPanel.add(pnAsignacionRedes);
			pnAsignacionRedes.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("/");
				lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
				lblNewLabel.setBounds(156, 52, 21, 26);
				pnAsignacionRedes.add(lblNewLabel);
			}
			{
				JLabel lblRedA = new JLabel("Red A:");
				lblRedA.setBounds(15, 28, 57, 20);
				pnAsignacionRedes.add(lblRedA);
			}
			{
				txtRedA = new JTextField();
				txtRedA.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c))&&(c!='.'))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtRedA.setBounds(15, 52, 135, 26);
				pnAsignacionRedes.add(txtRedA);
				txtRedA.setColumns(10);
			}
			{
				txtMascaraA = new JTextField();
				txtMascaraA.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c)))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtMascaraA.setColumns(10);
				txtMascaraA.setBounds(166, 52, 40, 26);
				pnAsignacionRedes.add(txtMascaraA);
			}
			{
				label_1 = new JLabel("/");
				label_1.setFont(new Font("Arial", Font.PLAIN, 18));
				label_1.setBounds(156, 118, 21, 26);
				pnAsignacionRedes.add(label_1);
			}
			{
				JLabel lblRedB = new JLabel("Red B:");
				lblRedB.setBounds(15, 94, 57, 20);
				pnAsignacionRedes.add(lblRedB);
			}
			{
				txtRedB = new JTextField();
				txtRedB.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c))&&(c!='.'))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtRedB.setColumns(10);
				txtRedB.setBounds(15, 118, 135, 26);
				pnAsignacionRedes.add(txtRedB);
			}
			{
				txtMascaraB = new JTextField();
				txtMascaraB.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c)))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtMascaraB.setColumns(10);
				txtMascaraB.setBounds(166, 118, 40, 26);
				pnAsignacionRedes.add(txtMascaraB);
			}
			{
				JLabel label = new JLabel("/");
				label.setFont(new Font("Arial", Font.PLAIN, 18));
				label.setBounds(156, 179, 21, 26);
				pnAsignacionRedes.add(label);
			}
			{
				JLabel lblRedC = new JLabel("Red C:");
				lblRedC.setBounds(15, 155, 57, 20);
				pnAsignacionRedes.add(lblRedC);
			}
			{
				txtRedC = new JTextField();
				txtRedC.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c))&&(c!='.'))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtRedC.setColumns(10);
				txtRedC.setBounds(15, 179, 135, 26);
				pnAsignacionRedes.add(txtRedC);
			}
			{
				txtMascaraC = new JTextField();
				txtMascaraC.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c)))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtMascaraC.setColumns(10);
				txtMascaraC.setBounds(166, 179, 40, 26);
				pnAsignacionRedes.add(txtMascaraC);
			}
			{
				JLabel label = new JLabel("/");
				label.setFont(new Font("Arial", Font.PLAIN, 18));
				label.setBounds(156, 245, 21, 26);
				pnAsignacionRedes.add(label);
			}
			{
				JLabel lblRedD = new JLabel("Red D:");
				lblRedD.setBounds(15, 221, 57, 20);
				pnAsignacionRedes.add(lblRedD);
			}
			{
				txtRedD = new JTextField();
				txtRedD.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c))&&(c!='.'))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtRedD.setColumns(10);
				txtRedD.setBounds(15, 245, 135, 26);
				pnAsignacionRedes.add(txtRedD);
			}
			{
				txtMascaraD = new JTextField();
				txtMascaraD.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c)))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtMascaraD.setColumns(10);
				txtMascaraD.setBounds(166, 245, 40, 26);
				pnAsignacionRedes.add(txtMascaraD);
			}
			{
				JLabel label = new JLabel("/");
				label.setFont(new Font("Arial", Font.PLAIN, 18));
				label.setBounds(156, 302, 21, 26);
				pnAsignacionRedes.add(label);
			}
			{
				JLabel lblRedE = new JLabel("Red E:");
				lblRedE.setBounds(15, 278, 57, 20);
				pnAsignacionRedes.add(lblRedE);
			}
			{
				txtRedE = new JTextField();
				txtRedE.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c))&&(c!='.'))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtRedE.setColumns(10);
				txtRedE.setBounds(15, 302, 135, 26);
				pnAsignacionRedes.add(txtRedE);
			}
			{
				txtMascaraE = new JTextField();
				txtMascaraE.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c)))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtMascaraE.setColumns(10);
				txtMascaraE.setBounds(166, 302, 40, 26);
				pnAsignacionRedes.add(txtMascaraE);
			}
			{
				JLabel label = new JLabel("/");
				label.setFont(new Font("Arial", Font.PLAIN, 18));
				label.setBounds(156, 368, 21, 26);
				pnAsignacionRedes.add(label);
			}
			{
				JLabel lblRedF = new JLabel("Red F:");
				lblRedF.setBounds(15, 344, 57, 20);
				pnAsignacionRedes.add(lblRedF);
			}
			{
				txtRedF = new JTextField();
				txtRedF.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c))&&(c!='.'))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtRedF.setColumns(10);
				txtRedF.setBounds(15, 368, 135, 26);
				pnAsignacionRedes.add(txtRedF);
			}
			{
				txtMascaraF = new JTextField();
				txtMascaraF.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c)))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtMascaraF.setColumns(10);
				txtMascaraF.setBounds(166, 368, 40, 26);
				pnAsignacionRedes.add(txtMascaraF);
			}
			{
				JLabel label = new JLabel("/");
				label.setFont(new Font("Arial", Font.PLAIN, 18));
				label.setBounds(156, 434, 21, 26);
				pnAsignacionRedes.add(label);
			}
			{
				JLabel lblRedG = new JLabel("Red G:");
				lblRedG.setBounds(15, 410, 57, 20);
				pnAsignacionRedes.add(lblRedG);
			}
			{
				txtRedG = new JTextField();
				txtRedG.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c))&&(c!='.'))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtRedG.setColumns(10);
				txtRedG.setBounds(15, 434, 135, 26);
				pnAsignacionRedes.add(txtRedG);
			}
			{
				txtMascaraG = new JTextField();
				txtMascaraG.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if((!(Character.isDigit(c)))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)) {
							e.consume();
						}
					}
				});
				txtMascaraG.setColumns(10);
				txtMascaraG.setBounds(166, 434, 40, 26);
				pnAsignacionRedes.add(txtMascaraG);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				btnConfirmar = new JButton("Confirmar Red");
				btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtRedA.getText().equalsIgnoreCase("") && !txtRedB.getText().equalsIgnoreCase("")
							&& !txtRedC.getText().equalsIgnoreCase("") && !txtRedD.getText().equalsIgnoreCase("")
							&&!txtRedE.getText().equalsIgnoreCase("") && !txtRedF.getText().equalsIgnoreCase("")
							&&!txtRedG.getText().equalsIgnoreCase("") && !txtMascaraA.getText().equalsIgnoreCase("")
							&& !txtMascaraB.getText().equalsIgnoreCase("") && !txtMascaraC.getText().equalsIgnoreCase("")
							&& !txtMascaraD.getText().equalsIgnoreCase("") && !txtMascaraE.getText().equalsIgnoreCase("")
							&& !txtMascaraF.getText().equalsIgnoreCase("") && !txtMascaraG.getText().equalsIgnoreCase("")) {

					        for (int i = 0; i <7; i++) {
					        	int octetos[] = new int[5];
					        	String red = "";
								switch (i) {
									case 0: octetos=obtenerIP(txtRedA.getText(), (txtMascaraA.getText())); red = "RED A"; break;
									case 1: octetos=obtenerIP(txtRedB.getText(), (txtMascaraB.getText())); red = "RED B"; break;
									case 2: octetos=obtenerIP(txtRedC.getText(), (txtMascaraC.getText())); red = "RED C"; break;
									case 3: octetos=obtenerIP(txtRedD.getText(), (txtMascaraD.getText())); red = "RED D"; break;
									case 4: octetos=obtenerIP(txtRedE.getText(), (txtMascaraE.getText())); red = "RED E"; break;
									case 5: octetos=obtenerIP(txtRedF.getText(), (txtMascaraF.getText())); red = "RED F"; break;
									case 6: octetos=obtenerIP(txtRedG.getText(), (txtMascaraG.getText())); red = "RED G"; break;
								}
								DireccionIP direccionIP = new DireccionIP(octetos[0], octetos[1], octetos[2], octetos[3], octetos[4]);
								SistemaEnrutamiento.getInstance().ingresarDireccionIP(direccionIP);
								Red redIng = new Red(red+SistemaEnrutamiento.getInstance().getGeneradorCodigoRed());
								redIng.establecerDireccionRed(direccionIP.direccionRed(direccionIP));
								redIng.establecerDireccionBroadcast(direccionIP.direccionBroadcast(direccionIP));
								SistemaEnrutamiento.getInstance().ingresarRed(redIng);
							}

					        try {
								asignarRed();
								btnConfirmar.setEnabled(false);
								btnAceptar.setEnabled(true);
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "ERROR");
							}

						}else {
							JOptionPane.showMessageDialog(null, "Llene todos los campos");
						}
					}
				});
				buttonPane.add(btnConfirmar);
			}
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int j = 0;
						for (int i = 0; i <5; i++) {
							String nombreR = "";
							switch (i) {
								case 0: nombreR = "Router 1"; break;
								case 1: nombreR = "Router 2"; break;
								case 2: nombreR = "Router 3"; break;
								case 3: nombreR = "Router 4"; break;
								case 4: nombreR = "Router 5"; break;
							}
							Router router = new Router(nombreR, nombreR);
							SistemaEnrutamiento.getInstance().ingresarRouter(router);
						}
						for (int i = 0; i <14; i++) {
							DireccionIP ip = null; 
							if(i%2==0) {
								ip = SistemaEnrutamiento.getInstance().getMisRedes().get(j).establecerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(j).getDireccionRed(), 1);
							}else {
								ip = SistemaEnrutamiento.getInstance().getMisRedes().get(j).establecerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(j).getDireccionRed(), 2);
								j++;
							}
							String codigo="", nombre="";
							switch (i) {
								case 0: codigo = "Router 1"; nombre = "Router 1 - E0/0"; break;
								case 1: codigo = "Router 2"; nombre = "Router 2 - E0/0"; break;
								case 2: codigo = "Router 1"; nombre = "Router 1 - E0/1"; break;
								case 3: codigo = "Router 3"; nombre = "Router 3 - E0/1"; break;
								case 4: codigo = "Router 2"; nombre = "Router 2 - E0/2"; break;
								case 5: codigo = "Router 3"; nombre = "Router 3 - E0/2"; break;
								case 6: codigo = "Router 2"; nombre = "Router 2 - E0/3"; break;
								case 7: codigo = "Router 4"; nombre = "Router 4 - E0/3"; break;
								case 8: codigo = "Router 4"; nombre = "Router 4 - E0/0"; break;
								case 9: codigo = "Router 5"; nombre = "Router 5 - E0/0"; break;
								case 10: codigo = "Router 3"; nombre = "Router 3 - E0/3"; break;
								case 11: codigo = "Router 5"; nombre = "Router 5 - E0/3"; break;
								case 12: codigo = "Router 2"; nombre = "Router 2 - E0/1"; break;
								case 13: codigo = "Router 5"; nombre = "Router 5 - E0/1"; break;
							}
							Interfaz interfaz = new Interfaz(codigo, nombre, ip);
							SistemaEnrutamiento.getInstance().ingresarInterfaces(interfaz);
							
							for (int k = 0; k < 5; k++) {
								if(SistemaEnrutamiento.getInstance().getMisRouters().get(k).getNombreRouter().equalsIgnoreCase(codigo)) {
									SistemaEnrutamiento.getInstance().getMisRouters().get(k).asignarInterfaces(interfaz);
								}									
							}
						}
						FrmPrincipal.btnEnrutamientos.setEnabled(true);
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(0).getInterfaces().get(0).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(0).getInterfaces().get(0).getDireccionIP().obtenerIP());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(0).getInterfaces().get(1).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(0).getInterfaces().get(1).getDireccionIP().obtenerIP());
//						
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(1).getInterfaces().get(0).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(1).getInterfaces().get(0).getDireccionIP().obtenerIP());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(1).getInterfaces().get(1).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(1).getInterfaces().get(1).getDireccionIP().obtenerIP());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(1).getInterfaces().get(2).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(1).getInterfaces().get(2).getDireccionIP().obtenerIP());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(1).getInterfaces().get(3).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(1).getInterfaces().get(3).getDireccionIP().obtenerIP());
//						
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(2).getInterfaces().get(0).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(2).getInterfaces().get(0).getDireccionIP().obtenerIP());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(2).getInterfaces().get(1).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(2).getInterfaces().get(1).getDireccionIP().obtenerIP());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(2).getInterfaces().get(2).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(2).getInterfaces().get(2).getDireccionIP().obtenerIP());
//						
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(3).getInterfaces().get(0).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(3).getInterfaces().get(0).getDireccionIP().obtenerIP());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(3).getInterfaces().get(1).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(3).getInterfaces().get(1).getDireccionIP().obtenerIP());
//						
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(4).getInterfaces().get(0).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(4).getInterfaces().get(0).getDireccionIP().obtenerIP());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(4).getInterfaces().get(1).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(4).getInterfaces().get(1).getDireccionIP().obtenerIP());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(4).getInterfaces().get(2).getNombreInterfaz()+": "+SistemaEnrutamiento.getInstance().getMisRouters().get(4).getInterfaces().get(2).getDireccionIP().obtenerIP());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(0).getInterfaces().size());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(1).getInterfaces().size());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(2).getInterfaces().size());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(3).getInterfaces().size());
//						System.out.println(SistemaEnrutamiento.getInstance().getMisRouters().get(4).getInterfaces().size());

						dispose();
					}
				});
				btnAceptar.setEnabled(false);
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		probando();
		
	}
	
	public void probando() {
		txtRedA.setText("10.0.0.0");
		txtMascaraA.setText("30");		
		txtRedB.setText("10.0.0.4");
		txtMascaraB.setText("30");
		txtRedC.setText("10.0.0.8");
		txtMascaraC.setText("30");
		txtRedD.setText("10.0.0.12");
		txtMascaraD.setText("30");
		txtRedE.setText("10.0.0.16");
		txtMascaraE.setText("30");
		txtRedF.setText("10.0.0.20");
		txtMascaraF.setText("30");
		txtRedG.setText("10.0.0.24");
		txtMascaraG.setText("30");
	}
	//Para comprobar si la sintaxis de la direccion ip esta bien:
	//Sintaxis correcta:
	//(solo numeros y .)
	//3 puntos (OBLIGATORIO)
	//Numeros = (0-255)
	
	public int[] obtenerIP(String ip, String mascara) {
        char[] chars = (ip+".").toCharArray();
        String aux = "";
        int octetos[] = new int[5];
        int j=0;
        for (char ch : chars) {
        	if(ch!='.') {
        		aux=aux+ch;
        	}else {
        		octetos[j]=Integer.parseInt(aux);
        		aux="";
        		j++;
        	}
        }
        octetos[4]=Integer.parseInt(mascara);
        return octetos;
	}
	
	public void comprobarSintaxisIP(String direccionIPComprobar) {
		if(!SistemaEnrutamiento.getInstance().direccionIPSintaxisValida((txtRedA.getText()))) {
			JOptionPane.showMessageDialog(null, "DireccionIPInvalida", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}
		if( !(txtRedA.getText().equalsIgnoreCase("")) && !(txtMascaraA.getText().equalsIgnoreCase("")) 
			&& !(txtRedB.getText().equalsIgnoreCase("")) && !(txtMascaraB.getText().equalsIgnoreCase("")) 
			&& !(txtRedC.getText().equalsIgnoreCase("")) && !(txtMascaraC.getText().equalsIgnoreCase("")) 
			&& !(txtRedD.getText().equalsIgnoreCase("")) && !(txtMascaraD.getText().equalsIgnoreCase(""))
			&& !(txtRedE.getText().equalsIgnoreCase("")) && !(txtMascaraE.getText().equalsIgnoreCase(""))
			&& !(txtRedF.getText().equalsIgnoreCase("")) && !(txtMascaraF.getText().equalsIgnoreCase(""))
			&& !(txtRedG.getText().equalsIgnoreCase("")) && !(txtMascaraG.getText().equalsIgnoreCase(""))) {
			btnConfirmar.setEnabled(true);
			
		}else {
			btnConfirmar.setEnabled(false);
		}
	}
	




//
//	public boolean comprobarDireccionIPCampo(int red) {
//		boolean aux = false;
//		int contador = 0;
//		int mascara=0;
//		String ip="";
//		switch (red) {
//			case 1: ip = txtRedA.getText(); mascara = Integer.parseInt(txtMascaraA.getText()); break;
//			case 2: ip = txtRedB.getText(); mascara = Integer.parseInt(txtMascaraB.getText()); break;
//			case 3: ip = txtRedC.getText(); mascara = Integer.parseInt(txtMascaraC.getText()); break;
//			case 4: ip = txtRedD.getText(); mascara = Integer.parseInt(txtMascaraD.getText()); break;
//			case 5: ip = txtRedE.getText(); mascara = Integer.parseInt(txtMascaraE.getText()); break;
//			case 6: ip = txtRedF.getText(); mascara = Integer.parseInt(txtMascaraF.getText()); break;
//			case 7: ip = txtRedG.getText(); mascara = Integer.parseInt(txtMascaraG.getText()); break;
//		}
//		ip=ip+".";
//        char[] chars = ip.toCharArray();
//        String aux2 = "";
//        int j=0;
//        int octetos[] = new int[4];
//        for (char ch : chars) {
//            if(ch!='.') {
//            	aux2=aux2+ch;
//            }else {
//            	if(Integer.parseInt(aux2)<255 && Integer.parseInt(aux2)>=0 ) {
//            		contador++;
//            		octetos[j]=Integer.parseInt(aux2);
//            		j++;
//            	}
//            	aux2="";
//            }
//        }
//        
//        DireccionIP dirIP = new DireccionIP(octetos[0], octetos[1], octetos[2], octetos[3], mascara);
//        
//        if(contador==4 && (mascara>0&&mascara<31) && !SistemaEnrutamiento.getInstance().existeIP(dirIP)) {
//        	aux = true;
//        }
//		
//        return aux;
//		
//	}
//	
//	public void habilitarRed(int red) {
//		switch (red) {
//		case 1: 
//			txtRedA.setEnabled(true);
//			txtMascaraA.setEnabled(true);
//			txtRedB.setEnabled(false);
//			txtMascaraB.setEnabled(false);
//			break;
//			
//		case 2:
//			txtRedB.setEnabled(true);
//			txtMascaraB.setEnabled(true);
//			txtRedA.setEnabled(false);
//			txtMascaraA.setEnabled(false);			
//			txtRedC.setEnabled(false);
//			txtMascaraC.setEnabled(false);
//			break;
//		
//		case 3:
//			txtRedC.setEnabled(true);
//			txtMascaraC.setEnabled(true);
//			txtRedB.setEnabled(false);
//			txtMascaraB.setEnabled(false);			
//			txtRedD.setEnabled(false);
//			txtMascaraD.setEnabled(false);
//			break;
//		
//		case 4:
//			txtRedD.setEnabled(true);
//			txtMascaraD.setEnabled(true);
//			txtRedC.setEnabled(false);
//			txtMascaraC.setEnabled(false);			
//			txtRedE.setEnabled(false);
//			txtMascaraE.setEnabled(false);
//			break;
//		
//		case 5:
//			txtRedE.setEnabled(true);
//			txtMascaraE.setEnabled(true);
//			txtRedD.setEnabled(false);
//			txtMascaraD.setEnabled(false);			
//			txtRedF.setEnabled(false);
//			txtMascaraF.setEnabled(false);
//			break;
//		
//		case 6:
//			txtRedF.setEnabled(true);
//			txtMascaraF.setEnabled(true);
//			txtRedE.setEnabled(false);
//			txtMascaraE.setEnabled(false);			
//			txtRedG.setEnabled(false);
//			txtMascaraG.setEnabled(false);
//			break;
//		
//		case 7:
//			txtRedG.setEnabled(true);
//			txtMascaraG.setEnabled(true);
//			txtRedF.setEnabled(false);
//			txtMascaraF.setEnabled(false);
//			break;
//		}
//	}
//	
	public void asignarRed() {
		String ip = "";
		DireccionIP dirIP = null;
		for (int i = 1; i < 8; i++) {
			switch (i) {
				case 1: 
					ip = txtRedA.getText()+"/"+Integer.parseInt(txtMascaraA.getText());
					dirIP = SistemaEnrutamiento.getInstance().buscarIP(ip);
					txtRedA.setText(""+dirIP.direccionRed(dirIP).obtenerIP());
					break;
				
				case 2: 
					ip = txtRedB.getText()+"/"+Integer.parseInt(txtMascaraB.getText());
					dirIP = SistemaEnrutamiento.getInstance().buscarIP(ip);
					txtRedB.setText(""+dirIP.direccionRed(dirIP).obtenerIP());
					break;
				
				case 3: 
					ip = txtRedC.getText()+"/"+Integer.parseInt(txtMascaraC.getText()); 
					dirIP = SistemaEnrutamiento.getInstance().buscarIP(ip);
					txtRedC.setText(""+dirIP.direccionRed(dirIP).obtenerIP());
					break;
				
				case 4: 
					ip = txtRedD.getText()+"/"+Integer.parseInt(txtMascaraD.getText()); 
					dirIP = SistemaEnrutamiento.getInstance().buscarIP(ip);
					txtRedD.setText(""+dirIP.direccionRed(dirIP).obtenerIP());
					break;
				
				case 5: 
					ip = txtRedE.getText()+"/"+Integer.parseInt(txtMascaraE.getText()); 
					dirIP = SistemaEnrutamiento.getInstance().buscarIP(ip);
					txtRedE.setText(""+dirIP.direccionRed(dirIP).obtenerIP());
					break;
				
				case 6: 
					ip = txtRedF.getText()+"/"+Integer.parseInt(txtMascaraF.getText()); 
					dirIP = SistemaEnrutamiento.getInstance().buscarIP(ip);
					txtRedF.setText(""+dirIP.direccionRed(dirIP).obtenerIP());
					break;
				
				case 7: 
					ip = txtRedG.getText()+"/"+Integer.parseInt(txtMascaraG.getText()); 
					dirIP = SistemaEnrutamiento.getInstance().buscarIP(ip);
					txtRedG.setText(""+dirIP.direccionRed(dirIP).obtenerIP());
					break;
				
			}
		}
		
		
	}

}
