/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorchefe;




/////////////SERVIDOR
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChefe {
boolean continua=true;
ServerSocket sv=null, sv2=null;

public ServidorChefe(){

     try{
	String conf[]=new Ler().AbrirS("config.jpc").split("\n");
            for(int cont=0;cont<conf.length;cont++){
                System.out.println("Criado "+conf[cont]);
         new iniciaServidorGeral(new ServerSocket(
         Integer.parseInt(conf[cont])
         )).start();
            }
            }catch(Exception e){}
    
	
	


}
	int cont=0;
	

class iniciaServidorGeral extends Thread{
    ServerSocket svg=null;
public iniciaServidorGeral(ServerSocket svg){
    this.svg=svg;
}
	
	public void run()
        {
            
            while(continua){
			try {
				new trabalhaCliente1(svg.accept(),cont++).start();;
                        	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class iniciaServidor1 extends Thread{

	
	public void run(){
		while(continua){
			try {
				new trabalhaCliente1(sv.accept(),cont++).start();;
                                System.out.println("Inicio Cliente 1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}


class iniciaServidor2 extends Thread{
	
	
	public void run(){
		while(continua){
			try {
				new trabalhaCliente2(sv2.accept()).start();;
                                System.out.println("Inicio Cliente 2");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class iniciaServidor3 extends Thread{
	
	
	public void run(){
		while(continua){
			try {
				new trabalhaCliente2(sv2.accept()).start();;
                                System.out.println("Inicio Cliente 3");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}


class trabalhaCliente1 extends Thread{
DataInputStream in=null;
DataOutputStream ou=null;
public boolean valida=true;
int cont=0;
public trabalhaCliente1(Socket s, int cont){
	try {
            this.cont=cont;
		ou=new DataOutputStream(s.getOutputStream());
		in=new DataInputStream(s.getInputStream());

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void run(){
while(valida){
	esTx("Conexao numero "+cont);
    System.out.println("Servidor Neberson Valor Enviado 'Conexao numero "+cont+"'");
try {
	Thread.sleep(500);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
		
		
	}
	

public void esTx(String tx){
	try {//Função de escrita texto, es-> escrita
		ou.writeUTF(tx);
	} catch (IOException e) {
		e.printStackTrace();
		valida=false;
	}}//Função de escrita numero, es-> escrita
public void esNm(double db){
	try {
		ou.writeDouble(db);
	} catch (IOException e) {
		e.printStackTrace();
		valida=false;
	}}
public Double lerNm(){
		try {//Função para ler Numero Ler
		return in.readDouble();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		valida=false;
	}	return null;}
public String lerTx(){
try {
	return	in.readUTF();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
valida=false;
}
return null;
}

	
	
}



class trabalhaCliente2 extends Thread{
DataInputStream in=null;
DataOutputStream ou=null;
public boolean valida=true;
public trabalhaCliente2(Socket s){
	try {
		ou=new DataOutputStream(s.getOutputStream());
		in=new DataInputStream(s.getInputStream());

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void run(){
while(valida){
	esTx("Conectado 2");

try {
	Thread.sleep(500);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
		
		
	}
	

public void esTx(String tx){
	try {//Função de escrita texto, es-> escrita
		ou.writeUTF(tx);
	} catch (IOException e) {
		e.printStackTrace();
		valida=false;
	}}//Função de escrita numero, es-> escrita
public void esNm(double db){
	try {
		ou.writeDouble(db);
	} catch (IOException e) {
		e.printStackTrace();
		valida=false;
	}}
public Double lerNm(){
		try {//Função para ler Numero Ler
		return in.readDouble();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		valida=false;
	}	return null;}
public String lerTx(){
try {
	return	in.readUTF();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
valida=false;
}
return null;
}

	
	
}

class trabalhaCliente3 extends Thread{
DataInputStream in=null;
DataOutputStream ou=null;
public boolean valida=true;
public trabalhaCliente3(Socket s){
	try {
		ou=new DataOutputStream(s.getOutputStream());
		in=new DataInputStream(s.getInputStream());

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void run(){
while(valida){
	esTx("Conectado 3");

try {
	Thread.sleep(500);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
		
		
	}
	

public void esTx(String tx){
	try {//Função de escrita texto, es-> escrita
		ou.writeUTF(tx);
	} catch (IOException e) {
		e.printStackTrace();
		valida=false;
	}}//Função de escrita numero, es-> escrita
public void esNm(double db){
	try {
		ou.writeDouble(db);
	} catch (IOException e) {
		e.printStackTrace();
		valida=false;
	}}
public Double lerNm(){
		try {//Função para ler Numero Ler
		return in.readDouble();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		valida=false;
	}	return null;}
public String lerTx(){
try {
	return	in.readUTF();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
valida=false;
}
return null;
}

	
	
}
  public static void main(String args[]){
        new ServidorChefe();
    }
}
