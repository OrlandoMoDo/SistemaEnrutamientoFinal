package Logico;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entradaEscaner = new Scanner (System.in);
//		DireccionIP direccion = new DireccionIP(10, 10, 0, 255, 30);
//		System.out.println(direccion.obtenerMascara(direccion.getMascara()));
//		int x = 192;
//		String y=Long.toBinaryString(x);
//		System.out.println(y);
//        String binaryString="00001110";  
//        int decimal=Integer.parseInt(binaryString,2);  
//        System.out.println(decimal);
//        for (int i = 0; i <=255; i++) {
//			System.out.print(i+" - ");
//			System.out.print(Long.toBinaryString(i));
//			System.out.print(" -"+Integer.parseInt(Long.toBinaryString(i)+"", 2));
//			System.out.println();
//			
//		}
        
//        for (int i = 0; i < 256; i++) {
//    		DireccionIP direccionAux = new DireccionIP(10, 0, 0, i, 30);
//            System.out.println(direccionAux.obtenerIPMask()+" es una ip de: "+direccionAux.tipoIP(direccionAux));
//
//		}
        
//        for (int i = 0; i < 256; i++) {
//    		DireccionIP direccionAux = new DireccionIP(10, 0, 0, i, 16);
//            System.out.print(direccionAux.direccionRed(direccionAux).obtenerIPMask());
//            System.out.println(direccionAux.direccionBroadcast(direccionAux).obtenerIPMask());
//		}
//        System.out.println((direccion.obtenerIP()));
//        System.out.println(SistemaEnrutamiento.getInstance().direccionIPSintaxisValida(direccion.obtenerIP()));
		
		ArrayList<String> nombres = new ArrayList<String>();
		nombres.add("Juan");
		nombres.add("Pedro");
		nombres.add("Marcos");
		nombres.add("Antonio");
		nombres.add("Oscar");
		nombres.remove(1);
		for (int i = 0; i <nombres.size(); i++) {
			System.out.println((i+1)+nombres.get(i));
		}
		
		for (int i = 0; i <7; i++) {
			System.out.print("Ingresa la red no. "+(i+1)+": ");
			String red = entradaEscaner.next();
			System.out.print("Ingresa la mascara de la red no. "+(i+1)+": ");
			String mascara = entradaEscaner.next();
			System.out.println();
        	int octetos[] = new int[5];
        	octetos = obtenerIP(red,  mascara);
			
        	DireccionIP ip = new DireccionIP(octetos[0], octetos[1], octetos[2], octetos[3], octetos[4]);
        	SistemaEnrutamiento.getInstance().ingresarDireccionIP(ip);
			
			
		}
		
		for (int i = 0; i <SistemaEnrutamiento.getInstance().getMisDireccionesIP().size(); i++) {
			System.out.println("Red no. "+ (i+1) +" es: "+SistemaEnrutamiento.getInstance().getMisDireccionesIP().get(i).direccionRed(SistemaEnrutamiento.getInstance().getMisDireccionesIP().get(i)).obtenerIPMask());
		}
	}
	
	public static int[] obtenerIP(String ip, String mascara) {
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
	

}
