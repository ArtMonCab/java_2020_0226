package com.ipartel.formacion.ejecutarcomandomsdos;

import java.io.IOException;

public class EjecutarComando {
	
	public static void main(String[] args) throws IOException, InterruptedException{
		Process runProcess = Runtime.getRuntime().exec("notepad.exe D:\\cursos\\curso java\\backup\\supermercado.sql");
		int processComplete = runProcess.waitFor();
		
		if(processComplete == 0) {
			System.out.println("Todos correcto");
		}else {
			System.out.println("Ha habido algún error");
		}
				
				
	}

}
