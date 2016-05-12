package tugas.pos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Imam Badrudin
 *
 */
@Entity
@Table(name = "salesdetail", uniqueConstraints = @UniqueConstraint(columnNames = { "sales_id", "pembelian_id" }))
public class SalesDetail {
	private long id;
	private Sales sales=new Sales();
	private Pembelian pembelian=new Pembelian();
	
	public SalesDetail(){};
	
	public SalesDetail(Sales sales, Pembelian pembelian){
		this.sales=sales;
		this.pembelian=pembelian;
	};
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@ManyToOne
	@JoinColumn(name = "pembelian_id", nullable = false)
	public Pembelian getPembelian(){
		return pembelian;
	}
	
	public void setPembelian(Pembelian pembelian){
		this.pembelian=pembelian;
	}
	
	@ManyToOne
	@JoinColumn(name = "sales_id", nullable = false)
	public Sales getSales(){
		return sales;
	}
	
	public void setSales(Sales sales){
		this.sales=sales;
	}
}
