package gal.chanchi.scanner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * <h2>KeyboardScanner</h2>
 * 
 * Librería que simplifica el uso de la clase Scanner cuando se utiliza para
 * leer datos por teclado
 * 
 * @author Santiago González Lago
 * @version 1.0
 */
public final class KeyboardScanner {
	private static final int DEFAULT_ATTEMPT_LIMIT = 1;

	private Scanner sc;
	private boolean lineInBuffer;
	private int attemptLimit;

	/**
	 * Constructor por defecto
	 */
	public KeyboardScanner() {
		this(DEFAULT_ATTEMPT_LIMIT);
	}

	/**
	 * Este constructor permite modificar el número de intentos de lectura que harán
	 * los métodos antes de devolver una excepción
	 * 
	 * @param attemptLimit El límite de intentos de lectura al usar métodos
	 */
	public KeyboardScanner(int attemptLimit) {
		sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		lineInBuffer = false;
		this.attemptLimit = attemptLimit;
	}

	/**
	 * Este constructor permite modificar el Locale utilizado por el Scanner
	 * subyacente
	 * 
	 * @param locale El Locale a utilizar
	 */
	public KeyboardScanner(Locale locale) {
		this();
		sc.useLocale(locale);
	}

	/**
	 * Este constructor permite modificar el número de intentos de lectura que harán
	 * los métodos antes de devolver una excepción y el Locale utilizado por el
	 * Scanner subyacente
	 * 
	 * @param attemptLimit El límite de intentos de lectura al usar métodos
	 * @param locale       El Locale a utilizar
	 */
	public KeyboardScanner(int attemptLimit, Locale locale) {
		this(attemptLimit);
		sc.useLocale(locale);
	}

	/**
	 * Modifica el Locale utilizado por el Scanner subyacente<br/>
	 * Funciona igual que {@link #setLocale(Locale)}
	 * 
	 * @param locale El Locale a utilizar
	 */
	public void useLocale(Locale locale) {
		sc.useLocale(locale);
	}

	/**
	 * Modifica el Locale utilizado por el Scanner subyacente<br/>
	 * Funciona igual que {@link #useLocale(Locale)}
	 * 
	 * @param locale El Locale a utilizar
	 */
	public void setLocale(Locale locale) {
		useLocale(locale);
	}

	/**
	 * Modifica el número de intentos de lectura que harán los métodos antes de
	 * devolver una excepción
	 * 
	 * @param attemptLimit El límite de intentos de lectura al usar métodos
	 */
	public void setAttemptLimit(int attemptLimit) {
		this.attemptLimit = attemptLimit;
	}

	/**
	 * Cierra el Scanner subyacente
	 */
	public void close() {
		sc.close();
	}

	/**
	 * Obtiene la siguiente línea introducida por teclado
	 * 
	 * @return La línea leída
	 */
	public String nextLine() {
		cleanBuffer();
		return sc.nextLine();
	}

	private void cleanBuffer() {
		if (lineInBuffer) {
			sc.nextLine();
			lineInBuffer = false;
		}
	}

	/**
	 * Obtiene el primer byte en el buffer del teclado, o el siguiente que se
	 * introduzca, si no lo hubiese
	 * 
	 * @return El byte leído
	 * @throws InputMismatchException Si no puede leer ningún byte
	 */
	public byte nextByte() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		byte input = 0;
		do {
			error = false;
			try {
				input = sc.nextByte();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	/**
	 * Obtiene el primer short en el buffer del teclado, o el siguiente que se
	 * introduzca, si no lo hubiese
	 * 
	 * @return El short leído
	 * @throws InputMismatchException Si no puede leer ningún short
	 */
	public short nextShort() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		short input = 0;
		do {
			error = false;
			try {
				input = sc.nextShort();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	/**
	 * Obtiene el primer int en el buffer del teclado, o el siguiente que se
	 * introduzca, si no lo hubiese
	 * 
	 * @return El int leído
	 * @throws InputMismatchException Si no puede leer ningún int
	 */
	public int nextInt() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		int input = 0;
		do {
			error = false;
			try {
				input = sc.nextInt();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	/**
	 * Obtiene el primer long en el buffer del teclado, o el siguiente que se
	 * introduzca, si no lo hubiese
	 * 
	 * @return El long leído
	 * @throws InputMismatchException Si no puede leer ningún long
	 */
	public long nextLong() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		long input = 0;
		do {
			error = false;
			try {
				input = sc.nextLong();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	/**
	 * Obtiene el primer float en el buffer del teclado, o el siguiente que se
	 * introduzca, si no lo hubiese
	 * 
	 * @return El float leído
	 * @throws InputMismatchException Si no puede leer ningún float
	 */
	public float nextFloat() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		float input = 0;
		do {
			error = false;
			try {
				input = sc.nextFloat();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	/**
	 * Obtiene el primer double en el buffer del teclado, o el siguiente que se
	 * introduzca, si no lo hubiese
	 * 
	 * @return El double leído
	 * @throws InputMismatchException Si no puede leer ningún double
	 */
	public double nextDouble() throws InputMismatchException {
		boolean error;
		int attempts = 0;
		double input = 0;
		do {
			error = false;
			try {
				input = sc.nextDouble();
				lineInBuffer = true;
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	/**
	 * Obtiene el primer char en el buffer del teclado, o el siguiente que se
	 * introduzca, si no lo hubiese
	 * 
	 * @return El char leído
	 * @throws StringIndexOutOfBoundsException Si no puede leer ningún char
	 */
	public char nextChar() throws StringIndexOutOfBoundsException {
		boolean error;
		int attempts = 0;
		char input = 0;
		do {
			error = false;
			try {
				input = sc.nextLine().charAt(0);
			} catch (StringIndexOutOfBoundsException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	/**
	 * Obtiene el primer BigInteger en el buffer del teclado, o el siguiente que se
	 * introduzca, si no lo hubiese
	 * 
	 * @return El BigInteger leído
	 * @throws InputMismatchException Si no puede leer ningún BigInteger
	 */
	public BigInteger nextBigInteger() {
		boolean error;
		int attempts = 0;
		BigInteger input = null;
		do {
			error = false;
			try {
				input = sc.nextBigInteger();
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

	/**
	 * Obtiene el primer BigDecimal en el buffer del teclado, o el siguiente que se
	 * introduzca, si no lo hubiese
	 * 
	 * @return El BigDecimal leído
	 * @throws InputMismatchException Si no puede leer ningún BigDecimal
	 */
	public BigDecimal nextBigDecimal() {
		boolean error;
		int attempts = 0;
		BigDecimal input = null;
		do {
			error = false;
			try {
				input = sc.nextBigDecimal();
			} catch (InputMismatchException ex) {
				error = true;
				attempts++;
				sc.nextLine();
				if (attempts >= attemptLimit)
					throw ex;
			}
		} while (error);
		return input;
	}

}
