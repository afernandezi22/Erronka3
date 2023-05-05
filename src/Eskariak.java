import java.util.Arrays;
/**
 * Eskariak array batean gordetzen dituen klasea
 * @author Ikasle
 * @version 2023/05/05
 * @see Eskari
 */
public class Eskariak {
	private Eskari [] es;
	
	/**
	 * Lehenetsitako sortzailea. 0 espazioko Eskari arraya sortzen du.
	 */
	public Eskariak() {
		es = new Eskari[0];
	}
	
	/**
	 * Parametro bezala pasatutako Eskaria arrayan sartzen du
	 * @param Eskari
	 */
	public void addEskari(Eskari es) {
		this.es = Arrays.copyOf(this.es, this.es.length+1);
		this.es[this.es.length-1] = es;
	}
	/**
	 * Eskarien arraya bueltatzen du
	 * @return Eskari[]
	 */
	public Eskari [] getEskari() {
		return this.es;
	}
}
