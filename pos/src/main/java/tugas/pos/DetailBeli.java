package tugas.pos;

import javax.persistence.Column;
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
@Table(name = "detailpembelian", uniqueConstraints = @UniqueConstraint(columnNames = { "produk_id", "pembelian_id" }))
public class DetailBeli {
	private long id;
	private Produk produk=new Produk();
	private Pembelian pembelian=new Pembelian();
	
	private long jumlah;
	private long harga;
	
	public DetailBeli(){};
	
	public DetailBeli(Produk produk,Pembelian pembelian){
		this.produk=produk;
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

	@Column(name = "jumlah")
	public long getJumlah() {
		return jumlah;
	}
	
	public void setJumlah(long jumlah) {
		this.jumlah = jumlah;
	}
	
	@Column(name = "harga")
	public long getHarga() {
		return harga;
	}
	
	public void setHarga(long harga) {
		this.harga = harga;
	}
	
	@ManyToOne
	@JoinColumn(name = "produk_id", nullable = false)
	public Produk getProduk(){
		return produk;
	}
	
	public void setProduk(Produk produk){
		this.produk=produk;
	}
	
	@ManyToOne
	@JoinColumn(name = "pembelian_id", nullable = false)
	public Pembelian getPembelian(){
		return pembelian;
	}
	
	public void setPembelian(Pembelian pembelian){
		this.pembelian=pembelian;
	}
	/*
	 * @ManyToOne
	@JoinColumn(name = "news_id", nullable = false)
	public News getNews(){
		return news;
	}
	
	public void setNews(News news){
		this.news=news;
	}
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory(){
		return category;
	}
	
	public void setCategory(Category category){
		this.category=category;
	}
	 */
	
}
