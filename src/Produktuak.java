import java.util.Arrays;
/**
 * Produktuen arraya gordetzen du
 * @author Talde3
 * @version 2023/05/05
 * @see Produktu
 *
 */
public class Produktuak {
	private Produktu [] p;
	/**
	 * Lehenetsitako sortzailea.  0 tamainako Produktu arraya sortzen du.
	 */
	public Produktuak() {
		this.p = new Produktu[0];
	}
	/**
	 * Arrayari parametro bezala pasatzen diogun produktua gehitzen dio.
	 * @param p
	 */
	public void addProduktu(Produktu p) {
		this.p = Arrays.copyOf(this.p, this.p.length+1);
		this.p[this.p.length-1] = p;
	}
	/**
	 * Arraya bueltatzen du
	 * @return p
	 */
	public Produktu[] getP() {
		return p;
	}
	/**
	 * Arrayaren tamaina bueltatzen du
	 * @return arrayaren tamaina
	 */
	public int length() {
		return this.p.length;
	}
	/**
	 * Parametro bezala pasatzen diogun indizean dagoen produktua bueltatzen du.
	 * @param indizea
	 * @return Produktu
	 */
	public Produktu lortuProduktu(int i) {
		return this.p[i];
	}
}
