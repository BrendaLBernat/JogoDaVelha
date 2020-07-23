
public class JogoDaVelhaV2 {
	
	    private char[][] tabuleiro; //declara um tabuleiro com coordenadas [0..2][0..2]
	    private String nomeDoTabuleiro;
	    private static final int LINHAS = 3;
	    private static final int COLUNAS = 3;
	    
	    public JogoDaVelhaV2() {
	       tabuleiro = new char[LINHAS][COLUNAS]; //CRIA o tabuleiro
	       
	       //preenche com espacos
	       for (int i = 0; i < LINHAS;i++) {
	           for (int j = 0; j < COLUNAS; j++) {
	               tabuleiro [i][j] = '.';
	           }
	       }//for i
	       
	       nomeDoTabuleiro = "Tabuleiro do Mauro";
	    }

	    public void mostraTabuleiroComoCoordenadas() {
	    	System.out.println("Coordenadas do tabuleiro");
	        for (int i = 0; i<LINHAS;i++) { //varre cada linha
	            System.out.print('|');            //inicia a linha com um marcador de barra
	            for (int j = 0; j< COLUNAS; j++) { //varre cada coluna
	                System.out.print("("+i+","+j+")");   //concatena seu conteúdo
	            }//for j
	            System.out.println('|');   //apos encerrar a varredura das colunas, concatena uma barra final
	        } //for i
	    }
	    
	    public String toString() {
	    	return "tabuleiro";
	    }
	    
	    public static void main(String args[]) {
	        JogoDaVelhaV2 jv = new JogoDaVelhaV2();//cria um OBJETO JogoDaVelhaV2
	        jv.mostraTabuleiroComoCoordenadas();   //envia uma MENSAGEM para o OBJETO
	    }
	    
	}
