import java.util.Arrays;
public class Produktuak {
	private Produktu [] p;

	public Produktuak() {
		this.p = new Produktu[0];
	}

	public void addProduktu(Produktu p) {
		this.p = Arrays.copyOf(this.p, this.p.length+1);
		this.p[this.p.length-1] = p;
	}

	public Produktu[] getP() {
		return p;
	}

	public int length() {
		return this.p.length;
	}

	public Produktu lortuProduktu(int i) {
		return this.p[i];
	}
}
