package org.meruvian.yama.webapi.service.pos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tugas.pos.DetailBeli;
import tugas.pos.DetailBeliRepository;
import tugas.pos.Pembelian;
import tugas.pos.PembelianRepository;
import tugas.pos.Produk;

@Service
@Transactional(readOnly = true)
public class RestPembelianService implements PembelianService {
	@Inject
	private PembelianRepository pembelianRepository;
	
	@Inject
	private DetailBeliRepository detailbeliRepository;
	
	@Override
	public Pembelian getPembelianById(long id){
		return pembelianRepository.findById(id);
	}
	
	@Override
	public Pembelian getPembelianByNomor(String nomor){
		return pembelianRepository.findByNomor(nomor);
	}
	
	@Override
	public List<Pembelian> findPembelianByNomor(String nomor){
		return pembelianRepository.findByNomor(nomor, nomor);
	}
	
	@Override
	@Transactional
	public Pembelian savePembelian(Pembelian pembelian){
		pembelian.setCreateDate(new Date());
		pembelian.setId(0);
		
		return pembelianRepository.save(pembelian);
	}
	
	@Override
	@Transactional
	public Pembelian updatePembelian(long id, Pembelian pembelian){
		Pembelian ori=getPembelianById(id);
		if (ori != null) {
			ori.setNomor(pembelian.getNomor());
			ori.setSurat(pembelian.getSurat());
		}
		return ori;
	}
	
	@Override
	@Transactional
	public void deletePembelian(long id){
		pembelianRepository.delete(id);
	}
	
	@Override
	@Transactional
	public boolean addProdukToPembelian(long id,long produkId){
		Pembelian p=getPembelianById(id);
		for(DetailBeli dt : p.getProduks()){
			if(dt.getProduk().getId()==produkId){
				return false;
			}
		}
		DetailBeli dt=new DetailBeli();
		dt.setPembelian(p);
		Produk produk=new Produk();
		produk.setId(produkId);
		dt.setProduk(produk);
		
		detailbeliRepository.save(dt);
		return true;
	}
	
	@Override
	@Transactional
	public boolean removeProdukFromPembelian(long id, long produkId) {
		Pembelian p=getPembelianById(id);
		DetailBeli dt=detailbeliRepository.findByProdukIdAndPembelianId(p.getId(), produkId);
		detailbeliRepository.delete(dt);
		return true;
	}
	
	@Override
	public Page<Produk> findProdukByPembelian(long id, Pageable pageable) {
		Pembelian p=getPembelianById(id);
		Page<DetailBeli> detailBeli=detailbeliRepository.findByPembelianId(p.getId(), pageable);
		
		List<Produk> produks=new ArrayList<Produk>();
		
		for(DetailBeli dt : detailBeli){
			produks.add(dt.getProduk());
		}
		return new PageImpl<Produk>(produks,pageable,detailBeli.getTotalElements());
	}
}
