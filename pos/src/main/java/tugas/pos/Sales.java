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
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Imam Badrudin
 *
 */
@Entity
@Table(name = "sales")
public class Sales {
	private long id;
	private String nik;
	private String ktp;
	private String nama;
	private String kelamin;
	private Alamat alamat;
	private String telp;
	private Date createDate;
	List<SalesDetail> pembelians=new ArrayList<SalesDetail>();
	
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
	
	@Column(name = "nik")
	public String getNik() {
		return nik;
	}
	
	public void setNik(String nik) {
		this.nik = nik;
	}
	
	@Column(name = "ktp")
	public String getKtp() {
		return ktp;
	}
	
	public void setKtp(String ktp) {
		this.ktp = ktp;
	}
	
	@Column(name = "kelamin")
	public String getKelamin() {
		return kelamin;
	}
	
	public void setKelamin(String kelamin) {
		this.kelamin = kelamin;
	}

	@Column(name = "telp")
	public String getTelp() {
		return telp;
	}
	
	public void setTelp(String telp) {
		this.telp = telp;
	}
	
	public Alamat getAlamat() {
		return alamat;
	}
	
	public void setAlamat(Alamat alamat) {
		this.alamat = alamat;
	}
	
	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "sales", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	public List<SalesDetail> getPembelians(){
		return pembelians;
	}
	
	public void setPembelians(List<SalesDetail> pembelians){
		this.pembelians=pembelians;
	}
	
	
}
