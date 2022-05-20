package Logico;

import java.util.ArrayList;

public class Red {
	
	private String codigoRed;
	private DireccionIP direccionRed;
	private ArrayList<DireccionIP> hosts;
	private DireccionIP direccionBroadcast;

	public Red(String codigoRed) {
		this.codigoRed = codigoRed;
		this.direccionRed = null;
		this.hosts = new ArrayList<DireccionIP>();
		this.direccionBroadcast = null;
	}

	public String getCodigoRed() {
		return codigoRed;
	}

	public void setCodigoRed(String codigoRed) {
		this.codigoRed = codigoRed;
	}

	public DireccionIP getDireccionRed() {
		return direccionRed;
	}

	public void setDireccionRed(DireccionIP direccionRed) {
		this.direccionRed = direccionRed;
	}

	public ArrayList<DireccionIP> getHosts() {
		return hosts;
	}

	public void setHosts(ArrayList<DireccionIP> hosts) {
		this.hosts = hosts;
	}

	public DireccionIP getDireccionBroadcast() {
		return direccionBroadcast;
	}

	public void setDireccionBroadcast(DireccionIP direccionBroadcast) {
		this.direccionBroadcast = direccionBroadcast;
	}
	
	public void establecerDireccionRed(DireccionIP direccionIp) {
		
		direccionRed = direccionIp.direccionRed(direccionIp);
		
	}
	
	public void establecerDireccionBroadcast(DireccionIP direccionIp) {
		
		direccionBroadcast = direccionIp.direccionBroadcast(direccionIp);
		
	}
	
	public DireccionIP establecerHosts(DireccionIP direccionIPAux, int noHost) {
		DireccionIP direccionIPRed = direccionIPAux.direccionRed(direccionIPAux);
//		int cantidad = direccionIPAux.cantidadHost(direccionIPAux);
		DireccionIP aux = null;
		DireccionIP direccion = new DireccionIP(direccionIPRed.getPrimerOcteto(), direccionIPRed.getSegundoOcteto(), 
				direccionIPRed.getTercerOcteto(), (direccionIPRed.getCuartoOcteto()+noHost), 
				direccionIPRed.getMascara());
		SistemaEnrutamiento.getInstance().ingresarDireccionIP(direccion);
		hosts.add(direccion);
		aux = direccion;
		return aux;

		
	}
	
	public DireccionIP obtenerHosts(DireccionIP direccionIPAux, int noHost) {
		DireccionIP direccionIPRed = direccionIPAux.direccionRed(direccionIPAux);
//		int cantidad = direccionIPAux.cantidadHost(direccionIPAux);
		DireccionIP aux = null;
		DireccionIP direccion = new DireccionIP(direccionIPRed.getPrimerOcteto(), direccionIPRed.getSegundoOcteto(), 
				direccionIPRed.getTercerOcteto(), (direccionIPRed.getCuartoOcteto()+noHost), 
				direccionIPRed.getMascara());
		aux = direccion;
		return aux;

		
	}
	
	
}
