package tugas.pos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProdukRepository extends CrudRepository<Produk,Long> {
	Produk findById(long id);
	Produk findByNama(String nama);
	
	@Query("SELECT n FROM Produk n WHERE n.nama LIKE %?1% OR n.keterangan LIKE %?2%")
	List<Produk> findByNama(String nama, String keterangan);

}
