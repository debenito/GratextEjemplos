package gratext.application;

import java.rmi.Naming;


public class GratextClient {

	public static void main(String[] args) {
		GratextParser parse = new GratextParser();
		try {
			
				GratextInterface gratext =  (GratextInterface)Naming.lookup("//localhost:2020/gratext");
				Ventana ventana= new Ventana(); 
				 ventana.setVisible(true);
				 ventana.mandarDatos(gratext.recibirDatos());
			}catch (Exception e) {
				System.out.println("Excepcion en el cliente:"+e.getMessage());
			}
		

	}

}
