package Logico;

import java.util.ArrayList;

public class DireccionIP {
	
	private int primerOcteto;  //0-255
	private int segundoOcteto; //0-255
	private int tercerOcteto;  //0-255
	private int cuartoOcteto;  //0-255
	private int mascara;	   //8-30
	
	public DireccionIP(int primerOcteto, int segundoOcteto, int tercerOcteto, int cuartoOcteto, int mascara) {
		this.primerOcteto = primerOcteto;
		this.segundoOcteto = segundoOcteto;
		this.tercerOcteto = tercerOcteto;
		this.cuartoOcteto = cuartoOcteto;
		this.mascara = mascara;
	}

	public int getPrimerOcteto() {
		return primerOcteto;
	}

	public void setPrimerOcteto(int primerOcteto) {
		this.primerOcteto = primerOcteto;
	}

	public int getSegundoOcteto() {
		return segundoOcteto;
	}

	public void setSegundoOcteto(int segundoOcteto) {
		this.segundoOcteto = segundoOcteto;
	}

	public int getTercerOcteto() {
		return tercerOcteto;
	}

	public void setTercerOcteto(int tercerOcteto) {
		this.tercerOcteto = tercerOcteto;
	}

	public int getCuartoOcteto() {
		return cuartoOcteto;
	}

	public void setCuartoOcteto(int cuartoOcteto) {
		this.cuartoOcteto = cuartoOcteto;
	}

	public int getMascara() {
		return mascara;
	}

	public void setMascara(int mascara) {
		this.mascara = mascara;
	}
	
	public String obtenerMascara(int mascaraParametro) {
		String mascara = "";
		int octetos[] = new int[4];
		
		for (int i = 0; i < 4; i++) {
			if(mascaraParametro>8) {
				octetos[i] = 8;
				mascaraParametro-=8;
			}else if(mascaraParametro>0){
				octetos[i] = mascaraParametro;
				mascaraParametro-=mascaraParametro;
			}else {
				mascaraParametro=0;
			}
			
			octetos[i]=mascaraMult(octetos[i]);
			
		}
		mascara = octetos[0]+"."+octetos[1]+"."+octetos[2]+"."+octetos[3];
		return mascara;
	}
	
	public int mascaraMult(int parametro) {
		int aux = 0;
		int numeroAuxiliar = 7;
		for (int i = 0; i <parametro; i++) {
			aux+=Math.pow(2, numeroAuxiliar);
			numeroAuxiliar--;
		}
		return aux;
	}
	
	public String obtenerIP() {
		String direccion = primerOcteto+"."+segundoOcteto+"."+tercerOcteto+"."+cuartoOcteto;
		return direccion;
	}
	
	public String obtenerIPBinario() {
		String octetos[] = new String[4];

		octetos[0] = Long.toBinaryString(primerOcteto);
		octetos[1] = Long.toBinaryString(segundoOcteto);
		octetos[2] = Long.toBinaryString(tercerOcteto);
		octetos[3] = Long.toBinaryString(cuartoOcteto);
		
		for (int i = 0; i < 4; i++) {
			int cant=8-octetos[i].length();
			String octetosAux = octetos[i];
			octetos[i]="";
			for (int j = 0; j < cant; j++) {
				octetos[i]=octetos[i]+0;
			}
			octetos[i]=octetos[i]+octetosAux;
		}
		
		String direccion = octetos[0]+octetos[1]+octetos[2]+octetos[3];
		return direccion;
	}
	
	public String obtenerIPMask() {
		String direccion = primerOcteto+"."+segundoOcteto+"."+tercerOcteto+"."+cuartoOcteto+"/"+mascara;
		return direccion;
	}
	
	public String tipoIP(DireccionIP parametro) {
		
		String tipo = "";
		boolean encontrado = false;		
		String ipBinario = parametro.obtenerIPBinario();
		
		char[] chars = ipBinario.toCharArray();
		int mascara = parametro.getMascara();
		String ipAux = "";
        
		//Todos los bits de host en 0:
		for (int i=0; i<chars.length; i++) {
            if(mascara>0) {
            	mascara--;
            }else {
            	chars[i]='0';
            }
            ipAux=ipAux+chars[i];
        }

		//Si la ip con los bits de host en 0 coincide con la ip dada por parametro, es de red:
        if(ipAux.equalsIgnoreCase(ipBinario)) {
        	tipo="red";
        	encontrado=true;
        }
        
        //Si no se encuentra que es de red, probamos que sea de broadcast:
        if(!encontrado) {
    		chars = ipBinario.toCharArray();
    		mascara = parametro.getMascara();
    		ipAux="";
    		
    		//Convirtiendo Todos los bits de host en 1:
    		for (int i=0; i<chars.length; i++) {
                if(mascara>0) {
                	mascara--;
                }else {
                	chars[i]='1';
                }
                ipAux=ipAux+chars[i];

            }
    		//Si la ip con los bits de host en 1 coincide con la ip dada por parametro, es de broadcast:

            if(ipAux.equalsIgnoreCase(ipBinario)) {
            	tipo="broadcast";
            	encontrado=true;
            }
        }
        
        //Si no se cumple lo anterior es de broadcast:
        if(!encontrado) {
        	tipo="host";
        }
        
		return tipo;
	}
	
	public DireccionIP direccionRed(DireccionIP direccionIpAux) {
		
		String ipBinario = direccionIpAux.obtenerIPBinario();
		
		char[] chars = ipBinario.toCharArray();
		int mascara = direccionIpAux.getMascara();
		String ipAux = "";
    	String aux = ipAux;
    	
    	int octetos[]= new int[4];
    	int j=0;

		//Todos los bits de host en 0:
		for (int i=0; i<chars.length; i++) {
            if(mascara>0) {
            	mascara--;
            }else {
            	chars[i]='0';
            }
            ipAux=ipAux+chars[i];
            aux = aux+chars[i];
            if(i==7 || i==15 || i==23 || i==31) {
                int decimal=Integer.parseInt(aux,2); 
                aux="";
                octetos[j]=decimal;
                j++;
            }
        }
		
		DireccionIP direccionRed = new DireccionIP(octetos[0], octetos[1], octetos[2], octetos[3], direccionIpAux.getMascara());
		
		return direccionRed;
	
	}
	
	public DireccionIP direccionBroadcast(DireccionIP direccionIpAux) {
		
		String ipBinario = direccionIpAux.obtenerIPBinario();
		
		char[] chars = ipBinario.toCharArray();
		int mascara = direccionIpAux.getMascara();
		String ipAux = "";
    	String aux = ipAux;
    	
    	int octetos[]= new int[4];
    	int j=0;

		//Todos los bits de host en 0:
		for (int i=0; i<chars.length; i++) {
            if(mascara>0) {
            	mascara--;
            }else {
            	chars[i]='1';
            }
            ipAux=ipAux+chars[i];
            aux = aux+chars[i];
            if(i==7 || i==15 || i==23 || i==31) {
                int decimal=Integer.parseInt(aux,2); 
                aux="";
                octetos[j]=decimal;
                j++;
            }
        }
		
		DireccionIP direccionRed = new DireccionIP(octetos[0], octetos[1], octetos[2], octetos[3], direccionIpAux.getMascara());
		
		return direccionRed;
	
	}
	
	public ArrayList<DireccionIP> direccionesHosts(DireccionIP direccionIpAux){
		ArrayList<DireccionIP> hosts = new ArrayList<DireccionIP>();
		
		int cantidadHost = (int) (Math.pow(2, (32-direccionIpAux.getMascara())) - 2);
		for (int i = 0; i < cantidadHost; i++) {
			
		}
		
		return hosts;
	}
	
	public int cantidadHost(DireccionIP direccionIPAux) {
		int cantidad = (int) (Math.pow(2, (32-direccionIPAux.getMascara())) - 2);
		
		return cantidad;
	}
	
}
