
package JavaServerSocket_Calculadora;


//O servidor mantem uma conexão aberta escutando mensagens e esperando as entradas enviadas pelo cliente.

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServerSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket welcomeSocket;
		DataOutputStream socketOutput;     	
                DataInputStream socketInput;
                BufferedReader socketEntrada = null;
                Calculadora calc = new Calculadora();
                String result= "";
	    
		try {
                    welcomeSocket = new ServerSocket(9090);
                    int i=0; //n�mero de clientes
	  
                    System.out.println ("Servidor no ar");
                    while(true) { 
	  
                        Socket connectionSocket = welcomeSocket.accept(); 
                        i++;
                        System.out.println ("Nova conexao");

                        //Interpretando dados do servidor
                        socketInput = new DataInputStream(connectionSocket.getInputStream());
                        String arrayOperadores = socketInput.readUTF();
                        String arrayOperandos = socketInput.readUTF();
                                                
                        if (arrayOperadores!=null){
                            for (int i = 0; i < arrayOperadores.length(); i++){
                                if (arrayOperadores.charAt(i) == "/"){
                                        
                                } if else (arrayOperadores.charAt(i) == "*"){

                                } if else (arrayOperadores.charAt(i) == "-"){

                                } else {

                                }
                            }
                        }
                        
                      
               
               //Enviando dados para o cliente
                        socketOutput= new DataOutputStream(connectionSocket.getOutputStream());     	
                        socketOutput.writeBytes(result+ '\n');
                        System.out.println (result);	           
                        socketOutput.flush();
                        socketOutput.close();

	                    
                }
            } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            } 
	    
	}

}

