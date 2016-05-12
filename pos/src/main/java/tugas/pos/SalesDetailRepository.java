package tugas.pos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface SalesDetailRepository extends CrudRepository<SalesDetail,Long> {
	SalesDetail findById(long id); //extends CrudRepository<SalesDetail,Long>
	Page<SalesDetail> findBySalesId(Long id, Pageable pageable);
	Page<SalesDetail> findBySalesNama(String nama, Pageable pageable);
	Page<SalesDetail> findByPembelianId(Long id, Pageable pageable);
	Page<SalesDetail> findByPembelianNomor(String nomor, Pageable pageable);
	
	SalesDetail findBySalesIdAndPembelianId(Long SalesId, Long pembelianId);
	
}
