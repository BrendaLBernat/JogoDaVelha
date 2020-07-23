
public class JogoDaVelhaV1  {
	
	    private char[][] tabuleiro;//DECLARA um tabuleiro com coordenadas [0..2][0..2]
	    private static final int LINHAS = 3;
	    private static final int COLUNAS = 3;
	    
	    public JogoDaVelhaV1() { //metodo CONSTRUTOR que inicializa os ATRIBUTOS da classe
	       tabuleiro = new char[LINHAS][COLUNAS]; //ALOCA memoria para o tabuleiro
	       
	       //preenche com espacos
	       for (int i = 0; i < LINHAS;i++) {//para cada linha faca
	           for (int j = 0; j < COLUNAS; j++) { //varre cada coluna
	               tabuleiro [i][j] = '.';
	           } //for j
	       }//for i
	       
	       //na saida deste metodo construtor temos um tabuleiro criado
	    }
	    
	    public String toString() {
	    	return "tabuleiro";
	    }
	    
	    public static void main(String args[]) {
	    	 //aqui NEW significa: cria um OBJETO JogoDaVelhaV1, ou seja, ALOCA memoria
	    	 // para uma variavel do tipo JogoDaVelhaV1
	        JogoDaVelhaV1 jv = new JogoDaVelhaV1(); //cria uma INSTANCIA da classe JogoDaVelhaV1
	        System.out.println(jv);  //vai aparecer JogoDaVelhaV1@15db9742
	    }	    
	}
