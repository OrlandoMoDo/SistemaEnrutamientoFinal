package Logico;

public class Interfaz {
	
	private String codigoRouter;
	private String nombreInterfaz;
	private DireccionIP direccionIP;
	private boolean enUso;
	
	public Interfaz(String codigoRouter, String nombreInterfaz, DireccionIP ip) {
		this.codigoRouter = codigoRouter;
		this.nombreInterfaz = nombreInterfaz;
		this.direccionIP = ip;
		this.enUso = true;
	}
	
	public String getCodigoRouter() {
		return codigoRouter;
	}
	public void setCodigoRouter(String codigoRouter) {
		this.codigoRouter = codigoRouter;
	}
	public String getNombreInterfaz() {
		return nombreInterfaz;
	}
	public void setNombreInterfaz(String nombreInterfaz) {
		this.nombreInterfaz = nombreInterfaz;
	}
	public DireccionIP getDireccionIP() {
		return direccionIP;
	}
	public void setDireccionIP(DireccionIP direccionIP) {
		this.direccionIP = direccionIP;
	}
	public boolean isEnUso() {
		return enUso;
	}
	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}	
	
	

}
