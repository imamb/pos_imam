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
import tugas.pos.Produk;
import tugas.pos.ProdukRepository;

@Service
@Transactional(readOnly = true)
public class RestProdukService implements ProdukService {
	@Inject
	private ProdukRepository produkRepository;
	
	@Inject
	private DetailBeliRepository detailbeliRepository;
	
	@Override
	public Produk getProdukById(long id){
		return produkRepository.findById(id);
	}
	
	@Override
	public Produk getProdukByNama(String nama){
		return produkRepository.findByNama(nama);
	}
	
	@Override
	public List<Produk> findProdukByNama(String nama){
		return produkRepository.findByNama(nama,nama);
	}
	
	@Override
	@Transactional
	public Produk saveProduk(Produk produk){
		produk.setId(0);
		produk.setCreateDate(new Date());
		
		return produkRepository.save(produk);
	}
	
	@Override
	@Transactional
	public Produk updateProduk(long id, Produk produk){
		Produk ori= getProdukById(id);
		if (ori != null) {
			ori.setHarga(produk.getHarga());
			ori.setNama(produk.getNama());
			ori.setKeterangan(produk.getKeterangan());
			ori.setStok(produk.getStok());	
		}
		return ori;
	}
	
	@Override
	@Transactional
	public void deleteProduk(long id){
		produkRepository.delete(id);
	}
	
	@Override
	@Transactional
	public boolean addPembelianToProduk(long id,long pembelianId){
		Produk p=getProdukById(id);
		for(DetailBeli dt : p.getPembelians()){
			if(dt.getPembelian().getId()==pembelianId){
				return false;
			}
		}
		
		DetailBeli detailBeli=new DetailBeli();
		detailBeli.setProduk(p);
		Pembelian pembelian=new Pembelian();
		pembelian.setId(pembelianId);
		detailBeli.setPembelian(pembelian);
		
		detailbeliRepository.save(detailBeli);
		return true;
	}
	
	@Override
	@Transactional
	public boolean removePembelianFromProduk(long id, long pembelianId) {
		Produk p=getProdukById(id);
		DetailBeli detailBeli=detailbeliRepository.findByProdukIdAndPembelianId(p.getId(), pembelianId);
		detailbeliRepository.delete(detailBeli);
		return true;
	}
	
	@Override
	public Page<Pembelian> findPembelianByProduk(long id, Pageable pageable) {
		Produk p=getProdukById(id);
		Page<DetailBeli> detailBelis=detailbeliRepository.findByProdukId(p.getId(), pageable);
		
		List<Pembelian> pembelians=new ArrayList<Pembelian>();
		
		for(DetailBeli dt : detailBelis){
			pembelians.add(dt.getPembelian());
		}
		return new PageImpl<Pembelian>(pembelians,pageable,detailBelis.getTotalElements());
	}
	/*
	@Override
	@Transactional
	public boolean removePembelianFromProduk(long id) {
		Produk p=getProdukById(id);
		detailbeliRepository.delete(p.getPembelians());
		return true;
	}
	*/
	
	
}
