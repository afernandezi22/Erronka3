import java.util.Arrays;
public class Eskariak {
	private Eskari [] es;
	
	public Eskariak() {
		es = new Eskari[0];
	}
	
	public void addEskari(Eskari es) {
		this.es = Arrays.copyOf(this.es, this.es.length+1);
		this.es[this.es.length-1] = es;
	}
	
	public Eskari [] getEskari() {
		return this.es;
	}
}
