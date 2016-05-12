package tugas.pos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PembelianRepository extends CrudRepository<Pembelian, Long>{
	Pembelian findById(long id);
	Pembelian findByNomor(String nomor);
	Pembelian findBySurat(String surat);

	@Query("SELECT n FROM Pembelian n WHERE n.nomor LIKE %?1% OR n.surat LIKE %?2%")
	List<Pembelian> findByNomor(String nomor,String surat);
}
