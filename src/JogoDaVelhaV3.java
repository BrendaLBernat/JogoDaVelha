
public class JogoDaVelhaV3 {
	
	    private char[][] tabuleiro; //declara um tabuleiro com coordenadas [0..2][0..2]
	    private static final int LINHAS = 3;
	    private static final int COLUNAS = 3;
	    
	    public JogoDaVelhaV3() {
	       tabuleiro = new char[LINHAS][COLUNAS]; //CRIA o tabuleiro
	       
	       //preenche com espacos
	       for (int i = 0; i < LINHAS;i++) {
	           for (int j = 0; j < COLUNAS; j++) {
	               tabuleiro [i][j] = '.';
	           }
	       }//for i
	    }

	    public void mostraTabuleiroComoCoordenadas() {
	    	System.out.println("Coordenadas do tabuleiro");
	        for (int i = 0; i<LINHAS;i++) { //varre cada linha
	            System.out.print('|');            //inicia a linha com um marcador de barra
	            for (int j = 0; j< COLUNAS; j++) { //varre cada coluna
	                System.out.print("("+i+","+j+")");   //concatena seu conteÃºdo
	            }//for j
	            System.out.println('|');   //apos encerrar a varredura das colunas, concatena uma barra final
	        } //for i
	    }
	    
	    public void mostraConteudoDoTabuleiro () {
	    	System.out.println("CONTEúDO do tabuleiro");
	       for (int i = 0; i < LINHAS;i++) {
	    	   System.out.print('|'); 
	           for (int j = 0; j < COLUNAS; j++) {
	               System.out.print(tabuleiro [i][j] );
	           }
	           System.out.println('|'); 
	       }//for i
	    }
	    
	    public static void main(String args[]) {
	        JogoDaVelhaV3 jv = new JogoDaVelhaV3();//cria um OBJETO JogoDaVelhaV3
	        jv.mostraTabuleiroComoCoordenadas();   //envia uma MENSAGEM para o OBJETO
	        jv.mostraConteudoDoTabuleiro();			//envia outra MENSAGEM para o OBJETO
	    }
	    
	}
