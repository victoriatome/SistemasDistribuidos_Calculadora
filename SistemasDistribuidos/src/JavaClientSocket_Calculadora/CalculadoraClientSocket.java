
package JavaClientSocket_Calculadora;

//O cliente inicia uma comunicação com o servidor e envia a mensagem com os parametros.
//O servidor executa a operação e responde com uma mensagem. 

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class CalculadoraClientSocket {

	public static void main(String[] args) throws JSONException {
         //Criação de variaveis 
            int x = 0;
            int y = 0;
            String EquacaoSocket="";
            Scanner sc = new Scanner(System.in);
		
            //Escolhendo a operação para ser executada na calculadora
            System.out.println("Conexão ...");
            System.out.println("Digite a equação que você deseja calcular:");
            EquacaoSocket  = sc.nextLine();
        
            //Percorrendo o vetor e contando os elementos 
            int NumeroOperador = 0;
            int NumeroExpressao = 0; 
                    
            for (int i = 0; i < EquacaoSocket.length(); i++){
                if (EquacaoSocket.charAt(i) == '+' || EquacaoSocket.charAt(i) == '-' || EquacaoSocket.charAt(i) == '*' || EquacaoSocket.charAt(i) == '/'){
                    NumeroOperador = NumeroOperador + 1;
                } else {
                    NumeroExpressao = NumeroExpressao + 1;
                }
            }
            
            //Criando dois vetores
            //Um vetor de operandos e outro vetor de operadores 
            char[] Operandos = new char[NumeroExpressao];
            char[] Operadores = new char[NumeroOperador];
            int OperandosIndex = 0;
            int OperadoresIndex = 0;
            
            for (int i = 0; i < EquacaoSocket.length(); i++){
                if (EquacaoSocket.charAt(i) == '+' || EquacaoSocket.charAt(i) == '-' || EquacaoSocket.charAt(i) == '*' || EquacaoSocket.charAt(i) == '/'){
                    for (int j = 0; j < NumeroOperador; j++){
                        Operadores[OperadoresIndex++] = EquacaoSocket.charAt(i); 
                        break;
                    }
                } else {
                    for (int j = 0; j < NumeroExpressao; j++){
                        Operandos[OperandosIndex++] = EquacaoSocket.charAt(i);
                        break;
                    }
                }
            }
            
            //Criando objetos 
            System.out.println("operandos - " + new String(Operadores));
            System.out.println("operadores - " + new String(Operandos));

            JSONObject my_obj = new JSONObject();
    
            JSONArray arrayOperadores = new JSONArray(Operadores);
            my_obj.put("operadores", arrayOperadores);

            JSONArray arrayOperandos = new JSONArray(Operandos);
            my_obj.put("operandos", arrayOperandos);
            
            String json_string = my_obj.toString();
            System.out.println("objeto original -> " + json_string);
            System.out.println();
            
            String result="";
            
            try {

        	//Conexao com o Servidor
                Socket clientSocket = new Socket("192.168.0.11", 9090);
                DataOutputStream socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream());
            
                //Enviando os dados
                socketSaidaServer.writeUTF(arrayOperadores);
                socketSaidaServer.writeUTF(arrayOperandos);
                socketSaidaServer.flush();

                //Recebendo a resposta
                DataInputStream socketResostaServer = new DataInputStream(clientSocket.getInputStream());
                result = socketResostaServer.readUTF();

                System.out.println("resultado="+result);
                
                clientSocket.close();
                sc.close();

            } catch (IOException e) {
                e.printStackTrace();
                sc.close();
            }
            
    }
}