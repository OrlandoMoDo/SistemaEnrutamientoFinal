package Logico;

public class Enrutamiento {
	
	private String codigoEnrutamiento;
	private Red redDestino;
	private DireccionIP nextHop;
	private int distanciaAdministrativa;
	private int metrica;
	private String protocoloEnrutamiento;
	private Interfaz interfazSalida;
	
	public Enrutamiento(String codigoEnrutamiento, Red redDestino, DireccionIP nextHop, int distanciaAdministrativa,
			int metrica, String protocoloEnrutamiento, Interfaz interfazSalida) {
		this.codigoEnrutamiento = codigoEnrutamiento;
		this.redDestino = redDestino;
		this.nextHop = nextHop;
		this.distanciaAdministrativa = distanciaAdministrativa;
		this.metrica = metrica;
		this.protocoloEnrutamiento = protocoloEnrutamiento;
		this.interfazSalida = interfazSalida;
	}
	
	public String getCodigoEnrutamiento() {
		return codigoEnrutamiento;
	}
	public void setCodigoEnrutamiento(String codigoEnrutamiento) {
		this.codigoEnrutamiento = codigoEnrutamiento;
	}
	public Red getRedDestino() {
		return redDestino;
	}
	public void setRedDestino(Red redDestino) {
		this.redDestino = redDestino;
	}
	public DireccionIP getNextHop() {
		return nextHop;
	}
	public void setNextHop(DireccionIP nextHop) {
		this.nextHop = nextHop;
	}
	public int getDistanciaAdministrativa() {
		return distanciaAdministrativa;
	}
	public void setDistanciaAdministrativa(int distanciaAdministrativa) {
		this.distanciaAdministrativa = distanciaAdministrativa;
	}
	public int getMetrica() {
		return metrica;
	}
	public void setMetrica(int metrica) {
		this.metrica = metrica;
	}
	public String getProtocoloEnrutamiento() {
		return protocoloEnrutamiento;
	}
	public void setProtocoloEnrutamiento(String protocoloEnrutamiento) {
		this.protocoloEnrutamiento = protocoloEnrutamiento;
	}
	public Interfaz getInterfazSalida() {
		return interfazSalida;
	}
	public void setInterfazSalida(Interfaz interfazSalida) {
		this.interfazSalida = interfazSalida;
	}
	
	public boolean estaPresenteIPenEnrutamiento(DireccionIP ip) {
		boolean aux = true;
		String ipBinario = ip.obtenerIPBinario();
		String ipDireccionRed = redDestino.getDireccionRed().obtenerIPBinario();
//		System.out.println(ipBinario);
//		System.out.println(ipDireccionRed);
        char[] chars = ipBinario.toCharArray();
        char[] chars2 = ipDireccionRed.toCharArray();
        for (int i = 0; i < redDestino.getDireccionRed().getMascara(); i++) {
			if(chars[i]!=chars2[i]) {
				aux=false;
			}
		}
        
//		if()
		
		return aux;
	}

}
