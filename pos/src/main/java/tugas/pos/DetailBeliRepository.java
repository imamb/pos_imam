package tugas.pos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface DetailBeliRepository extends CrudRepository<DetailBeli, Long> {
	DetailBeli findById(Long id);
	Page<DetailBeli> findByProdukId(Long id, Pageable pageable);
	Page<DetailBeli> findByProdukNama(String nama, Pageable pageable);
	Page<DetailBeli> findByPembelianId(Long id, Pageable pageable);
	Page<DetailBeli> findByProdukSurat(String surat, Pageable pageable);
	Page<DetailBeli> findByProdukNomor(String nomor, Pageable pageable);
	DetailBeli findByProdukIdAndPembelianId(Long produkId, Long pembelianId);

}
