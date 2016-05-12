package tugas.pos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SalesRepository extends CrudRepository<Sales, Long> {
	Sales findById(long id); 
	Sales findByNama(String nama);
	Sales findByKtp(String ktp);
	
	@Query("SELECT n FROM Sales n WHERE n.nama LIKE %?1% OR n.nik LIKE %?2% OR n.ktp LIKE %?3%")
	List<Sales> findByNama(String nama,String surat, String ktp);
}
