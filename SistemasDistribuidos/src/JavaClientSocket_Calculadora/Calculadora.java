
package JavaClientSocket_Calculadora;

public class Calculadora {
	
	// Nome e sobrenome
    public String sayHello(String nome, String sobrenome) {
        return "Fala "+ nome + " " + sobrenome;
    }
    
    //Operação de soma
    public double soma(double oper1, double oper2) {
        return oper1 + oper2;
    }
    
    //Operação de subtração
	public double subtracao(double oper1, double oper2) {
        return oper1 - oper2;
    }
	
	//Operação de multiplicação
	public double multiplicacao(double oper1, double oper2) {
        return oper1 * oper2;
    }
	
	//Operação de divisão
	public double divisao(double oper1, double oper2) {
        return oper1 / oper2;
    }
}
