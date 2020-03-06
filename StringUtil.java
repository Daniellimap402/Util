package whatever;

public final class StringUtil {

	public static final int DIFERENCA_MINUSCULA_MAIUSCULA = 32;
	public static final int UM_DIGITO = 0;
	public static final String STRING_MAIUSCULA = "maiuscula";
	public static final String STRING_MINUSCULA = "minuscula";

	private StringUtil() {
	}

	/**
	 * 
	 * @param texto 
	 * a String
	 * @return a String em letras minusculas
	 */
	public static String getFraseMinuscula(String texto) {
		return texto.toLowerCase();
	}

	/**
	 * 
	 * @param texto
	 * a String
	 * @return a String em letras maiusculas
	 */
	public static String getFraseMaiuscula(String texto) {
		return texto.toUpperCase();
	}

	/**
	 * 
	 * @param texto 
	 * a String
	 * @return a String reversa
	 */
	public static String getStringReversa(String texto) {
		StringBuilder fraseInvertida = new StringBuilder();
		fraseInvertida.append(texto);
		return fraseInvertida.reverse().toString();
	}

	/**
	 * 
	 * @param texto 
	 * a String
	 * @return a String sem espaços obliquos
	 */
	public static String removerEspacosObliquos(String texto) {
		texto = texto.trim();
		for (int i = 0; i < texto.length(); i++) {
			texto = texto.replaceAll("  ", " ");
		}
		return texto;
	}

	/**
	 * 
	 * @param texto 
	 * a String
	 * @return a String sem nenhum espaço
	 */
	public static String removerEspacos(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			texto = texto.replaceAll(" ", "");
		}
		return texto;
	}

	/**
	 * 
	 * @param texto
	 * a String
	 * @return a quantidade de palavras
	 */
	public static int getQuantPalavras(String texto) {
		texto = removerEspacosObliquos(texto);
		String[] fraseArray = texto.split(" ");
		return fraseArray.length;
	}

	/**
	 * 
	 * @param numeros      
	 * a string
	 * @param quantDigitos 
	 * a quantidade de digitos que deve conter a String
	 * @return A string com determinada quantidade de digitos
	 */
	public static String addZerosEsquerda(String numeros, int quantDigitos) {
		for (int i = numeros.length(); i < quantDigitos; i++) {
			numeros = UM_DIGITO + numeros;
		}
		return numeros;
	}

	/**
	 * 
	 * @param texto 
	 * a String
	 * @return a String com a primeira letra em maiusculo
	 */
	public static String getPrimeiraLetraMaiuscula(String texto) {
		String letraMaiuscula = Character.toString(texto.charAt(0)).toUpperCase();
		StringBuilder textoB = new StringBuilder();
		textoB.append(texto);
		textoB.replace(0, 1, letraMaiuscula);
		return textoB.toString();
	}

	/**
	 * 
	 * @param frase
	 * a String
	 * @return a String em formatação de atributo/metodo
	 */
	public static String getFormatacaoAtributoMetodo(String frase) {
		frase = removerEspacosObliquos(frase);
		frase = getFraseMinuscula(frase);
		String fraseFormatada = frase.split(" ")[0];
		for (int i = 1; i < frase.split(" ").length; i++) {
			String palavra = frase.split(" ")[i];
			int numLetra = palavra.charAt(0) - DIFERENCA_MINUSCULA_MAIUSCULA;
			String letraMaiuscula = Character.toString((char) numLetra);
			String primeira = palavra.substring(0, 1);
			palavra = palavra.replaceFirst(primeira, letraMaiuscula);
			fraseFormatada += palavra;
		}
		return fraseFormatada;
	}
	/**
	 * 
	 * @param frase
	 * a String
	 * @return a String em formatação de classe
	 */
	public static String getFormatacaoClasse(String frase) {
		frase = removerEspacosObliquos(frase);
		frase = getFraseMinuscula(frase);
		frase = " " + frase;
		return getFormatacaoAtributoMetodo(frase);
	}
	
	/**
	 * 
	 * @param texto
	 * a String
	 * @return true se estiver vazia e false se não estiver vazia
	 */
	public static boolean isEmpty(String texto) {
		return texto.trim().length() == 0;
	}

	/**
	 * 
	 * @param texto
	 * a String
	 * @return a quantidade de letras da string (sem contar com espaços)
	 */
	public static int getQuantLetras(String texto) {
		texto = removerEspacos(texto);
		return texto.length();
	}
	/**
	 * 
	 * @param texto
	 * a String
	 * @return a quantidade de caracteres da String (contando com espaços)
	 */
	public static int getQuantCaracteres(String texto) {
		return texto.length();
	}
	
	/**
	 * 
	 * @param texto
	 * o texto
	 * @param palavra
	 * a letra a ser encontrada
	 * @return
	 */
	public static int getIndexLetra(String texto, String letra) {
		return texto.indexOf(letra);
	}
	/**
	 * 
	 * @param texto
	 * o texto
	 * @param palavra
	 * a palavra a ser tirada
	 * @param palavraSubstituta
	 * a nova palavra a ser colocada
	 * @return uma String nova com palavras substituidas
	 */
	public static String trocarPalavras(String texto, String palavra, String palavraSubstituta)
	{
		return texto.replace(palavra, palavraSubstituta);
	}
	
	/**
	 * 
	 * @param texto
	 * o texto
	 * @param palavra
	 * a palavra a ser inserida
	 * @param posicaoInserir
	 * o numero equivalente a posicao onde sera inserido a palavra
	 * @return uma String com uma palavra inserida nele
	 */
	public static String inserirPalavra(String texto, String palavra,int posicaoInserir)
	{
		StringBuilder textoB = new StringBuilder();
		textoB.append(texto);
		textoB.insert(posicaoInserir, palavra);
		return textoB.toString();
	}
	
	/**
	 * 
	 * @param texto
	 * a String a ser formatada
	 * @return uma string formatada com todas as primeiras letras maiusculas
	 */
	public static String transformarPrimeirasLetrasMaiusculas(String texto)
	{
		String tipo = STRING_MAIUSCULA;
		return transformarPrimeirasLetrasMM(texto, tipo);
	}
	
	/**
	 * 
	 * @param texto
	 * a String a ser formatada
	 * @return uma string formatada com todas as primeiras letras minusculas
	 */
	public static String transformarPrimeirasLetrasMinusculas(String texto)
	{
		String tipo = STRING_MINUSCULA;
		return transformarPrimeirasLetrasMM(texto, tipo);
	}
	
	/**
	 * 
	 * @param texto
	 * a string a ser formatada
	 * @param tipo
	 * o tipo a se transformar(minusculo ou maiusculo)
	 * @return a string formatada em maiusculo ou minusculo
	 */
	private static String transformarPrimeirasLetrasMM(String texto,String tipo)
	{
		String[] textoFormatado = texto.split(" ");
		StringBuilder textoB = new StringBuilder();
		for (int i = 0; i < textoFormatado.length; i++) {
			if(tipo == STRING_MAIUSCULA) {
			textoB.append(Character.toString(textoFormatado[i].charAt(0)).toUpperCase());
			}
			else if(tipo == STRING_MINUSCULA) {
				textoB.append(Character.toString(textoFormatado[i].charAt(0)).toLowerCase());
			}
			for (int j = 1; j < textoFormatado[i].length(); j++) {
				textoB.append(Character.toString(textoFormatado[i].charAt(j)));
			}
			textoB.append(" ");
		}
		return textoB.toString();
	}
	
	/**
	 * 
	 * @param texto
	 * a String a ser formatada
	 * @param quantPalavrasParaQuebra
	 * a cada quantas palavras deve-se quebrar o texto
	 * @return
	 */
	public static String quebrarLinhas(String texto, int quantPalavrasParaQuebra) {
		texto = removerEspacosObliquos(texto);
		StringBuilder textoB = new StringBuilder();
		int quantQuebra = quantPalavrasParaQuebra;
		for (int i = 0; i < texto.split(" ").length; i++) {
			textoB.append(texto.split(" ")[i]);
			textoB.append(" ");
			if(i==quantQuebra-1)
			{
				quantQuebra+=quantPalavrasParaQuebra;
				textoB.append("\n");
			}
		}
		return textoB.toString();
	}
	
	/**
	 * 
	 * @param texto
	 * o texto
	 * @return uma String com todas as primeiras letras do texto
	 */
	public static String getPrimeirasLetras(String texto)
	{
		String[] textoFormatado = texto.split(" ");
		StringBuilder textoB = new StringBuilder();
		
		for (int i = 0; i < textoFormatado.length; i++) {
			textoB.append(Character.toString(textoFormatado[i].charAt(0)));
		}
		return textoB.toString();
	}
	
	
	
}
