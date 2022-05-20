package Logico;

import java.util.ArrayList;

public class Router {
	
	private String codigoRouter;
	private String nombreRouter;
	private ArrayList<Interfaz> interfaces;
	private ArrayList<Enrutamiento> enrutamientos;
	public Router(String codigoRouter, String nombreRouter) {
		this.codigoRouter = codigoRouter;
		this.nombreRouter = nombreRouter;
		this.interfaces = new ArrayList<Interfaz>(4);
		this.enrutamientos = new ArrayList<Enrutamiento>();
	}
	public String getCodigoRouter() {
		return codigoRouter;
	}
	public void setCodigoRouter(String codigoRouter) {
		this.codigoRouter = codigoRouter;
	}
	public String getNombreRouter() {
		return nombreRouter;
	}
	public void setNombreRouter(String nombreRouter) {
		this.nombreRouter = nombreRouter;
	}
	public ArrayList<Interfaz> getInterfaces() {
		return interfaces;
	}
	public void setInterfaces(ArrayList<Interfaz> interfaces) {
		this.interfaces = interfaces;
	}
	public ArrayList<Enrutamiento> getEnrutamientos() {
		return enrutamientos;
	}
	public void setEnrutamientos(ArrayList<Enrutamiento> enrutamientos) {
		this.enrutamientos = enrutamientos;
	}
//	public void agregarInterfaces() {
//		for (int i = 0; i < 3; i++) {
//			Interfaz interfaz = new Interfaz(codigoRouter, nombreRouter+"-E0/"+i);
//			interfaces.add(interfaz);
//		}
//	}
	
	public void asignarInterfaces(Interfaz interfaz) {
		interfaces.add(interfaz);
	}
	
	public void establecerIPInterfaz(Interfaz interfaz, DireccionIP ip) {
		
		int aux = buscarInterfaz(interfaz);
		interfaces.get(aux).setDireccionIP(ip);
		interfaces.get(aux).setEnUso(true);
		
	}
	
	public int buscarInterfaz(Interfaz interfazBuscar) {
		int aux = -1;
		
		for (int i = 0; i < interfaces.size(); i++) {
			if(interfazBuscar.getNombreInterfaz().equalsIgnoreCase(interfaces.get(i).getNombreInterfaz())) {
				aux = i;
				i=interfaces.size()+1;
			}
		}
		
		return aux;
	}
	
	public void agregarEnrutamiento(Enrutamiento enrutamiento) {
		enrutamientos.add(enrutamiento);
	}
	public void ordenarInterfaces() {
		switch (nombreRouter) {
			case "Router 2": 
				Interfaz aux1 = interfaces.get(1);
				Interfaz aux2 = interfaces.get(2);
				Interfaz aux3 = interfaces.get(3);
				interfaces.set(1, aux2);
				interfaces.set(2, aux3);
				interfaces.set(3, aux1);				
				break;
				
			case "Router 4":
				Interfaz aux = interfaces.get(0);
				interfaces.set(0, interfaces.get(3));
				interfaces.set(1, aux);
				break;
			case "Router 5":
				Interfaz auxi1 = interfaces.get(1);
				Interfaz auxi2 = interfaces.get(2);
				Interfaz auxi3 = interfaces.get(3);
				interfaces.set(1, auxi3);
				interfaces.set(2, auxi1);
				interfaces.set(3, auxi2);
		
		}
		
	}
	

}
