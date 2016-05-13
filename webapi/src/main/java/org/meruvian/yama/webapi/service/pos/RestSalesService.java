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

import tugas.pos.Pembelian;
import tugas.pos.Sales;
import tugas.pos.SalesDetail;
import tugas.pos.SalesDetailRepository;
import tugas.pos.SalesRepository;

@Service
@Transactional(readOnly = true)
public class RestSalesService implements SalesService {
	@Inject
	private SalesRepository salesRepository;
	/*
	@Inject
	private SalesDetailRepository salesdetailRepository;
	*/
	@Override
	public Sales getSalesById(long id){
		return salesRepository.findById(id);
	}
	
	@Override
	public Sales getSalesByNama(String nama){
		return salesRepository.findByNama(nama);
	}
	
	@Override
	public List<Sales> findSalesByNama(String nama){
		return salesRepository.findByNama(nama, nama, nama);
	}
	
	@Override
	@Transactional
	public Sales saveSales(Sales sales){
		sales.setId(0);
		sales.setCreateDate(new Date());
		
		return salesRepository.save(sales);	
	}
	
	@Override
	@Transactional
	public Sales updateSales(long id,Sales sales){
		Sales ori=getSalesById(id);
		if (ori != null) {
			ori.setAlamat(sales.getAlamat());
			ori.setKelamin(sales.getKelamin());
			ori.setKtp(sales.getKtp());
			ori.setNama(sales.getNama());
			ori.setNik(sales.getNik());
			ori.setTelp(sales.getTelp());
		}
		return ori;	
	}
	
	@Override
	@Transactional
	public void deleteSales(long id){
		salesRepository.delete(id);
	}
	/*
	@Override
	@Transactional
	public boolean addPembelianToSales(long id,long pembelianId){
		Sales s=getSalesById(id);
		for(SalesDetail sd: s.getPembelians()){
			if(sd.getPembelian().getId()==pembelianId){
				return false;
			}
		}
		SalesDetail sd=new SalesDetail();
		sd.setSales(s);
		Pembelian pembelian=new Pembelian();
		pembelian.setId(pembelianId);
		sd.setPembelian(pembelian);
		
		salesdetailRepository.save(sd);
		return true;
	}
	
	@Override
	@Transactional
	public boolean removePembelianFromSales(long id,long pembelianId){
		Sales s=getSalesById(id);
		SalesDetail sd=salesdetailRepository.findBySalesIdAndPembelianId(s.getId(), pembelianId);
		salesdetailRepository.delete(sd.getId());
		return true;
	}
	
	@Override
	public Page<Pembelian> findPembelianBySales(long id, Pageable pageable) {
		Sales s=getSalesById(id);
		Page<SalesDetail> salesDetail=salesdetailRepository.findBySalesId(s.getId(), pageable);
		
		List<Pembelian> pembelians=new ArrayList<Pembelian>();
		
		for(SalesDetail sd: salesDetail){
			pembelians.add(sd.getPembelian());
		}
		
		return new PageImpl<Pembelian>(pembelians,pageable,salesDetail.getTotalElements());
	}
	*/
}
