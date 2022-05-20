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

import Logico.DireccionIP;
import Logico.SistemaEnrutamiento;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmVisualizarTopologia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JLabel lblImagenTopologia;
	private Image imagenTopologia = new ImageIcon(FrmVisualizarTopologia.class.getResource("Imagenes/Topologia.png")).getImage().getScaledInstance(430, 400, Image.SCALE_SMOOTH);
	private JLabel lblGatewayC_1;
	private JLabel lblGatewayC_2;
	private JLabel lblGatewayA_2;
	private JLabel lblGatewayA_1;
	private JLabel lblGatewayB_1;
	private JLabel lblGatewayB_2;
	private JLabel lblGatewayE_1;
	private JLabel lblGatewayD_1;
	private JLabel lblGatewayF_1;
	private JLabel lblGatewayG_1;
	private JLabel lblGatewayD_2;
	private JLabel lblRedA;
	private JLabel lblRedB;
	private JLabel lblRedC;
	private JLabel lblRedD;
	private JLabel lblRedE;
	private JLabel lblRedF;
	private JLabel lblRedG;
	private JLabel lblGatewayE_2;
	private JLabel lblGatewayF_2;
	private JLabel lblGatewayG_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmVisualizarTopologia dialog = new FrmVisualizarTopologia();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmVisualizarTopologia() {
		setBounds(100, 100, 695, 578);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Visualizacion de la Topologia");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(15, 16, 659, 462);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblGatewayB_2 = new JLabel(".255");
		lblGatewayB_2.setForeground(Color.RED);
		lblGatewayB_2.setBounds(485, 147, 32, 20);
		panel.add(lblGatewayB_2);
		
		lblGatewayF_1 = new JLabel(".255");
		lblGatewayF_1.setForeground(Color.RED);
		lblGatewayF_1.setBounds(497, 232, 32, 20);
		panel.add(lblGatewayF_1);
		
		lblGatewayD_2 = new JLabel(".255");
		lblGatewayD_2.setForeground(Color.RED);
		lblGatewayD_2.setBounds(100, 346, 32, 20);
		panel.add(lblGatewayD_2);
		
		lblGatewayE_1 = new JLabel(".255");
		lblGatewayE_1.setForeground(Color.RED);
		lblGatewayE_1.setBounds(182, 374, 32, 20);
		panel.add(lblGatewayE_1);
		
		lblGatewayC_2 = new JLabel(".255");
		lblGatewayC_2.setForeground(Color.RED);
		lblGatewayC_2.setBounds(422, 174, 32, 20);
		panel.add(lblGatewayC_2);
		
		lblGatewayF_2 = new JLabel(".255");
		lblGatewayF_2.setForeground(Color.RED);
		lblGatewayF_2.setBounds(497, 346, 32, 20);
		panel.add(lblGatewayF_2);
		
		lblGatewayD_1 = new JLabel(".255");
		lblGatewayD_1.setForeground(Color.RED);
		lblGatewayD_1.setBounds(100, 232, 32, 20);
		panel.add(lblGatewayD_1);
		
		lblGatewayC_1 = new JLabel(".255");
		lblGatewayC_1.setForeground(Color.RED);
		lblGatewayC_1.setBounds(182, 174, 32, 20);
		panel.add(lblGatewayC_1);
		
		lblGatewayG_1 = new JLabel(".255");
		lblGatewayG_1.setForeground(Color.RED);
		lblGatewayG_1.setBounds(203, 220, 32, 20);
		panel.add(lblGatewayG_1);
		
		lblGatewayE_2 = new JLabel(".255");
		lblGatewayE_2.setForeground(Color.RED);
		lblGatewayE_2.setBounds(406, 374, 32, 20);
		panel.add(lblGatewayE_2);
		
		lblGatewayG_2 = new JLabel(".255");
		lblGatewayG_2.setForeground(Color.RED);
		lblGatewayG_2.setBounds(422, 329, 32, 20);
		panel.add(lblGatewayG_2);
		
		lblGatewayB_1 = new JLabel(".255");
		lblGatewayB_1.setForeground(Color.RED);
		lblGatewayB_1.setBounds(371, 48, 32, 20);
		panel.add(lblGatewayB_1);
		
		lblGatewayA_1 = new JLabel(".255");
		lblGatewayA_1.setForeground(Color.RED);
		lblGatewayA_1.setBounds(238, 48, 32, 20);
		panel.add(lblGatewayA_1);
		
		lblGatewayA_2 = new JLabel(".255");
		lblGatewayA_2.setForeground(Color.RED);
		lblGatewayA_2.setBounds(116, 147, 46, 20);
		panel.add(lblGatewayA_2);
		
		lblRedB = new JLabel("255.255.255.255/30");
		lblRedB.setBounds(413, 85, 147, 20);
		panel.add(lblRedB);
		
		lblRedG = new JLabel("255.255.255.255/30");
		lblRedG.setBounds(270, 258, 147, 20);
		panel.add(lblRedG);
		
		lblRedF = new JLabel("255.255.255.255/30");
		lblRedF.setBounds(497, 296, 147, 20);
		panel.add(lblRedF);
		
		lblRedD = new JLabel("255.255.255.255/30");
		lblRedD.setBounds(15, 296, 147, 20);
		panel.add(lblRedD);
		
		lblRedC = new JLabel("255.255.255.255/30");
		lblRedC.setBounds(256, 174, 147, 20);
		panel.add(lblRedC);
		
		lblRedE = new JLabel("255.255.255.255/30");
		lblRedE.setBounds(256, 404, 147, 20);
		panel.add(lblRedE);
		
		lblRedA = new JLabel("255.255.255.255/30");
		lblRedA.setBounds(75, 85, 147, 20);
		panel.add(lblRedA);
		
		lblImagenTopologia = new JLabel("");
		lblImagenTopologia.setIcon(new ImageIcon(imagenTopologia));
		lblImagenTopologia.setBounds(100, 16, 459, 430);
		panel.add(lblImagenTopologia);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
		}
		
		cargarRedes();
		cargarNextHops();
		
	}

	public void cargarRedes() {
		lblRedA.setText("...");
		lblRedB.setText("...");
		lblRedC.setText("...");
		lblRedD.setText("...");
		lblRedE.setText("...");
		lblRedF.setText("...");
		lblRedG.setText("...");
		
		for(int i=0; i<SistemaEnrutamiento.getInstance().getMisRedes().size(); i++) {
			String ip = SistemaEnrutamiento.getInstance().getMisRedes().get(i).getDireccionRed().obtenerIPMask();
			switch (i) {
				case 0: lblRedA.setText(ip); break;
				case 1: lblRedB.setText(ip); break;
				case 2: lblRedC.setText(ip); break;
				case 3: lblRedD.setText(ip); break;
				case 4: lblRedE.setText(ip); break;
				case 5: lblRedF.setText(ip); break;
				case 6: lblRedG.setText(ip); break;			
			}
		}
		
	}
	
	public void cargarNextHops() {
//		if(SistemaEnrutamiento.getInstance().getMIs)
		lblGatewayA_1.setText("...");
		lblGatewayA_2.setText("...");
		lblGatewayB_1.setText("...");
		lblGatewayB_2.setText("...");
		lblGatewayC_1.setText("...");
		lblGatewayC_2.setText("...");
		lblGatewayD_1.setText("...");
		lblGatewayD_2.setText("...");
		lblGatewayE_1.setText("...");
		lblGatewayE_2.setText("...");
		lblGatewayF_1.setText("...");
		lblGatewayF_2.setText("...");
		lblGatewayG_1.setText("...");
		lblGatewayG_2.setText("...");
		
		int j=0;
		if(SistemaEnrutamiento.getInstance().getMisRedes().size()!=0) {
			for (int i = 0; i <14; i++) {
				DireccionIP ip = null; 
				if(i%2==0) {
					ip = SistemaEnrutamiento.getInstance().getMisRedes().get(j).establecerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(j).getDireccionRed(), 1);
//				DireccionIP ip2 = SistemaEnrutamiento.getInstance().getMisRedes().get(j).establecerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(j).getDireccionRed());
				}else {
					ip = SistemaEnrutamiento.getInstance().getMisRedes().get(j).establecerHosts(SistemaEnrutamiento.getInstance().getMisRedes().get(j).getDireccionRed(), 2);
					j++;
				}
				int nextHop = ip.getCuartoOcteto();
				switch (i) {
					case 0: lblGatewayA_1.setText("."+nextHop); break;
					case 1: lblGatewayA_2.setText("."+nextHop); break;
					case 2: lblGatewayB_1.setText("."+nextHop); break;
					case 3: lblGatewayB_2.setText("."+nextHop); break;
					case 4: lblGatewayC_1.setText("."+nextHop); break;
					case 5: lblGatewayC_2.setText("."+nextHop); break;
					case 6: lblGatewayD_1.setText("."+nextHop); break;
					case 7: lblGatewayD_2.setText("."+nextHop); break;
					case 8: lblGatewayE_1.setText("."+nextHop); break;
					case 9: lblGatewayE_2.setText("."+nextHop); break;
					case 10: lblGatewayF_1.setText("."+nextHop); break;
					case 11: lblGatewayF_2.setText("."+nextHop); break;
					case 12: lblGatewayG_1.setText("."+nextHop); break;
					case 13: lblGatewayG_2.setText("."+nextHop); break;
				}
			}

		}
		
	}
}
