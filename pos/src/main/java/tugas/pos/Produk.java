package tugas.pos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Imam Badrudin
 *
 */
@Entity
@Table(name = "produk")
public class Produk {
	private long id;
	private String nama;
	private String keterangan;
	private long stok;
	private long harga;
	private Date createDate;
	List<DetailBeli> pembelians=new ArrayList<DetailBeli>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}

	@Lob
	public String getKeterangan() {
		return keterangan;
	}
	
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name = "stok")
	public long getStok() {
		return stok;
	}
	
	public void setStok(long stok) {
		this.stok = stok;
	}
	
	@Column(name = "harga")
	public long getHarga() {
		return harga;
	}
	
	public void setHarga(long harga) {
		this.harga = harga;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "produk", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	public List<DetailBeli> getPembelians(){
		return pembelians;
	}
	
	public void setPembelians(List<DetailBeli> pembelians){
		this.pembelians=pembelians;
	}
	 
}
