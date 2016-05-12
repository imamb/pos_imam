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
@Table(name = "pembelian")
public class Pembelian {
	private long id;
	private String nomor;
	private String surat;
	private Date createDate;
	List<DetailBeli> produks=new ArrayList<DetailBeli>();
	List<SalesDetail> saless=new ArrayList<SalesDetail>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getNomor() {
		return nomor;
	}
	
	public void setNomor(String nomor) {
		this.nomor = nomor;
	}
	
	@Column(name="surat")
	public String getSurat() {
		return surat;
	}
	
	public void setSurat(String surat) {
		this.surat = surat;
	}
	
	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "pembelian", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	public List<DetailBeli> getProduks(){
		return produks;
	}
	
	public void setProduks(List<DetailBeli> produks){
		this.produks=produks;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "pembelian", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	public List<SalesDetail> getSaless(){
		return saless;
	}
	
	public void setSaless(List<SalesDetail> saless){
		this.saless=saless;
	}
}
