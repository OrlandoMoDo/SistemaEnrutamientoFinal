package Logico;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class SistemaEnrutamiento {
	
	private ArrayList<DireccionIP> misDireccionesIP;
	private ArrayList<Red> misRedes;
	private ArrayList<Enrutamiento> misEnrutamientos;
	private ArrayList<Router> misRouters;
	private ArrayList<Interfaz> misInterfaces;
	
	public int generadorCodigoRed;
	public int generadorCodigoEnrutamiento;
	public int generadorCodigoRouter;
	
	public static SistemaEnrutamiento instanciaGlobal = null;
	
	public SistemaEnrutamiento() {
		super();
		this.misDireccionesIP = new ArrayList<DireccionIP>();
		this.misRedes = new ArrayList<Red>();
		this.misEnrutamientos = new ArrayList<Enrutamiento>();
		this.misRouters = new ArrayList<Router>();
		this.misInterfaces = new ArrayList<Interfaz>();
		
		this.generadorCodigoRed = 1;
		this.generadorCodigoEnrutamiento = 1;
		this.generadorCodigoRouter= 1;
			
	}
	
	//Metodo del patron Singleton
	public static SistemaEnrutamiento getInstance() {
		if(instanciaGlobal==null) {
			instanciaGlobal=new SistemaEnrutamiento();
		}		
		return instanciaGlobal;
	}

	public ArrayList<DireccionIP> getMisDireccionesIP() {
		return misDireccionesIP;
	}

	public void setMisDireccionesIP(ArrayList<DireccionIP> misDireccionesIP) {
		this.misDireccionesIP = misDireccionesIP;
	}

	public ArrayList<Red> getMisRedes() {
		return misRedes;
	}

	public void setMisRedes(ArrayList<Red> misRedes) {
		this.misRedes = misRedes;
	}

	public ArrayList<Enrutamiento> getMisEnrutamientos() {
		return misEnrutamientos;
	}

	public void setMisEnrutamientos(ArrayList<Enrutamiento> misEnrutamientos) {
		this.misEnrutamientos = misEnrutamientos;
	}

	public ArrayList<Router> getMisRouters() {
		return misRouters;
	}

	public void setMisRouters(ArrayList<Router> misRouters) {
		this.misRouters = misRouters;
	}

	public ArrayList<Interfaz> getMisInterfaces() {
		return misInterfaces;
	}

	public void setMisInterfaces(ArrayList<Interfaz> misInterfaces) {
		this.misInterfaces = misInterfaces;
	}

	public int getGeneradorCodigoRed() {
		return generadorCodigoRed;
	}

	public void setGeneradorCodigoRed(int generadorCodigoRed) {
		this.generadorCodigoRed = generadorCodigoRed;
	}

	public int getGeneradorCodigoEnrutamiento() {
		return generadorCodigoEnrutamiento;
	}

	public void setGeneradorCodigoEnrutamiento(int generadorCodigoEnrutamiento) {
		this.generadorCodigoEnrutamiento = generadorCodigoEnrutamiento;
	}

	public int getGeneradorCodigoRouter() {
		return generadorCodigoRouter;
	}

	public void setGeneradorCodigoRouter(int generadorCodigoRouter) {
		this.generadorCodigoRouter = generadorCodigoRouter;
	}
	
	public void ingresarDireccionIP(DireccionIP direccionIP) {
		this.misDireccionesIP.add(direccionIP);
	}
	
	public void ingresarRed(Red red) {
		this.misRedes.add(red);
	}
	
	public void ingresarEnrutamiento(Enrutamiento enrutamiento) {
		generadorCodigoEnrutamiento++;
		this.misEnrutamientos.add(enrutamiento);
	}
	
	public void ingresarInterfaces(Interfaz interfaz) {
		this.misInterfaces.add(interfaz);
	}
	
	public void ingresarRouter(Router router) {
		this.misRouters.add(router);
	}

	public DireccionIP buscarIP(String ip) {
		DireccionIP aux = null;
		
		for (int i = 0; i < SistemaEnrutamiento.getInstance().getMisDireccionesIP().size(); i++) {
			if(SistemaEnrutamiento.getInstance().getMisDireccionesIP().get(i).obtenerIPMask().equalsIgnoreCase(ip)) {
				aux = SistemaEnrutamiento.getInstance().getMisDireccionesIP().get(i);
			}
		}
		
		return aux;
	}

	public boolean existeIP(DireccionIP dirIP) {
		boolean aux = false;
		
		for (int i = 0; i <misDireccionesIP.size(); i++) {
			if(misDireccionesIP.get(i).obtenerIPMask().equalsIgnoreCase(dirIP.obtenerIPMask())) {
				aux=true;
			}
		}
		
		return aux;
	}
	
	
	public boolean direccionIPSintaxisValida(String direccionIPComprobar) {
		
		boolean resultado = true;
		if(!direccionIPComprobar.equalsIgnoreCase("")) {
			direccionIPComprobar=direccionIPComprobar+".";
		}
		String aux = "";
		int cantPuntos=0;
		
        char[] chars = direccionIPComprobar.toCharArray();
        char anterior1 = chars[chars.length-1];
        char anterior2 = chars[chars.length-2];
        if(anterior1!=anterior2) {
	        for (char ch : chars) {
	            
	        	if(ch!='.') {
	        		aux=aux+ch;
	        	}else {
	        		if(cantPuntos<4) {
		        		int octeto = Integer.parseInt(aux);
		        		if(!(octeto<=255 && octeto>=0)) {
		        			resultado=false;
		        		}
		        		aux="";
		        		cantPuntos++;
	        		}else {
	        			resultado = false;
	        		}
	        	}
	        	
	        }
        }else {
        	resultado = false;
        }
		
		return resultado;	
		
	}

	public Router buscarRouterNombre(String nombreRouter) {
		Router router = null;
		boolean encontrado = false;
		int i=0;
		
		while (i<misRouters.size() && !encontrado) {
			if(misRouters.get(i).getNombreRouter().equalsIgnoreCase(nombreRouter)) {
				encontrado = true;
				router = misRouters.get(i);
			}
			i++;
			
		}
		
		return router;
	}
	
	public Red buscarRed(String redBuscar) {
		Red red = null;
		boolean encontrado = false;
		int i=0;
		
		while (i<misRedes.size() && !encontrado) {
			if(misRedes.get(i).getDireccionRed().obtenerIPMask().equalsIgnoreCase(redBuscar)) {
				encontrado = true;
				red = misRedes.get(i);
			}
			i++;
			
		}
		
		return red;
		
	}
	
	public DireccionIP buscarDireccionIP(String ipBuscar) {
		DireccionIP ip = null;
		boolean encontrado = false;
		int i=0;
		
		while (i<misDireccionesIP.size() && !encontrado) {
			if(misDireccionesIP.get(i).obtenerIPMask().equalsIgnoreCase(ipBuscar)) {
				encontrado = true;
				ip = misDireccionesIP.get(i);
			}
			i++;
			
		}
		
		return ip;
		
	}
	
	public Red direccionIPbyIp(String ip, String mask) {
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
        octetos[4]=Integer.parseInt(mask);
        DireccionIP ipDir = new DireccionIP(octetos[0], octetos[1], octetos[2], octetos[3], octetos[4]);
		Red redAux = new Red("");
		redAux.establecerDireccionRed(ipDir);
		
		return redAux;
	}
	
	public DireccionIP direccionIPbyIp2(String ip, String mask) {
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
        octetos[4]=Integer.parseInt(mask);
        DireccionIP ipDir = new DireccionIP(octetos[0], octetos[1], octetos[2], octetos[3], octetos[4]);
		
		return ipDir;
	}
	
	public ArrayList<Enrutamiento> rutasDireccion(String ip) {
		ArrayList<Enrutamiento> rutasDireccion = new ArrayList<Enrutamiento>();
		DireccionIP ipAuxiliar = direccionIPbyIp2(ip, "0");
		
		for (int i = 0; i <SistemaEnrutamiento.getInstance().getMisEnrutamientos().size(); i++) {
			if(SistemaEnrutamiento.getInstance().getMisEnrutamientos().get(i).estaPresenteIPenEnrutamiento(ipAuxiliar)) {
				rutasDireccion.add(SistemaEnrutamiento.getInstance().getMisEnrutamientos().get(i));
			}
		}
		
		return rutasDireccion;
		
	}
	
	public int mascaraMayor(ArrayList<Enrutamiento> enrutamientosDireccion) {
		int aux = enrutamientosDireccion.get(0).getRedDestino().getDireccionRed().getMascara();
		
		for (int i = 1; i < enrutamientosDireccion.size(); i++) {
			if(enrutamientosDireccion.get(i).getRedDestino().getDireccionRed().getMascara()>aux) {
				aux=enrutamientosDireccion.get(i).getRedDestino().getDireccionRed().getMascara();
			}
		}
		return aux;
		
	}
	
	public int distanciaADministrativaMenor(ArrayList<Enrutamiento> enrutamientosDireccion) {
		int aux = (int) (enrutamientosDireccion.get(0).getDistanciaAdministrativa());
		
		for (int i = 1; i < enrutamientosDireccion.size(); i++) {
			if(enrutamientosDireccion.get(i).getDistanciaAdministrativa()<aux) {
				aux=(int) enrutamientosDireccion.get(i).getDistanciaAdministrativa();
			}
		}
		return aux;
		
	}
	
	public int metricaMenor(ArrayList<Enrutamiento> enrutamientosDireccion) {
		int aux = (int) (enrutamientosDireccion.get(0).getMetrica());
		
		for (int i = 1; i < enrutamientosDireccion.size(); i++) {
			if(enrutamientosDireccion.get(i).getMetrica()<aux) {

				aux=(int) enrutamientosDireccion.get(i).getMetrica();
			}
		}
		return aux;
		
	}
	
	public Enrutamiento buscarEnrutamientoCodigo(String codigo) {
		
		Enrutamiento enrutamientoAux = null;
		boolean encontrado = false;
		int i=0;
		while (i<misEnrutamientos.size() && !encontrado) {
			JOptionPane.showMessageDialog(null, misEnrutamientos.get(i).getCodigoEnrutamiento()+" - "+codigo);
			JOptionPane.showMessageDialog(null, misEnrutamientos.get(i).getCodigoEnrutamiento().equalsIgnoreCase(codigo));

			if(misEnrutamientos.get(i).getCodigoEnrutamiento().equalsIgnoreCase(codigo)) {
				encontrado = true;
				enrutamientoAux = misEnrutamientos.get(i);
			}
			i++;
			
		}
		
		return enrutamientoAux;
	
	}
	
	public int buscarIndiceEnrutamiento(Enrutamiento enrutamiento) {
		
		int aux = 0;
		boolean encontrado = false;
		int i=0;
		while (i<misEnrutamientos.size() && !encontrado) {
			if(misEnrutamientos.get(i).getCodigoEnrutamiento().equalsIgnoreCase(enrutamiento.getCodigoEnrutamiento())) {
				encontrado = true;
				aux = i;
			}
			i++;			
		}		
		
		return aux;
	
	}
	
	public void EliminarEnrutamiento(int indiceEliminar) {
		misEnrutamientos.remove(indiceEliminar);
	}
	

}
