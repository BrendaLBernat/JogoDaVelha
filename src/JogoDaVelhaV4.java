import javax.swing.JOptionPane;

public class JogoDaVelhaV4 {
	private char[][] tabuleiro;
	private static final int LINHAS = 3;
	private static final int COLUNAS = 3;

	public JogoDaVelhaV4() {
		tabuleiro = new char[LINHAS][COLUNAS]; // cria um tabuleiro com coordenadas [0..2][0..2]

		// preenche com "."para demonstrar espaço vazio
		for (int i = 0; i < LINHAS; i++) { // varre cada linha
			for (int j = 0; j < COLUNAS; j++) { // varre cada coluna da linha
				tabuleiro[i][j] = '.';
			} // for j
		} // for i
	}

	public void mostraTabuleiroComoCoordenadas() {
		System.out.println("Coordenadas do tabuleiro");
		for (int i = 0; i < LINHAS; i++) { // varre cada linha
			System.out.print('|'); // inicia a linha com um marcador de barra
			for (int j = 0; j < COLUNAS; j++) { // varre cada coluna
				System.out.print("(" + i + "," + j + ")"); // concatena seu conteúdo
			} // for j
			System.out.println('|'); // apos encerrar a varredura das colunas, concatena uma barra final
		} // for i
	}

	public void mostraConteudoDoTabuleiro() {
		System.out.println("CONTE�DO do tabuleiro");
		System.out.println(this.toString());
	}

	/*
	 * Método registraJogada recebe uma coordenada x e uma coordenada Y e a
	 * identificacao do jogador Este metodo verifica se a posicao indicada está
	 * vazia (marcada com um ".") e se estiver, registra a jogada do jogador.
	 */
	public boolean registraJogada(int x, int y, char jogador) {
		if (tabuleiro[x][y] != '.') {
			System.out.println("A posicao esta ocupada, escolha outra");
			return false;
		} else {
			tabuleiro[x][y] = jogador; // registra a jogada do jogador
		}
		return true;
	}

	public boolean ehVencedor(char jogador) {
		if ((tabuleiro[0][0] == jogador) && (tabuleiro[0][1] == jogador) && (tabuleiro[0][2] == jogador)) {
			return true;
		}

		if ((tabuleiro[1][0] == jogador) && (tabuleiro[1][1] == jogador) && (tabuleiro[1][2] == jogador)) {
			return true;
		}

		if ((tabuleiro[2][0] == jogador) && (tabuleiro[2][1] == jogador) && (tabuleiro[2][2] == jogador)) {
			return true;
		}

		if ((tabuleiro[0][0] == jogador) && (tabuleiro[1][1] == jogador) && (tabuleiro[2][2] == jogador)) {
			return true;
		}

		if ((tabuleiro[0][2] == jogador) && (tabuleiro[1][1] == jogador) && (tabuleiro[2][0] == jogador)) {
			return true;
		}

		return false;
	}

	public boolean ehEmpate() {
		for (int i = 0; i < LINHAS; i++) { // varre cada linha
			for (int j = 0; j < COLUNAS; j++) { // varre cada coluna da linha
				if (tabuleiro[i][j] == '.') {// se encontrou pelo menos uma posicao, ainda da para jogar
					return false;
				}
				;
			} // for j
		} // for i
		return true;
	}

	/*
	 * toString é um metodo padrao utilizado para fazer com que a classe
	 * "mostre-se" de alguma forma. Neste caso, o método formata um String
	 * registrando o estado do tabuleiro após a jogada
	 */
	public String toString() {
		String lin = "";
		for (int i = 0; i < LINHAS; i++) { // varre cada linha
			lin = lin + '|'; // inicia a linha com um marcador de barra
			for (int j = 0; j < COLUNAS; j++) { // varre cada coluna
				lin = lin + tabuleiro[i][j]; // concatena seu conteúdo
			} // for j
			lin = lin + '|' + "\n"; // apos encerrar a varredura das colunas, concatena uma barra final
		} // for i
		return lin; // retorna um string contendo o estado do tabuleiro formatado
	}

	public int validaCoordenadaUsuario(char lc, char jogador) {
		String respostaS;
		int respostaI = 9;
		boolean repetir = true;

		String linCol = "LINHA";
		if (lc == 'c') {
			linCol = "COLUNA";
		}
		// precisamos garantir que deste laco de repeticao s� saia um valor entre 0..3
		while (repetir) {
			respostaS = JOptionPane.showInputDialog(
					"Informe a coordenada de" + linCol + " para o jogador [" + jogador + "] (Cancele para sair)");

			if (respostaS == null) {
				respostaI = 3; // liga o FLAG
				repetir = false;
			} else {
				respostaI = Integer.parseInt(respostaS);

				if (respostaI >= 0 && respostaI < 3) { // para de repetir pq o valor eh valido
					repetir = false;
				} else {
					System.out.println("Erro, voce deve informar um valor entre 0 e 2");
				}
			}
		} // while

		return respostaI;
	}

	public static void main(String args[]) {
		// declaracao das variaveis
		boolean repetir = true;
		int linha = 0;
		int coluna = 0;
		char jogador = 'x'; // determina que o jogador "x"inicia jogando

		JogoDaVelhaV4 jogodavelha = new JogoDaVelhaV4(); // cria um OBJETO JogoDaVelhaV4
		jogodavelha.mostraTabuleiroComoCoordenadas(); // envia uma MENSAGEM para o OBJETO

		while (repetir) {
			jogodavelha.mostraConteudoDoTabuleiro(); // envia outra MENSAGEM para o OBJETO

			linha = jogodavelha.validaCoordenadaUsuario('l', jogador);
			coluna = jogodavelha.validaCoordenadaUsuario('c', jogador);
			if (linha == 3 || coluna == 3) { // significa que nao foi informado um valor valido
				repetir = false;
			} else {
				if (jogodavelha.registraJogada(linha, coluna, jogador) == true) { // se a jogada foi valida
					// VERIFICA SE O JOGADOR ATUAL EH O VENCEDOR
					if (jogodavelha.ehVencedor(jogador)) {
						jogodavelha.mostraConteudoDoTabuleiro();
						System.out.println("O jogador " + jogador + " eh o vencedor");
						repetir = false;
					} else if (jogodavelha.ehEmpate()) {
						jogodavelha.mostraConteudoDoTabuleiro();
						System.out.println("Houve empate no jogo");
						repetir = false;

					} else // se o jogador atual nao eh vencedor decide qual o proximo jogador
					if (jogador == 'x') {
						jogador = 'o';
					} else {
						jogador = 'x';
					}
				} else {
					// neste caso permanece com o mesmo jogador!!!!
				}
			}
		} // volta a repetir
		System.out.println("FIM");
	}
}
